import Bevande.*;

import java.util.*;

public class Utente {
   private ArrayList<Bar> bars;
   private ArrayList<Cliente> clienti;
    GestioneFile fileBar = new GestioneFile("DataBar.txt");

    public Utente() {
        this.bars = new ArrayList<Bar>();
        this.clienti = new ArrayList<Cliente>();
    }

    /**Funzione per leggere da file i bar già registrati**/

    public void readBar(){
        ArrayList<String[]> datiBar = fileBar.readFile();
        for(int i = 0; i < datiBar.size(); i++){

                Bar bar = new Bar(datiBar.get(i)[0], datiBar.get(i)[1], datiBar.get(i)[2], datiBar.get(i)[3]);
                bars.add(bar);
                readDati(bar.getId(),bar);
        }

    }

    public void readDati(String fileDati, Bar bar){
        GestioneFile file = new GestioneFile(fileDati +".txt");
        ArrayList<String[]> dati = file.readFile();
        for(int i = 0; i < dati.size(); i++) {
            switch (dati.get(i)[0]){
                case "BIR":
                    Bevanda birra = new Birra(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]),
                                                Double.parseDouble(dati.get(i)[3]));
                    bar.getMenu().addBevanda(birra);
                    break;

                case "DRI":
                    Bevanda drink = new Drink(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]),
                                                Double.parseDouble(dati.get(i)[3]));
                    bar.getMenu().addBevanda(drink);
                    break;

                case "BIB":
                    Bevanda bibita = new Bibita(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]));
                    bar.getMenu().addBevanda(bibita);
                    break;

                case "ANA":
                    Bevanda analcolico = new Analcolico(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]));
                    bar.getMenu().addBevanda(analcolico);
                    break;

                case "EV":
                    Evento evento = new Evento(Integer.parseInt(dati.get(i)[1]), Integer.parseInt(dati.get(i)[2]),
                                                Integer.parseInt(dati.get(i)[3]),dati.get(i)[4]);
                    bar.addEventi(evento);
                    break;
            }

        }
    }

    public boolean newBar(String nome, String ubicazione, String id, String pass){
        if(bars.size()!=0)
        for (Bar br: bars){
            if(br.getId().equals(id) || br.getNome().equals(nome)){
                return false;
            }
        }
        Bar bar = new Bar(nome, ubicazione, id, pass);
        bar.setPass(pass, "Password");
        bars.add(bar);
        fileBar.writeFile(bar.barDati());
        return true;
    }

    public boolean newCliente(String nome, String cognome,String id, String pass){
        if(clienti.size()!=0)
            for (Cliente cl: clienti){
                if(cl.getId().equals(id)){
                    return false;
                }
            }
        Cliente cliente = new Cliente(nome, cognome, id);
        cliente.setPass(pass, "Password");
        clienti.add(cliente);
        return true;
    }

    public Bar getBar(String nome) {
        for (Bar br:bars){
            if(br.getNome().equals(nome)){
                return br;
            }
        }
        return null;
    }
    public Bar checkIdBar(String id){
        for (Bar br:bars){
            if(br.getId().equals(id)){
                return br;
            }
        }
        return null;
    }

    public Bar checkIdCliente(String id){
        for (Bar br:bars){
            if(br.getId().equals(id)){
                return br;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String out = "";
        for (Bar br: bars){
            out += br.toString()+"\n";
        }
        return out;
    }
}
