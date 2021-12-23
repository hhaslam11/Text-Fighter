package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.player.*;

import java.util.ArrayList;

public class Property {

public static final ArrayList<Property> arrayProperty = new ArrayList<Property>();
	
	private String name;
	private int price;
	private int level;
	private String description;
	private boolean owns;
	
	public Property(String name, int price, int level, String description, boolean firstInit, boolean changeDif) {
		this.name = name;
		this.price = price;
		this.level = level;
		this.description = description;
		
		if (!changeDif) {
            arrayProperty.add(this);
        }

        if (firstInit) {
            this.owns = false;
        }
	}
	
	public static ArrayList<Property> getPropertyList() {
		return arrayProperty;
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

	public void visit() {
		Ui.cls();
		Ui.printhr();
		Ui.println(Ui.getCentred("Welcome to the " + name + "!"));
		Ui.printhr();
		Ui.pause();

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
			Ui.msg("You are not a high enough level to buy this item.");
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
	
    /*
    private String name;
    private String desc;
    private Type type;
    private int pricePerSqFt;
    private int levelNeeded;
    private final int MAX_SQ_FT = 100;//TODO Change this later. Not sure how the SqFt thing is going to work yet.

    private int sqFtOwned;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return this.desc;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return this.type;
    }
    public void setPricePerSqFt(int pricePerSqFt){
        this.pricePerSqFt = pricePerSqFt;
    }
    public int getPricePerSqFt(){
        return this.pricePerSqFt;
    }
    public void setLevelNeeded(int levelNeeded){
        this.levelNeeded = levelNeeded;
    }
    public int getLevelNeeded(){
        return this.levelNeeded;
    }
    public void setSqFtOwned(int sqFtOwned){
        if (sqFtOwned > MAX_SQ_FT){
            this.sqFtOwned = MAX_SQ_FT;
        } else {
            this.sqFtOwned = sqFtOwned;
        }
    }
    public int getSqFtOwned(){
        return this.sqFtOwned;
    }
    public static void buyProperty(){

    }

    public enum Type{
        CROP_FIELD,
        ORCHARD,
        RIVER;

        @Override
        public String toString() {
            switch(super.toString()){
                case "CROP_FIELD":
                    return "Crop Field";
                case "ORCHARD":
                    return "Orchard";
                case "RIVER":
                    return "River";
                default:
                    Handle.error("Unknown Property Type: " + super.toString());
                    return null;
            }
        }
    } */
}

