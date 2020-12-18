package GUI;

import SetRoom.Room;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class GUIFX extends Application {
    private Room room = new Room();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double width = screenSize.getWidth() / 2;
            double height = screenSize.getHeight() / 2;

            BorderPane root = new BorderPane(); // the root is Group or Pane
            root.setStyle("-fx-background-color: #000000");

            LeftTab leftTab = new LeftTab(room);
            leftTab.setPrefSize(width / 3, height / 3);

            //TODO CREARE CLASS
            BorderPane view = new BorderPane();
            view.setPrefSize(width, height);
            view.setStyle("-fx-background-color: aliceblue");

            TopTab topbar = new TopTab();

            root.setLeft(leftTab);
            root.setCenter(view);
            root.setTop(topbar);

        Scene scene = new Scene(root, width, height, Color.DARKGRAY);
        primaryStage.setTitle("WSP Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
        });



    }
}
