package com.hotmail.kalebmarc.textfighter.player;
import com.hotmail.kalebmarc.textfighter.main.Game;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Food;
import com.hotmail.kalebmarc.textfighter.main.Game;
import com.hotmail.kalebmarc.textfighter.main.StatusEffect;

public class PotionTest  {

	@Test
	public void testGet() {
		// Test if correct integer is returned from the Poison type of potion.
		Potion.set("poison", 0, false);
		assertEquals(0, Potion.get("poison"));
		Potion.set("poison", 1, false);
		assertEquals(1, Potion.get("poison"));
	}

	@Test
	public void testSet() {
		Potion.set("poison", 1, false);
		assertEquals(1, Potion.poisonPotion);
		Potion.set("poison", 3, true);
		assertEquals(4, Potion.get("poison"));
		Potion.set("poison", -4, true);
		assertEquals(0, Potion.get("poison"));
	}
	
	@Test
	//Poison reduces enemies health by 30 health points.
	//Must hit "Enter" when testing because of UI pause.
	public void testUse() {
		//Testing when user doesnt have poison available.
        Enemy darkElf = new Enemy("Dark Elf", 40, 10, 15, 10, 15, 15, 1, 100, true, false);
        darkElf.arrayEnemy.add(darkElf);
        darkElf.set(0);
		Potion.set("poison", 1, true);
        Potion.use("poison");
		assertEquals(10, darkElf.getHealth());
	}
	
	@Test
	public void testUsed() {
		Potion.ppUsed = 0;
		Potion.used("poison");
		assertEquals(1,Potion.ppUsed) ;
	}
	
	@Test
	public void testBuy() {
		Potion.set("poison", 0, false);
		Potion.buy("poison");
		assertEquals(1, Potion.get("poison"));
	}
	
	@Test
	public void testGetLevel() {
		Potion.ppLevel = 0; 
		assertEquals(0,Potion.getLevel("poison"));
	}

	@Test
	public void testGetPrice() {
		Potion.ppPrice = 0;
		assertEquals(0, Potion.getPrice("poison"));
	}
	
	@Test
	public void testBrewPotion() {
		Game test = new Game();
		Potion.set("recovery", 0, false);
		Potion.brewPotion("recovery");
		assertEquals(1, Potion.get("recovery"));
		Potion.set("survival", 0, false);
		Potion.brewPotion("survival");
		assertEquals(1, Potion.get("survival"));
		Potion.set("poison", 0, false);
	}
	
	@Test
	public void testFruitAvailable() {
		assertFalse(Potion.fruitAvailable("Raspberry", "recovery"));
		assertFalse(Potion.fruitAvailable("Apple", "recovery"));
		assertTrue(Potion.fruitAvailable("Chunk of meat", "poison"));
	}
	@Test
	public void testUseFruitInPotion() {
		// Fish is available to use in potion.
		assertTrue(Potion.fruitAvailable("Fish", "poison"));
		// Use fish in potion
		Potion.useFruitInPotion("Fish");
		// Fish is now unavailable.
		assertFalse(Potion.fruitAvailable("Fish", "poison"));
		
	}

}


