package Gestione;

import Arredamento.*;

import java.util.ArrayList;

public class AllMob {
    private ArrayList<Mobili> mobili;

    public AllMob() {
        mobili = new ArrayList<Mobili>();
        lettFile();
    }

    private  void lettFile(){

        GestioneFile cc = new GestioneFile(".\\src\\FILETXT\\Elenco.txt");
        ArrayList<String[]> line = cc.readFile();

        for(int i =0; i < line.size(); i++){
            switch (line.get(i)[0]){
                case "Scrivania":
                    Mobili scrivania = new Scrivania(Integer.parseInt(line.get(i)[2]),Integer.parseInt(line.get(i)[3]), line.get(i)[1]);
                    mobili.add(scrivania);
                    break;
                case "Cassettiera":
                    Mobili cass = new Cassettiera(Integer.parseInt(line.get(i)[2]),Integer.parseInt(line.get(i)[3]),line.get(i)[1]);
                    mobili.add(cass);
                    break;
                case "Armadio":
                    Mobili armadio = new Armadio(Integer.parseInt(line.get(i)[2]),Integer.parseInt(line.get(i)[3]),line.get(i)[1]);
                    mobili.add(armadio);
                    break;
                case "Libreria":
                    Mobili libr = new Libreria(Integer.parseInt(line.get(i)[2]),Integer.parseInt(line.get(i)[3]),line.get(i)[1]);
                    mobili.add(libr);
                    break;
            }
        }
    }

    public ArrayList<Mobili> getMobili() {
        return mobili;
    }
}
