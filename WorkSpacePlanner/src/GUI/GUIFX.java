package GUI;

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




//        BorderPane setting = new BorderPane();
//        setting.setPrefSize(width/4, height/3);
//        setting.setStyle("-fx-background-color: chartreuse");

            LeftTab leftTab = new LeftTab();
            leftTab.setPrefSize(width / 3, height / 3);

            BorderPane view = new BorderPane();
            view.setPrefSize(width, height);
            view.setStyle("-fx-background-color: aliceblue");

            BorderPane topbar = new BorderPane();
            topbar.setPrefSize(width, 40);
            topbar.setStyle("-fx-background-color: blue");

        Button ut = new Button("OOOOOOOH");


        leftTab.setTop(ut);
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
