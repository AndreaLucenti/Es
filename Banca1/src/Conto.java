public class Conto{
    private String Iban;
    private String Cf;
    private double Saldo;

    public Conto(String iban, String cf) {
        Iban = iban;
        Cf = cf;
        Saldo = 0;
    }

    public double getSaldo() {
        return Saldo;
    }

    public String getIban() {
        return Iban;
    }

    public String getCf() {
        return Cf;
    }

    public boolean Prelievo(double Imp){
        if(Imp <= Saldo && Imp > 0){
            Saldo = Saldo - Imp;
            return true;
        }
        return false;
    }

    public boolean Deposito(double Imp){
        if(Imp > 0){
            Saldo = Saldo + Imp;
            return true;
        }
        return false;
    }

}