package Classi;

import Bevande.Bevanda;

import java.util.ArrayList;

public class Menu {
    ArrayList<Bevanda> bevande;

    public Menu() {
        this.bevande = new ArrayList<Bevanda>();
    }

    /**
     * Funzione per il caricamento dell'elenco delle bevande presenti nel menu
     * **/
    public boolean loadBevanda(Bevanda bevanda){
        if(bevande.size() != 0){
            for (Bevanda bev : bevande){
                if(bev.getNome().equals(bevanda.getNome())){
                    return false;
                }
            }
        }
        bevande.add(bevanda);
        return true;
    }

    /**
     * Funzione per aggiungere una bevamda al menu se non presente
     * **/
    public boolean addBevanda(Bevanda bevanda, String pathFile, String type, Double grad){
        if(bevande.size() != 0){
            for (Bevanda bev : bevande){
                if(bev.getNome().equals(bevanda.getNome())){
                    return false;
                }
            }
        }
        bevande.add(bevanda);
        GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+pathFile+".txt");
        if(type.equals("DRI") || type.equals("BIR")){
        gestioneFile.writeFile(type+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo()+"\t"+grad);}
        else{
                gestioneFile.writeFile(type+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo());
    }
        return true;
    }

    /**
     * Funzione per la rimozione di una bevanda dal menu
     * **/
    public boolean remBevanda(Bevanda bevanda){
        if(bevande.size() != 0) {
            for (Bevanda bev : bevande) {
                if (bev.getNome().equals(bevanda.getNome())) {
                    bevande.remove(bevanda);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Bevanda> getBevande() {
        return bevande;
    }

    @Override
    public String toString() {
        int i = 1;
        String out = "";
        for (Bevanda bv : bevande){
            out += i+")"+bv.toString()+"\n";
            i++;
        }
        return out;
    }
}
