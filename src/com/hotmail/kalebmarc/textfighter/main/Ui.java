package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Ui {
    public static boolean guiEnabled = true;
    private final static Scanner IN = new Scanner(System.in);
    private Ui() {
    }

    public static boolean isDecimalNumber(String string) {
        if (string == null) {
            return false;
        }

        //Search for 1 or more digits followed by a `.` and 1 or more digits after the dot
        return string.matches("\\d+\\.\\d+");
    }

    public static boolean isNumber(String string) {
        if (string == null) return false;

        //Search for any character that is not a digit
        //If you find a non-digit char, return false
        return !string.matches("\\D");
    }

    /*
     * The whole purpose of this class is to make it easy to change from using the Console to other
     * ways to output information. For example, switching to a GUI application, instead of changing
     * every System.out.println() in the program, you can change just the methods in this class.
     *
     * Also to control whether popup should actually be a popup or not, based on user preference
     */

    public static <T> void print(T input){
        System.out.print(String.valueOf(input));
    }

    public static <T> void println(T input){
        System.out.println(String.valueOf(input));
    }

    public static void print(){
        System.out.print("");
    }

    public static void println(){
        System.out.println("");
    }

    /**
     * Clears screen, prints msg, then calls pause();.
     *
     * @param msg string to output
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
        while (!IN.hasNextInt()) {
            IN.nextLine();
        }
        return IN.nextInt();
    }

    public static int getValidInt(int min, int max) {
        int value = getValidInt();

        while (min > value || value > max)
            value = getValidInt();

        return value;
    }

    public static String getValidString() {

        IN.reset();
        return IN.next();

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
