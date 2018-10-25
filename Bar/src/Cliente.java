import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cognome;
    private String id;
    private String pass;
    private ArrayList<Bar> preferiti;
    private boolean loggedin = false;

    public Cliente(String nome, String cognome, String id, String pass) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.pass = pass;
        this.preferiti = new ArrayList<Bar>();

    }

    public boolean loadPref(Bar bar){
        preferiti.add(bar);
        return true;
    }

    public boolean addPref(Bar bar){
        if(preferiti.size() != 0){
            for (Bar br : preferiti){
                if(br.getId().equals(bar.getId())){
                    return false;
                }
            }
        }
        preferiti.add(bar);
        GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
        gestioneFile.writeFile(bar.getId());
        return true;
    }

    public boolean remPref(Bar bar){
        if(preferiti.size() != 0){
            for (Bar br: preferiti){
                if(br.getId().equals(bar.getId())){
                    preferiti.remove(br);
                    GestioneFile gestioneFile = new GestioneFile("src/FILETXT/"+id+".txt");
                    gestioneFile.remRow(br.getId());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean setPass(String pass, String Oldpass){
        if(this.pass != pass && Oldpass == this.pass){
            this.pass = pass;
            return true;
        }
        return false;
    }

    public boolean Log(String id, String pass){
        if(this.id.equals(id) && this.pass.equals(pass)){
            loggedin = true;
            return loggedin = true;
        }
        return loggedin = false;
    }

    public String clienteDati(){
        String out;
        out = nome+"\t"+cognome+"\t"+id+"\t"+pass;
        return out;
    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public ArrayList<Bar> getPreferiti() {
        return preferiti;
    }
}
