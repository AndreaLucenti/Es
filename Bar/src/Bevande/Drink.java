package Bevande;

public class Drink extends Bevanda{
    private double gradazione;

    public Drink(String nome, double prezzo, double gradazione){
        super(nome, prezzo);
        this.gradazione = gradazione;
    }

    public String toString() {
        return super.toString()+"\t"+gradazione+"%";
    }
}
