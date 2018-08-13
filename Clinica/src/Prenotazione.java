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

    public String getGg() {
        return gg;
    }

    public String getOra() {
        return ora;
    }

    public String getNome() {

        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return nome+"\t"+cognome+"\t"+patologia+"\t"+ora+"\t"+gg+"\n";
    }
}
