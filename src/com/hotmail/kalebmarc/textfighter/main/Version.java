package com.hotmail.kalebmarc.textfighter.main;

class Version {
	private Version(){}
	
	private static final String VERSION = "4.5";
	
	private static final String STAGE = "Alpha";
	
	private static final String DESC = ""
			+ "Text-Fighter is a Text-Based\n"
			+ "Fighter RPG game, completely\n"
			+ "written in Java. Text-Fighter\n"
			+ "is made by Kaleb Haslam\n\n"
			+ "Text-Fighter is currently in Alpha stage\n"
			+ "which means it's still in early development,\n"
			+ "and will contain lots of bugs and missing features.";
	
	private static final String CHANGE_LOG = ""
			+ "(Not compatible with previous saves)\n\n"
			
			+ "New Stuff:\n"
			+ "- Renamed Villain to Barbarian\n"
			+ "- Renamed Snake to Giant Ant\n"
			+ "- Added Evil Unicorn (Extra coins & XP)\n"
			+ "- Added Ogre (Hard)\n"
			+ "- Added total coins spent stat\n"
			+ "- Added Coins spent on weapons/ammo stat\n"
			+ "- Added coins spent on health stat\n"
			+ "- Added coins spent on bank interest stat\n"
			+ "- Added bullets fired stat\n"
			+ "- Added bullets that hit stat\n"
			+ "- Added K:D ratio stat\n"
			+ "- Added times cheated stat\n"
			+ "- Added times quit stat\n"
			+ "- Added Items Crafted stat\n"
			+ "- Added Dice Games played stat\n"
			+ "- Added Slot Games played stat\n"
			+ "- Added XP bought stat\n"
			+ "- Added Godmode cheat\n"
			+ "- Added option to turn off pop-up windows\n"
			+ "- Added better way to deal with output\n"
			+ "- Added option to start with \"nogui\"\n\n"
			
			+ "Bug Fixes:\n"
			+ "- Fixed getting XP when cheats are enabled";
	
	public static String get(){
		return VERSION;
	}
	public static String getStage(){
		return STAGE;
	}
	public static String getFull(){
		return STAGE + " " + VERSION;
	}
	public static String getDesc(){
		return DESC;
	}
	public static String getChange(){
		return CHANGE_LOG;
	}
}
