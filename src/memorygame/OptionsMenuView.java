package memorygame;

import java.util.Scanner;
/*
 * @author michelewhite
 */

public class OptionsMenuView extends Menu {
    private String whatToDo;
    private int numbPlayers;
    private int numblevel;    
    
    private final static String[][] menuItemsLevel = {
        {"1","Easy"},
        {"2","Medium"},
        {"3","Large"},
        {"Q","Quit"},
    };
    
    private final static String[][] menuItemsNumbPlayers = {
        {"1","One Player"},
        {"2","Two Player"},
        {"X","Quit Options Menu"},
    };
   // LevelMenuView levelMenu= new LevelMenuView();
    
    
    public OptionsMenuView() {
        super(OptionsMenuView.menuItemsNumbPlayers);
    }
    
    @Override
    public String executeCommands(Object object) {
      //  String gameStatus = Game.PLAYING;
        
        if (this.whatToDo.equalsIgnoreCase("Level")){
            
            this.setMenuItems(menuItemsLevel);                
            this.display();
            String command = this.getCommand();
            switch (command) {
                    case "1":
                        this.setNumbLevel(1);
                        break; 
                    case "2":
                        this.setNumbLevel(2);
                        break;
                     case "3":
                       this.setNumbLevel(3);
                         break;
                     case "X":
                         return Game.EXIT;
            }
        }else if (this.whatToDo.equalsIgnoreCase("Player")){
                   
            this.setMenuItems(menuItemsNumbPlayers); 
            this.display();
            String command = this.getCommand();
            switch (command) {
                case "1": 
                   this.setNumbPlayers(1);
                   break;
                case "2":
                   this.setNumbPlayers(2);
                   break;
                 case "X":case"x":
                    return Game.EXIT;
            }
        }
        
 
        return Game.EXIT;
    }
    
    /*
    
    public void startGame(int noPlayers,int gameLevel)
    {
                 
        if (noPlayers != 1  &&  noPlayers != 2) {
            new MemoryGameError().displayError("startGame - invalid number of players specified.");
            return;
        }
        //COMMENT/////////////////////////////////////////////
         // The game should not be calling from here to create a tight cohesion.
        //I think Game class should call here and get the "noPlayers" and "gameLevel" parameters
        // to set the right board for each game 
       
        
        if (noPlayers == 1){
            if(gameLevel==1){
                System.out.println(" One PLayer Level 1");
                GameEasy gameEasy = new GameEasy();
                gameEasy.choosePairOfCards();
               
               
                             }
             else if(gameLevel==2){
                 System.out.println(" One PLayer Level 2");
               
                              }
             else if (gameLevel==3){
                 System.out.println(" One PLayer Level 3");
             //  game.choosePairOfCards(); // just a prototype needed to be created still   
                                    }
                    
                   
            }
        else {
             if(gameLevel==1){
                System.out.println(" Two PLayer Level 1");
            //   game.choosePairOfCards();// just a prototype needed to be created still
                             }
             else if(gameLevel==2){
                 System.out.println(" Two PLayer Level 2");
            //      game.choosePairOfCards();// just a prototype needed to be created still
                              }
             else if (gameLevel==3){
                 System.out.println(" Two PLayer Level 3");
           //       game.choosePairOfCards();// just a prototype needed to be created still
                              }
        
             }
        
    }

              
                

     /*
    
    //    private Game createGame(String gameType) {
        Game game = null;
        Player playerA = null;
        Player playerB = null;
        
     //   if (gameType == null) {
       //     new MemoryGameError().displayError("MainCommands - create: gameType is null");
         //   return null;
        //}
        
        if (gameType.equals(Game.ONE_PLAYER_GAME)) {
            game = new Game(Game.ONE_PLAYER_GAME);
            playerA = new Player(Player.MAIN_USER);
            playerA.name = "Player 1";
        }
        else if (gameType.equals(Game.TWO_PLAYER_GAME)) {
            game = new Game(Game.TWO_PLAYER_GAME);
            playerA = new Player(Player.MAIN_USER);
            playerA.name = "Player 1";
            playerB = new Player(Player.SECOND_USER);
            playerB.name = "Player 2";

        }

        // save the two players created as the default players of the game
        game.playerA = playerA;
        game.playerB = playerB; 
        
        // set the game status to game not yet in playing mode
        game.status = Game.NO_ACTIVE_GAME;
        
        return game;
    }*/ 
    
    public String quitGame() {
        System.out.println("\n\tAre you sure you want to quit? (Y or N)");
        Scanner inFile = new Scanner(System.in);
        String answer = inFile.next().trim().toUpperCase();
        if (answer.equals("Y")) {
            return Game.EXIT;
        }

        return Game.PLAYING;
    }

    
    
    
    
    public void setNumbLevel(int level){
        this.numblevel = level;
    }
    
    public int getNumbLevel(){
        return this.numblevel;
    }
    
    public void setNumbPlayers(int level){
        this.numbPlayers = level;
    }
    
    public int getNumbPlayers(){
        return this.numbPlayers;
    }
 
   public void setWhatToDo(String doing){
        this.whatToDo = doing;
    }
 
 
}


