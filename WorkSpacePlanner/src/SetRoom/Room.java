package SetRoom;

import BHO.Vincoli;
import Arredamento.Mobili;

import java.util.ArrayList;

public class Room {
    private Utilizzo utilizzo;
    private int scala;
    private double[] side;
    private ArrayList<Vincoli> vincoli;
    private ArrayList<Mobili> mobili;

    public Room() {
        scala = 0;
        side = new double[4];
        vincoli = new ArrayList<Vincoli>();
        mobili = new ArrayList<Mobili>();
    }

    public void SetScala(int s){
        scala = scala;
    }

    public void SetDimension(String s[]){

        for (int i = 0; i < s.length; i++){
            side[i] = Double.parseDouble(s[i])*100;
        }
    }

    public void setUtilizzo(Utilizzo utilizzo){
        this.utilizzo = utilizzo;
        System.out.println(""+utilizzo);
    }

    public void setVin(Vincoli vin){ vincoli.add(vin); }

    public double[] getSide() {
        return side;
    }

    public ArrayList<Vincoli> getVincoli() {
        return vincoli;
    }

    public void setMob(Mobili mob){mobili.add(mob);}

    public ArrayList<Mobili> getMobili() {
        return mobili;
    }

    public void addPreSet(){
        for(int i = 0; i < utilizzo.getMobili().size(); i++){
            mobili.add(utilizzo.getMobili().get(i));
        }
    }
}
