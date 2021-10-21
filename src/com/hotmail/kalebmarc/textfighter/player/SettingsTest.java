package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import org.junit.Test;

public class SettingsTest {

	@Test
	public void testGetDif() {
		Settings test = new Settings();
		test.setConstants("Easy", true, false);
		assertEquals(5, Potion.ppLevel);
		assertEquals(50, Potion.ppPrice);
		test.setConstants("Difficult", true, false);
		assertEquals(5, Potion.ppLevel);
		assertEquals(60, Potion.ppPrice);
	}

}
