package Bevande;

public class Birra extends Bevanda{
    private double gradazione;

    public Birra(String nome, double prezzo, double gradazione){
        super(nome, prezzo);
        this.gradazione = gradazione;
    }

    @Override
    public String toString() {
        return super.toString()+"\t"+gradazione+"%";
    }
}
