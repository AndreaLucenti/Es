package GUI;

import Classi.Bar;
import Classi.Cliente;
import Classi.Utente;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JPanel {

    private JButton createNewAcoountButton = new JButton("NEW ACCOUNT");
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel(new GridLayout(2,2));
    private JPanel panel2 = new JPanel(new GridLayout(1,1));
    private JPanel Spacepanel = new JPanel();
    private JPanel Spacepanel2 = new JPanel();
    private JButton OKButton = new JButton("OK");
    private JTextField IDField = new JTextField();
    private JPasswordField PasswordField = new JPasswordField();
    private JLabel id = new JLabel("ID");
    private JLabel pass = new JLabel("PASSWORD");
    private Utente ut = new Utente();
    private Bar bar;
    private Cliente cliente;


    public GUI(JFrame frame) {
        ut.readBar();
        ut.readCliente();


        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        Spacepanel2.setMaximumSize(new Dimension(1,150));
        panel.add(Spacepanel2);
        panel1.setMaximumSize(new Dimension(600,70));
        panel.add(panel1);
        Spacepanel.setMaximumSize(new Dimension(1,150));
        panel.add(Spacepanel);
        panel2.setMaximumSize(new Dimension(600,50));
        panel.add(panel2);

        panel1.add(id);
        panel1.add(IDField);
        panel1.add(pass);
        panel1.add(PasswordField);
        panel2.add(createNewAcoountButton);
        panel2.add(OKButton);



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
                    }
                }else if(ut.checkIdCliente(id) != null){
                    if (ut.checkIdCliente(id).Log(id, Pass)){
                        cliente = ut.checkIdCliente(id);
                        GUI_CLIENTE gui_cliente = new GUI_CLIENTE(frame,cliente, ut);
                        gui_cliente.openCl();
                    }
                }
                else if(ut.checkIdCliente(id) == null && ut.checkIdBar((id)) == null){
                    JOptionPane.showMessageDialog(null,"Wrong Password or Id");
                }

//                else{
//                    JOptionPane.showMessageDialog(null,"Wrong Password or Id");
//                }

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
                        }}else if(ut.checkIdCliente(id) != null){
                        if (ut.checkIdCliente(id).Log(id, Pass)){
                            cliente = ut.checkIdCliente(id);
                            GUI_CLIENTE gui_cliente = new GUI_CLIENTE(frame,cliente, ut);
                            gui_cliente.openCl();
                        }
                    }
                    else if(ut.checkIdCliente(id) == null && ut.checkIdBar((id)) == null){
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
        frame.setContentPane(new GUI(frame).panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize, ySize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
