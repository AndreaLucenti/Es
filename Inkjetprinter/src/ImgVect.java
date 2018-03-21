import java.util.Arrays;

public class ImgVect implements Comparable<ImgVect>{
    private int Nmax;
    private int Nf = 0;
    private Forme[] forme;

    public ImgVect(int nmax) {
        Nmax = nmax;
        forme = new Forme[Nmax];
    }

    public boolean aggforma(Forme f){
        if(Nf < Nmax){
            forme[Nf] = f;
            Nf++;
            return true;
        }
     return false;
    }

    public double SommAree(){
        double s = 0;
        for(int i = 0; i < Nf; i++){
            s += forme[i].Area();
        }
        return s;
    }

    public double SommAreeC(Colore colore){
        double s = 0;
        for(int i = 0; i < Nf; i++){
            if(forme[i].getColore().equals(colore))
            s += forme[i].Area();
        }
        return s;
    }

    @Override
    public int compareTo(ImgVect o) {
        if(this.SommAree() > o.SommAree()){
            return +1;
        }
        else if(this.SommAree() < o.SommAree()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (Forme f : forme){
            if(forme != null){
                s += f;
            }
        }
        return s;
    }
}
