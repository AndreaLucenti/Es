package Alimenti;

public class Carne extends Alimento {
    private String Nome;
    private String Pezzo;
    private String Animale;

    public Carne(String nome, String pezzo, String animale) {
        Nome = nome;
        Pezzo = pezzo;
        Animale = animale;
    }

    @Override
    public String getNome() {
        return Nome;
    }

    public String getPezzo() {
        return Pezzo;
    }

    public String getAnimale() {
        return Animale;
    }
}
