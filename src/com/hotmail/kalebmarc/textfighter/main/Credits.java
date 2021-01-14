package com.hotmail.kalebmarc.textfighter.main;

class Credits {

    public static void view() {
        while (true) {

            Ui.cls();
            Ui.println("------------------------------------------------------------------");
            Ui.println("*");
            Ui.println("------------------------------------------------------------------");
            Ui.println("0) Back");
            Ui.println("------------------------------------------------------------------");

            switch (Ui.getValidInt()) {
                case 0:
                    return;
                default:
                    break;
            }
        } //while loop
    } //view method
} //class
