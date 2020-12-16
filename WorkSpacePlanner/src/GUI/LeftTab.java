package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.awt.*;

public class LeftTab extends BorderPane {
    private Dimension screensize;

    public LeftTab() {
        this.screensize = Toolkit.getDefaultToolkit().getScreenSize() ;
        this.setStyle("-fx-background-color: chartreuse");

        this.setVisible(true);
//
//        Button ut = new Button("Utilizzo");
//       ut.setStyle("-fx-background-color: blueviolet");
//       ut.setPrefSize(16*screensize.width/100,screensize.height/9);
//        ut.setOnAction(event ->{
//
//       });
//       this.setTop(ut);
    }
}
