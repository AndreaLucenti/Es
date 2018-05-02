import javax.swing.*;
import java.awt.*;

public class FrameSett extends JFrame {
    public FrameSett(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width/2,screenSize.height/2);
        setLocation(screenSize.width/4,screenSize.height/4);
        setTitle("Prova");
        Bottoni b = new Bottoni();
        add(b);
        pack();




    }
}
