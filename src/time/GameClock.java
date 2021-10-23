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
	private static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy-HH:mm:ss");
	private static String gameDate;
	private static String gameTime;
	
	
	// Default constructor
	public GameClock() {
		
	}
	
	// Declares the base time of the players current time.
	public static void startTimeClock() {
		startTime = System.currentTimeMillis();
		baseTime = LocalDateTime.now();
	}
	
	// This method is used as a end time place holder so that we can get a time duration.
	public static void endTimeCounter() {
		endTime = System.currentTimeMillis();
	}
	
	// The time increase is based off of getting the milliseconds and increasing it by a percentage.
	// This method returns the amount of time in milliseconds that the game clock needs to be increased.
	public static long timeConversion() {
        increasedTime = endTime - startTime;
        return (long) (increasedTime + (increasedTime * increasePercent));
	}
	
	// This method adds the increased time to the base time.
	// The base time gets formatted into a string.
	// The date and time string gets split into two separate date and time strings.
	public static void updateGameTime() {
		endTimeCounter();
		fastTime = baseTime.plus(Duration.ofMillis(timeConversion()));
		splitDateTime(fastTime);
	}
	
	// This method is for simply splitting up the LocalDateTime into separate strings of date and time.
	public static void splitDateTime(LocalDateTime dateTime) {
		String[] dateTimeArray = dateTime.format(myFormatObj).split("-");
		gameDate = dateTimeArray[0];
		gameTime = dateTimeArray[1];
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
	
	// The getter and setter methods below here are static so that they can be used from the Game class to grab
	// the date and time as separate strings.
	public static void setGameDate(String date) {
		GameClock.gameDate = date;
	}
	
	public static String getGameDate() {
		return GameClock.gameDate;
	}
	
	public static void setGameTime(String time) {
		GameClock.gameTime = time;
	}
	
	public static String getGameTime() {
		return GameClock.gameTime;
	}
	
	
}
