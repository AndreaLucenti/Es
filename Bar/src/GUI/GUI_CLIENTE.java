package GUI;

import Classi.Cliente;
import Classi.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_CLIENTE {
    private JFrame frame;
    private Classi.Cliente cliente;
    private JPanel panel = new JPanel();
    private JPanel panelId = new JPanel();
    private JPanel panel2 = new JPanel(new GridLayout(2,1));
    private JLabel Id = new JLabel();
    private JButton Br = new JButton("BAR");
    private JButton BrPrefe = new JButton("BAR PREFERITI");
    private Utente ut = new Utente();

    public GUI_CLIENTE(JFrame frame, Cliente cliente, Utente ut){
        this.frame = frame;
        this.cliente = cliente;
        this.ut = ut;
        Id.setText(""+cliente.getNome()+" "+cliente.getCognome());

        BrPrefe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_BARCL gui_barcl= new GUI_BARCL(frame, cliente, ut);
                gui_barcl.setPREF();
            }
        });

        Br.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_BARCL gui_barcl= new GUI_BARCL(frame, cliente, ut);
                gui_barcl.setBRCL();
            }
        });
    }

    public void openCl(){

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelId.setMaximumSize(new Dimension(400,150));
        panelId.add(Id);
        panel2.setMaximumSize(new Dimension(400,150));
        panel2.add(Br);
        panel2.add(BrPrefe);
        panel.add(panelId);
        panel.add(panel2);

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
