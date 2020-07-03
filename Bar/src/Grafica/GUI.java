package Grafica;

import Classi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {

    private JButton createNewAcoountButton;
    private JPanel panel1;
    private JButton OKButton;
    private JTextField IDField;
    private JPasswordField PasswordField;
    private Utente ut = new Utente();
    private Bar bar;


    public GUI(JFrame frame) {
        ut.readBar();
        ut.readCliente();

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Pass = String.valueOf(PasswordField.getPassword());
                String id = IDField.getText();

                if(ut.checkIdBar((id)) != null){
                if(ut.checkIdBar(id).Log(id, Pass)){
                    bar = ut.checkIdBar(id);
                    GBAR gbar = new GBAR(frame, bar);
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
                GNewB gNewB = new GNewB(frame, ut);
                gNewB.openNewB();
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
                            GBAR gbar = new GBAR(frame, bar);
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
