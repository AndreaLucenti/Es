import java.util.ArrayList;

public class Bar {
    private String nome;
    private ArrayList<Evento> eventi;
    private Menu menu;
    private String ubicazione;

    public Bar(Menu menu, String ubicazione, String nome) {
        this.eventi = new ArrayList<Evento>();
        this.menu = menu;
        this.ubicazione = ubicazione;
        this.nome = nome;
    }

    public boolean addEventi(Evento evento){
        if(eventi.size() != 0){
            for (Evento ev: eventi){
                if(ev.getDescrizioneEvento().equals(evento.getDescrizioneEvento())){
                    return false;
                }
            }
        }
        eventi.add(evento);
        return true;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome+"\t"+ubicazione+"\n"+"menu: "+menu.toString();
    }
}
