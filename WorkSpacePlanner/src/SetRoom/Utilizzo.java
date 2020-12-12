package SetRoom;

import Arredamento.Mobili;

import java.util.ArrayList;

/** TODO AGGIUNGERE UTILIZZI **/
public abstract class Utilizzo{

    public Utilizzo() {
    }

    abstract ArrayList<Mobili> getMobili();

    @Override
    public String toString() {
        return "Utilizzo = ";
    }
}
