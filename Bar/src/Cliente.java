import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cognome;
    private String id;
    private String pass;
    private ArrayList<Bar> preferiti;
    private boolean loggedin = false;
    private boolean Flogg = true;

    public Cliente(String nome, String cognome, String id) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        pass = "Password";

    }
//TODO Mettere a posto il passaggio del bar per i preferiti magari tramite gli utenti
    public boolean addRemPref(Bar bar){
        if(preferiti.size() != 0){
            for (Bar br : preferiti){
                if(br.getNome().equals(bar.getNome())){
                    preferiti.remove(bar);
                    return false;
                }
            }
        }
        preferiti.add(bar);
        return true;
    }

    public String getId() {
        return id;
    }

    public boolean setPass(String pass, String Oldpass){
        if(this.pass != pass && Oldpass == this.pass){
            this.pass = pass;
            Flogg = false;
            return true;
        }
        return false;
    }

    public boolean Log(String id, String pass){
        if(this.id.equals(id) && this.pass.equals(pass) && !Flogg){
            loggedin = true;
            return loggedin = true;
        }
        return loggedin = false;
    }
}
