public abstract class Forma implements Comparable{
    private Colore colore;

    public Forma(Colore colore) {
        this.colore = colore;
    }

    public Colore getColore() {
        return colore;
    }

    public abstract double Perimetro();

    public abstract double Area();

    public int compareTo(Object o) {
        if(this.Area() > ((Forma)o).Area()){
            return +1;
        }
        else if(this.Area() < ((Forma)o).Area()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Colore = " +this.colore;
    }
}
