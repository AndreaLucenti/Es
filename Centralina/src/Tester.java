public class Tester {
    public static void main(String[] args) {
        Sensori[] s = new Sensori[5];

        s[0]= new Sensori("0001", AB.A, "Temperatura");
        s[1] = new Sensori("0002", AB.A, "Umidità");
        s[2] = new Sensori("0003", AB.B, "Apertura Finestre");
        s[3] = new Sensori("0004", AB.B, "Allarme Perimetro");
        s[4] = new Sensori("0005", AB.B, "Presenza Fumo");

        Porta[] p = new Porta[10];

        p[0] = new Porta("00001", AB.A);
        p[1] = new Porta("00002", AB.A);
        p[2] = new Porta("00003", AB.B);
        p[3] = new Porta("00004", AB.B);
        p[4] = new Porta("00005", AB.B);

        Centralina c = new Centralina(p, "467426093", s);
        c.genMap();
        c.richLett();

    }
}
