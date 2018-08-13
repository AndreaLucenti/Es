import java.util.ArrayList;

public class Elenco {
    private ArrayList<Bar> elencoBar;

    public Elenco() {
        this.elencoBar = new ArrayList<Bar>();
    }

    public boolean addBer(Bar bar){
        if(elencoBar.size() != 0){
            for (Bar br : elencoBar){
                if(br.getNome().equals(bar)){
                    return false;
                }
            }
        }
        elencoBar.add(bar);
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (Bar br: elencoBar){
            out = br.toString()+"\n";
        }
        return out;
    }
}
