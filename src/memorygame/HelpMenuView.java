/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorygame;

import java.util.Scanner;



/**
 * @author michelecope
 */
public class HelpMenuView extends Menu  {
     public static final String OBJECTIVE = "OBJECTIVE";
    public static final String  PLAYER_ONE= "PLAYER-ONE";
    public static final String PLAYER_TWO = "PLAYER_TWO";
    
        
    private final static String[][] menuItems = {
        {"O", "The Objective"},
        {"1", "The One Player Game"}, 
        {"2", "The Two Player Game"},        
        {"Q", "Quit Help"}        
    };
   
     public HelpMenuView() {
        super(HelpMenuView.menuItems);
     }
   
    @Override
    public String executeCommands (Object object){
         String gameStatus = Game.PLAYING;
                
        do {
            
            this.display(); 
            String command = this.getCommand();
            switch (command) {
                case "O":
                   // this.helpMenuControl.displayGameObjective();
                    this.displayHelp(HelpMenuView.OBJECTIVE);
                    break;
                case "1":
                    this.displayHelp(HelpMenuView.PLAYER_ONE);
                    break;
                case "2":
                     this.displayHelp(HelpMenuView.PLAYER_TWO);
                    break;                   
                case "Q": 
                     return Game.QUIT;
               }
        } while (!gameStatus.equals(Game.QUIT));  
        
         return gameStatus;
    }

       private void displayHelp(String helpType) {

        String helpText = null;
        switch (helpType) {
            case HelpMenuView.OBJECTIVE: helpText = 
               "\t The objective of this game is to try and find \n\n"
            + "\tthe match for each cards by memorizing them";
                break;
                
            case HelpMenuView.PLAYER_ONE: helpText = 
                 "\t You have 115 points.\n\n"
            +"\tYour points is substructed when you make a move\n\n"
            +"\tTry to finish the game with just few moves";
                break; 
                
            case HelpMenuView.PLAYER_TWO: helpText = 
                 "\t You compete against the computer. The one that\n\n"
            +"\thas the most matches at the nd of the game wins!\n\n";
                break;
                
            
        }   
        
        StringBuilder dividerLine = new StringBuilder(80);
        for (int i = 0; i < 80; i++) {
            dividerLine.insert(i, '~');
        }
        
        System.out.println("\t" + dividerLine.toString());
        System.out.println(helpText);
        System.out.println("\t" + dividerLine.toString());
    }
  
}
