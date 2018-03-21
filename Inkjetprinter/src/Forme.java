public abstract class Forme implements Comparable, Misurabile{
    private Colore colore;

    public Forme(Colore colore) {
        this.colore = colore;
    }

    public Colore getColore() {
        return colore;
    }

    @Override
    public int compareTo(Object o) {
        if(this.Area() > ((Forme)o).Area()) {
            return +1;
        }else if(this.Area() > ((Forme)o).Area()){
            return -1;
        }
        return 0;
    }

    public abstract  double Area();

    public abstract double Perimetro();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " +Area()+"\n";
    }
}
