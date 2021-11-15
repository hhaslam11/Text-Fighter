package tests;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import time.GameClock;

public class TestGameClock {


	
	@Test
	void testTimeConversion() {
		GameClock newClock = new GameClock();
		newClock.setStartTime(0);
		newClock.setEndTime(60000);
		long conversion = newClock.timeConversion();
		assertEquals(conversion, (newClock.getIncreasedTime() + (newClock.getIncreasedTime() * newClock.getIncreasePercent())));
		assertNotEquals(conversion, (newClock.getIncreasedTime() + ((newClock.getIncreasedTime() + 1) * newClock.getIncreasePercent())));
		assertNotEquals(conversion, (newClock.getIncreasedTime() + (345346 * newClock.getIncreasePercent())));
	}
	
	@Test
	void testUpdateGameTime() {
		LocalDateTime testTimeBase = LocalDateTime.of(LocalDate.of(2021, Month.DECEMBER, 2), LocalTime.of(5, 0, 0)); 
		String testTimeFast;
		GameClock newClock = new GameClock();
		newClock.setBaseTime(testTimeBase);
		newClock.setStartTime(0);
		newClock.setEndTime(6000000);
		newClock.updateGameTime();
		testTimeFast = newClock.getFastTime().format(newClock.getDateTimeFormat());
		assertFalse(testTimeFast.equals(newClock.getBaseTime().format(newClock.getDateTimeFormat())));
		
	}
	

	@BeforeClass
	void testValues() {
		GameClock newClock = new GameClock();
		assertEquals(newClock.getStartTime(), 0);
		assertEquals(newClock.getEndTime(), 0);
	}
	
	@Test
	void testDayRollOver() {
		LocalDateTime testTimeBase = LocalDateTime.of(LocalDate.of(2021, Month.OCTOBER, 23), LocalTime.of(23, 59, 59)); 
		GameClock newClock = new GameClock();
		newClock.setBaseTime(testTimeBase);
		newClock.splitDateTime(newClock.getBaseTime());
		String baseDate = newClock.getGameDate();
		newClock.setStartTime(0);
		newClock.setEndTime(6000000);
		newClock.updateGameTime();
		String fastDate = newClock.getGameDate();
		assertFalse(fastDate.equalsIgnoreCase(baseDate));
	}
	
	
	
}
