package Bevande;

public abstract class Bevanda {
    private String nome;
    private double prezzo;
    private String type;
    private double grad;

    public Bevanda(String nome, double prezzo, String type, double grad) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.type = type;
        this.grad = grad;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getType() { return type; }

    public double getGrad() {
        return grad;
    }

    @Override
    public String toString() {
        return type+"\t"+nome+"\t"+prezzo;
    }
}
