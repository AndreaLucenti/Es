package BancaV2;

public class Stipendio extends AbstractAccountable{
    public double imp;
    public Stipendio(double imp) {
        super(Accountabletype.Accredito);
        this.imp = imp;
    }
    public double getImporto(){return imp;}
}
