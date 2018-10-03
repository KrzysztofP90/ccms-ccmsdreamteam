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
            num ++;
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
    public String getUserPassword() {
        return getUserLogin();
    }
    public void printErrorInputMessage() {
        System.out.println("Provide proper input!");
    }
    public void printWelcomeUser(String user) {
        System.out.println("Welcome" + user + "!");
    }

}
