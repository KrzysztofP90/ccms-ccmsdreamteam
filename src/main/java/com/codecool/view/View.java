package com.codecool.view;

import com.codecool.model.User;

import java.util.List;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    public void printMainMenu() {
        printHeader();
        System.out.println("1.Log In\n2.Exit");
        printGetOption();
    }
    public void printInputLogin() {
        System.out.print("Input user login: ");
    }
    public void printInputPassword() {
        System.out.print("Input user password: ");
    }
    public void printUserLoginPasswordError() {
        System.out.println("User login or password is incorrect!");
    }
    public void printMenuForUser(String[] userMenu){
        for (int i = 0; i < userMenu.length; i++) {
            System.out.println("(" + (i + 1) + ") " + userMenu[i]);
        }
    }
    public void printListOfUsers(List<User> listOfUsers) {
        int num = 1;
        for (User user : listOfUsers) {
            System.out.println("(" + num + ") " + user.getNameOfUser() + " " + user.getSurnameOfUser());
            System.out.println("Login: " + user.getLogin());
            num ++;
        }
    }

    public void printGradedAssigmentForStudent(List<String> dataAssignmentList) {
        int num = 1;
        for (int i = 0; i < dataAssignmentList.size(); i += 4) {
            String tittle = dataAssignmentList.get(i);
            String link = dataAssignmentList.get(i + 1);
            String status = dataAssignmentList.get(i + 2);
            String grade = dataAssignmentList.get(i + 3);
            System.out.println("Tittle: " + tittle + "| Link: " + link + "| Status: " + status + "| Grade: " + grade);

        }

    }

    private void printHeader() {
        System.out.println("CcMS - Codecool Management System");
    }
    private void printGetOption() {
        System.out.print("Choose option: ");
    }
    public int getUserMenuOption() {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean isNumber = false;

        while (!isNumber) {
            try {
                userInput = scanner.nextInt();
                isNumber = true;
            } catch (InputMismatchException e) {
                printErrorInputMessage();
                scanner.next();
            }
        }
        return userInput;
    }
    public String getUserLogin() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        try {
            userInput = scanner.next();
        } catch (InputMismatchException e) {
            printErrorInputMessage();
        }
        return userInput;
    }

    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String stringInput = "";
        try {
            stringInput = scanner.nextLine();
        } catch (InputMismatchException e) {
            printErrorInputMessage();
        }
        return stringInput;
    }
    public String getUserPassword() {
        return getUserLogin();
    }

    public void printErrorInputMessage() {
        System.out.println("Provide proper input!");
    }

    public void printWelcomeUser(String user) {
        System.out.println("Welcome" + user + "!");
    }


    public String getStringInputFromUser(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
    public void askMentorToSetTitle(){
        System.out.println("Set assignment title: ");
    }
    public void printGetTitle() {
        System.out.print("Input title of an assignment: ");
    }
    public void printGetLink() {
        System.out.print("Submit assignment link: ");
    }

}
