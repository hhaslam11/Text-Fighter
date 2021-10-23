package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.GameTime;

public class TestTimeTrack {

	@Test
	public void testTimeConversion() {
		GameTime newTime = new GameTime();
		newTime.setStartTime(0);
		newTime.setEndTime(600000);
		newTime.calculateTime();
		assertEquals(600.0, newTime.getSeconds(), 0.0);
		assertEquals(10.0, newTime.getMinutes(), 0.0);
		assertEquals(0.167, newTime.getHours(), 0.0);
		assertEquals(0.007, newTime.getDays(), 0.0);
	}
	
	@Test
	public void testTimeUpdated() {
		GameTime newTime = new GameTime();
		newTime.setStartTime(0);
		newTime.setEndTime(600000);
		newTime.calculateTime();
		assertEquals(600.0, newTime.getTotalSecondTime(), 0.0);
		assertEquals(10.0, newTime.getTotalMinuteTime(), 0.0);
		assertEquals(0.167, newTime.getTotalHourTime(), 0.0);
		assertEquals(0.007, newTime.getTotalDayTime(), 0.0);
	}
	
	@Test
	public void testNewPlayerTime() {
		GameTime newTime = new GameTime();
		newTime.initializeNewTime();
		assertEquals(0.0, newTime.getSeconds(), 0.0);
		assertEquals(0.0, newTime.getMinutes(), 0.0);
		assertEquals(0.0, newTime.getHours(), 0.0);
		assertEquals(0.0, newTime.getDays(), 0.0);
		
	}
	
	@Test
	public void testSavedPlayerTime() {
		GameTime newTime = new GameTime();
		newTime.initializeSavedTime();
		assertNotEquals(0.0, newTime.getSeconds(), 0.0);
		assertNotEquals(0.0, newTime.getMinutes(), 0.0);
		assertNotEquals(0.0, newTime.getHours(), 0.0);
		assertNotEquals(0.0, newTime.getDays(), 0.0);
	}

}
