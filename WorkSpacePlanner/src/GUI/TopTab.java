package GUI;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

import java.awt.*;

public class TopTab extends BorderPane{
    private Dimension screensize;
    public TopTab() {
        this.screensize = Toolkit.getDefaultToolkit().getScreenSize() ;
       // this.setStyle("-fx-background-color: darkgoldenrod");
        this.setPrefSize((screensize.width), 20);

        MenuBar menuBar = new MenuBar();
        menuBar.setPrefSize(screensize.width, 20);
        menuBar.setStyle("-fx-background-color: slategray");

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        menuBar.getMenus().add(file);
        menuBar.getMenus().add(edit);
        menuBar.getMenus().add(help);

        this.setLeft(menuBar);
    }



}
