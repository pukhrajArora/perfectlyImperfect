/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pukhraj
 */
import java.util.Scanner;
public class BlackJack {

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    boolean stay = false;

    System.out.println("What nickName would you like to have?");
    String pAnswer = scanner.nextLine();
    Player me = new Player(pAnswer);
    Player dealer = new Player("Dealer");


    System.out.println("Would you like to start a new game?  'Yes/No' :");
    pAnswer = scanner.nextLine();

    if (pAnswer.equalsIgnoreCase("Yes")) {

        DeckOfCard deck1 = new DeckOfCard();
        Card card1 = new Card(Face.ACE, Suit.CLUBS);
        deck1.shuffleDeck();
        me.addCard(deck1.dealNextCard());
        me.addCard(deck1.dealNextCard());
        me.getPlayerHand(true);
        System.out.println(" ");
        dealer.addCard(deck1.dealNextCard());
        dealer.addCard(deck1.dealNextCard());
        dealer.getPlayerHand(false);

        //PLAYER
        do {
            System.out.println("Would " + me.getNickName() + " like to bust or stay? 'Bust/Stay'");
            pAnswer = scanner.nextLine();
            //BUST
            if (pAnswer.equalsIgnoreCase("Bust")) {
                me.addCard(deck1.dealNextCard());
                System.out.println(me.getHandSum());
                if (me.getHandSum() > 21) {
                    System.out.println("You busted and got a total of " + me.getHandSum() + ". Dealer wins this time! ");
                    System.exit(0);
                }
            }
            //STAY
            if (pAnswer.equalsIgnoreCase("stay")) {
                System.out.println("You have chosen to stay. Your hand: " + me.getHandSum());
            }

        } while (pAnswer.equalsIgnoreCase("Bust"));

        //DEALER
        stay = false;

        do {
            System.out.println("");
            System.out.println("- Dealers turn -");
            //DRAW CARD
            if (dealer.getHandSum() <= 15) {
                dealer.addCard(deck1.dealNextCard());
                if(dealer.getHandSum() == 15){
                    System.out.println("Blackjack! Dealer won.");
                    System.exit(0);
                }
                if (dealer.getHandSum() > 21) {
                    System.out.println("Dealer busted and got a total of " + dealer.getHandSum() + ". " + me.getNickName() + " wins this time!");
                    System.exit(0);
                }
            } else {
                System.out.println("Dealer has chosen to stay!");
                int totalDealerSum = dealer.getHandSum();
                int totalPlayerSum = me.getHandSum();

                if(totalDealerSum > totalPlayerSum){
                    System.out.println("Both players has decided to stay. The winner is " + dealer.getNickName() + " with a total of " +  totalDealerSum + ".");
                } else {
                    System.out.println("Both players has decided to stay. The winner is " + me.getNickName() + " with a total of " + totalPlayerSum + ".");
                }
                stay = false;
            }

        } while (stay);
    }
}
}
