package com.hotmail.kalebmarc.textfighter.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {
    Weapon rifle;
    Weapon pistol;

    @Before
    public void setUp() throws Exception {
        rifle = new Weapon("Rifle", 1, 18, true, 275, 1, 5, 10, true, true , 1);
        rifle.setAmmo(10, true);
        pistol = new Weapon("Pistol", 1, 18, true, 250, 1, 4, 15, true, true);
        pistol.setAmmo(10, true);
    }

    @Test
    public void dealDam() {

    }

    @Test
    public void setCriticalChance() {
        // Check the Rifle critical chance is set to 1
        assertTrue(rifle.getCriticalChance() == 1);
        rifle.setCriticalChance(-200);
        assertTrue(rifle.getCriticalChance() == -200);
        rifle.setCriticalChance(1);
        assertTrue(rifle.getCriticalChance() == 1);

        // Check Pistol set to default .01
        assertTrue(pistol.getCriticalChance() == .01);
        pistol.setCriticalChance(0);
        assertTrue(pistol.getCriticalChance() == 0);
        pistol.setCriticalChance(.01);
        assertTrue(pistol.getCriticalChance() == .01);
    }

    @Test
    public void getCriticalChance() {
        Weapon rifle2 = new Weapon("Rifle", 1, 18, true, 275, 1, 5, 10, true, true , .06);
        assertTrue(rifle2.getCriticalChance() == .06);

        // Check the Rifle critical chance is set to 1
        assertTrue(rifle.getCriticalChance() == 1);

        // Check Pistol set to default .01
        assertTrue(pistol.getCriticalChance() == .01);
    }

    @Test
    public void displayDamageDealt() {
    }

    @Test
    public void didCriticalHit() {
    }
}