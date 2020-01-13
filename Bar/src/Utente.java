import Bevande.*;

import java.util.*;

public class Utente {
   private ArrayList<Bar> bars;
   private ArrayList<Cliente> clienti;
    GestioneFile fileBar = new GestioneFile("src/FILETXT/DataBar.txt");
    GestioneFile fileCliente = new GestioneFile("src/FILETXT/DataCliente.txt");

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
                readDatiBar(bar.getId(),bar);
        }

    }

    public void readCliente(){
        ArrayList<String[]> datiCliente = fileCliente.readFile();
        for(int i = 0; i < datiCliente.size(); i++){

            Cliente cliente = new Cliente(datiCliente.get(i)[0], datiCliente.get(i)[1], datiCliente.get(i)[2], datiCliente.get(i)[3]);
            clienti.add(cliente);
            readDatiCl(cliente.getId(),cliente);
        }

    }

    public void readDatiBar(String fileDati, Bar bar){
        GestioneFile file = new GestioneFile("src/FILETXT/"+fileDati +".txt");
        ArrayList<String[]> dati = file.readFile();
        for(int i = 0; i < dati.size(); i++) {
            switch (dati.get(i)[0]){
                case "BIR":
                    Bevanda birra = new Birra(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]),
                                                Double.parseDouble(dati.get(i)[3]));
                    bar.getMenu().loadBevanda(birra);
                    break;

                case "DRI":
                    Bevanda drink = new Drink(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]),
                                                Double.parseDouble(dati.get(i)[3]));
                    bar.getMenu().loadBevanda(drink);
                    break;

                case "BIB":
                    Bevanda bibita = new Bibita(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]));
                    bar.getMenu().loadBevanda(bibita);
                    break;

                case "ANA":
                    Bevanda analcolico = new Analcolico(dati.get(i)[1],Double.parseDouble(dati.get(i)[2]));
                    bar.getMenu().loadBevanda(analcolico);
                    break;

                case "EV":
                    Evento evento = new Evento(Integer.parseInt(dati.get(i)[1]), Integer.parseInt(dati.get(i)[2]),
                                                Integer.parseInt(dati.get(i)[3]),dati.get(i)[4]);
                    bar.loadEventi(evento);
                    break;
            }

        }
    }

    public void readDatiCl(String fileDati, Cliente cliente) {
        GestioneFile file = new GestioneFile("src/FILETXT/"+fileDati + ".txt");
        ArrayList<String[]> dati = file.readFile();
        if(dati.size() != 0) {
            for (int i = 0; i < dati.size(); i++) {
                cliente.loadPref(checkIdBar(dati.get(i)[0]));
            }
        }
    }

        public boolean newBar(String nome, String ubicazione, String id, String pass){
        //TODO GESTIONE NUOVO BAR PROBLEMA GESTIONE EV e MEN
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
        GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
        gestioneFile.writeFile("");
        return true;
    }

    public Cliente newCliente(String nome, String cognome,String id, String pass){
        if(clienti.size()!=0)
            for (Cliente cl: clienti){
                if(cl.getId().equals(id)){
                    return null;
                }
            }
        Cliente cliente = new Cliente(nome, cognome, id, pass);
        cliente.setPass(pass, "Password");
        clienti.add(cliente);
        fileCliente.writeFile(cliente.clienteDati());
        GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
        return cliente;
    }

    public ArrayList<Bar> getBars() {
        return bars;
    }

    public Bar checkIdBar(String id){
        for (Bar br:bars){
            if(br.getId().equals(id)){
                return br;
            }
        }
        return null;
    }

    public Cliente checkIdCliente(String id){
        for (Cliente cl:clienti){
            if(cl.getId().equals(id)){
                return cl;
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
