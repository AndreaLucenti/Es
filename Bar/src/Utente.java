import java.util.*;

public class Utente {
   private ArrayList<Bar> bars;
   private ArrayList<Cliente> clienti;

    public Utente() {
        this.bars = new ArrayList<Bar>();
        this.clienti = new ArrayList<Cliente>();
    }

    public boolean newBar(String nome, String ubicazione, String id, String pass){
        if(bars.size()!=0)
        for (Bar br: bars){
            if(br.getId().equals(id) || br.getNome().equals(nome)){
                return false;
            }
        }
        Bar bar = new Bar(ubicazione, nome, id);
        bar.setPass(pass, "Password");
        bars.add(bar);
        return true;
    }

    public boolean newCliente(String nome, String cognome,String id, String pass){
        if(clienti.size()!=0)
            for (Cliente cl: clienti){
                if(cl.getId().equals(id)){
                    return false;
                }
            }
        Cliente cliente = new Cliente(nome, cognome, id);
        cliente.setPass(pass, "Password");
        clienti.add(cliente);
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (Bar br: bars){
            out = br.toString()+"\n";
        }
        return out;
    }

    public Bar getBar(String nome) {
        for (Bar br:bars){
            if(br.getNome().equals(nome)){
                return br;
            }
        }
        return null;
    }
    public Bar checkIdBar(String id){
        for (Bar br:bars){
            if(br.getId().equals(id)){
                return br;
            }
        }
        return null;
    }

    public Bar checkIdCliente(String id){
        for (Bar br:bars){
            if(br.getId().equals(id)){
                return br;
            }
        }
        return null;
    }
}
