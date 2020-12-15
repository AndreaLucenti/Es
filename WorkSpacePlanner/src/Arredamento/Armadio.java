package Arredamento;

public class Armadio extends Mobili {
    private String nome = "ARMADIO";

    public Armadio(int dim_x, int dim_y, String id) {
        super(dim_x, dim_y, id);
    }

    @Override
    public String toString() {
        return super.toString()+"Armadio "+ "Num: "+getNum();
    }


}
