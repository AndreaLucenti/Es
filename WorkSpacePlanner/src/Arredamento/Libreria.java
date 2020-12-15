package Arredamento;

public class Libreria extends Mobili{
    private String nome = "LIBRERIA";

    public Libreria(int dim_x, int dim_y, String id) {
        super(dim_x, dim_y, id);
    }

    @Override
    public String toString() {
        return  super.toString()+"Libreria "+ "Num: "+getNum();
    }


}
