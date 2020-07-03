package Grafica;

import Classi.Bar;
import Classi.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GNewB {
    private JTextField Nome;
    private JTextField Ubicazione;
    private JTextField ID;
    private JTextField Password;
    private JButton OKButton;
    private JPanel panel1;
    private JFrame frame;
    private Utente utente;

    public GNewB(JFrame frame, Utente utente) {
        this.frame = frame;
        this.utente = utente;
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckInfo();
            }
        });
    }

    public void openNewB(){
            frame.setContentPane(panel1);
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = tk.getScreenSize().width/2;
            int ySize = tk.getScreenSize().height/2;
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(xSize, ySize);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }

    public void CheckInfo(){
        if(Nome.getText() != null && Ubicazione.getText() != null && ID.getText() != null && Password.getText() != null ){
            utente.newBar(Nome.getText(), Ubicazione.getText(), ID.getText(), Password.getText());        }
        Bar bar = new Bar(Nome.getText(), Ubicazione.getText(), ID.getText(), Password.getText());
        GBAR gbar = new GBAR(frame,bar);
        gbar.OpenBar();
    }
}
