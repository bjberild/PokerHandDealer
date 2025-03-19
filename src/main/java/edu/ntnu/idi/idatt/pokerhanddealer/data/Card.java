package edu.ntnu.idi.idatt.pokerhanddealer.data;

/*
 * Class representing a card in a deck of cards.
 * The card has a suit, a rank and a string representation.
 *
 * The suit is an integer from 0 to 3, where 0 is spades, 1 is hearts, 2 is diamonds and 3 is clubs.
 * The rank is an integer from 0 to 12, where 0 is an ace, 1 is a 2, 2 is a 3, ...,
 * 9 is a 10, 10 is a jack, 11 is a queen and 12 is a king.
 */
public class Card {

  private final int suit;
  private final int rank;
  private final String cardString;


  public Card(int suit, int rank, String cardName) {
    this.suit = suit;
    this.rank = rank;
    this.cardString = cardName;
  }

  public int getRank() {
    return rank;
  }

  public int getSuit() {
    return suit;
  }

  public String getCardString() {
    return cardString;
  }

  @Override
  public String toString() {

    return "\nsuit: " + suit + "\nank: " + rank + "\nString: " + cardString;
  }
}
