package com.hotmail.kalebmarc.textfighter.main;

class Credits {

    public static void view() {
        while (true) {

            Ui.cls();
            Ui.println("------------------------------------------------------------------");
            Ui.println("hhaslam11 - Head Developer");
            Ui.println("BrendonButler");
            Ui.println("TimerErTim");
            Ui.println("docschorsch");
            Ui.println("htn17");
            Ui.println("Will-Estes");
            Ui.println("CLEMENTJOHNSHAJI");
            Ui.println("alfr3dosv");
            Ui.println("xdvrx1");
            Ui.println("RindT");
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
