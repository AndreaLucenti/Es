package GUI;

import Classi.Bar;
import Classi.Cliente;
import Classi.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI_BARCL {
    private JFrame frame;
    private Cliente cliente;
    private JPanel panel = new JPanel();
    private JPanel panelId = new JPanel();
    private JPanel panelL = new JPanel();
    private JPanel panelB = new JPanel(new GridLayout(1,2));
    private ArrayList<Bar> preferiti;
    private ArrayList<Bar> bars;
    private JList list = new JList();
    private JLabel Id = new JLabel();
    private JButton visita = new JButton("VISITA");
    private JButton rimuovi = new JButton("RIMUOVI");
    private Utente ut = new Utente();

    public GUI_BARCL(JFrame frame, Cliente cliente, Utente ut){
        this.frame = frame;
        this.cliente = cliente;
        this.ut = ut;
        preferiti = cliente.getPreferiti();
        Id.setText(""+cliente.getNome()+" "+cliente.getCognome());
    }

    /**
     * Funzione per visualizzare i bar preferiti con la possibilità di rimuoverli o visualizzare il menu e gli eventi
     */
    public void setPREF(){

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < preferiti.size(); i++) {
            listModel.add(i, preferiti.get(i).getNome());
        }
        list.setModel(listModel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelId.add(Id);
        panelId.setMaximumSize(new Dimension(700,150));
        panel.add(panelId);
        panelL.setMaximumSize(new Dimension(700,300));
        panelL.add(list);
        list.setPreferredSize(new Dimension(500,200));
        panel.add(panelL);
        panelB.setMaximumSize(new Dimension(400,150));
        panelB.add(visita);
        panelB.add(rimuovi);
        panel.add(panelB);
        setFrame();

        visita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null,"SELEZIONARE UN BAR");
                }else {
                    bars = preferiti;
                    opBars(list.getSelectedIndex());
                }
            }
        });

        rimuovi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null,"SELEZIONARE UN BAR");
                }else {
                    remPref(list.getSelectedIndex());
                }
            }
        });
    }

    /**
     * Funzione che elenca i bar
     */
    public void setBRCL(){
        bars = ut.getBars();

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < bars.size(); i++) {
            listModel.add(i, bars.get(i).getNome());
        }
        list.setModel(listModel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelId.add(Id);
        panelId.setMaximumSize(new Dimension(700,150));
        panel.add(panelId);
        panelL.setMaximumSize(new Dimension(700,300));
        panelL.add(list);
        list.setPreferredSize(new Dimension(500,200));
        panel.add(panelL);
        panelB.setMaximumSize(new Dimension(200,50));
        panelB.add(visita);
        panel.add(panelB);
        setFrame();

        visita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null,"SELEZIONARE UN BAR");
                }else {
                    opBars(list.getSelectedIndex());
                }

            }
        });
    }

    /**
     * Funzione per visualizzare gli eventi e il menu di un bar con la possibiòità di aggiungerlo ai preferiti
     * @param barI indice del bar selzionato da aprire
     */
    public void opBars(int barI) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panel3 = new JPanel();
        JLabel nomeB = new JLabel(bars.get(barI).getNome());
        panel3.add(nomeB);
        panel3.setMaximumSize(new Dimension(200,50));
        JPanel panel4 = new JPanel();
        JButton addPref = new JButton("Add Pref");
        panel4.add(addPref);

        JPanel panelE = new JPanel(new GridLayout(3, 1));
        panelE.setMaximumSize(new Dimension(300, 150));

        JLabel label1 = new JLabel("EVENTI");

        panel.add(panel3);


        String column[] = {"DATA", "DESCRIZIONE"};
        String data[][] = new String[bars.get(barI).getEventi().size()][2];
        for (int i = 0; i < bars.get(barI).getEventi().size(); i++) {
            data[i][0] = bars.get(barI).getEventi().get(i).getData();
            data[i][1] = bars.get(barI).getEventi().get(i).getDescrizioneEvento();
        }

        JTable table1 = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(table1);
        panel.add(panelE);
        panelE.add(label1);
        panelE.add(scrollPane);


        String column2[] = {"TYPE", "NAME", "PREZZ", "GRAD"};
        String data2[][] = new String[bars.get(barI).getMenu().getBevande().size()][4];
        JTable table2 = new JTable(data2, column2);
        for (int i = 0; i < bars.get(barI).getMenu().getBevande().size(); i++) {
            data2[i][0] = bars.get(barI).getMenu().getBevande().get(i).getType();
            data2[i][1] = bars.get(barI).getMenu().getBevande().get(i).getNome();
            data2[i][2] = String.valueOf(bars.get(barI).getMenu().getBevande().get(i).getPrezzo()) + " Euro";
            data2[i][3] = String.valueOf(bars.get(barI).getMenu().getBevande().get(i).getGrad());
        }
        JPanel panelM = new JPanel(new GridLayout(2,1));
        panelM.setMaximumSize(new Dimension(300, 150));
        JLabel label2 = new JLabel("MENU");
        JScrollPane scrollPane2 = new JScrollPane(table2);
        panelM.add(label2);
        panelM.add(scrollPane2);
        panel.add(panelM);
        panel.add(panel4);
        setFrame();

        addPref.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.addPref(bars.get(barI));
                JOptionPane.showMessageDialog(null, "BAR AGGIUNTO AI PREFERITI");
            }
        });

    }

    /**
     * Funzione che richiama la funzione per la rimozione di un bar dai preferiti
     * @param barI indice del bar preferito selezionato da rimuovere
     */
    public void remPref(int barI){
        cliente.remPref(preferiti.get(barI));
        setPREF();
    }

    public void setFrame(){
        frame.setContentPane(panel);
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
