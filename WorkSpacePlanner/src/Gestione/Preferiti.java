package Gestione;

import Arredamento.Mobili;

import java.util.ArrayList;

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
