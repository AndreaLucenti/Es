public class Tester {
    public static void main(String[] args) {

        ImmVect v1 = new ImmVect(10);
        Forma C1 = new Cerchio(Colore.RED, 10);
        Forma Q1 = new Quadrato(Colore.RED, 15);
        Forma Q2 = new Quadrato(Colore.BLACK, 1);
        Forma R1 = new Rettangolo(Colore.YELLOW, 1,2);
        Forma R2 = new Rettangolo(Colore.RED,2,3);



        v1.aggforma(C1);
        v1.aggforma(Q1);
        v1.aggforma(Q2);
        v1.aggforma(R1);
        v1.aggforma(R2);

        v1.OrdinaForme();
        System.out.println(v1);

        System.out.println(v1.aree());
        System.out.println(v1.perim());
        System.out.println(v1.areeC(Colore.YELLOW));
        System.out.println(v1.areeC(Colore.RED));
        System.out.println(v1.perimC(Colore.BLACK));

        int result = C1.compareTo(Q1);
        System.out.println("\ncomparazione =" +result);




    }
}
