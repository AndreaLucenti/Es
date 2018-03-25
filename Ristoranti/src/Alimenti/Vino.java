package Alimenti;

public class Vino extends Alimento {
    private String Nome;
    private String Colore;
    private double Grad;


    public Vino(String nome, String colore, double grad) {
        Nome = nome;
        Colore = colore;
        Grad = grad;

    }

    public String getNome() {
        return Nome;
    }

    public String getColore() {
        return Colore;
    }

    public double getGrad() {
        return Grad;
    }

    @Override
    public String toString() {
        return "\nNome: " +getNome()+ "\nColore: "+ getColore() +"\nGradazione: : "+getGrad() ;
    }
}
