package BancaV2;

import BancaV2.Conti.ContoType;

public class Tester {
    public static void main(String[] args) {
        Banca b = new Banca("MONTEPASCHI");
        Accountable s = new Stipendio(100);
        Accountable d = new AbbonamentoSky();

        b.AggConto("Lcnndr", ContoType.ContoCorr);
        b.AggConto("Lddrft", ContoType.ContoCorr);
        b.AggConto("MLJRK", ContoType.ContoWeb);
        b.AggConto("DRMSTR", ContoType.ContoDep);

        b.AddAcc("000ITMONTEPASCHI2", s);
        b.AddAcc("000ITMONTEPASCHI2", d);


        b.setPass("STOCA", "changename", "000ITMONTEPASCHI2");
        b.LogIn("MLJRK", "STOCA","000ITMONTEPASCHI2");
        System.out.println(b.Operaz(+200, "000ITMONTEPASCHI2"));
        System.out.println(b.Operaz(-100, "000ITMONTEPASCHI2"));
        System.out.println("SALDO: "+b.Saldo("000ITMONTEPASCHI2"));
        b.FineMese();
        System.out.println(b.toString("000ITMONTEPASCHI2"));



    }
}
