package BancaV2;

import BancaV2.Conti.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Banca {
    private String Iban;
    private Map<String, Conto> conti;
    private String Nome;

    public Banca(String nome) {
        conti = new LinkedHashMap<>();
        Nome = nome;
    }

    public Map<String, Conto> getConti() {
        return conti;
    }

    public Conto AggConto(String cf, ContoType contoType){
        Conto c = null;
        if(contoType.equals(ContoType.ContoCorr)){
            c = new ContoCorr(cf, genIban(), 0);
        }
        if(contoType.equals(ContoType.ContoDep)){
             c = new ContoDep(cf, genIban(), 0);
        }
        if(contoType.equals(ContoType.ContoWeb)){
             c = new ContoWeb(cf, genIban(), 0);
        }
        conti.put(c.getIban(), c);
        return c;
    }

    public String genIban(){
        Iban = "000IT" + Nome+ conti.size();
        return Iban;
    }

    public Boolean Operaz(double Imp, String Iban){
        Conto c = null;
        if(conti.containsKey(Iban)){
            c = conti.get(Iban);
            return c.Oper(Imp);
        }
        return false;
    }

    public boolean LogIn(String cf,String pass, String Iban){
        Conto c = conti.get(Iban);
        if(c instanceof ContoWeb) {
            boolean log = ((ContoWeb) c).Log(cf, pass);
            return log;
        }
        return false;
    }

    public boolean setPass(String pass, String OldPass, String Iban){
        Conto c = conti.get(Iban);
        if(c instanceof  ContoWeb){
            boolean Setpass = ((ContoWeb) c).setPass(pass, OldPass);
            return Setpass;
        }
        return false;
    }

    public double Saldo(String Iban){
        Conto c = conti.get(Iban);
        return c.getSaldo();
    }

    public String toString(String Iban){
        Conto c = conti.get(Iban);
        return c.toString();
    }

    public boolean AddAcc(String Iban, Accountable acc){
        Conto c = null;
        if(conti.containsKey(Iban)){
            c = conti.get(Iban);
            if((acc.getType().equals(Accountabletype.Addebito) && !(c instanceof ContoDep)) || acc.getType().equals(Accountabletype.Accredito)){
                c.AddAcc(acc);
                return true;
            }
        }
        return false;
    }

    public void FineMese(){
        for(Conto c : conti.values()){
            c.FineMese();
        }
    }


}
