package com.hotmail.kalebmarc.textfighter.player;

public class GameTime {


	   // Variables
	private static long startTime;
	private static long endTime;
	private static String sessionTime;
	private static String totalTime;
	private static double totalSecondTime;
	private static double totalMinuteTime;
	private static double totalHourTime;
	private static double totalDayTime;
	private static double dumTotalSecond;
	private static double dumTotalMinute;
	private static double dumTotalHour;
	private static double dumTotalDay;

	//Variables
	private static double secondTime;
	private static double minuteTime;
	private static double hourTime;
	private static double dayTime;	
	
	public GameTime() {
		
	}
	
	// Set the total time to 0 for new players.
	public static void initializeNewTime() {
		
	}
	
	public static void initializeSavedTime() {
		
	}
	
	// This method is to start counting the time when the game has started.
	public static void startSessionTime() {
		
	}
	
	// This method is for the end time place holder.
	public static void endTime() {
		
	}
	
	// This method will calculate how much time has been played.
	// It will set the seconds, minutes, hours, and days.
	public static void calculateTime() {
		
	}
	
	// This method will print the current session time played to the console.
	public static String printSessionTime() {
		return sessionTime;
	}
	
	// The following methods will up update the total time for seconds, minutes, hours, and days.
	public static double getTotalSecondTime() {
		return totalSecondTime += secondTime;
	}
	
   public static double getTotalMinuteTime() {
	   return totalMinuteTime += minuteTime;
   }

   public static double getTotalHourTime() {
      return totalHourTime += hourTime;
   }

   public static double getTotalDayTime() {
      return totalDayTime += dayTime;
   }

   
   // The following methods sets the time totals for the saved file.
   // Set time totals from save file
   public static void setTotalSecondTime(double oldSeconds) {
      totalSecondTime = oldSeconds;
   }

   // Set time totals from save file
   public static void setTotalMinuteTime(double oldMinutes) {
      totalMinuteTime = oldMinutes;
   }

   // Set time totals from save file
   public static void setTotalHourTime(double oldHours) {
      totalHourTime = oldHours;
   }

   // Set time totals from save file
   public static void setTotalDayTime(double oldDays) {
      totalDayTime = oldDays;
   }
   
   // These getters and setter will mainly be used for testing purposes.
   public void setStartTime(long start) {
	   GameTime.startTime = start;
   }
   
   public long getStartTime() {
	   return GameTime.startTime;
   }
   
   public void setEndTime(long end) {
	   GameTime.endTime = end;
   }
   
   public long getEndTime() {
	   return GameTime.endTime;
   }
   
   public Double getSeconds() {
	   return GameTime.secondTime;
   }
   
   public Double getMinutes() {
	   return GameTime.minuteTime;
   }
   
   public Double getHours() {
	   return GameTime.hourTime;
   }
   
   public Double getDays() {
	   return GameTime.dayTime;
   }
}
