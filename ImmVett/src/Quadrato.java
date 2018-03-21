public class Quadrato extends Forma{
    private double lato;

    public Quadrato(Colore colore, double lato) {
        super(colore);
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    @Override
    public double Area() {
        return lato*lato;
    }

    @Override
    public double Perimetro() {
        return lato*4;
    }

    @Override
    public String toString() {
        return super.toString()+ " "+"Lato = "+this.lato+"\n" ;
    }
}
