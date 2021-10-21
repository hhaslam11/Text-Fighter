package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import org.junit.Test;

public class SettingsTest {

	@Test
	public void testGetDif() {
		Settings.setConstants("Easy", true, false);
		assertEquals(5, Potion.ppLevel);
		assertEquals(50, Potion.ppPrice);
		Settings.setConstants("Difficult", true, false);
		assertEquals(5, Potion.ppLevel);
		assertEquals(60, Potion.ppPrice);
	}

}
