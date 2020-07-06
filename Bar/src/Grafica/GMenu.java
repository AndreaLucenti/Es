package Grafica;

import Bevande.Bevanda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GMenu {
    private JList list1;
    private JPanel panel1;
    private JLabel Label1;
    private JButton ADDBEVANDAButton;
    private  JFrame frame;
    private Classi.Menu menu;
    private ArrayList<Bevanda> bevande;

    public GMenu(JFrame frame, Classi.Bar bar){
        this.frame = frame;
        this.menu = bar.getMenu();
        Label1.setText(bar.getNome());
        ADDBEVANDAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GAddBev gAddBev = new GAddBev(frame, bar);
                gAddBev.OpenBev();
            }
        });
    }

    public void SetList(){
       bevande = menu.getBevande();
       DefaultListModel listModel = new DefaultListModel();
       for(int i = 0; i < bevande.size(); i++){
       listModel.add(i, bevande.get(i).toString());}
       list1.setModel(listModel);

    }

    public void OpenMenu(){
        frame.setContentPane(panel1);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = tk.getScreenSize().width/2;
        int ySize = tk.getScreenSize().height/2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        SetList();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
