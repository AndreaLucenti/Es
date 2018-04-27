package Eventi;

import Partite.PartitaVolley;

public class EventiVolley{


    public boolean Eventi(String cod, PartitaVolley p){

        if(cod.equals("V-00")){
            p.setSet();
            return true;
        }
        if(cod.equals("V-01")){
            p.setSet();
            return true;
        }
        if(cod.equals("V-02")){
            return true;
        }
        if(cod.equals("V-03")){
            p.setPuntiCasa();
            return true;
        }
        if(cod.equals("V-04")){
            p.setPuntiOspiti();
            return true;
        }
        if(cod.equals("V-05")){
            p.setTimeCasa();
            return true;
        }
        if(cod.equals("V-06")){
            p.setTimeOspiti();
            return true;
        }
        if(cod.equals("V-98")){
            return true;
        }
        if(cod.equals("V-99")){
            System.out.println(p);
            return true;
        }
        return false;
    }
}
