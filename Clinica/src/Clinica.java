import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Clinica {
    private String Nome;
    private ArrayList<Struttura> Strutture;


    public Clinica(String nome) {
        Nome = nome;
        Strutture = new ArrayList<Struttura>();
    }

    public boolean addStruttura(Struttura struttura) {

        if (Strutture.size() != 0) {
            for (Struttura str : Strutture) {
                if (struttura.getNome().equals(str.getNome())) {
                    return false;
                }
            }
        }
        Strutture.add(struttura);
        return true;
    }

    @Override
    public String toString() {
        String out = "Clinica:"+"\t"+Nome+"\n";
        for(int i = 0; i < Strutture.size(); i++){
            out+= Strutture.get(i).toString();
        }
        return out+"\n";
    }
}