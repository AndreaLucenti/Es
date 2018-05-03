package GUI;

import Partite.PartitaCalcio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartitaPanel extends JPanel{
    private JPanel pann, squadra1panel, squadra2panel;
    private JLabel squadra1Gol, squadra2Gol, squadra1Nome, squadra2Nome;
    public PartitaPanel(){
        setLayout(new GridLayout(2,3));
        squadra1Gol = new JLabel("??");
        squadra2Gol= new JLabel("??");
        squadra1Nome = new JLabel("JUVE");
        squadra2Nome = new JLabel("ROMA");

        squadra1panel = new JPanel();
        squadra1panel.setLayout(new GridLayout(2,1));

        squadra2panel = new JPanel();
        squadra2panel.setLayout(new GridLayout(2,1));

        JButton b = new JButton("Avanti");
        ButtonAction ba = new ButtonAction();
        b.addActionListener(ba);

        squadra1panel.add(squadra1Nome);
        squadra1panel.add(squadra1Gol);
        squadra2panel.add(squadra2Nome);
        squadra2panel.add(squadra2Gol);

        add(squadra1panel);
        add(squadra2panel);
        add(b);

    }

    public class ButtonAction implements ActionListener {
        public ButtonAction() {

        }

        public void actionPerformed(ActionEvent event) {
            squadra1Gol.setText("");
        }
    }
}

