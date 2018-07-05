import java.util.ArrayList;

public abstract class Struttura {
    private String Nome;
    private ArrayList<Fisioterapista> fisio;
    private Agenda agenda;

    public Struttura(String nome) {
        this.Nome = nome;
        fisio = new ArrayList<Fisioterapista>();
        this.agenda = new Agenda();

    }

    public abstract boolean check(Prenotazione p);

    public String getNome() {
        return Nome;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public boolean addFisio(Fisioterapista fisioterapista) {

        if (fisio.size() != 0) {
            for (Fisioterapista f: fisio) {
                if (fisioterapista.getCod().equals(f.getCod())){
                    System.out.println("ERR");
                    return false;
                }
            }
        }
        fisio.add(fisioterapista);
        return true;
    }

    @Override
    public String toString() {
        String out = "Struttura:"+"\t"+Nome+"\n";
        for(int i = 0; i < fisio.size(); i++){
            out += fisio.get(i).toString();
        }
        return out;
    }
}
