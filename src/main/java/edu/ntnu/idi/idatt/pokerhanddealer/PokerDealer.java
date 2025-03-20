package edu.ntnu.idi.idatt.pokerhanddealer;

import edu.ntnu.idi.idatt.pokerhanddealer.data.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PokerDealer {
  private final Stage primaryStage;
  private final BorderPane root = new BorderPane();
  private final VBox cardView = new VBox();
  private final VBox sidebar = new VBox();

  private DeckOfCards deck;
  private Hand hand;

  public PokerDealer(Stage stage) {
    this.primaryStage = stage;
  }

  public void init() {
    deck = new DeckOfCards();
    hand = new Hand();


    root.setCenter(cardView);
    root.setLeft(sidebar);

    cardView.setStyle("-fx-background-color: #444444");
    sidebar.setStyle("-fx-background-color: #111111");

    primaryStage.setTitle("PokerHandDealer");
    primaryStage.setResizable(false);
    primaryStage.setWidth(1000);
    primaryStage.setHeight(800);
    primaryStage.show();
  }

  public void show() {
    primaryStage.show();
  }

}
