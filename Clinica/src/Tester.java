public class Tester {
    public static void main(String[] args) {

        AgendaReader agendaReader = new AgendaReader();

        Clinica clinica = new Clinica("Mondino");
        Struttura struttura1 = new Piscina("Piscina");
        Struttura struttura3 = new Massaggi("Massaggi");
        Struttura struttura2 = new Palestra("Palestra");

        agendaReader.lettura(struttura1);
        agendaReader.lettura(struttura3);
        agendaReader.lettura(struttura2);

        clinica.addStruttura(struttura1);
        clinica.addStruttura(struttura3);
        clinica.addStruttura(struttura2);

        Fisioterapista f1 = new Fisioterapista("Mladen","Jurkic");
        Fisioterapista f3 = new Fisioterapista("Massimiliano","Rapetti");
        Fisioterapista f2 = new Fisioterapista("Dario","Maestri");
        Fisioterapista f4 = new Fisioterapista("Andrea","Lucenti");
        struttura1.addFisio(f1);
        struttura2.addFisio(f2);
        struttura3.addFisio(f3);
        struttura3.addFisio(f4);

        System.out.println(clinica);
    }
}
