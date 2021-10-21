package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Game;

public class PotionTest  {

	@Test
	public void testGet() {
		// Test if correct integer is returned from the Poison type of potion.
		assertEquals(-50, Potion.get("Poison"));
	}

	@Test
	public void testSet() {
		Potion.set("Poison", 1, true);
		assertEquals(1, Potion.poisonPotion);
	}

	@Test
	//Poison reduces enemies health by 30 health points.
	public void testUse() {
        Enemy darkElf = new Enemy("Dark Elf", 30, 10, 15, 10, 15, 15, 1, 100, true, false);
        darkElf.arrayEnemy.add(darkElf);
        darkElf.set(0);
        Potion.use("poisonPotion");
		assertEquals(0, darkElf.getHealth());
	}

	@Test
	public void testUsed() {
		Potion.used("poisonPotion");
		
		assertEquals(1, Potion.ppUsed);
	}

	@Test
	public void testBuy() {
		Potion.buy("poisonPotion");
		assertEquals(1, Potion.poisonPotion);
	}

	@Test
	public void testGetLevel() {
		
		assertEquals(5,Potion.getLevel("poisonPotion"));
	}

	@Test
	public void testGetPrice() {
		assertEquals(50, Potion.getPrice("poisonPotion"));
	}

}
