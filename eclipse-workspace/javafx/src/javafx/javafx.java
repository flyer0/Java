package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class javafx extends Application {

  public void start(Stage stage) throws Exception {
    Label msg_lbl = new Label("Hello JavaFX");
    StackPane root = new StackPane();
    root.getChildren().add(msg_lbl);

    stage.setScene(new Scene(root, 300, 150));
    stage.setTitle("Hello JavaFX");
    stage.show();
  }
  public static void main(String[] args) {
      launch(args);
    }
}
