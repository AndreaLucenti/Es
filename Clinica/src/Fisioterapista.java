public class Fisioterapista {
    String Nome;
    String Cognome;
    String Cod;
    private static  int numFis = 1;
    public Fisioterapista(String nome, String cognome) {
        Nome = nome;
        Cognome = cognome;
        Cod = "Cod" + numFis++;
    }

    public String getCod() {
        return Cod;
    }

    @Override
    public String toString() {
        return "Fisioterapista:"+"\t"+Nome+"\t"+Cognome+"\t"+Cod+"\n";
    }
}
