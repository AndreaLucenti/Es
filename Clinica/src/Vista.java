import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame{
    int i = 0;
    private JButton nextbutton = new JButton("Next");
    private JLabel nome = new JLabel();
    private JLabel cognome = new JLabel();
    private JLabel ora = new JLabel();
    private JLabel giorno = new JLabel();
    private JPanel prenotazione, bottone;
    private Agenda agenda;

    public Vista(Agenda agenda) throws HeadlessException {
        this.agenda = agenda;
        initComponent();
    }

    private void initComponent(){
        prenotazione = new JPanel(new GridLayout(1,1));
        bottone = new JPanel(new GridLayout(2,1));
        prenotazione.add(nome);
        prenotazione.add(cognome);
        prenotazione.add(ora);
        prenotazione.add(giorno);
        bottone.add(nextbutton);

        nextbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              nome.setText(agenda.getPrenotazione().get(i).getNome());
              cognome.setText(agenda.getPrenotazione().get(i).getCognome());
              ora.setText(agenda.getPrenotazione().get(i).getOra());
              giorno.setText(agenda.getPrenotazione().get(i).getGg());
              i++;
            }
        });

        add(prenotazione,BorderLayout.NORTH);
        add(bottone, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }


}
