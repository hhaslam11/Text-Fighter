package com.hotmail.kalebmarc.textfighter.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private GameClock() {}
	
	// Declares the base com.hotmail.kalebmarc.textfighter.time of the players current com.hotmail.kalebmarc.textfighter.time.
	public static void startTimeClock() {
		startTime = System.currentTimeMillis();
		baseTime = LocalDateTime.now();
	}
	
	// This method is used as a end com.hotmail.kalebmarc.textfighter.time place holder so that we can get a com.hotmail.kalebmarc.textfighter.time duration.
	public static void endTimeCounter() {
		endTime = System.currentTimeMillis();
	}
	
	// The com.hotmail.kalebmarc.textfighter.time increase is based off of getting the milliseconds and increasing it by a percentage.
	// This method returns the amount of com.hotmail.kalebmarc.textfighter.time in milliseconds that the game clock needs to be increased.
	public static long timeConversion() {
        increasedTime = endTime - startTime;
        return (long) (increasedTime + (increasedTime * increasePercent));
	}
	
	// This method adds the increased com.hotmail.kalebmarc.textfighter.time to the base com.hotmail.kalebmarc.textfighter.time.
	// The base com.hotmail.kalebmarc.textfighter.time gets formatted into a string.
	// The date and com.hotmail.kalebmarc.textfighter.time string gets split into two separate date and com.hotmail.kalebmarc.textfighter.time strings.
	public static void updateGameTime() {
		endTimeCounter();
		fastTime = baseTime.plus(Duration.ofMillis(timeConversion()));
		splitDateTime(fastTime);
	}
	
	// This method is for simply splitting up the LocalDateTime into separate strings of date and com.hotmail.kalebmarc.textfighter.time.
	public static void splitDateTime(LocalDateTime dateTime) {
		String[] dateTimeArray = dateTime.format(myFormatObj).split("-");
		gameDate = dateTimeArray[0];
		gameTime = dateTimeArray[1];
	}
	
	

	
	// All these methods below are getters and setters for the variables.
	// These will be used mainly for testing purposes.
	
	public static LocalDateTime getBaseTime() {
		return baseTime;
	}
	
	public static void setBaseTime(LocalDateTime newBaseTime) {
		baseTime = newBaseTime;
	}
	
	public static LocalDateTime getFastTime() {
		return fastTime;
	}
	
	public static void setFastTime(LocalDateTime newFastTime) {
		fastTime = newFastTime;
	}
	
	public static long getStartTime() {
		return startTime;
	}
	
	public static void setStartTime(long newStartTime) {
		startTime = newStartTime;
	}
	
	public static long getEndTime() {
		return endTime;
	}
	
	public static void setEndTime(long newEndTime) {
		endTime = newEndTime;
	}
	
	public static long getIncreasedTime() {
		return increasedTime;
	}
	
	public static double getIncreasePercent() {
		return increasePercent;
	}
	
	public static DateTimeFormatter getDateTimeFormat() {
		return myFormatObj;
	}
	
	// The getter and setter methods below here are static so that they can be used from the Game class to grab
	// the date and com.hotmail.kalebmarc.textfighter.time as separate strings.
	public static void setGameDate(String date) {
		gameDate = date;
	}
	
	public static String getGameDate() {
		return gameDate;
	}
	
	public static void setGameTime(String time) {
		gameTime = time;
	}
	
	public static String getGameTime() {
		return gameTime;
	}
	
	
}
