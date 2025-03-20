package edu.ntnu.idi.idatt.pokerhanddealer.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

  private ArrayList<Card> deck = new ArrayList<>();
  private static final Random random = new Random();

  public DeckOfCards() {
    restockDeck();
  }

  public Card drawCard() {
    int index = random.nextInt(deck.size());
    return deck.remove(index);
  }

  public void clearDeck() {
    deck.clear();
  }

  public void restockDeck() {
    if (!deck.isEmpty()) {
      clearDeck();
    }

    String[] suits = {"♠", "♥", "♦", "♣"};
    String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    for (int i = 0; i < suits.length; i++) {
      for (int j = 0; j < faces.length; j++) {
        deck.add(new Card(i, j, suits[i] + faces[j]));
      }
    }
  }

  public ArrayList<Card> drawFullHand() {
    if (deck.isEmpty()) {
      return new ArrayList<>();
    } else if (deck.size() < 5) {
      ArrayList<Card> hand = new ArrayList<>();
      for (int i = 0; i < getDeckSize()+1; i++) {
        hand.add(drawCard());
      }
      return hand;
    } else {
      ArrayList<Card> hand = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        hand.add(drawCard());
      }
      return hand;
    }
  }

  public int getDeckSize() {
    return deck.size();
  }
}
