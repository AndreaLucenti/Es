import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bottoni extends JPanel{
    private JPanel pann, Bpanel1, Bpanel2;
    private String txt1, txt2;
    private JLabel jb;
    int ib;
    public Bottoni(){
        setLayout(new GridLayout(4,1));
        jb = new JLabel("??");

        JButton b1 = new JButton("Uno");
        JButton b2 = new JButton("Due");
        ButtonAction b1a = new ButtonAction("Culo", this, 1);
        b1.addActionListener(b1a);
        ButtonAction b2a = new ButtonAction("Buona sera", this, 2);
        b2.addActionListener(b2a);

        Bpanel1 = new JPanel(new GridLayout(2,1));
        Bpanel1.add(b1);
        Bpanel2 = new JPanel(new GridLayout(2,1));
        Bpanel2.add(b2);
        add(jb);
        add(Bpanel1);
        add(Bpanel2);


    }

    public class ButtonAction implements ActionListener {


        public ButtonAction(String Txt, JPanel p, int i){
            if(i == 1){
                txt1 = Txt;
            }
            if(i == 2){
                txt2 = Txt;
            }
            pann = p;

        }
        public void actionPerformed(ActionEvent event) {

                jb.setText(txt1);
                jb.setText(txt2);

        }

    }

}
