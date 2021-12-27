package com.hotmail.kalebmarc.textfighter.farm;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Achievements;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import java.util.ArrayList;
import java.util.Locale;

public class Farm {

	public static final ArrayList<Farm> arrayFarm = new ArrayList<Farm>();
	
	private String name;
	private int price;
	private int level;
	private String description;

	private int fieldCount;
	private ArrayList<Field> fields = new ArrayList<Field>();

	private boolean owns;
	
	public Farm(String name, String description, int price, int level, int fieldCount, boolean firstInit, boolean changeDif) {
		this.name = name;
		this.price = price;
		this.level = level;
		this.description = description;

		this.fieldCount = fieldCount;
		for (int i = 0; i < fieldCount; i++) {
			fields.add(new Field());
		}
		
		if (!changeDif) {
            arrayFarm.add(this);
        }

        if (firstInit) {
            this.owns = false;
        }
	}
	
	public static ArrayList<Farm> getFarms() {
		return arrayFarm;
	}
	public String getName() {
		return name.toString();
	}
	public int getPrice() {
		return price;
	}
	public int getLevel() {
		return level;
	}
	public int getFieldCount() {
		return fieldCount;
	}
	public ArrayList<Field> getFields() {
		return fields;
	}

	public void menu() {
		while (true) {
			Ui.cls();
			Ui.printhr();
			Ui.println(Ui.getCentred("Welcome to " + name + "!"));
			Ui.println();
			Ui.println("Fields:");
			for (int i = 0; i < fieldCount; i++) {
				Ui.print((i + 1) + "): ");

				Seed seed = fields.get(i).getSeed();
				Ui.print("(" + ((seed == null) ? "No seeds planted)" : seed.getName() + ") - "));
				Ui.println((seed == null) ? "" : ((fields.get(i).getRemainingTime() > 0) ? fields.get(i).getRemainingTime() + " fights remaining until the harvest." : "Ready for harvest"));
			}
			Ui.println();
			Ui.println((fieldCount + 1) + ") Back");

			int menuItem = Ui.getValidInt();
			if (menuItem == fieldCount + 1) {
				Ui.cls();
				return;
			}

			if (menuItem <= fieldCount) {
				fields.get(menuItem - 1).menu(this, menuItem);
			} else {
				Ui.println();
				Ui.println(menuItem + " is not an option.");
				Ui.cls();
				Ui.pause();
			}
		}
	}

	public boolean owns() {
		return owns;
	}
	public void buy() {
		if (this.owns()) {
			Ui.msg("You already own this property.");
			return;
		}
		if (level > Xp.getLevel()) {
			Ui.msg("You do not have a high enough level to buy this item.");
			return;
		}
		if (price > Coins.get()) {
			Ui.msg("You do not have enough coins to buy this item.");
			return;
		}

		Achievements.boughtItem = true;
		Coins.set(-price, true);
		Stats.coinsSpentOnProperty += price;
		this.owns = true;
		Ui.println("You have bought a " + this.getName() + " for " + this.price + " coins.");
		Ui.println("Coins: " + Coins.get());
		Ui.pause();

	}

	public void updateFields() {
		for (Field f : fields) {
			f.updateCycle();
		}
	}

	public void viewAbout() {
		Ui.cls();
		Ui.printhr();
		Ui.println(Ui.getCentred(this.name.toUpperCase()));
		Ui.println(Ui.getCentred(this.description));
		Ui.println();
		Ui.println("Price: " + this.price + " coins");
		Ui.println("Required level: " + this.level);
		Ui.println("Number of fields: " + this.fieldCount);

		Ui.printhr();
		Ui.pause();
	}
}

