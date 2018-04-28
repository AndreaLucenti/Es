package Partite;

public class PartitaCalcio extends AbsPartita{
    private String NomeCasa;
    private String NomeOspiti;
    private int GolCasa;
    private int GolOspiti;
    private int Tempo;

    public PartitaCalcio(String nomeCasa, String nomeOspiti) {
        NomeCasa = nomeCasa;
        NomeOspiti = nomeOspiti;

    }

    public String getNomeCasa() {
        return NomeCasa;
    }

    public String getNomeOspiti() {
        return NomeOspiti;
    }

    public int getGolCasa() {
        return GolCasa;
    }

    public int getGolOspiti() {
        return GolOspiti;
    }

    public int getTempo() {
        return Tempo;
    }

    public void setGolCasa() {
        GolCasa += 1;
    }

    public void setGolOspiti() {
        GolOspiti += 1;
    }

    public void setTempo(int tempo) {
        Tempo = tempo;
    }

    @Override
    public String toString() {
        return "Risultato: "+GolCasa+"-"+GolOspiti;
    }
}
