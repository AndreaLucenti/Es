package GUI;

import Classi.Bar;
import Classi.Utente;
import Grafica.GBAR;
import Grafica.GNewB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JPanel {

    private JButton createNewAcoountButton = new JButton("NEW ACCOUNT");
    private JPanel panel1 = new JPanel(new GridLayout(3,2));
    private JButton OKButton = new JButton("OK");
    private JTextField IDField = new JTextField();
    private JPasswordField PasswordField = new JPasswordField();
    private JLabel id = new JLabel("ID");
    private JLabel pass = new JLabel("PASSWORD");
    private Utente ut = new Utente();
    private Bar bar;


    public GUI(JFrame frame) {
        ut.readBar();
        ut.readCliente();


        panel1.add(id);
        panel1.add(IDField);
        panel1.add(pass);
        panel1.add(PasswordField);
        panel1.add(createNewAcoountButton);
        panel1.add(OKButton);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Pass = String.valueOf(PasswordField.getPassword());
                String id = IDField.getText();

                if(ut.checkIdBar((id)) != null){
                    if(ut.checkIdBar(id).Log(id, Pass)){
                        bar = ut.checkIdBar(id);
                        GUI_BAR gbar = new GUI_BAR(frame, bar);
                        gbar.OpenBar();

                    }else{
                        JOptionPane.showMessageDialog(null,"Wrong Password or Id");
                    }}else{
                    JOptionPane.showMessageDialog(null,"Wrong Password or Id");
                }

            }
        });

        createNewAcoountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_NewUT gui_newUT = new GUI_NewUT(frame, ut);
                gui_newUT.openNewUT();
            }
        });

        PasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String Pass = String.valueOf(PasswordField.getPassword());
                    String id = IDField.getText();

                    if(ut.checkIdBar((id)) != null){
                        if(ut.checkIdBar(id).Log(id, Pass)){
                            bar = ut.checkIdBar(id);
                            GUI_BAR gbar = new GUI_BAR(frame, bar);
                            gbar.OpenBar();

                        }else{
                            JOptionPane.showMessageDialog(null,"Wrong Password or Id");
                        }}else{
                        JOptionPane.showMessageDialog(null,"Wrong Password or Id");
                    }

                }

            }
        });
    }

    public static void main(String[] args){
        Toolkit tk = Toolkit.getDefaultToolkit();
        JFrame frame = new JFrame("APP");
        int xSize = tk.getScreenSize().width/2;
        int ySize = tk.getScreenSize().height/2;
        frame.setContentPane(new GUI(frame).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
