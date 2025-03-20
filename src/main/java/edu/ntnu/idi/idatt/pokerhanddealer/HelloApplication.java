package edu.ntnu.idi.idatt.pokerhanddealer;


import javafx.application.Application;
import javafx.stage.Stage;


public class HelloApplication extends Application {

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws Exception {
    PokerDealer pokerDealer = new PokerDealer(stage);
    pokerDealer.init();
    pokerDealer.show();
  }


}