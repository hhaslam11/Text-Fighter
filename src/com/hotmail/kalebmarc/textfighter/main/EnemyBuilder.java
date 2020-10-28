package com.hotmail.kalebmarc.textfighter.main;

import java.util.ArrayList;

import static com.hotmail.kalebmarc.textfighter.player.Settings.getDif;

// Instead of initializing all enemies in the player's settings and storing all enemies in the game, use a builder instead to decouple enemy from player.
// This makes it easy to change stats for enemies and implement new enemies in the future as needed.
// Enemies (Name, health, coindropmin, coindropmax, damagemin, damagemax, xp, firstinit, changeDif)
public class EnemyBuilder {

    public static Enemy buildDarkElf() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Dark Elf", 55, 15, 20, 15, 20, 15, true, false);
                break;
            default:
                enemy = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildNinja() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Ninja", 75, 5, 15, 5, 15, 15, true, false);
                break;
            default:
                enemy = new Enemy("Ninja", 85, 10, 20, 10, 20, 15, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildGiantSpider() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Giant Spider", 35, 5, 10, 5, 10, 10, true, false);
                break;
            default:
                enemy = new Enemy("Giant Spider", 45, 10, 15, 10, 15, 10, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildZombie() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Zombie", 20, 5, 15, 5, 15, 15, true, false);
                break;
            default:
                enemy = new Enemy("Zombie", 30, 10, 20, 10, 20, 15, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildGoblin() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Goblin", 60, 10, 20, 10, 20, 20, true, false);
                break;
            default:
                enemy = new Enemy("Goblin", 70, 15, 25, 15, 25, 20, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildGhost() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Ghost", 85, 15, 25, 15, 25, 25, true, false);
                break;
            default:
                enemy = new Enemy("Ghost", 95, 20, 30, 20, 30, 25, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildBarbarian() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, true, false);
                break;
            default:
                enemy = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildGiantAnt() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, true, false);
                break;
            default:
                enemy = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildEvilUnicorn() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Evil Unicorn", 35, 30, 40, 5, 15, 20, true, false);
                break;
            default:
                enemy = new Enemy("Evil Unicorn", 35, 20, 40, 5, 15, 20, true, false);
                break;
        }
        return enemy;
    }

    public static Enemy buildOgre() {
        Enemy enemy;
        switch (getDif()) {
            case "Hard":
                enemy = new Enemy("Ogre", 90, 20, 50, 10, 30, 50, true, false);
                break;
            default:
                enemy = new Enemy("Ogre", 100, 20, 50, 10, 30, 50, true, false);
                break;
        }
        return enemy;
    }

    public static ArrayList<Enemy> getEnemyList() {
        ArrayList<Enemy> arrayEnemy = new ArrayList<>();

        // If new enemies are implemented, add here:
        arrayEnemy.add(buildDarkElf());
        arrayEnemy.add(buildNinja());
        arrayEnemy.add(buildGiantSpider());
        arrayEnemy.add(buildZombie());
        arrayEnemy.add(buildGoblin());
        arrayEnemy.add(buildGhost());
        arrayEnemy.add(buildBarbarian());
        arrayEnemy.add(buildGiantAnt());
        arrayEnemy.add(buildEvilUnicorn());
        arrayEnemy.add(buildOgre());

        return arrayEnemy;
    }
}
