public class Rettangolo extends Forma {

    private double base;
    private double altezza;

    public Rettangolo(Colore colore, double base, double altezza) {
        super(colore);
        this.base = base;
        this.altezza = altezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getBase() {
        return base;
    }

    @Override
    public double Perimetro() {
        return 2*(base+altezza);
    }

    @Override
    public double Area() {
        return base*altezza;
    }

    @Override
    public String toString() {
        return super.toString()+ " "+ "base = "+ this.base+ " altezza = "+ this.altezza+ "\n";
    }
}
