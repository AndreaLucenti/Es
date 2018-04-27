import java.util.Random;

public class Sensori {
    private String ID;
    private AB type;
    private String tipoMis;
    double risultato;
    private double MaxValue, MinValue;
    private String UnitMis;

    public Sensori(String ID, AB type, ) {
        this.ID = ID;
        this.type = type;
        this.tipoMis = tipoMis;

    }

    public boolean lettura(){
            Random random = new Random();
            switch (type) {
                case A:
                    risultato = random.nextInt(40);
                    return true;
                case B:
                    risultato = random.nextInt(2);
                    return true;
            }
            return false;
    }

    public double getRisultato() {
        return risultato;
    }

    private void genVal(double MaxValue,double MinValue, String UnitMis){
        this.MaxValue = MaxValue;
        this.MinValue = MinValue;
        this.UnitMis = UnitMis;
    }

}
