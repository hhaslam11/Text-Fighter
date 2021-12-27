package com.hotmail.kalebmarc.textfighter.farm;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Achievements;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import java.util.ArrayList;

public class Crop {
    public static final ArrayList<Crop> cropArrayList = new ArrayList<Crop>();

    private String name;
    private int sellPrice;
    private Seed seed;

    private int owned = 0;

    public Crop(String name, int sellPrice, Seed seed, boolean firstInit, boolean changeDif) {
        this.name = name;
        this.sellPrice = sellPrice;
        this.seed = seed;

        if (!changeDif) {
            cropArrayList.add(this);
        }

        if (firstInit) {
            this.owned = 0;
        }
    }

    public void sell(int piecesSold){
        int totalPrice = sellPrice * piecesSold;

        Coins.set(totalPrice, true);
        Stats.coinsGainedOnCrops += totalPrice;
        this.owned -= piecesSold;
        Ui.println("You have sold " + this.getName() + " (" + piecesSold + " bundles)" + " for " + totalPrice + " coins.");
        Ui.println("You currently have " + this.owned + " bundles of " + this.getName());
        Ui.println("Coins: " + Coins.get());
        Ui.pause();
    }

    public static ArrayList<Crop> getCrops() {
        return cropArrayList;
    }
    public String getName() {
        return name;
    }
    public int getSellPrice() {
        return sellPrice;
    }
    public int getOwned() {
        return owned;
    }
    public void setOwned(int owned, boolean add) {
        if (add) {
            this.owned += owned;
        } else {
            this.owned = owned;
        }
    }

    public void viewAbout() {
        Ui.cls();
        Ui.printhr();
        Ui.println(Ui.getCentred(this.name.toUpperCase()));
        Ui.println();
        Ui.println("Sell price: " + this.sellPrice + " coins");
        Ui.println("Seed: " + this.seed.getName());

        Ui.printhr();
        Ui.pause();
    }
}
