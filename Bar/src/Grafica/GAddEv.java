package Grafica;

import Classi.Bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class GAddEv {
    private JSpinner spinner1;
    private JPanel panel1;
    private JButton salvaButton;
    private JTextField textField1;
    private JSpinner spinner3;
    private JSpinner spinner2;
    private JFrame frame;
    private Bar bar;
    private Date date;

    public GAddEv(JFrame frame, Bar bar) {
        this.frame = frame;
        this.bar = bar;
        Date date = new Date();
        createUIComponents();

        salvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public void OpenEV(){
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

    private void createUIComponents() {
        // TODO: place custom component creation code here

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(dateModel);
        Calendar calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        spinner.setValue(calendar.getTime());
        panel1.add(spinner, BorderLayout.EAST);

    }
}

