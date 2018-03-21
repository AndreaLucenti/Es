public class Rettangolo extends Forme {

    private double base, altezza;

    public Rettangolo(Colore colore, double base, double altezza) {
        super(colore);
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public double getAltezza() {
        return altezza;
    }

    @Override
    public double Area() {
        return base*altezza;
    }

    @Override
    public double Perimetro() {
        return (base+altezza)*2;
    }
}
