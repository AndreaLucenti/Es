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

    public boolean remBevande(Bevanda bevanda, String id, Double grad){
        if(bevande.size() != 0){
            for (Bevanda bv: bevande){
                if(bv.getNome().equals(bevanda.getNome())){
                    bevande.remove(bv);
                    GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
                    System.out.println(bevanda.getClass().getName());
                    switch (bevanda.getClass().getName()){
                        case "Bevande.Birra":
                            gestioneFile.remRow("BIR"+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo()+"\t"+grad);
                            return true;
                        case "Bevande.Drink":
                            gestioneFile.remRow("DRI"+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo()+"\t"+grad);
                            return true;
                        case "Bevande.Bibita":
                            gestioneFile.remRow("BIB"+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo());
                        case "Bevande.Analcolico":
                            gestioneFile.remRow("ANA"+"\t"+bevanda.getNome()+"\t"+bevanda.getPrezzo());
                            return true;
                    }

                }
            }
        }
        return false;
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

    public ArrayList<Bevanda> getBevande() {
        return bevande;
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
