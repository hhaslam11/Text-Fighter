package com.hotmail.kalebmarc.textfighter.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.representer.Representer;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.Achievements;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Potion;
import com.hotmail.kalebmarc.textfighter.player.Settings;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

/**
 * Created by Brendon Butler on 7/27/2016.
 */
public class Saves {

	private static DumperOptions options;
	private static File saveLocation;
	private static Map<String, Object> data;
	private static Representer representer;
	private static Scanner input;
	private static String path;
	private static Yaml yaml;

	public static void save() {

		path = Saves.class.getProtectionDomain().getCodeSource().getLocation().getPath() + ".TFsave";
		path = path.replace(".jar", "_" + User.name());
		path = path.replaceAll("%20", " ");

		setup();

		/*
		 * TODO: make a version checker that checks each part of a version ex: 1.4.1DEV
		 * then determine whether or not it's older, current or newer.
		 */
		set("Version", Version.getFull());

		//Health
		set("User.Health", Health.get());
		set("User.Max_Health", Health.getOutOf());
		set("User.FirstAid.Owns", FirstAid.get());
		set("Stats.FirstAid.Used", FirstAid.used);
		set("User.InstaHealth.Owns", InstaHealth.get());
		set("Stats.InstaHealth.Used", InstaHealth.used);
		set("Stats.TimesDied", Health.timesDied);

		//Coins
		set("User.Balance", Coins.get());
		set("Bank.Balance", Bank.get());
		set("Casino.Winnings", Casino.totalCoinsWon);
		set("Casino.Plays", Casino.gamesPlayed);
		set("Casino.Lottery.Bought_Tickets", Casino.LOTTERY.getTicketsBought());
		set("Achievements.Bought_Item", Achievements.boughtItem);
		set("Stats.Money_Spent.Coins", Stats.totalCoinsSpent);
		set("Stats.Money_Spent.Interest", Stats.coinsSpentOnBankInterest);
		set("Stats.Money_Spent.Weapons", Stats.coinsSpentOnWeapons);
		set("Stats.Money_Spent.Health", Stats.coinsSpentOnHealth);
		set("Stats.Money_Spent.XP", Stats.xpBought);
		set("Stats.Blackjack_Games_Played", Stats.blackjackGamesPlayed);
		set("Stats.Lottery_Tickets_Bought", Stats.lotteryTicketsBought);
		set("Stats.Lottery_Won", Stats.lotteryWon);
		set("Bank.Current_Loan.Balance", Loan.getCurrentLoan());
		set("Bank.Current_Loan.Due", Loan.getNetDue());

		//Xp
		set("User.XP.Level", Xp.getLevel());
		set("User.XP.Needed", Xp.getOutOf());
		set("User.XP.Amount", Xp.get());
		set("User.XP.Total", Xp.total);
		set("User.XP.battleXp", Xp.getBattleXp());

		//Potions
		set("Stats.Potions.Survival.Used", Potion.spUsed);
		set("Stats.Potions.Recovery.Used", Potion.rpUsed);
		set("User.Potions.Survival", Potion.get("survival"));
		set("User.Potions.Recovery", Potion.get("recovery"));

		//Settings
		set("Settings.Difficulty.Level", Settings.getDif());
		set("Settings.Difficulty.Locked", Settings.difLocked);
		set("Settings.Cheats.Enabled", Cheats.enabled());
		set("Settings.Cheats.Locked", Cheats.locked());
		set("Settings.GUI.Enabled", Ui.guiEnabled);

		//Combat
		set("Stats.Kills", Stats.kills);
		set("Stats.Total_Kills", Stats.totalKills);
		set("Stats.High_Score", Stats.highScore);
		set("User.Weapons.Current", Weapon.getWeapons().indexOf(Weapon.get()));


		for (int i = 0; i < Weapon.getWeapons().size(); i++) {
			if (Weapon.getWeapons().get(i).owns()) {
				set(("User.Weapons." + i), true);
			} else {
				set(("User.Weapons." + i), false);
			}
			set(("User.Weapons.Ammo." + i), Weapon.getWeapons().get(i).getAmmo());
		}


		set("User.Power", Power.get());
		set("Stats.Power.Used", Power.used);
		set("Stats.Damage_Dealt", Stats.totalDamageDealt);
		set("Stats.Bullets_Fired", Stats.bulletsFired);
		set("Stats.Bullets_Hit", Stats.bulletsThatHit);

		List<Integer> ownedArmour = new ArrayList<>();

		for (int i = 0; i < Armour.getArmours().size(); i++)
			if (Armour.getArmours().get(i).isOwns())
				ownedArmour.add(i);
		set("User.Armour.Owns", ownedArmour);

		set("User.Armour.Current", Armour.get());

		//Enemy
		set("Battle.Current.Enemy", Enemy.getEnemies().indexOf(Enemy.get()));
		set("Battle.Current.Enemy_Health", Enemy.get().getHealth());
		set("Battle.Current.Enemy_Max_Health", Enemy.get().getHealthMax());
		set("Battle.Current.Enemy_First_Aid_Kit", Enemy.get().getFirstAidKit());

		//Achs
		set("Achievements.Money_Maker", Achievements.moneyMaker);
		set("Achievements.Enemy_Slayer", Achievements.enemySlayer);
		set("Achievements.First_Kill", Achievements.firstKill);
		set("Achievements.Time_For_An_Upgrade", Achievements.timeForAnUpgrade);

		List<String> enemiesKilled = new ArrayList<>();

		for (int i = 0; i < Enemy.getEnemies().size(); i++)
			if (Achievements.arrayKilled.get(i))
				enemiesKilled.add(Enemy.getEnemies().get(i).getName());
		set("Achievements.Enemies_Killed", enemiesKilled);
		set("Achievements.Text_Fighter_Master", Achievements.textFighterMaster);
		set("Achievements.YAY_POWER", Achievements.YAYPOWER);
		set("Achievements.Aww_You_Care_About_Me", Achievements.awwYouCareAboutMe);
		set("Achievements.Slayer", Achievements.slayer);
		set("Achievements.Nobodys_Perfect", Achievements.nobodysPerfect);
		set("Achievements.Making_Money", Achievements.makingMoney);
		set("Achievements.Gambling_Addiction", Achievements.gamblingAddiction);
		set("Achievements.Unnatural_Luck", Achievements.unnaturalLuck);
		set("Achievements.Level_2_Fighter", Achievements.level2Fighter);
		set("Achievements.Level_3_Fighter", Achievements.level3Fighter);
		set("Achievements.Level_4_Fighter", Achievements.level4Fighter);
		set("Achievements.Level_5_Fighter", Achievements.level5Fighter);
		set("Achievements.Level_6_Fighter", Achievements.level6Fighter);
		set("Achievements.Level_7_Fighter", Achievements.level7Fighter);
		set("Achievements.Level_8_Fighter", Achievements.level8Fighter);
		set("Achievements.Level_9_Fighter", Achievements.level9Fighter);
		set("Achievements.Level_10_Fighter", Achievements.level10Fighter);
		set("Achievements.Honest_Player", Achievements.honestPlayer);

		//Other Stuff
		set("Settings.About_Viewed", About.viewed());
		set("Stats.Times_Cheated", Stats.timesCheated);
		set("Stats.Times_Quit", Stats.timesQuit);
		set("Stats.Items_Crafted", Stats.timesCheated);
		set("Stats.Games_Played.Dice", Stats.diceGamesPlayed);
		set("Stats.Games_Played.Slots", Stats.slotGamesPlayed);

		try {
			if (!saveLocation.exists())
				saveLocation.createNewFile();

			FileWriter writer = new FileWriter(saveLocation);

			writer.write(yaml.dump(data));
			writer.flush();
			writer.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static boolean load() {
		setup();

		FileReader reader = read(saveLocation);

		if (reader == null) {
			Ui.cls();
			Ui.println("------------------------------");
			Ui.println("Cannot find save file.  ");
			Ui.println("Starting a new game...  ");
			Ui.println("------------------------------");
			Ui.pause();

			data = Collections.synchronizedMap(new LinkedHashMap<String, Object>());
			return true;
		}

		data = Collections.synchronizedMap((Map<String, Object>) yaml.load(reader));

		//Health
		Health.set(getInteger("User.Health"), getInteger("User.Max_Health"));
		FirstAid.set(getInteger("User.FirstAid.Owns"), false);
		FirstAid.used = getInteger("Stats.FirstAid.Used");
		InstaHealth.set(getInteger("User.InstaHealth.Owns"), false);
		InstaHealth.used = getInteger("Stats.InstaHealth.Used");
		Health.timesDied = getInteger("Stats.TimesDied");

		//Coins
		Coins.set(getInteger("User.Balance"), false);
		Bank.set(getInteger("Bank.Balance"), false);
		Casino.totalCoinsWon = getInteger("Casino.Winnings");
		Casino.gamesPlayed = getInteger("Casino.Plays");
		Casino.LOTTERY.setTicketsBought(getInteger("Casino.Lottery.Bought_Tickets"));
		Achievements.boughtItem = getBoolean("Achievements.Bought_Item");
		Stats.totalCoinsSpent = getInteger("Stats.Money_Spent.Coins");
		Stats.coinsSpentOnBankInterest = getInteger("Stats.Money_Spent.Interest");
		Stats.coinsSpentOnWeapons = getInteger("Stats.Money_Spent.Weapons");
		Stats.coinsSpentOnHealth = getInteger("Stats.Money_Spent.Health");
		Stats.xpBought = getInteger("Stats.Money_Spent.XP");
		Stats.blackjackGamesPlayed = getInteger("Stats.Blackjack_Games_Played");
		Stats.lotteryTicketsBought = getInteger("Stats.Lottery_Tickets_Bought");
		Stats.lotteryWon = getInteger("Stats.Lottery_Won");
		Loan.setCurrentLoan(getInteger("Bank.Current_Loan.Balance"));
		Loan.setNetDue(getInteger("Bank.Current_Loan.Due"));

		//Xp
		Xp.setLevel(getInteger("User.XP.Level"));
		Xp.setOutOf(getInteger("User.XP.Needed"));
		Xp.set(getInteger("User.XP.Amount"), false);
		Xp.total = getInteger("User.XP.Total");
		Xp.setBattleXp(getInteger("User.XP.battleXp"), false);

		//Potions
		Potion.spUsed = getInteger("Stats.Potions.Survival.Used");
		Potion.rpUsed = getInteger("Stats.Potions.Recovery.Used");
		Potion.set("survival", getInteger("User.Potions.Survival"), false);
		Potion.set("recovery", getInteger("User.Potions.Recovery"), false);

		//Settings
		Settings.setDif(getString("Settings.Difficulty.Level"), false, false);
		Settings.difLocked = getBoolean("Settings.Difficulty.Locked");
		if(getBoolean("Settings.Cheats.Enabled")) Cheats.enable();
		if(getBoolean("Settings.Cheats.Locked")) Cheats.lock();
		Ui.guiEnabled = getBoolean("Settings.GUI.Enabled");

		//Combat
		Stats.kills = getInteger("Stats.Kills");
		Stats.highScore = getInteger("Stats.High_Score");
		Stats.totalKills = getInteger("Stats.Total_Kills");
		Weapon.set(getInteger("User.Weapons.Current"));

		for(int i = 0; i < Weapon.getWeapons().size(); i++){
			if (getBoolean("User.Weapons." + i)){
				Weapon.getWeapons().get(i).owns = true;
			}
			Weapon.getWeapons().get(i).setAmmo(getInteger("User.Weapons.Ammo." + i), false);
		}

		Power.set(getInteger("User.Power"), false);
		Power.used = getInteger("Stats.Power.Used");
		Stats.totalDamageDealt = getInteger("Stats.Damage_Dealt");
		Stats.bulletsFired = getInteger("Stats.Bullets_Fired");
		Stats.bulletsThatHit = getInteger("Stats.Bullets_Hit");

		List<Integer> armours = (List<Integer>) getList("User.Armour.Owns");

		for(int i = 0; i < armours.size(); i++)
			Armour.getArmours().get(i).setOwns(true);

		Armour.set(getInteger("User.Armour.Current"));

		//Enemy
		Enemy.set(getInteger("Battle.Current.Enemy"));
		Enemy.get().setHealth(getInteger("Battle.Current.Enemy_Health"), getInteger("Battle.Current.Enemy_Max_Health"));
		Enemy.get().setFirstAidKit(getInteger("Battle.Current.Enemy_First_Aid_Kit"));

		//Achs
		Achievements.moneyMaker         = getBoolean("Achievements.Money_Maker");
		Achievements.enemySlayer        = getBoolean("Achievements.Enemy_Slayer");
		Achievements.firstKill          = getBoolean("Achievements.First_Kill");
		Achievements.timeForAnUpgrade   = getBoolean("Achievements.Time_For_An_Upgrade");

		List<String> achSet = (List<String>) getList("Achievements.Enemies_Killed");

		for (int i = 0; i < achSet.size(); i++){
			for (int x = 0; x < Enemy.getEnemies().size(); x++){
				if(Enemy.getEnemies().get(x).getName().equals(achSet.get(i))){
					Achievements.arrayKilled.set(x, true);
				}
			}
		}
		Achievements.textFighterMaster  = getBoolean("Achievements.Text_Fighter_Master");
		Achievements.YAYPOWER           = getBoolean("Achievements.YAY_POWER");
		Achievements.awwYouCareAboutMe  = getBoolean("Achievements.Aww_You_Care_About_Me");
		Achievements.slayer             = getBoolean("Achievements.Slayer");
		Achievements.nobodysPerfect     = getBoolean("Achievements.Nobodys_Perfect");
		Achievements.makingMoney        = getBoolean("Achievements.Making_Money");
		Achievements.unnaturalLuck 		= getBoolean("Achievements.Unnatural_Luck");
		Achievements.gamblingAddiction  = getBoolean("Achievements.Gabling_Addiction");
		Achievements.level2Fighter      = getBoolean("Achievements.Level_2_Fighter");
		Achievements.level3Fighter      = getBoolean("Achievements.Level_3_Fighter");
		Achievements.level4Fighter      = getBoolean("Achievements.Level_4_Fighter");
		Achievements.level5Fighter      = getBoolean("Achievements.Level_5_Fighter");
		Achievements.level6Fighter      = getBoolean("Achievements.Level_6_Fighter");
		Achievements.level7Fighter      = getBoolean("Achievements.Level_7_Fighter");
		Achievements.level8Fighter      = getBoolean("Achievements.Level_8_Fighter");
		Achievements.level9Fighter      = getBoolean("Achievements.Level_9_Fighter");
		Achievements.level10Fighter     = getBoolean("Achievements.Level_10_Fighter");
		Achievements.honestPlayer       = getBoolean("Achievements.Honest_Player");

		//Other Stuff
		About.setViewed(getBoolean("Settings.About_Viewed"));
		Stats.timesCheated = getInteger("Stats.Times_Cheated");
		Stats.timesQuit = getInteger("Stats.Times_Quit");
		Stats.itemsCrafted = getInteger("Stats.Items_Crafted");
		Stats.diceGamesPlayed = getInteger("Stats.Games_Played.Dice");
		Stats.slotGamesPlayed = getInteger("Stats.Games_Played.Slots");

		return true;
	}

	private static void setup() {
		saveLocation = new File(path);
		if (!saveLocation.exists())
			try {
				saveLocation.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}

		setupDumper();

		yaml = new Yaml(representer, options);
		data = Collections.synchronizedMap(new LinkedHashMap<String, Object>());
	}

	private static void setupDumper() {
		options = new DumperOptions();
		representer = new Representer();

		options.setIndent(2);
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		options.setAllowUnicode(Charset.defaultCharset().name().contains("UTF"));
		representer.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
	}

	public static boolean savesPrompt() {
		User.promptNameSelection();
		path = Saves.class.getProtectionDomain().getCodeSource().getLocation().getPath() + ".TFsave";
		path = path.replace(".jar", "_" + User.name());
		path = path.replaceAll("%20", " ");

		Ui.cls();
		Ui.println("------------------------------");
		Ui.println("What would you like to do?");
		Ui.println("------------------------------");
		Ui.println("1) Load Save");
		Ui.println("2) Convert Old Save");
		Ui.println("3) Exit");

		switch (Ui.getValidInt()) {
			case 1:
				load();
				break;
			case 2:
				//docschorsch 'if' needed for exit during convert()
				if(!convert()) {
					return false;
				} else {
					break;
				}
			default:
				return false;
		}
		return true;
	}

	public static boolean convert() {
		Ui.cls();
		Ui.println("------------------------------------");
		Ui.println("WARNING- Converting a save file may");
		Ui.println("result in a corrupt save.");
		Ui.println("It's recommended that you make a");
		Ui.println("backup of your current save file(s)");
		Ui.println("before you continue.");
		Ui.println("------------------------------------");
		Ui.println("1) Exit");
		Ui.println("2) Continue");

		switch(Ui.getValidInt()){
			case 1:
				return false;
			case 2:
				break;
			default:
				return false;
		}

		try {
			File file = new File(path);

			if (!file.exists()) {
				Ui.println("File not found. Please put an \"_\" before your username in the save file.");
				System.exit(0); //TODO shouldn't just exit like this.... Go back to main menu
			}

			input = new Scanner(file);

			setup();
			readString();

			//Health
			Health.set(readInt(), readInt());
			FirstAid.set(readInt(), false);
			FirstAid.used = readInt();
			InstaHealth.set(readInt(), false);
			InstaHealth.used = readInt();
			Health.timesDied = readInt();

			//Coins
			Coins.set(readInt(), false);
			Bank.set(readInt(), false);
			Casino.totalCoinsWon = readInt();
			Casino.gamesPlayed = readInt();
			Achievements.boughtItem = readBoolean();
			Stats.totalCoinsSpent = readInt();
			Stats.coinsSpentOnBankInterest = readInt();
			Stats.coinsSpentOnWeapons = readInt();
			Stats.coinsSpentOnHealth = readInt();
			Stats.xpBought = readInt();
			Loan.setCurrentLoan(readInt());
			Loan.setNetDue(readInt());

			//Xp
			Xp.setLevel(readInt());
			Xp.setOutOf(readInt());
			Xp.set(readInt(), false);
			Xp.total = readInt();
			Xp.setBattleXp(readInt(), false);

			//Potions
			Potion.spUsed = readInt();
			Potion.rpUsed = readInt();
			Potion.set("survival", readInt(), false);
			Potion.set("recovery", readInt(), false);


			//Settings
			Settings.setDif(input.nextLine(), false, false);
			if (readBoolean()) Cheats.enable();
			if (readBoolean()) Cheats.lock();
			Settings.difLocked = readBoolean();
			Ui.guiEnabled = readBoolean();

			//Combat
			Stats.kills = readInt();
			Stats.highScore = readInt();
			Stats.totalKills = readInt();
			Weapon.set(readInt());
			for (int i = 0; i < Weapon.getWeapons().size(); i++)
				Weapon.getWeapons().get(i).owns = readBoolean();
			for (int i = 0; i < Weapon.getWeapons().size(); i++)
				Weapon.getWeapons().get(i).setAmmo(readInt(), false);
			Power.set(readInt(), false);
			Power.used = readInt();
			Stats.totalDamageDealt = readInt();
			Stats.bulletsFired = readInt();
			Stats.bulletsThatHit = readInt();
			for (int i = 0; i < Armour.getArmours().size(); i++)
				Armour.getArmours().get(i).setOwns(readBoolean());
			Armour.set(readInt());

			//Enemy
			Enemy.set(readInt());
			Enemy.get().setHealth(readInt(), Enemy.get().getHealthMax());

			//Achs
			Achievements.moneyMaker = readBoolean();
			Achievements.enemySlayer = readBoolean();
			Achievements.firstKill = readBoolean();
			Achievements.timeForAnUpgrade = readBoolean();
			for (int i = 0; i < Enemy.getEnemies().size(); i++)
				Achievements.arrayKilled.set(i, readBoolean());
			Achievements.textFighterMaster = readBoolean();
			Achievements.YAYPOWER = readBoolean();
			Achievements.awwYouCareAboutMe = readBoolean();
			Achievements.slayer = readBoolean();
			Achievements.nobodysPerfect = readBoolean();
			Achievements.makingMoney = readBoolean();
			Achievements.gamblingAddiction = readBoolean();
			Achievements.level2Fighter = readBoolean();
			Achievements.level3Fighter = readBoolean();
			Achievements.level4Fighter = readBoolean();
			Achievements.level5Fighter = readBoolean();
			Achievements.level6Fighter = readBoolean();
			Achievements.level7Fighter = readBoolean();
			Achievements.level8Fighter = readBoolean();
			Achievements.level9Fighter = readBoolean();
			Achievements.level10Fighter = readBoolean();
			Achievements.honestPlayer = readBoolean();

			//Other Stuff
			About.setViewed(readBoolean());
			Stats.timesCheated = readInt();
			Stats.timesQuit = readInt();
			Stats.itemsCrafted = readInt();
			Stats.diceGamesPlayed = readInt();
			Stats.slotGamesPlayed = readInt();

			save();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static boolean contains(String key) {
		return data.containsKey(key);
	}

	public static boolean exists() {
		return data != null;
	}

	public static boolean getBoolean(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Boolean)
			return (Boolean) tempObject;
		if (tempObject instanceof String)
			if (tempObject.toString().equalsIgnoreCase("true") || tempObject.toString().equalsIgnoreCase("1"))
				return true;
			else if (tempObject.toString().equalsIgnoreCase("false") || tempObject.toString().equalsIgnoreCase("0"))
				return false;
		if (tempObject instanceof Number)
			if (((Number) tempObject).intValue() == 1)
				return true;
			else if (((Number) tempObject).intValue() == 0)
				return false;
		return false;
	}

	public static boolean hasValue(String key) {
		Object tempObject = data.get(key);

		return (tempObject != null);
	}

	public static boolean isEmpty() {
		return data.isEmpty() || data == null;
	}

	public static byte getByte(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Byte)
			return (Byte) tempObject;
		if (tempObject instanceof String)
			if (Ui.isNumber(tempObject.toString()))
				return Byte.parseByte(tempObject.toString());
		if (tempObject instanceof Number)
			return Byte.parseByte(tempObject.toString());
		return -1;
	}

	public static char getChar(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Character)
			return (Character) tempObject;
		if (tempObject instanceof String)
			return tempObject.toString().charAt(0);
		if (tempObject instanceof Number)
			return tempObject.toString().charAt(0);
		return '\u0000';
	}

	public static double getDouble(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Double)
			return (Double) tempObject;
		if (tempObject instanceof String)
			if (Ui.isDecimalNumber(tempObject.toString()))
				return Double.parseDouble(tempObject.toString());
		if (tempObject instanceof Number)
			return Double.parseDouble(tempObject.toString());
		return -1;
	}

	public static int getInteger(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Integer)
			return (Integer) tempObject;
		if (tempObject instanceof String)
			if (Ui.isNumber(tempObject.toString()))
				return Integer.parseInt(tempObject.toString());
		if (tempObject instanceof Number)
			return Integer.parseInt(tempObject.toString());
		return -1;
	}

	public static List<?> getList(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof List<?>)
			return (List) tempObject;
		return null;
	}

	public static long getLong(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Long)
			return (Long) tempObject;
		if (tempObject instanceof String)
			if (Ui.isNumber(tempObject.toString()))
				return Long.parseLong(tempObject.toString());
		if (tempObject instanceof Number)
			return Long.parseLong(tempObject.toString());
		return -1;
	}

	public static Map<?, ?> getMap(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Map<?, ?>)
			return (Map) tempObject;
		return null;
	}

	public static Map<String, Object> getValues() {
		if (!isEmpty())
			return data;
		return null;
	}

	public static Object get(String key) {
		if (isEmpty())
			return null;

		final String[] nodes = key.split("\\.");
		Map curMap = data;

		for (int i = 0; i <= nodes.length - 1; ++i) {
			Object child = curMap.get(nodes[i]);

			if (child == null) return null;
			else if (!(child instanceof Map)) {
				if (i == nodes.length - 1)
					return child;
				else return null;
			}

			curMap = (Map) child;
		}
		return null;
	}

	public static Set<String> getKeys() {
		if (!isEmpty())
			return data.keySet();
		return new HashSet<>();
	}

	public static short getShort(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Short)
			return (Short) tempObject;
		if (tempObject instanceof String)
			if (Ui.isNumber(tempObject.toString()))
				return Short.parseShort(tempObject.toString());
		if (tempObject instanceof Number)
			return Short.parseShort(tempObject.toString());
		return -1;
	}

	public static String getString(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof String)
			return (String) tempObject;
		return null;
	}

	public static FileReader read(File file) {
		try {
			if (!file.exists())
				return null;
			return new FileReader(file);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @return the next line as an integer
	 */
	private static int readInt(){
		return Integer.parseInt(input.nextLine());
	}

	/**
	 *
	 * @return the next line as a boolean
	 */
	private static boolean readBoolean(){
		return Boolean.parseBoolean(input.nextLine());
	}

	/**
	 *
	 * @return the next line as a String
	 */
	private static String readString(){
		return input.nextLine();
	}

    //Thanks http://stackoverflow.com/a/38951302/3291305 !
    public static void set(String key, Object object) {

        if (!exists())
            return;

        final String[] nodes = key.split("\\.");

		Map<String, Object> cur = data;

        for (int i = 0; i <= nodes.length - 2; ++i) {
            Object val = cur.get(nodes[i]);
            if (val == null) {
                val = new LinkedHashMap();
                cur.put(nodes[i], val);
            } else if (!(val instanceof Map)) {
                Handle.error("There was a problem saving your game.");
            }
			cur = (Map<String, Object>) val;
		}
        cur.put(nodes[nodes.length - 1], object);
    }
}