package edu.ntnu.idi.idatt.pokerhanddealer;

import edu.ntnu.idi.idatt.pokerhanddealer.data.Card;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.List;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CardView {
  public VBox createCardView(List<Card> cards) {
    HBox cardsDisplay = new HBox();
    cardsDisplay.setSpacing(10);
    HBox.setHgrow(cardsDisplay, Priority.ALWAYS);
    cardsDisplay.setAlignment(Pos.CENTER);
    VBox cardBox = new VBox();

    for (Card card : cards) {
      Label cardLabel = new Label(card.getCardString());
      cardLabel.getStyleClass().add("card");

      switch (card.getSuit()) {
        case 0:
          cardLabel.getStyleClass().add("spades");
          break;
        case 1:
          cardLabel.getStyleClass().add("hearts");
          break;
        case 2:
          cardLabel.getStyleClass().add("diamonds");
          break;
        case 3:
          cardLabel.getStyleClass().add("clubs");
          break;
      }

      cardsDisplay.getChildren().add(cardLabel);
    }
    cardBox.getChildren().add(cardsDisplay);
    VBox.setVgrow(cardBox, Priority.ALWAYS);
    return cardBox;
  }
}