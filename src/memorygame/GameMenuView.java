package memorygame;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michelewhite
 */
public class GameMenuView  extends Menu {// do we need this class? when is this class appear?
    
    private Game game;
    private MainMenuControl mainMenuControl ;
    private MainMenuView mainMenuView = new MainMenuView();
    private final static String[][] menuItems = {
        {"T","Take your turn"},
        {"D", "Display the board"},
        {"N", "New Game"},
        {"H", "Help"},
        {"Q", "QUIT"}
    };
public GameMenuView(){
super(GameMenuView.menuItems);
}
    public GameMenuView(Game game) {
        this.game = game;
        this.mainMenuControl = new MainMenuControl();
    }

    


    @Override
    public String executeCommands(Object object) {
        String gameStatus = Game.PLAYING;
    
    
        do {    
            this.display(); // display the menu

              String command = this.getCommand();
            switch (command) {
                case "T":case"t":
                    this.game.choosePairOfCards();
                    break;
                case "D":case"d":
                    this.game.printCells();
                    break;
                case "N":case"n":
                    this.mainMenuView.display();
                    break;
                case "H":case"h":
                     
                    HelpMenuView helpMenu = Memorygame.getHelpMenu();
                    helpMenu.executeCommands(null);
                    break;
                case "X": case"x":                  
                   return Game.EXIT;
                 
                                
            }
      } while (!gameStatus.equals(Game.EXIT));
        

           return Game.EXIT;
    }
  
}


