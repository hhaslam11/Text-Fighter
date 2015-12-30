package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;

class About {
	private About(){}

	private static boolean viewed = false;

	public static void view(boolean achValid){
						
		//Displays basic information
		Ui.popup("Text-Fighter " + Version.getFull() + "\n\n" + Version.getDesc(), "About", JOptionPane.INFORMATION_MESSAGE);
		
		//Displays the Change log (Pops-up after the basic information frame closes)
		Ui.popup("Text-Fighter " + Version.getFull() + " Change Log\n\n" + Version.getChange(), "Change Log", JOptionPane.INFORMATION_MESSAGE);

		if (achValid) {
			viewed = true;
		}
	}
	public static boolean viewed() {
		return viewed;
	}
	public static void setViewed(boolean v){
        viewed = v;
    }
}
