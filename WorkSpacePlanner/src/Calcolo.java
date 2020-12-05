import BHO.Vincoli;

import java.util.ArrayList;

public class Calcolo {
    private Room room;
    private double area;
    private double space;
    private ArrayList<Vincoli> vincoli;


    public Calcolo(Room room) {
        this.room = room;
    }

    public void calcolo_dati() {
        double[] lati = room.getSide();
        area = lati[0]*lati[1];
        space = area/3;
    }

    public void dati(){
        vincoli = room.getVincoli();
    }


}
