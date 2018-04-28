package Eventi;

import Partite.AbsPartita;
import Partite.PartitaCalcio;

public class EventiCalcio {


    public boolean Eventi(String cod, PartitaCalcio p){
        if(cod.equals("C-00")){
                p.setTempo(1);
                return true;
        }
        if(cod.equals("C-02")){
            p.setTempo(2);
            return true;
        }
        if(cod.equals("C-04")){
            p.setGolCasa();
            return true;
        }
        if(cod.equals("C-05")){
            p.setGolOspiti();
            return true;
        }
        if(cod.equals("C-01")){
            System.out.println("Fine primo tempo");
            System.out.println(p.toString());
            return true;
        }
        if(cod.equals("C-98")){
            return true;
        }
        if(cod.equals("C-99")){
            System.out.println("Fine partita");
            System.out.println(p+"\n");
            return true;
        }
        return false;
    }
}
