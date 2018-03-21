public class Cerchio extends Forma {

    double raggio;

    public Cerchio(Colore colore, double raggio) {
        super(colore);
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public double Area(){
        double area = Math.PI*Math.pow(raggio, 2);
        return area;
    }

    public double Perimetro(){
        double per = Math.PI*2*raggio;
        return per;
    }

    @Override
    public String toString() {
        return super.toString() + " Raggio = "+this.raggio+ "\n";
    }
}
