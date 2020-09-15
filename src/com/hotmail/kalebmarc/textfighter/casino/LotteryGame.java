package com.hotmail.kalebmarc.textfighter.casino;

public class LotteryGame extends BasicCasinoGame{
    public LotteryGame(){
        super("------------------------------------------------------------------\n" +
                "                                Lottery                            \n" +
                "------------------------------------------------------------------",
                "You will be able to buy lottery tickets.\n" +
                "Each lottery tickets costs 10 coins and increases\n" +
                "your chance to win a prize. Each lottery is drawn\n" +
                "the moment you pick the according option in the\n" +
                "menu. Good luck!",
                "1) Buy a ticket\n" +
                "2) Draw lottery results\n" +
                "3) Exit",
                GameType.LOTTO);
    }

    @Override
    public int play(int selection) {
        return 0;
    }

    @Override
    protected int getExitEntry() {
        return 3;
    }
}
