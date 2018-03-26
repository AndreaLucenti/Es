import Eventi.EventiCalcio;
import Eventi.EventiVolley;
import Partite.AbsPartita;
import Partite.PartitaCalcio;
import Partite.PartitaVolley;

import javax.imageio.IIOException;
import java.io.*;

public class ReadF {

    private PartitaVolley Pv;
    public void lettura(String nome, PartitaCalcio Pc){
        File f = new File(nome+".txt");
        try{
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while(br.ready()){
                String Line = br.readLine();
                String[] LineSplit = Line.split("\t");
                switch (LineSplit[0].charAt(0)){
                    case 'C':
                        EventiCalcio c = new EventiCalcio();
                        c.Eventi(LineSplit[0], Pc);
                        break;
                    case  'V':
                        EventiVolley v = new EventiVolley();
                        v.Eventi(LineSplit[0], Pv);
                        break;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("err1");
        }catch (IOException e){
            System.out.println("err2");
        }
    }
}
