package Arredamento;

public class Libreria extends Mobili{
    private String nome = "LIBRERIA";

    public Libreria(int dim_x, int dim_y, int num) {
        super(dim_x, dim_y, num);
    }

    @Override
    public String toString() {
        return  super.toString()+"Libreria"+ "Num: "+getNum();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
