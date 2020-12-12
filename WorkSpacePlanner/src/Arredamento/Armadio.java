package Arredamento;

public class Armadio extends Mobili {
    private String nome = "ARMADIO";

    public Armadio(int dim_x, int dim_y, int num) {
        super(dim_x, dim_y, num);
    }

    @Override
    public String toString() {
        return super.toString()+"Armadio "+ "Num: "+getNum();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
