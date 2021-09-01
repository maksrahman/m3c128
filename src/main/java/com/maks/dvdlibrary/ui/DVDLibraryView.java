package com.maks.dvdlibrary.ui;

import com.maks.dvdlibrary.dto.DVD;

import java.util.List;

public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add DVD");
        io.print("3. Find DVD");
        io.print("4. Edit DVD");
        io.print("5. Remove DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter movie title");
        String releaseDate = io.readString("Please enter release date (MM-YYYY)");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter director name");
        String studio = io.readString("Please enter studio name");
        int userRating = io.readInt("Please enter user rating", 0, 5);
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public DVD editDVDInfo(DVD dvdRecord) {
        String releaseDate = io.readString("Please enter new release date (current = " + dvdRecord.getReleaseDate() + ")");
        String mpaaRating = io.readString("Please enter MPAA Rating (current = " + dvdRecord.getMpaaRating() + ")");
        String directorName = io.readString("Please enter director name (current = " + dvdRecord.getDirectorName() + ")");
        String studio = io.readString("Please enter studio name (current = " + dvdRecord.getDirectorName() + ")");
        int userRating = io.readInt("Please enter user rating (current = " + dvdRecord.getUserRating() + ")", 0, 5);
        dvdRecord.setReleaseDate(releaseDate);
        dvdRecord.setMpaaRating(mpaaRating);
        dvdRecord.setDirectorName(directorName);
        dvdRecord.setStudio(studio);
        dvdRecord.setUserRating(userRating);
        return dvdRecord;
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditSuccessBanner() {
        io.readString(
                "DVD successfully edited.  Please hit enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String dvdInfo = String.format("%s ; Released : %s ; User Rating : %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDVDTitleChoice() {
        return io.readString("Please enter the title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
