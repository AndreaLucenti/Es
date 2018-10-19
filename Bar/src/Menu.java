import Bevande.Bevanda;

import java.util.ArrayList;

public class Menu {
    ArrayList<Bevanda> bevande;

    public Menu() {
        this.bevande = new ArrayList<Bevanda>();
    }

    public boolean addBevanda(Bevanda bevanda){
        if(bevande.size() != 0){
            for (Bevanda bev : bevande){
                if(bev.getNome().equals(bevanda.getNome())){
                    return false;
                }
            }
        }
        bevande.add(bevanda);
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (Bevanda bv : bevande){
            out += bv.toString();
        }
        out += "\n";
        return out;
    }
}
