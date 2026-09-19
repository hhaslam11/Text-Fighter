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

import com.hotmail.kalebmarc.textfighter.time.GameClock;

public class TestGameClock {



	@Test
	void testTimeConversion() {
		GameClock.setStartTime(0);
		GameClock.setEndTime(60000);
		long conversion = GameClock.timeConversion();
		assertEquals(conversion, (GameClock.getIncreasedTime() + (GameClock.getIncreasedTime() * GameClock.getIncreasePercent())));
		assertNotEquals(conversion, (GameClock.getIncreasedTime() + ((GameClock.getIncreasedTime() + 1) * GameClock.getIncreasePercent())));
		assertNotEquals(conversion, (GameClock.getIncreasedTime() + (345346 * GameClock.getIncreasePercent())));
	}
	
	@Test
	void testUpdateGameTime() {
		LocalDateTime testTimeBase = LocalDateTime.of(LocalDate.of(2021, Month.DECEMBER, 2), LocalTime.of(5, 0, 0)); 
		String testTimeFast;
		GameClock.setBaseTime(testTimeBase);
		GameClock.setStartTime(0);
		GameClock.setEndTime(6000000);
		GameClock.updateGameTime();
		testTimeFast = GameClock.getFastTime().format(GameClock.getDateTimeFormat());
		assertFalse(testTimeFast.equals(GameClock.getBaseTime().format(GameClock.getDateTimeFormat())));
	}
	

	@BeforeClass
	void testValues() {
		assertEquals(GameClock.getStartTime(), 0);
		assertEquals(GameClock.getEndTime(), 0);
	}
	
	@Test
	void testDayRollOver() {
		LocalDateTime testTimeBase = LocalDateTime.of(LocalDate.of(2021, Month.OCTOBER, 23), LocalTime.of(23, 59, 59));
		GameClock.setBaseTime(testTimeBase);
		GameClock.splitDateTime(GameClock.getBaseTime());
		String baseDate = GameClock.getGameDate();
		GameClock.setStartTime(0);
		GameClock.setEndTime(6000000);
		GameClock.updateGameTime();
		String fastDate = GameClock.getGameDate();
		assertFalse(fastDate.equalsIgnoreCase(baseDate));
	}
	
	
	
}
