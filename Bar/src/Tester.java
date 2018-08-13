import Bevande.Bevanda;
import Bevande.Birra;

public class Tester {
    public static void main(String[] args) {
        Bevanda bevanda1 = new Birra("Pils", 5, 4.5);
        Menu menu1 = new Menu();
        Bar bar1 = new Bar(menu1,"Viale Bligny 77", "Borgo Calvenzano");
        Elenco elenco = new Elenco();

        menu1.addBevanda(bevanda1);
        elenco.addBer(bar1);
        System.out.println(elenco);
    }
}
