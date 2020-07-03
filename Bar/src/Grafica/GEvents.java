package Grafica;

import Classi.Bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.*;

public class GEvents {
    private JPanel panel1;
    private  JFrame frame;
    private JList list1;
    private JLabel Label1;
    private JButton ADDEVENTSButton;
    private Bar bar;

    public GEvents(JFrame frame, Classi.Bar bar){
        this.bar = bar;
        this.frame = frame;
        Label1.setText(""+bar.getNome());
        ADDEVENTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void setEV(){
        DefaultListModel listModel = new DefaultListModel();
        for(int i = 0; i < bar.getEventi().size(); i++){
            listModel.add(i, bar.getEventi().get(i).toString());}
        list1.setModel(listModel);

    }

    public void OpenEV(){
        frame.setContentPane(panel1);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = tk.getScreenSize().width/2;
        int ySize = tk.getScreenSize().height/2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        setEV();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
