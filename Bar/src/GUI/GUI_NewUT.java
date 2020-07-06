package GUI;

import Classi.Bar;
import Classi.Utente;
import Grafica.GBAR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_NewUT {//TODO NUOVI UTENTI

    private JLabel nome = new JLabel("Nome");
    private JTextField Nome = new JTextField();
    private JLabel ubicazione = new JLabel("Ubicazione");
    private JTextField Ubicazione = new JTextField();
    private JLabel id = new JLabel("ID");
    private JTextField ID = new JTextField();
    private JLabel pass = new JLabel("password");
    private JTextField Password = new JTextField();
    private JButton cliente = new JButton("Cliente");
    private JButton bar = new JButton("Bar");
    private JButton OKButton = new JButton("OK");
    private JPanel panel1 = new JPanel(new GridLayout(2,1));
    private JPanel panel2 = new JPanel(new GridLayout(9,2));
    private JPanel panel3 = new JPanel(new GridLayout(3,1));
    private JFrame frame;
    private Utente utente;

    public GUI_NewUT(JFrame frame, Utente utente) {
        this.frame = frame;
        this.utente = utente;

        cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openB();
            }
        });
    }


    public void openNewUT(){
        panel1.add(cliente);
        panel1.add(bar);

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

    public void openB(){

        panel2.add(nome);
        panel2.add(Nome);
        panel2.add(ubicazione);
        panel2.add(Ubicazione);
        panel2.add(id);
        panel2.add(ID);
        panel2.add(pass);
        panel2.add(Password);
        panel2.add(OKButton);

        frame.setContentPane(panel2);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = tk.getScreenSize().width/2;
        int ySize = tk.getScreenSize().height/2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckInfo();
            }
        });
    }

    public void CheckInfo(){
        if(Nome.getText() != null && Ubicazione.getText() != null && ID.getText() != null && Password.getText() != null ){
            utente.newBar(Nome.getText(), Ubicazione.getText(), ID.getText(), Password.getText());        }
        Bar bar = new Bar(Nome.getText(), Ubicazione.getText(), ID.getText(), Password.getText());
        GUI_BAR gbar = new GUI_BAR(frame,bar);
        gbar.OpenBar();
    }
}
