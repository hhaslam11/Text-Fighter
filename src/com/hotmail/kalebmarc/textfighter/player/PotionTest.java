package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Game;

public class PotionTest extends Potion {
	
	Potion testPotion = new Potion();
	@Test
	public void testGet() {
		// Test if correct integer is returned from the Poison type of potion.
		assertEquals(-50, testPotion.get("Poison"));
	}

	@Test
	public void testSet() {
		testPotion.set("Poison", 1, true);
		assertEquals(1, testPotion.poisonPotion);
	}

	@Test
	//Poison reduces enemies health by 30 health points.
	public void testUse() {
        Enemy darkElf = new Enemy("Dark Elf", 30, 10, 15, 10, 15, 15, 1, 100, true, false);
        darkElf.arrayEnemy.add(darkElf);
        darkElf.set(0);
		testPotion.use("poisonPotion");
		assertEquals(0, darkElf.getHealth());
	}

	@Test
	public void testUsed() {
		testPotion.used("poisonPotion");
		
		assertEquals(1, testPotion.ppUsed);
	}

	@Test
	public void testBuy() {
		testPotion.buy("poisonPotion");
		assertEquals(1, testPotion.poisonPotion);
	}

	@Test
	public void testGetLevel() {
		
		assertEquals(5, testPotion.getLevel("poisonPotion"));
	}

	@Test
	public void testGetPrice() {
		assertEquals(50, testPotion.getPrice("poisonPotion"));
	}

}
