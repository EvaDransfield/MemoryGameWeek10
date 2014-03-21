/*
 * This class should include all of the statistic functions because those are all 
 * dependant on instances of the Player class.  So we need to make sure to 
 * move and statistic functions that are in other classes to this class.
 */

package gamecreator;

import controls.MemoryGameError;
import java.io.Serializable;
/**
 * @author KenandEva
 * this class creates our Player Object, kind of like the little silver pieces 
 * used to mark a player on the board in Monopoly
 */

// Eva's individual assignment lesson 3
// Paired Programming Assignment Lesson 8
public class Player implements Serializable {
    
    public static final String MAIN_USER = "USER_ONE";
    public static final String SECOND_USER = "USER_TWO";
    public String name;
        
    private int gameMove;
    private String playerType;
    private long wins = 0;
    private long losses = 0;
    private long ties = 0;
    private double startingPoints = 115.00;
    
    public Player(){
        this.getTotalPoints();
        getTotalPoints();
        this.calculateBestTime(55.55,235.55);
        this.calculateFactorial(5);
        this.calculateHappiness(12, 4);    
    }
    
    public Player (String userType){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameMove() {
        return gameMove;
    }

    public void setGameMove(int gameMove) {
        this.gameMove = gameMove;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getLosses() {
        return losses;
    }

    public void setLosses(long losses) {
        this.losses = losses;
    }

    public long getTies() {
        return ties;
    }

    public void setTies(long ties) {
        this.ties = ties;
    }

 // Paired Programming Assignment
    private void calculateBestTime(double recordBest, double newTime){
        int secondsBehind;
        int secondsAhead;
    
        if(((recordBest <= 0)&&(newTime <= 0))||(newTime <= 0)) 
            System.out.println("Invalid Time. \n");
        else if (recordBest == 0) {
            System.out.println(+newTime + " Game Time \n");
            System.out.println("New Record!");
        }
        else if (recordBest < newTime) {
            secondsBehind = (int) (newTime - recordBest);
            System.out.println(+newTime + " Game Time \n");
            System.out.println(+ secondsBehind+ " seconds behind the current record time. \n");
        } 
        else if (recordBest > newTime) {
            secondsAhead = (int) (recordBest - newTime);
            System.out.println(+newTime + " Game Time \n");
            System.out.println("New Record! " +secondsAhead+ " seconds ahead of previous record time. \n");
        }
        else if (recordBest == newTime) {
            System.out.println(+newTime + " Game Time \n");
            System.out.println("Tied Game Record! \n");
        }
        
    }
    
    private void getWinningScore(int gameMove, boolean cards){
        
        int score= (int) (startingPoints)-gameMove;// cast double to int
        if ((cards==true)&&(gameMove==15)){
            System.out.println("you win perfect score!: " +score+" points\n");
        }
        else if  ((cards==true) && (gameMove<115)){
            System.out.println("you win  "+score+" points\n");
        }        
        else if((cards==false) && (gameMove==115)){
            System.out.println("you loose! "+ score+" points\n");
        }
        else if((cards==true) && (gameMove<=0)){
            System.out.println("invalid input\n");
        }
        else if((cards==false) && (gameMove>115)){
            System.out.println("invalid input\n");
        }            
    }
        
        //Michele's Week 6 individual Assignment (collects and totals a players points)
    public void getTotalPoints() {    
        int points[] = {100, 115, 89, 60, 77, 26, 115};
        int sum = 0;
        for(int p : points) {
            System.out.println("\n\tGame Points are: " + p);
            sum += p;
        }
            System.out.println("\n\tTotal Player Points are: " + sum);
        if(points.length < 1) {
            new MemoryGameError().displayError("\n\t It looks like you Haven't "
            + "played yet! Play a game of Memory first to view your statistics");
        }
    }
     
public void calculateFactorial(int number) {
     if (number < 0 || number > 70) {
         System.out.println("Invalid number.");
     }
    if (number < 70 && number > 0) {
         long num = (long) (number);
         long factorial = 1;
         
         for(int i = 1; i < number; i++) {
            if(i == 1) {
                factorial = num * (num - i);
            } else {
                factorial *= num - i;
            }
        }


        System.out.println("The factorial is: " + factorial);
   }

}

    public void calculateHappiness(int totalWins, int totalLosses) {
        if (totalWins == 0 || totalLosses == 0) {
            System.out.println("Insufficient Data.");
    } else if (totalWins > totalLosses) {
        System.out.println("Yay! You're winning more than you're losing, you "
            + "must be happy.\nTotal wins: " + totalWins);
    } else if (totalWins < totalLosses) {
        System.out.println("You're losing more games than you're winning, you "
            + "must be sad.");
    } else if (totalWins == totalLosses) {
        System.out.println("Games won: " + totalWins +"\nTotal Lost: " 
        + totalLosses + "\nIts a tie!");
        }
    }
}
