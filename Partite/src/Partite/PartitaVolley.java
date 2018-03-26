package Partite;

public class PartitaVolley extends AbsPartita{
    private String NomeCasa;
    private String NomeOspiti;
    private int PuntiCasa;
    private int PuntiOspiti;
    private int Set;
    private int SetCasa;
    private int SetOspiti;
    private int TimeCasa;
    private int TimeOspiti;

    public PartitaVolley(String nomeCasa, String nomeOspiti) {
        NomeCasa = nomeCasa;
        NomeOspiti = nomeOspiti;
    }

    public String getNomeCasa() {
        return NomeCasa;
    }

    public String getNomeOspiti() {
        return NomeOspiti;
    }

    public void setPuntiCasa() {
        PuntiCasa += 1;
    }

    public void setPuntiOspiti() {
        PuntiOspiti += 1;
    }

    public void setSet() {
        Set += 1;
    }

    public void setSetCasa() {
        SetCasa += 1;
    }

    public void setSetOspiti() {
        SetOspiti += 1;
    }

    public void setTimeCasa() {
        TimeCasa += 1;
    }

    public void setTimeOspiti() {
        TimeOspiti += 1;
    }

    @Override
    public String toString() {
        return "Risultato: "+SetCasa+"-"+SetOspiti;
    }
}
