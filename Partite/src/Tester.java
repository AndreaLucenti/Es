import Partite.AbsPartita;
import Partite.PartitaCalcio;

public class Tester {
    public static void main(String[] args) {

        PartitaCalcio c = new PartitaCalcio("Juve", "Roma");
        ReadF r = new ReadF();
        r.lettura("calcio",c);
        System.out.println(c);
    }
}
