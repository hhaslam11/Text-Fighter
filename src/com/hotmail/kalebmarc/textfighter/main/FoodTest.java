package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Potion;

public class FoodTest {

	@Test
	public void testUseInPotion() {
		//Reduces quantity of fruit if potion is brewed.
		Food apple       = new Food("Apple",         "A boring 'ol apple.",                StatusEffect.type.HEALTH, Food.type.FRUIT,      5);
		 Food mushroom    = new Food("Mushroom",      "The good kind!",                     StatusEffect.type.HEALTH, Food.type.OTHER,      5);
		assertEquals(1, apple.getQuantity() );
		assertEquals(1, mushroom.getQuantity());
		Potion.brewPotion("survival");
		assertEquals(0, apple.getQuantity() );
		assertEquals(0, mushroom.getQuantity());
	}

}
