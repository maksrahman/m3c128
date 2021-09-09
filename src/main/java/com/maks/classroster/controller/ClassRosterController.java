package com.maks.classroster.controller;

import com.maks.classroster.dao.ClassRosterPersistenceException;
import com.maks.classroster.dto.Student;
import com.maks.classroster.service.ClassRosterDataValidationException;
import com.maks.classroster.service.ClassRosterDuplicateIdException;
import com.maks.classroster.service.ClassRosterServiceLayer;
import com.maks.classroster.ui.ClassRosterView;

import java.util.List;

public class ClassRosterController {

    private ClassRosterView view;
    private ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterView view, ClassRosterServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1 -> listStudents();
                    case 2 -> createStudent();
                    case 3 -> viewStudent();
                    case 4 -> removeStudent();
                    case 5 -> keepGoing = false;
                    default -> unknownCommand();
                }

            }
            exitMessage();

        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = service.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
