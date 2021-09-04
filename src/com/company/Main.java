package com.company;

import com.company.view.ClassMenu;
import com.company.view.LoginMenu;
import com.company.view.StudentMenu;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.run();
    }


}
