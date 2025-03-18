module edu.ntnu.idi.idatt.pokerhanddealer {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.ntnu.idi.idatt.pokerhanddealer to javafx.fxml;
  exports edu.ntnu.idi.idatt.pokerhanddealer;
}