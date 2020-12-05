package Arredamento;

public abstract class Mobili {
    private double dim_x, dim_y;
    private int num;

    public Mobili(double dim_x,double dim_y,int num) {
        this.dim_x = dim_x;
        this.dim_y = dim_y;
        this.num = num;
    }

    public double getDim_x() {
        return dim_x;
    }

    public double getDim_y() {
        return dim_y;
    }

    public int getNum() {
        return num;
    }
}
