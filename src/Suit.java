/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author pukhr
 */
public enum Suit{

HEARTS(" Hearts"),
SPADES(" Spades"),
DIAMONDS(" Diamonds"),
CLUBS(" Clubs");

private final String suitText;

private Suit(String suitText){
    this.suitText = suitText;
}

public String PrintSuitText(){
    return suitText;
}
}
