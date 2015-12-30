package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;

class Splash{
	private Splash(){}
	public static void screen(){

        //Skip splash screen if GUI is disabled, or if in a DEV build
		if(!Ui.guiEnabled) return;
        if(Debug.enabled()) return;

		//Splash Screen objects
		JFrame splashFrame;
		JLabel splashLabel;
		ImageIcon splashIcon;
		splashFrame = new JFrame();
		splashIcon = new ImageIcon(Start.class.getResource("/com/hotmail/kalebmarc/textfighter/main/gfx/TFLogo.png"));
		splashLabel = new JLabel(splashIcon);
		
		//Splash screen Properties
		splashFrame.add(splashLabel);
		splashFrame.setAlwaysOnTop(true);
		splashFrame.setUndecorated(true);
		splashFrame.pack();
		splashFrame.setLocationRelativeTo(null);
		splashFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		splashFrame.setVisible(true);
		
		//Pause splash screen
		try {
			Thread.sleep(750);
		} catch (Exception e) {
			Handle.error(e.toString());
		}
		
		//Close Splash screen
		splashFrame.setVisible(false);
		splashFrame.dispose();
	}
}