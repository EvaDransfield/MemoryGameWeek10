/* This class creates the card board array mentioned in the CardDeck class
*  I'm not sure what else it will need to do.
*/
package gamecreator;

import java.io.Serializable;

/**
 * @author Cope-Michele
 */

public class CardView implements Serializable{
    
    public boolean matched; // tells whether or not a card is matched
    public String back; // the hiden symbol at the back of the card
    private boolean showing;// true or false if the hidden card is showing
    private int front; //The font of the card 
    //private String symbol;
    public CardView() {
        
    }
    // constractor 
    public CardView(String theBack, int theFront) {
        showing = false; // showing refers to the back of the cards matching symbol
        matched = false;
        back = theBack;
        front = theFront;
    }

    public boolean isShowing() {
        return showing;
    }

    public void setShowing(boolean showing) {
        this.showing = showing;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }
    
    public void showCard(){
        if (showing)
        System.out.print(String.format("\t%10s","["+back+"]"));
    else
        System.out.print(String.format("\t%10s","["+front+"]"));
    }
    
    public void setShowingStatus(){// this method flips the card from showing to not showing
        if (showing)
        showing=false;
    else 
        showing = true;
    }
}