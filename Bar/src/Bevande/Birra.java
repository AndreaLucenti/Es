package Bevande;

public class Birra extends Bevanda{
    private double gradazione;

    public Birra(String nome, double prezzo, double gradazione, String type){
        super(nome, prezzo, type);
        this.gradazione = gradazione;
    }

    public double getGradazione() {
        return gradazione;
    }

    @Override
    public String toString() {
        return super.toString()+"\t"+gradazione;
    }
}
