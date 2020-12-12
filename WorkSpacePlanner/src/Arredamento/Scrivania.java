package Arredamento;

public class Scrivania extends Mobili {
    private  String nome = "SCRIVANIA";
    public Scrivania(int dim_x, int dim_y, int num) {
        super(dim_x, dim_y, num);
    }

    @Override
    public String toString() {
        return super.toString()+"Scrivania "+"Num: "+getNum();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
