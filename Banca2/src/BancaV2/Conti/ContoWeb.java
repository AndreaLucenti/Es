package BancaV2.Conti;

public class ContoWeb extends ContoCorr{
    private String pass = "changename";
    private boolean loggedin = false;
    private boolean Flogg = true;

    public ContoWeb(String CF, String iban, double saldo) {
        super(CF, iban, saldo);
    }

    @Override
    public boolean Oper(double imp) {
        if(!loggedin){
            System.out.println("Loggare");
            return false;
        }
        return super.Oper(imp);
    }

    public boolean setPass(String pass, String Oldpass){
        if(this.pass != pass && Oldpass == this.pass){
            this.pass = pass;
            Flogg = false;
            return true;
        }
        return false;
    }

    public boolean Log(String cf, String pass){
        if(super.getCF() == cf && this.pass == pass && !Flogg){
            loggedin = true;
            return loggedin = true;
        }
        return loggedin = false;
    }


}
