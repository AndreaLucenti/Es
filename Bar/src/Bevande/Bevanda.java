package Bevande;

public abstract class Bevanda {
    private String nome;
    private double prezzo;
    private String type;

    public Bevanda(String nome, double prezzo, String type) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.type = type;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getType() { return type; }

    @Override
    public String toString() {
        return type+"\t"+nome+"\t"+prezzo;
    }
}
