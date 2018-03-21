import java.lang.reflect.Array;
import java.util.Arrays;

public class ImmVect {
    private Forma[] forme;
    private final int Nmax;
    private int Nforme = 0;

    public ImmVect(int Nmax) {
        this.Nmax = Nmax;
        this.forme = new Forma[Nmax];
    }

    public Forma[] getForme() {
        return forme;
    }

    public boolean aggforma(Forma f){
        if(Nforme < Nmax){
            forme[Nforme] = f;
            Nforme++;
            return true; }
        return false;
    }

    public Forma retforme(){
        for(int i = 0; i < Nforme; i++){
            return forme[i];
        }
        return null;
    }

    public double aree(){
        double s = 0;
        for(int i = 0; i < Nforme; i++){

        s += forme[i].Area();
    }
    return s;
    }

    public double perim(){
        double s = 0;
        for(int i = 0; i < Nforme; i++){
            s += forme[i].Perimetro();
        }
        return s;
    }

    public double areeC(Colore colore){
        double s = 0;
        for(int i = 0; i < Nforme; i++){
            if(forme[i].getColore().equals(colore)){
            s += forme[i].Area();}
        }
        return s;
    }

    public double perimC(Colore colore){
        double s = 0;
        for(int i = 0; i < Nforme; i++){
            if(forme[i].getColore().equals(colore)){
            s += forme[i].Perimetro();}
        }
        return s;
    }

    public String toString() {
         String s = "";
         for(Forma f : forme){
             if(f!= null){
                 s += f;
             }
         }
        return s;
    }

    public void OrdinaForme(){
        Arrays.sort(forme, 0, Nforme);}
}
