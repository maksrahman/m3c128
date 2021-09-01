package com.maks.dvdlibrary.dao;

import com.maks.dvdlibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{

    private Map<String, DVD> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "src/main/java/com/maks/dvdlibrary/library.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    private DVD unmarshallDVD(String dvdAsText){
        // dvdAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // F9::07-2021::12+::Justin Lin::Universal::4
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
        // _______________________________________
        // |  |       |   |          |         | |
        // |F9|07-2021|12+|Justin Lin|Universal|4|
        // |  |       |   |          |         | |
        // ---------------------------------------
        //  [0]  [1]   [2]    [3]        [4]   [5]
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Index 0 - Title
        String title = dvdTokens[0];

        DVD dvdFromFile = new DVD(title);

        // Index 1 - releaseDate
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - mpaaRating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - directorName
        dvdFromFile.setDirectorName(dvdTokens[3]);

        // Index 4 - studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - userRating
        dvdFromFile.setUserRating(Integer.parseInt(dvdTokens[5]));

        return dvdFromFile;
    }

    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        DVD currentDVD;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){
        // F9::07-2021::12+::Justin Lin::Universal::4

        // title
        String dvdAsText = aDVD.getTitle() + DELIMITER;

        // releaseDate
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;

        // mpaaRating
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;

        // directorName
        dvdAsText += aDVD.getDirectorName() + DELIMITER;

        // studio
        dvdAsText += aDVD.getStudio() + DELIMITER;

        // userRating
        dvdAsText += aDVD.getUserRating();

        return dvdAsText;
    }

    /**
     * Writes all DVDs in the library out to a LIBRARY_FILE.  See loadLibrary
     * for file format.
     *
     * @throws DVDLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save student data.", e);
        }

        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
