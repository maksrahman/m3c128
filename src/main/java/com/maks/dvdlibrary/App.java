package com.maks.dvdlibrary;

import com.maks.dvdlibrary.controller.DVDLibraryController;
import com.maks.dvdlibrary.dao.DVDLibraryDao;
import com.maks.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.maks.dvdlibrary.ui.DVDLibraryView;
import com.maks.dvdlibrary.ui.UserIO;
import com.maks.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myView, myDao);
        controller.run();
    }
}
