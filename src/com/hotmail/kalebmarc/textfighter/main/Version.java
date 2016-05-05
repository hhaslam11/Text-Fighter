package com.hotmail.kalebmarc.textfighter.main;

class Version {
	private Version(){}
	
	private static final String VERSION = "4.7";
	
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
			+ "- Remove \"Not available\" in amour & weapon shop, and equip armour & equip weapon menu\n"
			+ "- nogui on by default\n"
			+ "- Potions\n"
			+ "- NPC's\n"
            + "- Changed way to access cheat menu\n"
            + "- Added more cheats\n"
            + "- Loans\n"
            + "- Better save file names\n"
            + "- Usernames (Again...)\n"
            + "- General optimizations\n"
			+ "- Auto Save\n\n"

			+ "Bug Fixes:\n"
			+ "- Remove crafting from help menu\n"
			+ "- Fixed not showing option 1 in Body Armour menu\n"
			+ "- Fixed showing no armour is equipped when starting new game";
	
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
