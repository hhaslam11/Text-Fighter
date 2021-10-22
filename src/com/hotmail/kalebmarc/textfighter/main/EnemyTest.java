package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Potion;

public class EnemyTest {

	@Test
	public void testTakeDamage() {
		
        Enemy darkElf = new Enemy("Dark Elf", 40, 10, 15, 10, 15, 15, 1, 100, true, false);
        darkElf.arrayEnemy.add(darkElf);
        darkElf.set(0);
		Potion.set("poison", 1, true);
        Potion.use("poison");
		assertEquals(10, darkElf.getHealth());
	}
	
	@Test
	/*Test is successful if lines Enemy<137,160> are commented out. 
	*These functions require more of the game to be initialized. 
	*EncounterNew() needs levels, xp, list of enemies to be initiated which doesn't involve potions. 
	*/
	public void testTakeDamageDie() {
		
        Enemy man = new Enemy("Dark Elf", 30, 10, 15, 10, 15, 15, 1, 100, true, false);
        man.arrayEnemy.add(man);
        man.set(0);
		Potion.set("poison", 1, true);
        Potion.use("poison");
		assertEquals(0, man.getHealth());
	}
}
