

/**
 *
 * @author Lenovo
 */
public class Card {

private Face face; //Face of card, i.e "King" & "Queen"
private Suit suit; //Suit of card, i.e "Hearts" & "diamonds"
int total = 0;

public Card (Face cardFace, Suit cardSuit){ //Constructor which initializes card's face and suit
    this.face = cardFace;
    this.suit = cardSuit;
}

public int getFace(){
     return face.getFaceValue();
}

public String getSuit(){
    return suit.PrintSuitText();
}

@Override
public String toString(){ //return String representation of Card
    return face + " of " + suit;
}
}
