package BancaV2.Conti;

import BancaV2.*;

import java.util.ArrayList;

public abstract class AbsConto implements Conto {
    private String CF;
    private String Iban;
    private double saldo;
    private ArrayList<Accountable> acc;


    public AbsConto(String CF, String iban, double saldo) {
        this.CF = CF;
        Iban = iban;
        this.saldo = saldo;
        this.acc = new ArrayList<>();
    }

    public String getCF() {
        return CF;
    }

    public String getIban() {
        return Iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean Oper(double imp){
        if(imp > 0){
            saldo += imp;
            return true;
        }
        else if(imp < 0 && Math.abs(imp) <= saldo){
            saldo += imp;
            return true;
        }
        return false;
    }

    public boolean AddAcc(Accountable acc){
        if(!this.acc.contains(acc)){
        this.acc.add(acc);
        return true;}
        return false;
    }

    public boolean FineMese(){
        for(Accountable acc1 : acc){
            double importo = acc1.getImporto();
            boolean esito = Oper(importo);
            if(esito == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"\nCF : " +getCF()+"\nIBAN : "+getIban()+"\nSALDO :"+getSaldo();
    }
}

