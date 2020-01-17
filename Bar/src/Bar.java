import Bevande.Bevanda;

import java.util.ArrayList;

public class Bar {
    private String nome;
    private String id;
    private ArrayList<Evento> eventi;
    private Menu menu = new Menu();
    private String ubicazione;
    private String pass = "Password";
    private boolean loggedin = false;

    public Bar(String nome, String ubicazione, String id, String pass) {
        this.eventi = new ArrayList<Evento>();
        this.ubicazione = ubicazione;
        this.nome = nome;
        this.id = id;
        this.pass = pass;
    }

    //TODO creare classe per rimozione eventi e bevande
    //TODO CICLO POST CREAZIONE BAR

    public boolean addEventi(Evento evento) {
        if (eventi.size() != 0) {
            for (Evento ev : eventi) {
                if (ev.getDescrizioneEvento().equals(evento.getDescrizioneEvento()) && ev.getData() != evento.getData()) {
                    return false;
                }
            }
        }
        eventi.add(evento);
        GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
        gestioneFile.writeFile("EV"+"\t"+evento.getGiorno()+"\t"+evento.getMese()+"\t"+evento.getAnno()
                                        +"\t"+evento.getDescrizioneEvento());
        return true;
    }
    
    public boolean remEventi(Evento evento) {
        if (eventi.size() != 0) {
            for (Evento ev : eventi) {
                if (ev.getDescrizioneEvento().equals(evento.getDescrizioneEvento()) && ev.getData() == evento.getData()) {
                    eventi.remove(evento);
                    GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
                    gestioneFile.remRow("EV"+"\t"+evento.getGiorno()+"\t"+evento.getMese()+"\t"+evento.getAnno()
                            +"\t"+evento.getDescrizioneEvento());
                    return true;
                }
            }
        }


        return false;

    }

    public boolean loadEventi(Evento evento) {
        if (eventi.size() != 0) {
            for (Evento ev : eventi) {
                if (ev.getDescrizioneEvento().equals(evento.getDescrizioneEvento()) && ev.getData() != evento.getData()) {
                    return false;
                }
            }
        }
        eventi.add(evento);
        return true;
    }

    public boolean setPass(String pass, String Oldpass) {
        if (this.pass != pass && Oldpass == this.pass) {
            this.pass = pass;
            return true;
        }
        return false;
    }

    public boolean Log(String id, String pass) {
        if (this.id.equals(id) && this.pass.equals(pass)) {
            loggedin = true;
            return loggedin = true;
        }
        return loggedin = false;
    }
    public boolean remBev(Bevanda bevanda){
        if(menu.remBevanda(bevanda) == true){
            GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
            System.out.println(bevanda.toString());
            gestioneFile.remRow(bevanda.toString());
            return true;
        }
        return false;


    }
    public String getNome() {
        return nome;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Evento> getEventi() {
        return eventi;
    }

    public String barDati(){
        String out;
        out = nome+"\t"+ubicazione+"\t"+id+"\t"+pass;
        return out;
    }

    @Override
    public String toString() {
        String out = "";
        if (eventi.size() == 0 || menu.equals(null)) {
            out += nome + "\t" + ubicazione + "\n";
            return out;
        }
        out += nome + "\t" + ubicazione + "\n" + "menu: " + menu.toString();
        for (Evento ev : eventi) {
            out += ev.toString();

        }
        return out;
    }
}
