package Bevande;

public abstract class Bevanda {
    private String nome;
    private double prezzo;

    public Bevanda(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome+"\t"+prezzo;
    }
}
