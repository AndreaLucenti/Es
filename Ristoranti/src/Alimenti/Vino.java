package Alimenti;

public class Vino extends Alimento {
    private String Nome;
    private String Colore;
    private double Grad;
    private String Tipo;


    public Vino(String nome, String colore, double grad, String tipo) {
        Nome = nome;
        Colore = colore;
        Grad = grad;
        Tipo = tipo;

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

    public String getTipo() {
        return Tipo;
    }

    @Override
    public String toString() {
        return "\nNome: " +getNome()+ "\nColore: "+ getColore() +"\nGradazione: "+getGrad() +"\nTipo: "+getTipo() ;
    }
}
