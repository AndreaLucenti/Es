package GUI;

import Classi.Bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_BAR {
    private JButton MENUButton = new JButton("Menu");
    private JButton EVENTIButton = new JButton("Eventi");
    private JPanel panel = new JPanel();
    private JPanel panelB = new JPanel(new GridLayout());
    private JPanel panelBu = new JPanel(new GridLayout(1, 2));
    private JFrame frame;
    private Bar br;
    private JLabel id = new JLabel();
    private JList ListEv = new JList();
    private JButton ADDEVENTSButton = new JButton("ADD EVENTO");
    private JButton ADDBEVANDAButton = new JButton("ADD BEVANDA");
    private JList ListBev = new JList();


    public GUI_BAR(JFrame frame, Bar br) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelB.add(id);
        panelB.setMaximumSize(new Dimension(200,200));
        panel.add(panelB);
        panelBu.add(MENUButton);
        panelBu.add(EVENTIButton);
        panelBu.setMaximumSize(new Dimension(300,100));
        panel.add(panelBu);

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
        frame.setContentPane(panel);

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
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panelE = new JPanel(new GridLayout(2,1));
        panelE.setMaximumSize(new Dimension(300,300));
        JPanel panelAdd = new JPanel();
        panelAdd.setMaximumSize(new Dimension(300,150));

        frame.setContentPane(panel);
        panel.add(panelE);
        panelE.add(id);
        panelE.add(ListEv);
        panel.add(panelAdd);
        panelAdd.add(ADDEVENTSButton);

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < br.getEventi().size(); i++) {
            listModel.add(i, br.getEventi().get(i).toString());
        }
        ListEv.setModel(listModel);

        ADDEVENTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              GUI_AddEv addEv = new GUI_AddEv(frame, br);
               addEv.AddEv();
            }
        });

    }

    public void setMenu(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panelM = new JPanel(new GridLayout(2,1));
        panelM.setMaximumSize(new Dimension(300,300));
        JPanel panelAdd = new JPanel();
        panelAdd.setMaximumSize(new Dimension(300,150));

        frame.setContentPane(panel);
        panel.add(panelM);
        panel.add(panelAdd);
        panelM.add(id);
        panelM.add(ListBev);
        panel.add(panelAdd);
        panelAdd.add(ADDBEVANDAButton);

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