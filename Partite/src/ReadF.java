import Eventi.EventiCalcio;
import Eventi.EventiVolley;
import Partite.AbsPartita;
import Partite.PartitaCalcio;
import Partite.PartitaVolley;

import javax.imageio.IIOException;
import java.io.*;

public class ReadF {
    private PartitaCalcio Pc;
    private PartitaVolley Pv;

    public void lettura(String nome, AbsPartita A){


        File f = new File(nome+".txt");
        try{
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            if(PoV(br)){
                Pc = new PartitaCalcio(A.getNomeCasa(), A.getNomeOspiti());
            }
            else{
                Pv = new PartitaVolley(A.getNomeCasa(), A.getNomeOspiti());
            }
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

    public boolean PoV(BufferedReader br){
        try{
            String Line = br.readLine();
            String[] LineSplit = Line.split("\t");
            if(LineSplit[0].charAt(0) == 'C'){
                return true;
            }
        }catch (IOException e){}
        return false;
    }
}
