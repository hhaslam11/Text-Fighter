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
		
		sysInBackup = System.in;
		
		none = new Armour("None", 0, 0, 1);
		basic = new Armour("Basic", 400, 15, 5);
		advanced = new Armour("Advanced", 750, 30, 7);
		
		none.setOwns(true);
		
		basic.setOwns(false);
		
		advanced.setOwns(false);
		
		Armour.set(0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
        System.setIn(sysInBackup);
	}

	@Before
	public void setUp() throws Exception {
		
        System.setIn(sysInBackup);
		
		none.setOwns(true);
		
		basic.setOwns(false);
		
		advanced.setOwns(false);
		
		Armour.set(0);
	}

	@After
	public void tearDown() throws Exception {
		
        System.setIn(sysInBackup);
	}

	@Test
	public void testChooseOnly() {
		// Select armour when only one type is owned
	    
		// Check that no armour is equipped yet
	    assertEquals(0, Armour.get());
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("1".getBytes()); // Set input stream to pick armour automatically
        
        System.setIn(chooseIn);
		
		Armour.choose(); // Pick armour to equip

        System.setIn(sysInBackup);
	    
	    assertEquals(0, Armour.get()); // Check that correct armour was equipped
	    
	    assertEquals(none, Armour.getEquipped()); // Check for correct armour object equipped
	}

	@Test
	public void testChooseFirst() {
		// Select armour when only all three types are owned
		
		none.setOwns(true);
		
		basic.setOwns(true);
		
		advanced.setOwns(true);
	    
		// Check that no armour is equipped yet
	    assertEquals(0, Armour.get());
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("1".getBytes()); // Set input stream to pick armour automatically
        
        System.setIn(chooseIn);
		
		Armour.choose(); // Pick armour to equip

        System.setIn(sysInBackup);
	    
	    assertEquals(0, Armour.get()); // Check that correct armour was equipped
	    
	    assertEquals(none, Armour.getEquipped()); // Check for correct armour object equipped
	}

	@Test
	public void testChooseMiddle() {
		
		none.setOwns(true);
		
		basic.setOwns(true);
		
		advanced.setOwns(true);
	    
		// Check that no armour is equipped yet
	    assertEquals(0, Armour.get());
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("2".getBytes()); // Set input stream to pick armour automatically
        
        System.setIn(chooseIn);
		
		Armour.choose(); // Pick armour to equip

        System.setIn(sysInBackup);
	    
	    assertEquals(1, Armour.get()); // Check that correct armour was equipped
	    
	    assertEquals(basic, Armour.getEquipped()); // Check for correct armour object equipped
	}

	@Test
	public void testChooseLast() {
		
		none.setOwns(true);
		
		basic.setOwns(true);
		
		advanced.setOwns(true);
	    
		// Check that no armour is equipped yet
	    assertEquals(0, Armour.get());
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("3".getBytes()); // Set input stream to pick armour automatically
        
        System.setIn(chooseIn);
		
		Armour.choose(); // Pick armour to equip

        System.setIn(sysInBackup);
	    
	    assertEquals(2, Armour.get()); // Check that correct armour was equipped
	    
	    assertEquals(advanced, Armour.getEquipped()); // Check for correct armour object equipped
	}

	@Test
	public void testGetArmours() {
		// Test constant armours array access
		
		assertEquals(3, Armour.getArmours().size());
		
		// Check all objects are the same in each list access method
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
}
