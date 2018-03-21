import java.util.Arrays;

public class TestPrinter {
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

        Arrays.sort(v1);

        InkJetPrinter ink = new InkJetPrinter(100);

        ink.CheckCart();

        for(int i = 0; i < v1.length; i++) {
            System.out.println(ink.CheckPrint(v1[i]));

            if(ink.CheckPrint(v1[i])){
                ink.Print(v1[i]);
            }
        }

        ink.CheckCart();


    }
}
