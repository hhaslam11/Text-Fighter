package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Ui {
    public static boolean guiEnabled = true;
    private static Scanner in = new Scanner(System.in);
    private Ui() {
    }

    public static boolean isDecimalNumber(String string) {
        if (string == null) {
            return false;
        }

        int length = string.length();

        if (length == 1) {
            return false;
        }

        int i = 0;

        if (string.charAt(0) == '-') {
            if (length < 3) {
                return false;
            }
            i = 1;
        }

        int numOfDot = 0;

        for (; i < length; i++) {
            char c = string.charAt(i);
            if (c == '.')
                numOfDot++;
            else if (c == '/')
                return false;
            else if (c < '.' || c > '9') {
                return false;
            }
        }

        return (numOfDot == 1);
    }

    public static boolean isNumber(String string) {
        if (string == null) return false;

        int length = string.length();

        if (length == 0) return false;

        int i = 0;

        if (string.charAt(0) == '-') {
            if (length == 1) return false;

            i = 1;
        }

        for (; i < length; i++) {
            char c = string.charAt(i);

            if (c <= '/' || c >= ':') return false;
        }
        return true;
    }

    /*
     * The whole purpose of this class is to make it easy to change from using the Console to other
     * ways to output information. For example, switching to a GUI application, instead of changing
     * every System.out.println() in the program, you can change just the methods in this class.
     *
     * Also to control whether popup should actually be a popup or not, based on user preference
     */
    public static void print(String input) {
        System.out.print(input);
    }

    public static void println(String input) {
        print(input + "\n");
    }

    public static void print(int input) {
        print(input + "");
    }

    public static void println(int input) {
        print(input + "\n");
    }

    public static void print(boolean input) {
        print(input + "");
    }

    public static void println(boolean input) {
        print(input + "\n");
    }

    public static void print(double input) {
        print(input + "");
    }

    public static void println(double input) {
        print(input + "\n");
    }

    public static void println() {
        print("\n");
    }

    /**
     * Clears screen, prints msg, then calls pause();.
     *
     * @param msg
     */
    public static void msg(String msg) {//TODO use this instead throughout project
        if (msg == null || msg.equals("")) {
            cls();
            pause();
        }

        cls();
        println(msg);
        pause();
    }

    /**
     * @param msgType Ex. JOptionPane.ERROR_MESSAGE
     */
    public static void popup(String body, String title, int msgType) {
        if (guiEnabled) {
            JOptionPane.showMessageDialog(null, body, title, msgType);
        } else {
            msg(body);
        }
    }

    public static int confirmPopup(String body, String title) {
        if (guiEnabled) {
            return JOptionPane.showConfirmDialog(null, body, title, JOptionPane.YES_NO_OPTION);
        } else {
            cls();
            println(body);
            println("(Y/N)");

            //TODO Replace this next snippet when using JTools lib
            //TODO Or.. Just write this better.
            //----------------------------------------------------
            java.util.Scanner in = new java.util.Scanner(System.in);

            while (!in.hasNextLine()) {
                in.nextLine();
            }

            String valid = in.nextLine();
            valid = valid.toUpperCase();
            if (valid.isEmpty()) {
                return 1;
            }
            char input = valid.charAt(0);
            //-----------------------------------------------------

            cls();
            if (input == 'Y') return 0;
            return 1;
        }
    }

    /*
     * Clears the console by attempting to run either the 'cls' (Windows CMD) or
     * 'clear' (Other terminals) command. If this is interrupted, the terminal
     * will be brute-force cleared
     */
    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException exception) {
            for (int i = 1; i < 50; i++)
                println("\n");
        }
    }

    public static int getValidInt() {
        while (!in.hasNextInt()) {
            in.nextLine();
        }
        return in.nextInt();
    }

    public static String getValidString() {

        in.reset();
        return in.next();

    }

    /*
     * Stops the program until the user presses enter, then continues
     */
    public static void pause() {
        try {

            Scanner pauseScan = new Scanner(System.in);
            String temp = pauseScan.nextLine();
            println(temp);


        } catch (Exception e) {
            //Blank for a reason - Not supposed to do anything.
        }
    }
}
