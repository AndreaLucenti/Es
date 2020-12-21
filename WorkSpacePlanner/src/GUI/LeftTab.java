package GUI;

import Arredamento.Mobili;
import Gestione.AllMob;
import SetRoom.Room;
import SetRoom.SalaRiunioni;
import SetRoom.UfficioSingolo;
import SetRoom.Utilizzo;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class LeftTab extends BorderPane {
    private Dimension screensize;
    private AllMob allMob = new AllMob();
    private ArrayList<Mobili> mobili = new ArrayList<Mobili>();
    private Room room;
    private Utilizzo utilizzo;
    private PopUp popUp;
    private Stage primaryStage;

    public LeftTab(Room room, Stage primaryStage) {
        this.room = room;
        this.primaryStage = primaryStage;
        this.screensize = Toolkit.getDefaultToolkit().getScreenSize() ;
        this.setStyle("-fx-background-color: slategray");
        this.setPrefSize((screensize.width/2)/3, (screensize.height/2)/3);

        this.setVisible(true);

        TilePane tilepane = new TilePane();
        tilepane.setPrefSize(this.getPrefWidth() ,screensize.height);
        tilepane.setStyle("-fx-background-color: slategray");

        MenuButton ut = new MenuButton();
        ut.setText("Utilizzo");
        ut.setStyle("-fx-background-color: #ffffff");
        ut.setPrefSize(tilepane.getPrefWidth(),screensize.height/100);
        ut.setOnAction(event ->{
        });

        MenuButton mob = new MenuButton();
        mob.setText("Mobili");
        mob.setStyle("-fx-background-color: #ffffff");
        mob.setPrefSize(tilepane.getPrefWidth(),screensize.height/100);
        mob.setOnAction(event -> {
        });

        MenuButton ev = new MenuButton();
        ev.setText("Vincoli");
        ev.setStyle("-fx-background-color: #ffffff;");
        ev.setPrefSize(tilepane.getPrefWidth(),screensize.height/100);
        ev.setOnAction(event -> {
        });



        tilepane.setVgap(10);
        tilepane.getChildren().addAll(ut,mob,ev);
        tilepane.setOrientation(Orientation.VERTICAL);

        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setPrefHeight((screensize.height)-40);

        this.setLeft(tilepane);
        this.setRight(scrollBar);

        setMob(mob);
        setUt(ut);



        //ScrollPane scrollPane = new ScrollPane();
        //this.getChildren().add(scrollPane);
    }

    public void setMob( MenuButton mob){

        mobili = allMob.getMobili();
        for(int i = 0; i< mobili.size();i++){
            MenuItem menuIt = new MenuItem(mobili.get(i).toString());
            mob.getItems().add(menuIt);
        }
        for(int j = 0; j < mobili.size(); j++) {
            int index =  mob.getItems().indexOf(mob.getItems().get(j));
            mob.getItems().get(j).setOnAction(event -> {
                room.setMob(mobili.get(index)) ;
                System.out.println(room.getMobili());
            });
        }

    }

    public void setUt(MenuButton ut){

        MenuItem SalaR = new MenuItem("Sala Riunioni");
        MenuItem UffS = new MenuItem("Ufficio Singolo");

        ut.getItems().addAll(SalaR,UffS);

        SalaR.setOnAction(event -> {
            popUp = new PopUp(room);
            utilizzo = new SalaRiunioni();
            room.setUtilizzo(utilizzo);
            popUp.popUtil();
            popUp.getPopup().show(primaryStage);
        });

        UffS.setOnAction(event -> {
            popUp = new PopUp(room);
            utilizzo = new UfficioSingolo();
            room.setUtilizzo(utilizzo);
            popUp.popUtil();
            popUp.getPopup().show(primaryStage);
        });

    }

}
