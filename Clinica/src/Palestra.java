import java.awt.*;

public class Palestra extends Struttura {
    private String[] Patologie = {"PATO1","PATO4","PATO3"};

    public Palestra(String nome) {
        super(nome);
    }

    public String[] getPatologie() {
        return Patologie;
    }

    public boolean check(Prenotazione p){
        for(int i = 0; i<Patologie.length; i++){
        if(p.getPatologia().equals(Patologie[i])){
            p.setOra(getAgenda().setOra());
            p.setGg(getAgenda().setGiorno());
            getAgenda().addPrenotazione(p);
            return true;}
        }
       return false;
    }

    @Override
    public String toString(){
        String out =  "";
        for(int i = 0;i < Patologie.length; i++){
            out += Patologie[i]+"\t";
        }
        return super.toString()+"Patologie:"+"\t"+out+"\n"+getAgenda().toString()+"\n";
    }
}
