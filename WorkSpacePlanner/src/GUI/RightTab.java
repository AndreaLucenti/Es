package GUI;


import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class RightTab extends GridPane {
    public RightTab() {


        //this.setGridLinesVisible(true);
        this.setStyle("-fx-grid-lines-visible: true");
        this.getRowConstraints();


        for(int i = 0; i <50; i++){
            for(int j = 0; j < 50; j++){
            Label label = new Label("HELLO");
            this.add(label, i, j);
            }
        }
    }

}
