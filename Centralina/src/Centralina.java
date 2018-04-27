import java.util.HashMap;
import java.util.Map;

public class Centralina {
    private Porta[] porte;
    private String NumTel;
    private Sensori[] sensori;

    private HashMap<Porta,Sensori> coppie;

    public Centralina(Porta[] porte, String numTel, Sensori[] sensori) {
        this.porte = porte;
        NumTel = numTel;
        this.sensori = sensori;
        this.coppie = new HashMap<>();
    }

    public void richLett (){
        for(int i = 0 ; i < 5; i++){
            coppie.get(porte[i]).lettura();
            System.out.println(coppie.get(porte[i]).getRisultato());
        }

    }

    public void genMap(){
        for(int i = 0; i < 5; i++){
            coppie.put(porte[i], sensori[i]);
        }
    }

    public void genVal(){


    }
}
