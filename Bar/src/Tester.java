import Bevande.Bevanda;
import Bevande.Bibita;
import Bevande.Birra;

public class Tester {
    public static void main(String[] args) {
        Utente utente = new Utente();
        utente.readBar();
        utente.readCliente();
        TextInput textInput = new TextInput(utente);

//       utente.newBar("Borgo","Viale Bligny","B", "b1");
//        utente.newBar("b","vl","BRGCALV");
//
//        Bevanda bevanda1 = new Birra("Pils", 5, 4.5);
//        Bevanda bevanda2 = new Bibita("Coca", 1);
//
//        Menu menu1 = new Menu();
//        menu1.addBevanda(bevanda1);
//        menu1.addBevanda(bevanda2);
//        Evento evento1 = new Evento(10,8,2018, "Party Hard");
//
//        utente.getBar("Borgo").addEventi(evento1);
//       utente.getBar("Borgo").addMenu(menu1);
//

        textInput.TextualInput();
        //System.out.println("\n"+utente);
    }
}
