import Alimenti.Alimento;
import Alimenti.Carne;
import Alimenti.Vino;
import Menu.*;
import Ristoranti.Enoteca;
import Ristoranti.EsRistoraz;
import Ristoranti.Ristorante;

public class Tester {
    public static void main(String[] args) {
        Menu m = new Menu();
        Ristorante R1 = new Ristorante("CICCIO",m);
        Alimento A1 = new Carne("Costata", "Costato", "Vitello");
        R1.Add(A1, 100);
        Alimento A2 = new Carne("Filetto", "Petto", "Maiale");
        R1.Add(A2, 50);
        Alimento A3 = new Vino("Barbera", "Rosso", 12);
        R1.Add(A3, 70);
        System.out.println(R1);


        Menu m2 = new Menu();
        Enoteca E1 = new Enoteca("CIRUZZO", m2);
        Alimento A4 = new Carne("cc", "dd", "franco");
        E1.Add(A4, 400);
        Alimento A5 = new Vino("Barbera", "ROSSO", 15);
        E1.Add(A5, 40);
        System.out.println(E1);




    }
}
