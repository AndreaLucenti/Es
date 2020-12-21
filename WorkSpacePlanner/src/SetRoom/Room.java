package SetRoom;

import Vin.Vincoli;
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
    //TODO TROVARE UTILITA ALLA SCALA
    public void SetScala(int s){
        scala = scala;
    }

    /**
     * Funzioni per impostare le dimensioni della stanza
     * @param s stringa contenente le dimensioni della stanza
     */
    public void SetDimension(String s[]){

        for (int i = 0; i < s.length; i++){
            side[i] = Double.parseDouble(s[i])*100;
        }
    }

    /**
     * Funzione per impostare l'utilizzo della stanza
     * @param utilizzo utilizzo della stanza
     */
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

    /**
     * Funzione che aggiunge i mobili selezionati se non presenzi o incrementa tramite
     * checkMob il numero dei mobili
     * @param mob
     */
    public void setMob(Mobili mob) {
        if (checkMob(mob.getId(), 1) == 0) {
            mobili.add(mob);
        }
    }

    public ArrayList<Mobili> getMobili() {
        return mobili;
    }

    /**
     * Aggiunge i preset dei mobili relativi all'utilizzo
     */
    public void addPreSet(){
        for(int i = 0; i < utilizzo.getMobili().size(); i++){
            mobili.add(utilizzo.getMobili().get(i));
        }
    }

    /**
     * Funzione che controlla la presenza di un mobile nell'elenco della stanza
     * e se presente ne incrementa il numero
     * @param nome nome relativo al mobile
     * @param num numero da incrementare del mobile
     * @return check per la presenza o meno del mobile dell'elenco della stanza
     */
    public int checkMob(String nome, int num){
        int check = 0;
        for(int i = 0; i < mobili.size(); i++){
            if (mobili.get(i).getId().equals(nome)){
                mobili.get(i).setNum(num);
                check = 1;
            }
            else{}


        }
        return check;
    }
}
