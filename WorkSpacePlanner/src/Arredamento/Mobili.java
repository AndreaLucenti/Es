package Arredamento;

public abstract class Mobili {
    private int dim_x, dim_y;
    private int num = 0;
    private String id;

    public Mobili(int dim_x,int dim_y, String id) {
        this.dim_x = dim_x;
        this.dim_y = dim_y;
        this.id = id;
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

    public String getId() {
        return id;
    }

    /**
    * Incrementa il numero dei mobili presenti
     * @param num numero da sommare
    * **/
    public void setNum(int num){
        this.num += num;
    }

//TODO METTERE A POSTO I TO STRING
    @Override
    public String toString() {
        return "";
    }
}
