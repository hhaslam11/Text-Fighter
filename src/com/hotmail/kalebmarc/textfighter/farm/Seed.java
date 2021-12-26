package com.hotmail.kalebmarc.textfighter.farm;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Achievements;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import java.util.ArrayList;

public class Seed {
    public static final ArrayList<Seed> seedArrayList = new ArrayList<Seed>();

    private String name;
    private int price;
    private int count;
    private int level;
    private String description;
    private int growthTime; // in fights
    private int minCrops;
    private int maxCrops;
    private Crop crop;

    private int owned = 0;

    public Seed(String name, int price, int count, int level, String description, int growthTime, int minCrops, int maxCrops, int cropSellPrice, boolean firstInit, boolean changeDif) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.level = level;
        this.description = description;
        this.growthTime = growthTime;
        this.minCrops = minCrops;
        this.maxCrops = maxCrops;
        this.crop = new Crop(name, cropSellPrice, this, firstInit, changeDif);

        if (!changeDif) {
            seedArrayList.add(this);
        }

        if (firstInit) {
            this.owned = 0;
        }
    }

    public Seed(String name, int price, int count, int level, String description, int growthTime, int minCrops, int maxCrops, Crop crop, boolean firstInit, boolean changeDif) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.level = level;
        this.description = description;
        this.growthTime = growthTime;
        this.minCrops = minCrops;
        this.maxCrops = maxCrops;

        if (!changeDif) {
            seedArrayList.add(this);
        }

        if (firstInit) {
            this.owned = 0;
        }
    }
    public void buy(int multiplier) {
        int totalPrice = price * multiplier;
        int totalBought = count * multiplier;

        if (level > Xp.getLevel()) {
            Ui.msg("You do not have a high enough level to buy this item.");
            return;
        }
        if (totalPrice > Coins.get()) {
            Ui.msg("You do not have enough coins to buy this item.");
            return;
        }

        Achievements.boughtItem = true;
        Coins.set(-totalPrice, true);
        Stats.coinsSpentOnSeeds += price;
        this.owned += totalBought;
        Ui.println("You have bought " + this.getName() + " (" + totalBought + " bundles)" + " for " + totalPrice + " coins.");
        Ui.println("You currently have " + this.owned + " bundles of " + this.getName());
        Ui.println("Coins: " + Coins.get());
        Ui.pause();
    }

    public static ArrayList<Seed> getSeeds() {
        return seedArrayList;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getLot() {
        return count;
    }
    public int getLevel() {
        return level;
    }
    public int getMinCrops() {
        return minCrops;
    }
    public int getMaxCrops() {
        return maxCrops;
    }
    public int getGrowthTime() {
        return growthTime;
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
    public Crop getCrop() {
        return crop;
    }
}