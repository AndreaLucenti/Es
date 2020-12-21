package GUI;

import SetRoom.Room;
import SetRoom.Utilizzo;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PopUp {
    Popup popup = new Popup();
    GridPane gridPane = new GridPane();
    Room room;
    Utilizzo utilizzo;

    public PopUp(Room room) {
        this.room = room;
    }

    //TODO METTERE A POSTO IL VBOX
    public void popUtil(){

        gridPane.setStyle("-fx-border-color: black");
        gridPane.setStyle("-fx-background-color: rgba(118,133,147,0.27)");


        Label label = new Label("Importare Preset ?");
        Button yes = new Button("SI");
        Button no = new Button("NO");

        gridPane.addRow(0,label);
        gridPane.add(yes,0,1);
        gridPane.add(no,1,1);

        popup.getContent().add(gridPane);

        yes.setOnAction(event ->{
            room.addPreSet();
            closePopup();
        });

        no.setOnAction(event -> {
            closePopup();
        });

    }

    public void closePopup(){
        this.popup.hide();
    }
    public Popup getPopup() {
        return popup;
    }
}
