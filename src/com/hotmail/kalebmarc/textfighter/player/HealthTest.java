package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HealthTest {

	@Test
	void testGet() {
		assertEquals(0, Health.get());
	}

	@Test
	void testGetOutOf() {
		assertEquals(0, Health.getOutOf());
	}

}
