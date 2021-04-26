package com.hotmail.kalebmarc.textfighter.main;

import static java.util.Arrays.asList;

class Menu {

  public void load() {
    while (true) {

      //Menu Screen
      GameUtils.showPopup(Constants.WELCOME_HEADER,
          Constants.SUB_HEADER,
          asList("To get started, Type in a number below", "and press enter."),
          asList("Start Game", "About Game")
      );

      switch (Ui.getValidInt()) {
        case 1:
          Ui.guiEnabled = false;
          new Game().start();

          //Saves the game before exiting
          // docschorsch: save() only if player is not program default player amd game had started
          if (User.getPlayerDefault() > 0 && Game.hadGameStarted()) {
            Saves.save();
          }
          break;
        case 2:
          About.view(false);
          break;
        case 3:
          return;
        default:
          break;
      }
    }//Loop
  }//Method
}//Class
