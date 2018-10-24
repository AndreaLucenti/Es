public class Evento {
    private int giorno;
    private int mese;
    private int anno;
    private String data;
    private String descrizioneEvento;

    public Evento(int giorno, int mese, int anno,String descrizioneEvento) {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.descrizioneEvento = descrizioneEvento;
        setData();
    }

    private void setData(){
        data = giorno+"\\"+mese+"\\"+anno;
    }

    public String getDescrizioneEvento() {
        return descrizioneEvento;
    }

    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int getAnno() {
        return anno;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data+"\t"+descrizioneEvento+"\n";
    }
}
