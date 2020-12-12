package Arredamento;

public class Cassettiera extends Mobili{
    private String nome = "CASSETTIERA";

    public Cassettiera(int dim_x, int dim_y, int num) {
        super(dim_x, dim_y, num);
    }

    @Override
    public String toString() {
        return  super.toString()+"Cassettiera "+"Num: "+getNum();
    }

    public String getNome() {
        return nome;
    }
}
