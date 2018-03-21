package BancaV2.Conti;

public class ContoDep extends AbsConto {
    public ContoDep(String CF, String iban, double saldo) {
        super(CF, iban, saldo);
    }

    public boolean Oper(double imp){
        if(imp > 0){
            return super.Oper(imp);
        }
        else return false;
    }
}

