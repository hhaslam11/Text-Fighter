package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;

public class Handle {
    private Handle() {
    }

    public static void error(String e) {
        System.err.println(e);
        Ui.popup(e, "An error has occurred", JOptionPane.WARNING_MESSAGE);
    }
}
