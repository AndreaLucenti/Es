public class Cerchio extends Forme {

    private double R;

    public Cerchio(Colore colore, double r) {
        super(colore);
        R = r;
    }

    public double getR() {
        return R;
    }

    @Override
    public double Area() {
        return Math.PI*Math.pow(R,2);
    }

    @Override
    public double Perimetro() {
        return Math.PI*R*2;
    }
}
