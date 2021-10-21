package com.hotmail.kalebmarc.textfighter.item;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class ArmourTest {
	
	static Armour none;
	
	static Armour basic;
	
	static Armour advanced;
	
	static InputStream sysInBackup;
	
	static ByteArrayInputStream in;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		none = new Armour("None", 0, 0, 1);
		basic = new Armour("Basic", 400, 15, 5);
		advanced = new Armour("Advanced", 750, 30, 7);
		
		none.setOwns(true);
		
		basic.setOwns(false);
		
		advanced.setOwns(true);
		
		Armour.set(0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		sysInBackup = System.in; // backup System.in to restore it later
	}

	@After
	public void tearDown() throws Exception {
		
        System.setIn(sysInBackup);
	}

	@Test
	public void testGetArmours() {
		
		assertEquals(3, Armour.getArmours().size());
		
		assertEquals("None", Armour.getArmours().get(0).getName());
		assertEquals(0, Armour.getArmours().get(0).getPrice());
		assertEquals(0, Armour.getArmours().get(0).getDamResist());
		assertEquals(1, Armour.getArmours().get(0).getLevel());

		assertEquals( "Basic", Armour.getArmours().get(1).getName());
		assertEquals(400, Armour.getArmours().get(1).getPrice());
		assertEquals(15, Armour.getArmours().get(1).getDamResist());
		assertEquals(5, Armour.getArmours().get(1).getLevel());

		assertEquals("Advanced", Armour.getArmours().get(2).getName());
		assertEquals(750, Armour.getArmours().get(2).getPrice());
		assertEquals(30, Armour.getArmours().get(2).getDamResist());
		assertEquals(7, Armour.getArmours().get(2).getLevel());
	}

	@Test
	public void testChoose() {
	    
	    assertEquals(0, Armour.get());
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("2".getBytes());
        
        System.setIn(chooseIn);
		
		Armour.choose();

        System.setIn(sysInBackup);
	    
	    assertEquals(2, Armour.get());
	}
}
