package Grafica;

import Bevande.Analcolico;
import Bevande.Bevanda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GAddBev {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton salvaButton;
    private JCheckBox birraCheckBox;
    private JCheckBox drinkCheckBox;
    private JCheckBox analcolicoCheckBox;
    private JCheckBox bibitaCheckBox;
    private JPanel panel1;
    private JFrame frame = new JFrame();
    private Bevanda bevanda;
    private Classi.Menu menu;
    private String type;
    private int i = 0;

    public GAddBev(JFrame frame, Classi.Menu menu) {
        this.frame = frame;
        this.menu = menu;
        salvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllo();
            }
        });
        birraCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        drinkCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        analcolicoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bibitaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void Controllo(){
        if(textField1 != null && textField2 != null && i > 2){
            operazione();
        }
        else if(textField1 != null && textField2 != null && i < 2 && textField3 != null){
            operazione();
        }
        else{
            JOptionPane.showMessageDialog(null,"Compilare tutti i campi");
        }

    }



    public void operazione(){
        if (i == 1){
            //TODO passare dati textfield, creare bevanda, unire textf, e menu.add
        }
    }

    public void OpenBev(){
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
}
