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
	private static double oldTotalSecond;
	private static double oldTotalMinute;
	private static double oldTotalHour;
	private static double oldTotalDay;

	//Variables
	private static double secondTime;
	private static double minuteTime;
	private static double hourTime;
	private static double dayTime;	
	
	public GameTime() {
		
	}
	
	// Set the total time to 0 for new players.
	public static void initializeNewTime() {
		
		setTotalSecondTime(0.0);
	    setTotalMinuteTime(0.0);
	    setTotalHourTime(0.0);
	    setTotalDayTime(0.0);
	    secondTime = 0.0;
	    minuteTime = 0.0;
	    hourTime = 0.0;
	    dayTime = 0.0;
	}
	
	public static void initializeSavedTime() {
		oldTotalSecond = totalSecondTime;
		oldTotalMinute = totalMinuteTime;
		oldTotalHour = totalHourTime;
		oldTotalDay = totalDayTime;
		
	}
	
	// This method is to start counting the time when the game has started.
	public static void startSessionTime() {
		startTime = System.currentTimeMillis();
	}
	
	// This method is for the end time place holder.
	public static void endTime() {
	    endTime = System.currentTimeMillis();
	    calculateTime();
	}
	
	// This method will calculate how much time has been played.
	// It will set the seconds, minutes, hours, and days.
	public static void calculateTime() {
		secondTime = (double) (endTime - startTime) / 1000;
		minuteTime = secondTime / 60;
		hourTime = minuteTime / 60;
		dayTime = hourTime / 24;
	}
	
	// This method will print the current session time played to the console.
	public static String printSessionTime() {
		endTime();
		sessionTime = "	Days: " + String.format("%.2f", dayTime) + "\n"
                     	+ "	Hours: " + String.format("%.2f", hourTime) + "\n"
                     	+ "	Minutes: " + String.format("%.2f", minuteTime) + "\n"
                     	+ "	Seconds: " + String.format("%.2f", secondTime);
		return sessionTime;
	}
	
	// This method will update the total amount of time played.
	public static void updateTotalTime() {
		endTime();
		totalTime =  " Days: " + String.format("%.2f", getTotalDayTime()) + "\n"
             	+ "	Hours: " + String.format("%.2f", getTotalHourTime()) + "\n"
             	+ "	Minutes: " + String.format("%.2f", getTotalMinuteTime()) + "\n"
             	+ "	Seconds: " + String.format("%.2f", getTotalSecondTime());
	}
	
	// The following methods will up update the total time for seconds, minutes, hours, and days.
	public static double getTotalSecondTime() {
		return totalSecondTime = oldTotalSecond + secondTime;
	}
	
   public static double getTotalMinuteTime() {
	   return totalMinuteTime = oldTotalMinute + minuteTime;
   }

   public static double getTotalHourTime() {
      return totalHourTime = oldTotalHour + hourTime;
   }

   public static double getTotalDayTime() {
      return totalDayTime = oldTotalDay + dayTime;
   }

   
   // The following methods sets the time totals for the saved file.
   // Set time totals from save file
   public static void setTotalSecondTime(double oldSeconds) {
      oldTotalSecond = oldSeconds;
   }

   // Set time totals from save file
   public static void setTotalMinuteTime(double oldMinutes) {
      oldTotalMinute = oldMinutes;
   }

   // Set time totals from save file
   public static void setTotalHourTime(double oldHours) {
      oldTotalHour = oldHours;
   }

   // Set time totals from save file
   public static void setTotalDayTime(double oldDays) {
      oldTotalDay = oldDays;
   }
   
   public static String getTotalTime() {
	   return GameTime.totalTime;
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
