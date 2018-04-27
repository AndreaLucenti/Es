public class Porta {
    private String ID;
    private AB Tipo;

    public Porta(String ID, AB tipo) {
        this.ID = ID;
        Tipo = tipo;
    }

    public String getID() {
        return ID;
    }

    public AB getTipo() {
        return Tipo;
    }
}
