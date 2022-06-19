package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.JOptionPane;

public class Handle {
    private Handle() {
    }

    public static void error(String e) {
        System.err.println(e);
        Ui.popup(e, "An error has occurred", JOptionPane.WARNING_MESSAGE);
    }

    public static void error(String e, Object... objects) {
        System.err.printf(e, objects);
        Ui.popup(String.format(e, objects), "An error has occurred", JOptionPane.WARNING_MESSAGE);
    }
}
