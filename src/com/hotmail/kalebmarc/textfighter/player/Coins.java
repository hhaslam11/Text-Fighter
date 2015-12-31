package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.main.Action;
import com.hotmail.kalebmarc.textfighter.main.Ui;

public class Coins {
	
	private static int coins;
	private static int bank;
    private static double interest;

	private Coins(){}
	
	public static int get(){
		return coins;
	}
	public static int getBank(){
		return bank;
	}
	public static void set(int amount, boolean add){
		if(!add){
			coins = amount;
		}else{
			coins += amount;
			if (amount < 0) Stats.totalCoinsSpent += -amount;
			if (coins < 0) coins = 0;
		}
	}
	public static void setBank(int amount, boolean add){
		if(!add){
			bank = amount;
		}else{
			bank += amount;
			if (bank < 0) bank = 0;
		}
	}
    public static void setInterest(double price){
        interest = price;
    }
	public static void bank(){
		
		int amount;
		
		//Makes sure user level 2
		if(Xp.getLevel() < 2){
			Action.cls();
			Ui.println("You have to be at least level 2 to use the bank.");
			Action.pause();
			return;
		}

		while(true){
			
			Action.cls();
			Ui.println("---------------------------------------");
			Ui.println("                BANK              ");
			Ui.println();
			Ui.println("You can deposit your coins into");
			Ui.println("the bank, so they will be safe if");
			Ui.println("you die. However, you will need to");
			Ui.println("pay " + (interest * 100) + "% of what you're depositing");
			Ui.println("every time (Rounded to the nearest ");
			Ui.println("whole number).");
			Ui.println();
			Ui.println("Balance (Coins in the bank): " + getBank());
			Ui.println("Coins: " + get());
			Ui.println();
			Ui.println("1) Deposit");
			Ui.println("2) Withdraw");
			Ui.println("3) Back");
			Ui.println("---------------------------------------");
			
			switch(Action.getValidInt()){
			case 1:
				//-----------------------------------------------------------------------------------
				Ui.println("How much money would you like to deposit? (You will have to pay " + (interest * 100) + "% of this)");
				Ui.println("You currently have " + get() + " coins.");
				do{
					amount = Action.getValidInt();
					if(amount > get()){
						Ui.println("You don't have enough coins. You only have " + get() + " coins.");
						amount = -1;
					}
				}while(amount < 0);
				if (amount == 0) return;
				
				//Deposit
				deposit(amount, interest);
				//-----------------------------------------------------------------------------------
				break;				
			case 2:
				//-----------------------------------------------------------------------------------
				Action.cls();
				
				//Input
				Ui.println("How much money would you like to withdraw?");
				Ui.println("You currently have " + getBank() + " coins in your bank.");
				do{
					amount = Action.getValidInt();
					if(amount > getBank()){
						Ui.println("You don't have enough coins in your bank. You only have " + getBank() + " coins.");
						amount = -1;
					}
				}while(amount < 0);
				
				//Withdraw
				withdraw(amount);				
				//-----------------------------------------------------------------------------------
				break;
			case 3:
				return;
			}
		}			
	}
	private static void withdraw(int amount){
		//Calculation
		set(amount, true);
		setBank(-amount, true);
				
		//Result
		Action.cls();
		Ui.println("Amount withdrawn: " + amount);
		Ui.println("Current Balance: " + getBank());
		Action.pause();
	}
	private static void deposit(int amount, double interest){
		
		//Get interest
		interest = interest * amount;
		if (amount < 10) interest = 1;
		
		//Take coins from player
		set(-amount, true);
		
		//Take away interest amount
		amount -= Math.round(interest);
		Stats.totalCoinsSpent += Math.round(interest);
        Stats.coinsSpentOnBankInterest += Math.round(interest);

		//Add remaining coins to bank account
		setBank(amount, true);
				
		//Display
		Action.cls();
		Ui.println("Amount Deposited: " + amount + " coins");
		Ui.println("Interest Paid: " + Math.round(interest) + " coins");
		Ui.println("Current Balance: " + getBank() + " coins");
		Action.pause();
	}	
}