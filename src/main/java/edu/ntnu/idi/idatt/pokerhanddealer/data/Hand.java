package edu.ntnu.idi.idatt.pokerhanddealer.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Hand {
  ArrayList<Card> hand;

  public Hand() {
    hand = new ArrayList<>();
  }

  public void addCard(Card card) {
    hand.add(card);
  }

  public ArrayList<Card> getHand() {
    return hand;
  }

  public void setHand(ArrayList<Card> hand) {
    this.hand = hand;
  }

  public void clearHand() {
    hand.clear();
  }

  public String checkHand() {
    if (isRoyalFlush()) return "Royal Flush";
    if (isStraightFlush()) return "Straight Flush";
    if (isFourOfAKind()) return "Four of a Kind";
    if (isFullHouse()) return "Full House";
    if (isFlush()) return "Flush";
    if (isStraight()) return "Straight";
    if (isThreeOfAKind()) return "Three of a Kind";
    if (isTwoPair()) return "Two Pair";
    if (isOnePair()) return "One Pair";
    return "High Card";
  }

  private boolean isRoyalFlush() {
    return isStraightFlush() && hand.stream().anyMatch(card -> card.getRank() == 12);
  }

  private boolean isStraightFlush() {
    return isFlush() && isStraight();
  }

  private boolean isFourOfAKind() {
    return hasNOfAKind(4);
  }

  private boolean isFullHouse() {
    return hasNOfAKind(3) && hasNOfAKind(2);
  }

  private boolean isFlush() {
    return hand.stream().allMatch(card -> card.getSuit() == hand.getFirst().getSuit());
  }

  private boolean isStraight() {
    ArrayList<Integer> ranks = new ArrayList<>();
    for (Card card : hand) {
      ranks.add(card.getRank());
    }
    Collections.sort(ranks);
    for (int i = 0; i < ranks.size() - 1; i++) {
      if (ranks.get(i) + 1 != ranks.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  private boolean isThreeOfAKind() {
    return hasNOfAKind(3);
  }

  private boolean isTwoPair() {
    Map<Integer, Integer> rankCount = new HashMap<>();
    for (Card card : hand) {
      rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
    }
    int pairCount = 0;
    for (int count : rankCount.values()) {
      if (count == 2) {
        pairCount++;
      }
    }
    return pairCount == 2;
  }

  private boolean isOnePair() {
    return hasNOfAKind(2);
  }

  private boolean hasNOfAKind(int n) {
    Map<Integer, Integer> rankCount = new HashMap<>();
    for (Card card : hand) {
      rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
    }
    return rankCount.values().stream().anyMatch(count -> count == n);
  }
}