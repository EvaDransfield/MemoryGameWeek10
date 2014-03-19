/*
 * This class works correctly! 
 */

package memorygame;
import java.util.Scanner;

/**
 * @author Eva
 */

// first appears to the screen
// this is what you see when first open the program
// the main menu will have: Easy, Normal, and hard option
public class MainMenuView extends Menu {  //this class has a tight cohesion
    private String command;
    
    private static final String[][] menuItems = {
        {"N", "Enter player names"},
        {"M", "Game Menu options"},
        {"H", "Help"},
        {"S", "Display Statistics"},
        {"X", "Exit Memory Game"},
    }; 
    
     MainMenuControl mainMenuControl=new MainMenuControl();
    // OptionsMenuView optionMenuView= new OptionsMenuView();
      
   
  
    public MainMenuView(){ 
        
        super(MainMenuView.menuItems);
    }
 

    @Override
  
       
    public String executeCommands(Object object) {
       
          String gameStatus = Game.PLAYING;
   
          do {
            this.display();           
           
            String command = this.getCommand();
            switch (command) {
                case "N": case "n":
                    this.mainMenuControl.createPlayerList();
                    
                    
                    break;
                case "M":case "m":
                    // get number of players
                    OptionsMenuView optionMenu = new OptionsMenuView();
                    optionMenu.setWhatToDo("Player");
                    optionMenu.executeCommands(null);

                    // get the level
                    optionMenu.setWhatToDo("Level");
                    optionMenu.executeCommands(null);
       
                    // play the game. (Need to move this to the Game class)
                   // optionMenu.startGame(optionMenu.getNumbPlayers(), optionMenu.getNumbLevel());
                   Game game = new Game();
                    game.startGame(optionMenu.getNumbPlayers(), optionMenu.getNumbLevel());
                    
       
                    //OptionsMenuView optionMenu = Memorygame.getOptionMenu();
                    //optionMenu.executeCommands(null);
                    /*this.optionMenuView.getCommand();*/
                    break;
                case "H":case"h":
                    HelpMenuView helpMenu = Memorygame.getHelpMenu();
                    helpMenu.executeCommands(null);
                    break;
                case "S": case"s":
                    this.mainMenuControl.displayStatistics();
                    break;
                case "X":case"x":
                    return Game.EXIT;
                 
                                
            }
      } while (!gameStatus.equals(Game.EXIT));

        return Game.EXIT;
    }

    public void setCommand(String cmd){
        this.command = cmd;
    }
    public String setCommand(){
        return this.command;
    }
}
 
        
       
   
    

