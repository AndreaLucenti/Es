package SetRoom;

import Arredamento.Mobili;
import Arredamento.Sedia;
import Arredamento.Scrivania;

import java.util.ArrayList;

public class SalaRiunioni extends Utilizzo{

    private ArrayList<Mobili> mobili;

    public SalaRiunioni() {
        mobili = new ArrayList<Mobili>();
        PredMobili();
    }

    private void PredMobili(){
        Mobili sedia = new Sedia(1,1,6);
        Mobili tavolo = new Scrivania(2,6,1);
        mobili.add(sedia);
        mobili.add(tavolo);
    }

    public ArrayList<Mobili> getMobili() {
        return mobili;
    }

    @Override
    public String toString() {
        return super.toString()+"SalaRiunioni "+ mobili+"\n";
    }
}
