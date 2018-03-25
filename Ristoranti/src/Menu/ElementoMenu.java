package Menu;
import Alimenti.*;

public class ElementoMenu {
    private double prezzo;
    private Alimento a;

    public ElementoMenu(double prezzo, Alimento a) {
        this.prezzo = prezzo;
        this.a = a;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Alimento getAlimento() {
        return a;
    }

    @Override
    public String toString() {
        return a +"\nPrezzo: "+prezzo+"\n";
    }
}
