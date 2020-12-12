package SetRoom;

import Arredamento.Armadio;
import Arredamento.Mobili;
import Arredamento.Sedia;
import Arredamento.Scrivania;

import java.util.ArrayList;

public class UfficioSingolo extends Utilizzo{

    private ArrayList<Mobili> mobili;

    public UfficioSingolo() {
        mobili = new ArrayList<Mobili>();
        PredMobili();
    }

    public void PredMobili(){
        Mobili sedia = new Sedia(1,1,1);
        Mobili tavolo = new Scrivania(120, 60,1);
        Mobili armadio = new Armadio(1,5,1);
        mobili.add(sedia);
        mobili.add(tavolo);
        mobili.add(armadio);
    }

    public ArrayList<Mobili> getMobili() {
        return mobili;
    }

    @Override
    public String toString() {
        return "UfficioSingolo " + mobili + "\n";
    }
}
