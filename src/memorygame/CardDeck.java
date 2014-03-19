/* We should use this class to create an array that creates the cards and board for
*  a game based on what size the player wants to play, Small, Medium, or Large.
*  So it will need to ask input for Small, Medium, or Large, and then create that
*  size of array of cards that will be used in the game.
*/

package memorygame;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * @author michelewhite
 */

public class CardDeck extends CardView implements Serializable{
    
    private Array cards;
    private int numberOfCards = 30;
   
    public CardDeck() {
        
    }
    
    public CardDeck(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    /**
     * @return the cards
     */
    public Array getCards() {
        return cards;
    }

    /**
     * @return the numberOfCards
     */
    public int getNumberOfCards() {
        return numberOfCards;
    }

    /**
     * @param numberOfCards the numberOfCards to set
     */
    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }
    
    //not sure if this function will need to be created or if it is covered in another function.
    public void boardSize(){
  
    int easy [][];
    easy = new int[3][3];//board that holds 9 cards
    
    int medium[][];
    medium= new int [3][4];//board that holds 12 cards
    
    int large [][];
    large= new int [4][4];//board that holds 16 cards
    
    }
}
