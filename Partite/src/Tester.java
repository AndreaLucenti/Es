import Partite.AbsPartita;
import Partite.PartitaCalcio;
import Partite.PartitaVolley;

public class Tester {
    public static void main(String[] args) {

        PartitaCalcio c = new PartitaCalcio("Juve", "Roma");
        ReadF r = new ReadF();
        r.lettura("calcio",c);

        PartitaVolley v = new PartitaVolley("Pavia", "Milano");
        ReadF r1 = new ReadF();
        r1.lettura("volley", v);

    }
}
