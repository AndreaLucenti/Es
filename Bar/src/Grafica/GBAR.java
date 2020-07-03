package Grafica;

import Classi.Bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GBAR {
    private JButton MENUButton;
    private JButton EVENTIButton;
    private JPanel panelB;
    private JFrame frame;
    private Bar br;
    private JLabel Label1;

    public GBAR(JFrame frame, Bar br) {
        this.br = br;
        this.frame = frame;
        Label1.setText(""+br.getNome());

        MENUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GMenu gMenu = new GMenu(frame, br);
                gMenu.OpenMenu();
            }
        });
        EVENTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GEvents gEvents = new GEvents(frame, br);
                gEvents.OpenEV();
            }
        });
    }

    public void OpenBar(){
        frame.setContentPane(panelB);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = tk.getScreenSize().width/2;
        int ySize = tk.getScreenSize().height/2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}