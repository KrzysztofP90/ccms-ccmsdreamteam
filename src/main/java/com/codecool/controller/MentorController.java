package com.codecool.controller;

import com.codecool.dao.MentorDAO;
import com.codecool.model.User;
import com.codecool.view.View;

public class MentorController {

    private MentorDAO mentorDAO;
    private User mentor;
    private View view;
    private final String[] mentorMenu = {"List students",
                                         "Add assignment",
                                         "Grade assignment",
                                         "Check attendance",
                                         "Add student",
                                         "Remove student",
                                         "Edit student",
                                         "Log out"};

    public MentorController(User mentorUser) {
        this.mentor = mentorUser;
        this.mentorDAO = new MentorDAO();
        this.view = new View();
    }

    public void manageMentor() {
        int listStudentsOption = 1;
        int addAssignmentOption = 2;
        int gradeAssignmentOption = 3;
        int checkAttendanceOption = 4;
        int addStudentOption = 5;
        int removeStudentOption = 6;
        int editStudentsOption = 7;
        int logOutOption = 8;
        boolean exit = false;

        view.printWelcomeUser(mentor.toString());
        while (!exit) {
            view.printMenuForUser(this.mentorMenu);
            int userMenuOption = view.getUserMenuOption();

            if (userMenuOption == listStudentsOption) {
                // TODO
            } else if (userMenuOption == addAssignmentOption) {
                // TODO
            } else if (userMenuOption == gradeAssignmentOption) {
                // TODO
            } else if (userMenuOption == checkAttendanceOption) {
                // TODO
            } else if (userMenuOption == addStudentOption) {
                // TODO
            } else if (userMenuOption == removeStudentOption) {
                // TODO
            } else if (userMenuOption == editStudentsOption) {
                // TODO
            } else if (userMenuOption == logOutOption) {
                exit = true;
            } else {
                view.printErrorInputMessage();
            }
        }
    }

    public void addAssigmen(){

    }

    public boolean gradeAssigment(boolean isPositiveGrade){
        return isPositiveGrade;
    }

    public void addStudent(){

    }

    public void removeStudent(){

    }

    public void editStudent(){

    }

    public void checkAttendance(){

    }
}
