package Arredamento;

public class Sedia extends Mobili{
    private String nome = "SEDIA";

    public Sedia(int dim_x, int dim_y) {
        super(dim_x, dim_y);
    }

    @Override
    public String toString() {
        return super.toString()+"Sedia "+"Num: "+getNum();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
