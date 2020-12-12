package Arredamento;

public abstract class Mobili {
    private int dim_x, dim_y;
    private int num;

    public Mobili(int dim_x,int dim_y,int num) {
        this.dim_x = dim_x;
        this.dim_y = dim_y;
        this.num = num;
    }

    public int getDim_x() {
        return dim_x;
    }

    public int getDim_y() {
        return dim_y;
    }

    public int getNum() {
        return num;
    }

    abstract String getNome();

//TODO METTERE A POSTO I TO STRING
    @Override
    public String toString() {
        return "Mobili -> ";
    }
}
