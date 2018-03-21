public class Banca {
    private String Nome;
    private int Nmax;
    private Conto[] conti;
    private int Nconti = 0;
    private String RadIban;

    public Banca(String nome, int nmax) {
        Nome = nome;
        Nmax = nmax;
        conti = new Conto[Nmax];
    }

    public Conto[] getConti() {
        return conti;
    }

    public Conto AggConto(Conto c) {
        if(Nconti < Nmax){
            conti[Nconti] = c;
            return c;
        }
        return null;
    }



}
