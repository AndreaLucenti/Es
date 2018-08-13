import java.io.*;

public class AgendaReader {
    private String[] LineSplit;
    public void lettura(Struttura str) {
        File file = new File("prenotazioni.txt");
        try {
            FileReader r = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(r);
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                LineSplit = line.split("\t");
                Prenotazione p = new Prenotazione(LineSplit[0],LineSplit[1],LineSplit[2]);
                str.check(p);

            }
        }catch (FileNotFoundException f){}
        catch (IOException i){};
    }

    public String[] getLineSplit() {
        return LineSplit;
    }
}
