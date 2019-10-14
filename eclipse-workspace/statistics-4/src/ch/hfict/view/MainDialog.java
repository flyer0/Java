package ch.hfict.view;

import java.io.BufferedReader;
import java.io.StringReader;

import ch.hfict.math.Statistics;
import ch.hfict.math.StatisticsImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainDialog extends Application{

    Statistics statistics = new StatisticsImpl();

      public void start(Stage stage) throws Exception {
        BufferedReader in = new BufferedReader(new StringReader("1 2 3"));
        statistics.read(in);
        TextField txt_1 = new TextField();
        Button calc_btn = new Button("Calculate");
        calc_btn.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                txt_1.setText(Double.toString(statistics.getAverange()));
        }});
        
        
        
        
        txt_1.setPrefColumnCount(10); // Textfeld soll 10 sein. Jedoch Layoutmanager ändert das Label
        txt_1.setText("Hello");
        
        StackPane root = new StackPane();
        root.getChildren().add(txt_1);
        root.getChildren().add(calc_btn);

        stage.setScene(new Scene(root, 300, 150));
        stage.setTitle("Statistic Calculation");
        stage.show();
      }
      public static void main(String[] args) {
          launch(args); 
        }
    

}
