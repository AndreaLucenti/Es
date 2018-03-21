package BancaV2;

public class AbbonamentoSky extends AbstractAccountable {
    public AbbonamentoSky() {
        super(Accountabletype.Addebito);
    }
    public double getImporto(){
        double importo = 50;
        return -importo;
    }
}
