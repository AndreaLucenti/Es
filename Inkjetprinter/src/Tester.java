import java.util.Arrays;

public class Tester {


    public static void main(String[] args) {
       ImgVect v1[] = new ImgVect[3];

        for(int i= 0; i < 3; i++){
            v1[i] = new ImgVect(10);
        }


        v1[0].aggforma(new Quadrato(Colore.BLACK,1));
        v1[0].aggforma(new Quadrato(Colore.YELLOW,1));
        v1[1].aggforma(new Quadrato(Colore.BLACK,3));
        v1[1].aggforma(new Cerchio(Colore.BLUE, 2));
        v1[1].aggforma(new Cerchio(Colore.YELLOW, 2));
        v1[2].aggforma(new Rettangolo(Colore.RED, 1,2));
        v1[2].aggforma(new Rettangolo(Colore.BLUE,2,5));

        //System.out.println(v1[0].SommAree());

        //System.out.println(v1[0].SommAreeC(Colore.BLACK));

        Arrays.sort(v1);

        for(ImgVect img : v1) {
            System.out.println(String.format("%.2f",img.SommAree()));
        }
    }
}
