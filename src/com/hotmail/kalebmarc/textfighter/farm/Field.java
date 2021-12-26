package com.hotmail.kalebmarc.textfighter.farm;

import com.hotmail.kalebmarc.textfighter.main.Random;
import com.hotmail.kalebmarc.textfighter.main.Ui;

import java.util.ArrayList;

public class Field {
    private Seed seed;
    private int remainingTime;

    public Seed getSeed() {
        return seed;
    }

    public void menu(Farm farm, int fieldNr) {
        while (true) {
            // int i = 1;
            Ui.cls();
            Ui.printhr();
            Ui.println(Ui.getCentred("Field " + fieldNr + " (" + farm.getName() + ") "));
            Ui.print("(" + ((seed == null) ? "No seeds planted)" : seed.getName() + ") - "));
            Ui.println((seed == null) ? "" : ((this.getRemainingTime() > 0) ? this.getRemainingTime() + " fights remaining until the harvest." : "Ready for harvest"));
            Ui.println();
// Can you think of any way I could possibly make this work? I wanted to make the menu dynamic - display the harvest option only if the crops are ready for harvest - but I just can't come up with a universal and scalable way to solve this other than bunch of if-else statements, which is rather bulky and doesn't meet either specified requirement.
//            if (remainingTime == 0) {
//                Ui.println(i + ") Harvest");
//                i++;
//            }
//            Ui.println(i + ") Plant seeds");
//            i++;
//            Ui.println(i + ") Back");
//
//            int menuItem = Ui.getValidInt();
//            int cond = i - menuItem;
//            switch (cond) {
//                case 0:
//                    return;
//                case 1:
//                    if (remainingTime == 0) {
//                        // ...
//                    }
//            }
            Ui.println("1) Plant seeds");
            Ui.println("2) Harvest");
            Ui.println("3) Back");

            int menuItem = Ui.getValidInt();

            switch (menuItem) {
                case 1:
                    plantSeed();
                    return;
                case 2:
                    harvest();
                case 3:
                    return;
                default:
                    Ui.println("\"" + menuItem + "\" isn't a valid option.");
                    Ui.pause();
            }
        }
    }

    public void plantSeed() {
        ArrayList<Seed> validSeeds = new ArrayList<>();

        Ui.cls();
        Ui.println("Which seeds would you like to plant?");
        Ui.println();
        for (int i = 0; i < Seed.getSeeds().size(); i++) {
            Seed s = Seed.getSeeds().get(i);
            if (s.getOwned() > 0) {
                validSeeds.add(s);
                Ui.println((i + 1) + ") " + s.getName());
            }
        }
        Ui.println((validSeeds.size() + 1) + ") Back");

        int menuItem = Ui.getValidInt();
        if (menuItem == validSeeds.size() + 1) {
            return;
        }
        Seed s = validSeeds.get(menuItem - 1);

        s.setOwned(-1, true);
        this.seed = s;
        remainingTime = s.getGrowthTime();

        Ui.cls();
        Ui.println("You have planted " + s.getName() + " on this field.");
        Ui.println("There are " + s.getOwned() + " bundles of " + s.getName() + " remaining in your inventory.");
        Ui.pause();
    }

    public void harvest() {
        if (seed == null) {
            Ui.cls();
            Ui.println("No seeds have been planted yet!");
            Ui.pause();
            return;
        }
        if (remainingTime > 0) {
            Ui.cls();
            Ui.println("The crops haven't fully matured yet!");
            Ui.pause();
            return;
        }

        Crop c = seed.getCrop();
        int yield = Random.RInt(seed.getMinCrops(), seed.getMaxCrops());
        c.setOwned(yield, true);
        this.seed = null;

        Ui.cls();
        Ui.println("The harvest has yielded " + yield + " bundles of " + c.getName() + ".");
        Ui.println("You currently have " + c.getOwned() + " bundles of " + c.getName() + ".");
        Ui.pause();
    }

    public void updateCycle() {
        if (!(remainingTime <= 0)) {
            remainingTime--;
        }
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}
