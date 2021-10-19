package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.manipulation.Ordering.Context;

public class PotionTest {
	
	static InputStream sysInBackup;
	
	static ByteArrayInputStream in;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        sysInBackup = System.in; // backup System.in to restore it later
        in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        System.setIn(sysInBackup);
	}

	@Before
	public void setUp() throws Exception {
        sysInBackup = System.in; // backup System.in to restore it later
        in = new ByteArrayInputStream("\n\n\n\n\n\n\n\n\n\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n".getBytes());
        System.setIn(in);
	}

	@After
	public void tearDown() throws Exception {
        
	}

	@Test
	public void testGet() {
		//fail("Not yet implemented");
		
		assertEquals(Potion.get("survival"), 0);
		
		assertEquals(Potion.get("recovery"), 0);
		
		Potion.set("survival", 5, false);
		
		Potion.set("recovery", 5, false);
		
		assertEquals(Potion.get("survival"), 5);
		
		assertEquals(Potion.get("recovery"), 5);
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		assertEquals(Potion.get("survival"), 2);
		
		assertEquals(Potion.get("recovery"), 3);
	}

	@Test
	public void testSet() {
		
		Potion.set("survival", 0, false);
		
		Potion.set("recovery", 0, false);
		
		assertEquals(Potion.get("survival"), 0);
		
		assertEquals(Potion.get("recovery"), 0);
		
		Potion.set("survival", 5, false);
		
		Potion.set("recovery", 5, false);
		
		assertEquals(Potion.get("survival"), 5);
		
		assertEquals(Potion.get("recovery"), 5);
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.set("survival", 5, false);
		
		Potion.set("recovery", 5, false);
		
		assertEquals(Potion.get("survival"), 5);
		
		assertEquals(Potion.get("recovery"), 5);
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.set("survival", 5, true);
		
		Potion.set("recovery", 5, true);
		
		assertEquals(Potion.get("survival"), 7);
		
		assertEquals(Potion.get("recovery"), 8);
	}

	@Test
	public void testUse() {
		
		Potion.set("survival", 0, false);
		
		Potion.set("recovery", 0, false);
		
		Potion.set("survival", 5, false);
		
		Potion.set("recovery", 5, false);
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(Potion.get("survival"), 2);
		
		assertEquals(Potion.get("recovery"), 3);
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(Potion.get("survival"), 0);
		
		assertEquals(Potion.get("recovery"), 0);
		
		Potion.use("survival");
		
		Potion.use("recovery");

		assertEquals(Potion.get("survival"), 0);
		
		assertEquals(Potion.get("recovery"), 0);
	}

	@Test
	public void testUsed() {
		
		Potion.set("survival", 0, false);
		
		Potion.set("recovery", 0, false);
		
		Potion.set("survival", 5, false);
		
		Potion.set("recovery", 5, false);

		assertEquals(14, Potion.spUsed);
		
		assertEquals(11, Potion.rpUsed);
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(17, Potion.spUsed);
		
		assertEquals(13, Potion.rpUsed);
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(19, Potion.spUsed);
		
		assertEquals(16, Potion.rpUsed);
		
		Potion.use("survival");
		
		Potion.use("recovery");

		assertEquals(19, Potion.spUsed);
		
		assertEquals(16, Potion.rpUsed);
	}

}
