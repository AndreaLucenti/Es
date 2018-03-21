public class Tester {
    public static void main(String[] args) {
        Banca b = new Banca("SS", 10);
        Conto c = new Conto("iiii", "lcnndr");
        b.AggConto(c);

        System.out.println(b.getConti());

    }
}
