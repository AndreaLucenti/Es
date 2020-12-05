import BHO.Vincoli;
import Arredamento.Mobili;

import java.util.ArrayList;

public class Room {
    private double[] side;
    private ArrayList<Vincoli> vincoli;
    private ArrayList<Mobili> mobili;

    public Room() {
        side = new double[4];
        vincoli = new ArrayList<Vincoli>();
        mobili = new ArrayList<Mobili>();
    }

    public void SetDimension(String s[]){
        for (int i = 0; i < s.length; i++){
            side[i] = Double.parseDouble(s[i]);
        }
    }


    public void setVin(Vincoli vin){ vincoli.add(vin); }

    public double[] getSide() {
        return side;
    }

    public ArrayList<Vincoli> getVincoli() {
        return vincoli;
    }

    public void setMob(Mobili mob){mobili.add(mob);

    }

}
