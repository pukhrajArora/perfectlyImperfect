/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pukhr
 */
import java.util.Random;
public class DeckOfCard {

private Card[] deck;
private static final Random random = new Random();

private int currentCard; //index of next Card to be deal (0-51)
private static int NUMBER_OF_CARDS = 52; //Constant number of cards

public DeckOfCard(){

    Face [] faces = {Face.ACE, Face.DEUCE, Face.THREE, Face.FOUR, Face.FIVE, Face.SIX,
                     Face.SEVEN, Face.EIGHT, Face.NINE, Face.TEN, Face.JACK, Face.QUEEN,
                     Face.KING};
    Suit[] suits = {Suit.HEARTS, Suit.SPADES, Suit.DIAMONDS, Suit.CLUBS};

    deck = new Card [NUMBER_OF_CARDS]; // create array with Cards (52)
    currentCard = 0;

    //Populate deck with Cards
    for(int count = 0; count < deck.length; count++)
        deck [count] = new Card(faces [count % 13], suits [count / 13]);
}

public void shuffleDeck(){
    currentCard = 0;

    for (int first = 0; first < deck.length; first++){

        int second = random.nextInt(NUMBER_OF_CARDS); //Select a random card from number 0-51 (Number_of_cards)

        //Loops through all the cards and swaps it with the "Second" card which is randomly chosen card from hte same list.
        Card temp = deck[first];
        deck [first] = deck [second];
        deck [second] = temp;
    }
}

public void getCardDeck(){
    int start = 1;
    for(Card k : deck) {
        System.out.println("" + start + "/52 " + k);
        start++;
    }
}

public Card dealNextCard(){

    //Get the top card
    Card topCard = this.deck[0];

    //shift all the subsequent cards to the left by one index
    for(int currentCard = 1; currentCard < NUMBER_OF_CARDS; currentCard ++){
        this.deck[currentCard-1] = this.deck[currentCard];
    }
    this.deck[NUMBER_OF_CARDS-1] = null;

    //decrement the number of cards in our deck
    this.NUMBER_OF_CARDS--;

    return topCard;
}
}
