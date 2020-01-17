import Bevande.Bevanda;
import Bevande.Bibita;
import Bevande.Birra;

public class Tester {
    public static void main(String[] args) {
        Utente utente = new Utente();
        utente.readBar();
        utente.readCliente();
        TextInput textInput = new TextInput(utente);

        textInput.TextualInput();

    }
}
