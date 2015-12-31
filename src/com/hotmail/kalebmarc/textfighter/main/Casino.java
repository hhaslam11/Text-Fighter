package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;

public class Casino {
	private Casino(){}

	public static int totalCoinsWon  = 0;
    public static int gamesPlayed = 0;
	public static void menu(){
		
		while (true){
			Action.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                      WELCOME TO THE CASINO                       ");
			Ui.println();
			Ui.println("     Coins: " + Coins.get());
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Dice Game");
			Ui.println("2) Slots");
			Ui.println("3) Back");
			Ui.println("------------------------------------------------------------------");

			int menuChoice = Action.getValidInt();

			switch(menuChoice){
			case 1:
				dice();
				break;
			case 2:
				slots();
				break;
			case 3:
				return;
			default:
				break;
			}//Switch
		}//main loop
	}
	private static void dice(){
		while (true){
			Action.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                            Dice Game                             ");
			Ui.println(                                                                    );
			Ui.println("     Coins: " + Coins.get()                                        );
			Ui.println("------------------------------------------------------------------");
			Ui.println("                           How to play                            ");
			Ui.println(                                                                    );
			Ui.println("You will pick two numbers between 1, and 6.");
			Ui.println("Two dice will be rolled. If one of the dice matches one of your    ");
			Ui.println("numbers, you will win double the coins you bet. If both dice      ");
			Ui.println("matches both of your numbers, you will win 5 times the amount     ");
			Ui.println("of coins you bet. If none of the dice matches either of your      ");
			Ui.println("numbers, then you lose all your coins that you have bet.          ");
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Let's play!                                                    ");
			Ui.println("2) Back to casino menu                                            ");
			Ui.println("------------------------------------------------------------------");

			int menuChoice = Action.getValidInt();

			switch(menuChoice){
			case 1:
				dicePlay();
				break;
			case 2:
				return;
			default:
				break;
			}//Switch
		}//While
		
	}
	private static void slots(){
		while (true){

			Action.cls();

			Ui.println("------------------------------------------------------------------");
			Ui.println("                              Slots                               ");
			Ui.println(                                                                    );
			Ui.println("     Coins: " + Coins.get()                                        );
			Ui.println("------------------------------------------------------------------");
			Ui.println("                           How to play                            ");
			Ui.println(                                                                    );
			Ui.println("You will pick an amount of coins to bet. Then, 4 slots will spin, ");
			Ui.println("each containing 5 possibilities. You'll win coins depending on how");
			Ui.println("much of the same item you spin.                                   ");
			Ui.println(                                                                    );
			Ui.println("0 the same : Lose amount you bet                                  ");
			Ui.println("2 the same : Lose amount you bet                                  ");
			Ui.println("3 the same : Win 4 times the amount you bet                       ");
			Ui.println("4 the same : Win 8 times the amount you bet                       ");
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Let's play!                                                    ");
			Ui.println("2) Back to casino menu                                            ");
			Ui.println("------------------------------------------------------------------");

			int menuChoice = Action.getValidInt();

			switch(menuChoice){
			case 1:
				slotsPlay();
				break;
			case 2:
				return;
			default:
				break;
			}//Switch
		}//While
	}
	private static void dicePlay(){
		int bet;
		int firstNumber;
		int secondNumber;
		int dice1;
		int dice2;
		int coinsWon = 0;
		
		//Greeting & Input
		Action.cls();
		Ui.println("------------------------------------------------------------------");
		Ui.println("                              Dice Game                           ");
		Ui.println("------------------------------------------------------------------");
		Ui.println();
		Ui.println("Coins: " + Coins.get());
		Ui.println();
		Ui.println("To begin, enter the amount of coins you would like to bet.. ");
		Ui.println("It must be between 10, and 250.");
		Ui.println("Enter 0 to go back");
		do{//Bet
			bet = Action.getValidInt();
			if (bet == 0) return;
			if (bet > Coins.get()){
				Action.cls();
				bet = 0;
				Ui.println("You do not have enough coins. Please enter a smaller amount. (Or enter 0 to go back)");
				Action.pause();
			}
		}while(bet < 10 || bet > 250);
		
		Coins.set(-bet, true);
		
		do{//First Number
			Action.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                              Dice Game                           ");
			Ui.println("------------------------------------------------------------------");
			Ui.println();
			Ui.println("Now, pick your first number.");
			Ui.println("It must be between 1, and 6.");
			firstNumber = Action.getValidInt();
		}while(firstNumber < 1 || firstNumber > 6);
		do{//Second Number
			Action.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                              Dice Game                           ");
			Ui.println("------------------------------------------------------------------");
			Ui.println();
			Ui.println("Finally, pick your second number.");
			Ui.println("It must be between 1, and 6.");
			secondNumber = Action.getValidInt();
		}while(secondNumber < 1 || secondNumber > 6);

		//Rolling Dice
		Action.cls();
		Ui.println("Rolling the two dice...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Handle.error(e.toString());
		}
		dice1 = Random.RInt(6);
		dice2 = Random.RInt(6);
		Ui.println("Results are ready! Press enter to continue.");
		Action.pause();
		
		//Results
		boolean fNum = false, sNum = false;
		if (firstNumber == dice1 || firstNumber == dice2) fNum = true;
		if (secondNumber == dice1 || secondNumber == dice2) sNum = true;
		if (fNum ^ sNum) coinsWon = bet * 2;
		if (fNum && sNum) coinsWon = bet * 5;
		Action.cls();
		Ui.println("------------------------------------------------------------------");
		Ui.println("                              Dice Game                           ");
		Ui.println("------------------------------------------------------------------");
		Ui.println("Your bet: " + bet);
		Ui.println("First number: " + firstNumber);
		Ui.println("Second Number: " + secondNumber);
		Ui.println();
		Ui.println("Dice 1: " + dice1);
		Ui.println("Dice 2: " + dice2);
		Ui.println();
		Ui.println("Coins Won: " + coinsWon);
		Coins.set(coinsWon, true);
		totalCoinsWon += coinsWon;
		gamesPlayed++;
		Stats.diceGamesPlayed++;
		Action.pause();
	}
	private static void slotsPlay(){
		
		int bet;
		int slot;
		int coinsWon = 0;
		String slots[] = {"", "", "", "", ""};
		int s[] = {0, 0, 0, 0, 0, 0};
		
		//Greetings/Input
		Action.cls();
		Ui.println("------------------------------------------------------------------");
		Ui.println("                                Slots                             ");
		Ui.println("------------------------------------------------------------------");
		Ui.println();
		Ui.println("Coins: " + Coins.get());
		Ui.println();
		Ui.println("To begin, enter the amount of coins you would like to bet.. ");
		Ui.println("It must be between 10, and 250.");
		do{//Bet
			bet = Action.getValidInt();
			if (bet == 0) return;
			if (bet > Coins.get()){
				Action.cls();
				bet = 0;
				Ui.println("You do not have enough coins. Please enter a smaller amount, or type 0 to go back.");
				Action.pause();
			}
		}while(bet < 10 || bet > 250);
		Coins.set(-bet, true);
		
		//Rolling slots
		//slot1
		slot = Random.RInt(5);
		if (slot == 1) slots[1] = "$";
		if (slot == 2) slots[1] = "%";
		if (slot == 3) slots[1] = "&";
		if (slot == 4) slots[1] = "*";
		if (slot == 5) slots[1] = "@";
		//slot2
		slot = Random.RInt(5);
		if (slot == 1) slots[2] = "$";
		if (slot == 2) slots[2] = "%";
		if (slot == 3) slots[2] = "&";
		if (slot == 4) slots[2] = "*";
		if (slot == 5) slots[2] = "@";
		//slot3
		slot = Random.RInt(5);
		if (slot == 1) slots[3] = "$";
		if (slot == 2) slots[3] = "%";
		if (slot == 3) slots[3] = "&";
		if (slot == 4) slots[3] = "*";
		if (slot == 5) slots[3] = "@";
		//slot4
		slot = Random.RInt(5);
		if (slot == 1) slots[4] = "$";
		if (slot == 2) slots[4] = "%";
		if (slot == 3) slots[4] = "&";
		if (slot == 4) slots[4] = "*";
		if (slot == 5) slots[4] = "@";
		
		//Result
		Action.cls();
		Ui.println("Spinning slots...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Handle.error(e.toString());
		}
		
		for (int i = 1; i < 5; i++){
			if (slots[i].equals("$")) s[1]++;
			if (slots[i].equals("%")) s[2]++;
			if (slots[i].equals("&")) s[3]++;
			if (slots[i].equals("*")) s[4]++;
			if (slots[i].equals("@")) s[5]++;
		}
		for (int i = 1; i < 5; i++){
			if (s[i] == 3) coinsWon = bet * 4;
		}
		for (int i = 1; i < 5; i++){
			if (s[i] == 4) coinsWon = bet * 8;
		}
		Ui.println("Results Ready! Press enter to continue.");
		Action.pause();
		Ui.println("------------------------------------------------------------------");
		Ui.println("                                Slots                             ");
		Ui.println("------------------------------------------------------------------");
		Ui.println("Your bet: " + bet);
		Ui.println();
		Ui.println("Rolled Slots: " + slots[1] + "  " + slots[2] + "  " + slots[3] + "  " + slots[4]);
		Ui.println();
		Ui.println("Coins Won: " + coinsWon);
		Coins.set(coinsWon, true);
		totalCoinsWon += coinsWon;
		gamesPlayed++;
        Stats.slotGamesPlayed++;
		Action.pause();		
	}
}
