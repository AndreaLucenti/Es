package BancaV2;

public interface Conto {
     boolean Oper(double Imp);
     String getIban();
     double getSaldo();
     String getCF();
     boolean AddAcc(Accountable acc);
     boolean FineMese();

}
