package com.maks.dvdlibrary.dao;

import com.maks.dvdlibrary.dto.DVD;

import java.util.List;

public interface DVDLibraryDao {

    /**
     * Adds the given DVD to the library and associates it with the given
     * title. If there is already a DVD with the given title
     * it will return that student object, otherwise it will
     * return null.
     *
     * @param title title with which DVD is to be associated
     * @param dvd DVD to be added to the library
     * @return the DVD object previously associated with the given
     * title if it exists, null otherwise
     */
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    /**
     * Returns a List of all DVDs in the library.
     *
     * @return List containing all DVDs in the library.
     */
    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    /**
     * Returns the DVD object associated with the given title.
     * Returns null if no such DVD exists
     *
     * @param title Title of the DVD to retrieve
     * @return the DVD object associated with the given title,
     * null if no such DVD exists
     */
    DVD getDVD(String title) throws DVDLibraryDaoException;

    /**
     * Removes from the library the DVD associated with the title.
     * Returns the DVD object that is being removed or null if
     * there is no DVD associated with the title
     *
     * @param title Title of DVD to be removed
     * @return DVD object that was removed or null if no DVD
     * was associated with the given title
     */
    DVD removeDVD(String title) throws DVDLibraryDaoException;
}
