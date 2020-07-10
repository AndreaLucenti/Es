package Bevande;

public class Drink extends Bevanda{
    private double gradazione;

    public Drink(String nome, double prezzo, double gradazione, String type){
        super(nome, prezzo, type, gradazione);
        this.gradazione = gradazione;
    }

    public double getGradazione() {
        return gradazione;
    }

    public String toString() {
        return super.toString()+"\t"+gradazione;
    }
}
