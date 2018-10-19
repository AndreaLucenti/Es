import java.util.ArrayList;

public class Bar {
    private String nome;
    private String id;
    private ArrayList<Evento> eventi;
    private Menu menu;
    private String ubicazione;
    private String pass = "Password";
    private boolean Flogg = true;
    private boolean loggedin = false;

    public Bar(String ubicazione, String nome, String id) {
        this.eventi = new ArrayList<Evento>();
        this.ubicazione = ubicazione;
        this.nome = nome;
        this.id = id;
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

    //TODO mettere a posto l'input dell menù
    public void  addMenu(Menu menu){
        this.menu = menu;
    }

    public boolean setPass(String pass, String Oldpass){
        if(this.pass != pass && Oldpass == this.pass){
            this.pass = pass;
            Flogg = false;
            return true;
        }
        return false;
    }

    public boolean Log(String id, String pass){
        if(this.id.equals(id) && this.pass.equals(pass) && !Flogg){
            loggedin = true;
            return loggedin = true;
        }
        return loggedin = false;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String out = "";
        if(eventi.size() == 0 || menu.equals(null)){return out;}
        out = nome+"\t"+ubicazione+"\n"+"menu: "+menu.toString();
        for (Evento ev: eventi){
            out += ev.toString();

        }
        return out;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getId() {
        return id;
    }
}
