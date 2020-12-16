package GUI;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group(); // the root is Group or Pane
        Scene scene = new Scene(root, 500, 500, Color.DARKGRAY);
        primaryStage.setTitle("WSP Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
