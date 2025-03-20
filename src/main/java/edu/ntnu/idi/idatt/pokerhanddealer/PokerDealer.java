package edu.ntnu.idi.idatt.pokerhanddealer;

import edu.ntnu.idi.idatt.pokerhanddealer.data.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PokerDealer {
  private final Stage primaryStage;
  private final BorderPane root = new BorderPane();
  private VBox cardBox = new VBox();
  private final VBox sidebar = new VBox();
  private final VBox information = new VBox();

  private DeckOfCards deck;
  private Hand hand;

  private Label cardsLeftLabel;
  private Label label1;
  private Label label2;
  private Label label3;
  private Label label4;
  private Label label5;

  public PokerDealer(Stage stage) {
    this.primaryStage = stage;
  }

  public void init() {
    deck = new DeckOfCards();
    hand = new Hand();

    // Sidebar buttons
    sidebar.setPrefWidth(200);
    sidebar.setSpacing(10);
    sidebar.setStyle("-fx-background-color: #F2C6DE;");
    sidebar.setAlignment(Pos.CENTER);
    cardsLeftLabel = new Label("Cards Left: " + deck.getDeckSize());
    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");
    Button restockDeckButton = new Button("Restock Deck");
    sidebar.getChildren().addAll(cardsLeftLabel, dealHandButton, checkHandButton, restockDeckButton);

    // Information
    information.setPrefHeight(200);
    information.setSpacing(10);
    information.setStyle("-fx-background-color: #FAEDCB;");
    information.setAlignment(Pos.CENTER);
    label1 = new Label("Sum of the Faces: ");
    label2 = new Label("Cards of Hearts: ");
    label3 = new Label("Flush: ");
    label4 = new Label("Queen of Spades: ");
    label5 = new Label("Best Hand: ");
    information.getChildren().addAll(label1, label2, label3, label4, label5);

    // Set actions for buttons
    dealHandButton.setOnAction(e -> dealHand());
    checkHandButton.setOnAction(e -> checkHand());
    restockDeckButton.setOnAction(e -> restockDeck());

    updateCardView();
    root.setCenter(cardBox);
    root.setLeft(sidebar);
    root.setBottom(information);

    primaryStage.setTitle("PokerHandDealer");
    primaryStage.setResizable(false);
    primaryStage.setWidth(1000);
    primaryStage.setHeight(800);

    Scene scene = new Scene(root);
    try{
      scene.getStylesheets().add(getClass().getResource("/edu/ntnu/idi/idatt/pokerhanddealer/styles.css").toExternalForm());
    } catch (Exception e){
      System.out.println("Could not load stylesheet");
    }
    primaryStage.setScene(scene);
  }

  public void show() {
    primaryStage.show();
  }

  private void dealHand() {
    hand.setPokerHand(deck.drawFullHand());
    updateCardView();
  }

  private void restockDeck() {
    deck.restockDeck();
    hand.clearHand();
    updateCardView();
  }

  private void checkHand() {
    label1.setText("Sum of the Faces: " + hand.sumOfRanks());
    String hearts = hand.getHearts();
    label2.setText("Cards of Hearts: " + (hearts.isEmpty() ? "No Hearts" : hearts));
    label3.setText("Flush: " + (hand.isFlushFive() ? "Yes" : "No"));
    label4.setText("Queen of Spades: " + (hand.containsQueenOfSpades() ? "Yes" : "No"));
    label5.setText("Best Hand: " + hand.checkHand());
  }

  private void updateCardView() {
    CardView cardView = new CardView();
    cardsLeftLabel.setText("Cards Left: " + deck.getDeckSize());
    this.cardBox = cardView.createCardView(hand.getPokerHand());
    root.setCenter(cardBox);
    cardBox.setAlignment(Pos.CENTER);
    BorderPane.setAlignment(cardBox, Pos.CENTER);
  }
}