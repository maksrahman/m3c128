package com.maks.dvdlibrary.controller;

import com.maks.dvdlibrary.dao.DVDLibraryDao;
import com.maks.dvdlibrary.dao.DVDLibraryDaoException;
import com.maks.dvdlibrary.dto.DVD;
import com.maks.dvdlibrary.ui.DVDLibraryView;

import java.util.List;

public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1 -> listDVDs();
                    case 2 -> createDVD();
                    case 3 -> viewDVD();
                    case 4 -> editDVD();
                    case 5 -> removeDVD();
                    case 6 -> keepGoing = false;
                    default -> unknownCommand();

                }
            }
            exitMessage();

        } catch (DVDLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }

    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        if (dvd != null){
            DVD editedDVD = view.editDVDInfo(dvd);
            dao.addDVD(title, editedDVD);
            view.displayEditSuccessBanner();
        } else {
            view.displayErrorMessage("Error, DVD does not exist");
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
