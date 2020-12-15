package Arredamento;

public class Sedia extends Mobili{
    private String nome = "SEDIA";

    public Sedia(int dim_x, int dim_y, String id) {
        super(dim_x, dim_y, id);
    }

    @Override
    public String toString() {
        return super.toString()+"Sedia "+"Num: "+getNum();
    }

}
