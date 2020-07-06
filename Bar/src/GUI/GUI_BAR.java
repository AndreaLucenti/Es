package GUI;

import Classi.Bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_BAR {
    private JButton MENUButton = new JButton("Menu");
    private JButton EVENTIButton = new JButton("Eventi");
    private JPanel panelB = new JPanel(new GridLayout(3,1));
    private JFrame frame;
    private Bar br;
    private JLabel id = new JLabel();
    private JList ListEv = new JList();
    private JButton ADDEVENTSButton = new JButton("ADD EVENTO");
    private JButton ADDBEVANDAButton = new JButton("ADD BEVANDA");
    private JList ListBev = new JList();


    public GUI_BAR(JFrame frame, Bar br) {

        panelB.add(id);
        panelB.add(MENUButton);
        panelB.add(EVENTIButton);

        this.br = br;
        this.frame = frame;
        id.setText("" + br.getNome());

        MENUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenu();
            }
        });
        EVENTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEV();
            }
        });
    }

    public void OpenBar() {
        frame.setContentPane(panelB);

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = tk.getScreenSize().width / 2;
        int ySize = tk.getScreenSize().height / 2;
        panelB.setSize(xSize, ySize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setEV() {
        JPanel panelE = new JPanel(new GridLayout(3,1));
        panelE.add(id);
        panelE.add(ListEv);
        panelE.add(ADDEVENTSButton);

        frame.setContentPane(panelE);
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < br.getEventi().size(); i++) {
            listModel.add(i, br.getEventi().get(i).toString());
        }
        ListEv.setModel(listModel);

        ADDEVENTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO COLLEGAMENTO
            }
        });

    }

    public void setMenu(){
        JPanel panelM = new JPanel(new GridLayout(3,1));
        frame.setContentPane(panelM);
        panelM.add(id);
        panelM.add(ListBev);
        panelM.add(ADDBEVANDAButton);

        DefaultListModel listModel = new DefaultListModel();
        for(int i = 0; i < br.getMenu().getBevande().size(); i++){
            listModel.add(i, br.getMenu().getBevande().get(i).toString());}
        ListBev.setModel(listModel);
        ADDBEVANDAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_AddBev gui_addBev = new GUI_AddBev(frame, br);
                gui_addBev.OpenBev();
            }
        });

    }
}