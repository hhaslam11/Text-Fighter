package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Potion;

public class EnemyTest {

	@Test
	public void testTakeDamage() {
		Potion poison = new Potion();
		poison.set("poisonPotion", 1, true);
	       Enemy darkElf = new Enemy("Dark Elf", 30, 10, 15, 10, 15, 15, 1, 100, true, false);
	        darkElf.arrayEnemy.add(darkElf);
	        darkElf.set(0);
	    poison.use("poisonPotion");
		assertEquals(0, darkElf.getHealth());
	}

}
