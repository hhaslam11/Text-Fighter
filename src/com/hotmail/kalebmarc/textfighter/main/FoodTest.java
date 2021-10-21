package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Health;


/*import org.easymock.EasyMock;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Food.class)*/
public class FoodTest {
	
	static InputStream sysInBackup;
	
	public static Food apple;
	public static Food orange;
	public static Food dragonfruit;
	public static Food meat;
	public static Food mushroom;
	public static Food fish;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		apple = new Food("Apple", "A boring 'ol apple.", StatusEffect.type.HEALTH, Food.type.FRUIT, 5);
		orange = new Food("Orange", "Sort of like an apple, but orange.", StatusEffect.type.HEALTH, Food.type.FRUIT, 5);
		dragonfruit = new Food("Dragon Fruit", "Unfortunately, not a real dragon.", StatusEffect.type.HEALTH, Food.type.FRUIT, 10);
		meat = new Food("Chunk of meat", "Probably not rotten.", StatusEffect.type.HEALTH, Food.type.MEAT_OTHER, 15);
		mushroom = new Food("Mushroom", "The good kind!", StatusEffect.type.HEALTH, Food.type.OTHER, 5);
		fish = new Food("Fish", "Found in rivers and lakes.", StatusEffect.type.HEALTH, Food.type.MEAT_FISH, 15);
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
	}

	@Test
	public void testList() {
		Health.set(50, 100);
		
		//PowerMockito.mockStatic(Ui.class);
	    //when(Ui.getValidInt()).thenReturn(1);
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("1".getBytes());
        
        System.setIn(chooseIn);
	    
	    Food.list();

        System.setIn(sysInBackup);
	    
	    assertEquals(Health.get(), 55);
	}

	@Test
	public void testGetFoods() {
		assertEquals(Food.arrayFood, Food.getFoods());
		assertEquals(Food.arrayFood.get(0), Food.getFoods().get(0));
		assertEquals(Food.arrayFood.get(1), Food.getFoods().get(1));
		assertEquals(Food.arrayFood.get(2), Food.getFoods().get(2));
		assertEquals(Food.arrayFood.get(3), Food.getFoods().get(3));
		assertEquals(Food.arrayFood.get(4), Food.getFoods().get(4));
		assertEquals(Food.arrayFood.get(5), Food.getFoods().get(5));
	}
}
