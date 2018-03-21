import Alimenti.Alimento;
import Alimenti.Carne;
import Menu.*;
import Ristoranti.EsRistoraz;
import Ristoranti.Ristorante;

public class Tester {
    public static void main(String[] args) {
        Menu m = new Menu();
        Ristorante R1 = new Ristorante("CICCIO",m);
        Alimento A1 = new Carne("Costata", "Costato", "Vitello");
        ElementoMenu EM1 = new ElementoMenu(100, A1);
        R1.Add(EM1);
    }
}
