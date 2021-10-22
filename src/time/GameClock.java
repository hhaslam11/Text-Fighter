package time;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class GameClock {

	
	private static LocalDateTime baseTime;
	private static LocalDateTime fastTime;
	private static long startTime;
	private static long endTime;
	private static long increasedTime;
	// Maybe where we set increasePercent could be moved to Settings?
	private static double increasePercent = 0.5;  // Time increase can be changed to desired increase.
	private static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
	
	
	// Default constructor
	public GameClock() {
		
	}
	
	// Declares the base time of the players current time.
	public static void startTimeClock() {
		
	}
	
	// This method is used as a end time place holder so that we can get a time duration.
	public static void endTimeCounter() {

	}
	
	// The time increase is based off of getting the milliseconds and increasing it by a percentage.
	// This method returns the amount of time in milliseconds that the game clock needs to be increased.
	public static long timeConversion() {
        
        return increasedTime;
	}
	
	// After you get the increase in time, you can add it to the base time.
	public static String updateGameTime() {
		
		return fastTime.toString();
	}

	
	// All these methods below are getters and setters for the variables.
	// These will be used mainly for testing purposes.
	
	public LocalDateTime getBaseTime() {
		return GameClock.baseTime;
	}
	
	public void setBaseTime(LocalDateTime newBaseTime) {
		GameClock.baseTime = newBaseTime;
	}
	
	public LocalDateTime getFastTime() {
		return GameClock.fastTime;
	}
	
	public void setFastTime(LocalDateTime newFastTime) {
		GameClock.fastTime = newFastTime;
	}
	
	public long getStartTime() {
		return GameClock.startTime;
	}
	
	public void setStartTime(long newStartTime) {
		GameClock.startTime = newStartTime;
	}
	
	public long getEndTime() {
		return GameClock.endTime;
	}
	
	public void setEndTime(long newEndTime) {
		GameClock.endTime = newEndTime;
	}
	
	public long getIncreasedTime() {
		return GameClock.increasedTime;
	}
	
	public double getIncreasePercent() {
		return GameClock.increasePercent;
	}
	
	public DateTimeFormatter getDateTimeFormat() {
		return GameClock.myFormatObj;
	}
	
	
}
