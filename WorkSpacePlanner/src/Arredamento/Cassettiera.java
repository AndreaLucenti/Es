package Arredamento;

public class Cassettiera extends Mobili{
    private String nome = "CASSETTIERA";

    public Cassettiera(int dim_x, int dim_y,String id) {
        super(dim_x, dim_y, id);
    }

    @Override
    public String toString() {
        return  super.toString()+"Cassettiera "+"Num: "+getNum();
    }

}
