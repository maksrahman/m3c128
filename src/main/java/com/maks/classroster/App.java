package com.maks.classroster;

import com.maks.classroster.controller.ClassRosterController;
import com.maks.classroster.dao.ClassRosterDao;
import com.maks.classroster.dao.ClassRosterDaoFileImpl;
import com.maks.classroster.ui.ClassRosterView;
import com.maks.classroster.ui.UserIO;
import com.maks.classroster.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myView, myDao);
        controller.run();
    }
}
