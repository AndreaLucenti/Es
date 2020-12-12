package GUI;

import Bevande.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_AddBev {
    private JLabel nome = new JLabel("Nome");
    private JLabel costo = new JLabel("Costo");
    private JLabel gradazione = new JLabel("Gradazione");
    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();
    private JTextField textField3 = new JTextField();
    private JButton salvaButton = new JButton("Save");
    private JCheckBox birraCheckBox = new JCheckBox("Birra");
    private JCheckBox drinkCheckBox = new JCheckBox("Drink");
    private JCheckBox analcolicoCheckBox = new JCheckBox("Analcolico");
    private JCheckBox bibitaCheckBox = new JCheckBox("Bibita");
    private JPanel panel1 = new JPanel(new GridLayout(8,2));
    private JPanel panel2 = new JPanel(new GridLayout(1,4)) ;
    private JPanel panel3 = new JPanel(new GridLayout(1,1));
    private JPanel panel = new JPanel();
    private JFrame frame;
    private Bevanda bevanda;
    private Classi.Menu menu;
    private Classi.Bar bar;
    private String type;
    private int i = 0;

    public GUI_AddBev(JFrame frame, Classi.Bar bar) {
        this.frame = frame;
        this.bar = bar;
        this.menu = bar.getMenu();
        type = null;

        salvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllo();
            }
        });

        birraCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = 1;
                type = "BIR";
            }
        });
        drinkCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = 2;
                type = "DRI";
            }
        });
        analcolicoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = 3;
                type = "ANA";
            }
        });
        bibitaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = 4;
                type = "BIB";
            }
        });
    }

    /**
     * Funzione per il controllo della compilazione dei campi per l'aggiunta di una bevanda
     *
     */
    public void Controllo(){
        if(textField1 != null && textField2 != null && i > 2){
            operazione();
        }
        else if(textField1 != null && textField2 != null && i < 3 && textField3 != null){
            operazione();
        }
        else{
            JOptionPane.showMessageDialog(null,"Compilare tutti i campi");
        }

    }

    /**
     * Funzione per Aggiungere una nuova bevanda al menu del bar
     */
    public void operazione(){
        if (i == 1){

            bevanda = new Birra(textField1.getText(), Integer.parseInt(textField2.getText()), Double.parseDouble(textField3.getText()), "BIR");
            menu.addBevanda(bevanda, bar.getId(), type, Double.parseDouble(textField3.getText()));
        }
        if (i == 2){
            bevanda = new Drink(textField1.getText(), Integer.parseInt(textField2.getText()), Double.parseDouble(textField3.getText()), "DRI");
            menu.addBevanda(bevanda, bar.getId(), type, Double.parseDouble(textField3.getText()));
        }
        if (i == 3){
            bevanda = new Analcolico(textField1.getText(), Integer.parseInt(textField2.getText()),"ANA", 0);
            menu.addBevanda(bevanda, bar.getId(), type, null);
        }
        if(i == 4){
            bevanda = new Bibita(textField1.getText(), Integer.parseInt(textField2.getText()), "BIB", 0);
            menu.addBevanda(bevanda, bar.getId(), type, null);
        }
        GUI_BAR gui_bar = new GUI_BAR(frame,bar);
        gui_bar.setMenu();
    }

    public void OpenBev(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel1.setMaximumSize(new Dimension(600,400));
        panel.add(panel1);
        panel2.setMaximumSize(new Dimension(600,200));
        panel.add(panel2);
        panel3.setMaximumSize(new Dimension(400,100));
        panel.add(panel3);

        panel1.add(nome);
        panel1.add(textField1);
        panel1.add(costo);
        panel1.add(textField2);
        panel1.add(gradazione);
        panel1.add(textField3);
        panel2.add(birraCheckBox);
        panel2.add(drinkCheckBox);
        panel2.add(analcolicoCheckBox);
        panel2.add(bibitaCheckBox);
        panel3.add(salvaButton);


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
