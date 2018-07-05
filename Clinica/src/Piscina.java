public class Piscina extends Struttura {
    private String[] Patologie = {"PATO2","PATO8","PATO9", "PATO6"};

    public Piscina(String nome) {
        super(nome);
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
    public String toString() {
        String out =  "";
        for(int i = 0;i < Patologie.length; i++){
            out += Patologie[i]+"\t";
        }
        return super.toString()+"Patologie:"+"\t"+out+"\n"+getAgenda().toString()+"\n";    }
}
