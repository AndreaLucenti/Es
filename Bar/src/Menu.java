import Bevande.Bevanda;

import java.util.ArrayList;

public class Menu {
    ArrayList<Bevanda> bevande;

    public Menu() {
        this.bevande = new ArrayList<Bevanda>();
    }

    public boolean addBevanda(Bevanda bevanda, String pathFile, String type, Double grad){
        if(bevande.size() != 0){
            for (Bevanda bev : bevande){
                if(bev.getNome().equals(bevanda.getNome())){
                    return false;
                }
            }
        }
        bevande.add(bevanda);
        GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+pathFile+".txt");
        if(type.equals("DRI") || type.equals("BIR")){
        gestioneFile.writeFile(type+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo()+"\t"+grad);}
        else{
                gestioneFile.writeFile(type+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo());
    }
        return true;
    }

    public boolean loadBevanda(Bevanda bevanda){
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
            out += bv.toString()+"\n";
        }
        return out;
    }
}
