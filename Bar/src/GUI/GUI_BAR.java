package GUI;

import Bevande.Bevanda;
import Bevande.Birra;
import Classi.Bar;
import Classi.Evento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
    private JButton REMEVENTOButton = new JButton("REM EVENTO");
    private JButton REMBEVANDAButton = new JButton("REM BEVANDA");


    public GUI_BAR(JFrame frame, Bar br) {


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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelB.add(id);
        panelB.setMaximumSize(new Dimension(200,200));
        panel.add(panelB);
        panelBu.add(MENUButton);
        panelBu.add(EVENTIButton);
        panelBu.setMaximumSize(new Dimension(300,100));
        panel.add(panelBu);
        setFrame();
    }

    public void setEV() {
        panel = new JPanel();
        String column[] = {"DATA", "DESCRIZIONE"};
        String data[][] = new String[br.getEventi().size()][2];

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panelE = new JPanel(new GridLayout(2,1));
        panelE.setMaximumSize(new Dimension(300,300));
        JPanel panelAdd = new JPanel(new GridLayout(1,2));
        panelAdd.setMaximumSize(new Dimension(300,50));
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(panelE);
        panelE.add(id);
        panelE.add(scrollPane);
        panel.add(panelAdd);
        panelAdd.add(ADDEVENTSButton);
        panelAdd.add(REMEVENTOButton);
        setFrame();

        for(int i = 0; i < br.getEventi().size(); i++){
            data[i][0] = br.getEventi().get(i).getData();
            data[i][1] = br.getEventi().get(i).getDescrizioneEvento();
        }
//
//        DefaultListModel listModel = new DefaultListModel();
//        for (int i = 0; i < br.getEventi().size(); i++) {
//            listModel.add(i, br.getEventi().get(i).toString());
//        }
//        ListEv.setModel(listModel);

        ADDEVENTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              GUI_AddEv addEv = new GUI_AddEv(frame, br);
               addEv.AddEv();
            }
        });

        REMEVENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ListEv.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null,"PLEASE SELECT EVENT");
                }else {
                    Evento evento1 = br.getEventi().get(table.getSelectedRow());
                    br.remEventi(evento1);
                    setEV();
                }

            }
        });

    }

    public void setMenu(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panelM = new JPanel(new GridLayout(1,1));
        panelM.setMaximumSize(new Dimension(300,500));
        JPanel panelAdd = new JPanel(new GridLayout(1,2 ));
        panelAdd.setMaximumSize(new Dimension(300,50));

        String column[] = {"TYPE", "NAME", "PREZZ", "GRAD"};
        String data[][] = new String[br.getMenu().getBevande().size()][4];
        JTable table = new JTable(data,column);
        for(int i = 0; i < br.getMenu().getBevande().size(); i++){
            data[i][0] = br.getMenu().getBevande().get(i).getType();
            data[i][1] = br.getMenu().getBevande().get(i).getNome();
            data[i][2] = String.valueOf(br.getMenu().getBevande().get(i).getPrezzo())+" Euro";
            data[i][3] = String.valueOf(br.getMenu().getBevande().get(i).getGrad());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(panelM);
        panel.add(panelAdd);
        panelM.add(id);
        panel.add(scrollPane);

        panel.add(panelAdd);
        panelAdd.add(ADDBEVANDAButton);
        panelAdd.add(REMBEVANDAButton);
//        frame.setContentPane(panel);
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = tk.getScreenSize().width / 2;
//        int ySize = tk.getScreenSize().height / 2;
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setSize(xSize, ySize);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
        setFrame();


        //  panelM.add(ListBev);
//        DefaultListModel listModel = new DefaultListModel();
//        for(int i = 0; i < br.getMenu().getBevande().size(); i++){
//            listModel.add(i, br.getMenu().getBevande().get(i).toString());}
//        ListBev.setModel(listModel);

        ADDBEVANDAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_AddBev gui_addBev = new GUI_AddBev(frame, br);
                gui_addBev.OpenBev();
            }
        });

        REMBEVANDAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null,"PLEASE SELECT BEVANDA");
                }else {
                    Bevanda bevanda = br.getMenu().getBevande().get(table.getSelectedRow());
                    br.remBev(bevanda);
                    setMenu();
                }

            }
        });

    }

    public void setFrame(){
        frame.setContentPane(panel);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = tk.getScreenSize().width / 2;
        int ySize = tk.getScreenSize().height / 2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}