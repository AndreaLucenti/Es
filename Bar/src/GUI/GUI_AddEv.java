package GUI;

import Classi.Bar;
import Classi.Evento;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

public class GUI_AddEv {//TODO PROGETTO
    private JFrame frame;
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel(new GridLayout(4,2));
    private JPanel panel2 = new JPanel();
    private JLabel giorno = new JLabel("Giorno");
    private JLabel mese = new JLabel("Mese");
    private JLabel anno = new JLabel("Anno");
    private JSpinner spinG = new JSpinner();
    private JSpinner spinM = new JSpinner();
    private JSpinner spinA = new JSpinner();
    private JLabel descr = new JLabel("Descrizione");
    private JTextField TxtDescr = new JTextField();
    private JButton save = new JButton("SAVE");
    private Bar bar;
    private Date date = new Date();
    private Evento ev;
    private int g, m, a;

    public GUI_AddEv(JFrame frame, Bar bar){
        this.frame = frame;
        this.bar = bar;
        setSpinner();
        g = date.getDate();
        m= date.getMonth()+1;
        a = date.getYear()+1900;

        save.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkDate()){
                    ev = new Evento(g,m,a,TxtDescr.getText());
                    bar.addEventi(ev);
                    GUI_BAR gui_bar =new GUI_BAR(frame,bar);
                    gui_bar.setEV();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong Date");
                }
            }
        });

        spinG.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                g = (int)((JSpinner)e.getSource()).getValue();
            }
        });
        spinM.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                m = (int)((JSpinner)e.getSource()).getValue();
            }
        });
        spinA.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                a = (int)((JSpinner)e.getSource()).getValue();
            }
        });


    }

    public void AddEv(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel1);
        panel1.setMaximumSize(new Dimension(400,150));
        panel1.add(giorno);
        panel1.add(spinG);
        panel1.add(mese);
        panel1.add(spinM);
        panel1.add(anno);
        panel1.add(spinA);
        panel1.add(descr);
        panel1.add(TxtDescr);
        panel.add(panel2);
        panel2.setMaximumSize(new Dimension(400,150));
        panel2.add(save);
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

    public void setSpinner(){
        SpinnerModel spinnerModelA = new SpinnerNumberModel
                (date.getYear()+1900, date.getYear() -1800, date.getYear() +2000, 1);
        spinA.setModel(spinnerModelA);

        SpinnerModel spinnerModelM = new SpinnerNumberModel
                (date.getMonth()+1, 1,12,1 );
        spinM.setModel(spinnerModelM);

        SpinnerModel spinnerModelG = new SpinnerNumberModel
                (date.getDate(), 1, 31,1);
        spinG.setModel(spinnerModelG);
    }

    public boolean checkDate(){
        if((m == 11 || m == 4 || m == 6 ||m == 9) &&
                g == 31) {
            return false;
        }else if(m == 2 && ((a % 4) != 0) && g > 28){
            return false;
        }else if(m == 2 && ((a % 4) == 0) && g > 29){
            return false;
        }
        return true;
    }
}
