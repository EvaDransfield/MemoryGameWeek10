/*
 * 1.Paired Programming Assignment function is called calculateBestTime()
 * 2.Make a loop so that player can take a new turn.
 * 3.Make board sizes within the Board class, and call them into our Game.
 * 4. We need to create a timer so that we can get statistics for our game.
 */

package memorygame;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;
import java.io.Serializable;

/*
 * @author michelecope
 */

public class Game implements Serializable {  
    //these tags are used to reference the Game class in other classes.
    public static final String ONE_PLAYER_GAME = "ONE_PLAYER";
    public static final String TWO_PLAYER_GAME = "TWO_PLAYER";
    public static final String EASY="EASY";
      public static final String MEDIUM="MEDIUM";
        public static final String HARD="HARD";
    
    
    public static final String NO_ACTIVE_GAME = "NO_GAME_STARTED";
    public static final String NEW_GAME = "NEW_GAME";
    public static final String PLAYING = "PLAYING"; 
    public static final String WINNER = "WINNER"; 
    public static final String TIE = "TIE"; 
    public static final String QUIT = "QUIT"; 
    public static final String ERROR = "ERROR";
    public static final String EXIT = "EXIT";
    
    private String gameType;// used?
    public Player playerA;
    public Player playerB;
    private Player currentPlayer;
    private Player otherPlayer;
    private Player winner;// SAME AS THIS ONE ?  public static final String WINNER = "WINNER"; 
    private Player loser;
    public String status;
    private HelpMenuView gameRules;
    private Array gamePlayers;
    
    private final CardView[][]board;
    private final String[] words={"RED","RED","ORANGE","ORANGE","YELLOW","YELLOW","GREEN","GREEN","BLUE","BLUE","PURPLE","PURPLE","INDIGO","INDIGO","BLACK","BLACK","WHITE","WHITE","GRAY","GRAY","BROWN","BROWN","PINK","PINK","TURQOUISE","TURQOUISE","AQUA","AQUA","MAROON","MAROON","LIME","LIME","VIOLET","VIOLET","AMBER","AMBER"};
    private final Random randomCard;
    private final Scanner getInput;
    private int card;
    private int cardChoice1;
    private int cardChoice2;
   private int gameMove=0;// the player move
    private boolean matched = false;
    private double startingPoints = 115.00;
    
    
    public Game(){ //one player hard 
        randomCard = new Random();
        getInput = new Scanner(System.in);
        board = new CardView[4][6];
        playerA = new Player();
        playerB = new Player();
            
         shuffle();
        setCells ();
        printCells();
       playGame();
    }
    
    
     public void startGame(int noPlayers,int gameLevel)
    {
         Game game=new Game();        
        if (noPlayers != 1  &&  noPlayers != 2) {
            new MemoryGameError().displayError("startGame - invalid number of players specified.");
            return;
        }
      
       
        
        if (noPlayers == 1){
            if(gameLevel==1){
                System.out.println(" One PLayer Level 1");
               
                             }
             else if(gameLevel==2){
                 System.out.println(" One PLayer Level 2");
             
                              }
             else if (gameLevel==3){
                 System.out.println(" One PLayer Level 3");
               
                                    }
                    
                   
            }
        else {
             if(gameLevel==1){
                System.out.println(" Two PLayer Level 1");
               game.choosePairOfCards();// just a prototype needed to be created still
                             }
             else if(gameLevel==2){
                 System.out.println(" Two PLayer Level 2");
                  game.choosePairOfCards();// just a prototype needed to be created still
                              }
             else if (gameLevel==3){
                 System.out.println(" Two PLayer Level 3");
                  game.choosePairOfCards();// just a prototype needed to be created still
                              }
        
             }
    }
    
    
    /*public Game(){ //one player hard 
        randomCard = new Random();
        getInput = new Scanner(System.in);
        board = new CardView[6][6];
        playerA = new Player();
        playerB = new Player();
        shuffle();
        setCells ();
        printCells();
       // playGame();
    }
    
  /*  public Game(String gameType) {
        randomCard = new Random();
        getInput = new Scanner(System.in);
        board = new CardView[6][6];// create game "board"
        playerA = new Player();
        playerB = new Player();
        shuffle();
        setCells ();
        printCells();
        playGame();
    }*/

   
    
    public void choosePairOfCards(){
        int row1, col1, row2, col2;
        System.out.println();
        System.out.println("Enter the number on the card.");
        System.out.print("First Card Choice?>");
        cardChoice1 =getInputAsInt();
        gameMove++; //
        row1=cardChoice1/6;
        col1=cardChoice1%6;
        board[row1][col1].setShowingStatus();
        System.out.print("Second CardView Choice?>");
        System.out.print("\n");
        cardChoice2 =getInputAsInt();
        row2=cardChoice2/6 ;
        col2=cardChoice2%6;
        board[row2][col2].setShowingStatus();
       
        System.out.print('\u000C'); // Clear the screen
        printCells();
        matchedCards(row1, col1, row2, col2);
        
    }
    
        // check the card to see if the "cards" match
        // if they don't call each card's setShowingStatus to "flip" them
    public void matchedCards(int row1, int col1, int row2, int col2){
        if(board[row1][col1].back == board[row2][col2].back){
            matched = true;
            board[row1][col1].matched = true;
            board[row2][col2].matched = true;
            System.out.println("You made a match!"); // cards stay flipped over for duration of the game
            playGame();
        }
        else 
            board[row1][col1].setShowingStatus();
            board[row2][col2].setShowingStatus();
            playGame();
   }
   
   public void setCells (){
       card = 0;//the front of the card
       for (int row=0; row<board.length;row++){
           for (int col=0; col<board[0].length;col++){
               {
               board[row][col]=new CardView (words[card],card); // create a new card object
               card++;
               }
           }
       }
   }

   //makes the board, fills a grid with card object
   public void printCells(){
       for (int row=0; row<board.length;row++){
           for (int col=0; col<board[0].length;col++){
                board[row][col].showCard();
            }
       System.out.println();
       }    
   } 
    
    //Eva individual assignment lesson 6   
    public void shuffle(){
        for(int a=0; a < words.length;a++);{
            int pos = randomCard.nextInt(words.length);
            String temp = words[card];
            words[card] = words[pos];
            words[pos] = temp;
        }
    }

    public int getInputAsInt(){
        String temp = getInput.nextLine();
        return Integer.parseInt(temp); // example Integer.parseInt("34")returns the value of 34 integer
    }

    public String getInputAsString(){
        return getInput.nextLine();
    }
     public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HelpMenuView getGameRules() {
        return gameRules;
    }

    public void setGameRules(HelpMenuView gameRules) {
        this.gameRules = gameRules;
    }

    public Array getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Array gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getCardChoice1() {
        return cardChoice1;
    }

    public void setCardChoice1(int cardChoice1) {
        this.cardChoice1 = cardChoice1;
    }

    public int getCardChoice2() {
        return cardChoice2;
    }

    public void setCardChoice2(int cardChoice2) {
        this.cardChoice2 = cardChoice2;
    }

    public int getGameMove() {
        return gameMove;
    }

    public void setGameMove(int gameMove) {
        this.gameMove = gameMove;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public double getStartingPoints() {
        return startingPoints;
    }

    public void setStartingPoints(double startingPoints) {
        this.startingPoints = startingPoints;
    }
    
    //this function will call all functions to play the game
    public void playGame(){
       choosePairOfCards();
    }
}