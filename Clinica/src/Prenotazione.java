public class Prenotazione {
    private String nome;
    private String cognome;
    private String patologia;
    private String gg;
    private String ora;

    public Prenotazione(String nome, String cognome, String patologia) {
        this.nome = nome;
        this.cognome = cognome;
        this.patologia = patologia;
        this.ora = ora;
        this.gg = gg;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    @Override
    public String toString() {
        return nome+"\t"+cognome+"\t"+patologia+"\t"+ora+"\t"+gg+"\n";
    }
}
