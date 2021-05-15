package com.hotmail.kalebmarc.textfighter.domain;


public class GameEntity{
    
  private static double bankInterest;
  private static int bankBalance;

  public double getBankInterest(){
    return bankInterest;
  }
  
  
  public void setBankInterest(double bankInterest){
    GameEntity.bankInterest = bankInterest;
  }


  public void setBankBalance(double bankBalance){
    GameEntity.bankBalance = bankBalance;
  }

  public int getBankBalance(){
   return bankBalance;
  }
 
}
