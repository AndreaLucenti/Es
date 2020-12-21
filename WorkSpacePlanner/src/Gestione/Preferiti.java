package Gestione;

import Arredamento.Mobili;

import java.util.ArrayList;

/**
 * Classe per la gestione e il salvataggio dei mobili preferiti
 */
//TODO GESTIRE I PREFERITI
public class Preferiti {

    private ArrayList<Mobili> preferiti;

    public Preferiti() {
        this.preferiti = new ArrayList<Mobili>();
    }

    public void setPreferiti(Mobili mobili) {
            preferiti.add(mobili);
    }

    public ArrayList<Mobili> getPreferiti() {
        return preferiti;
    }
}
