import Alimenti.Alimento;
import Alimenti.Carne;
import Alimenti.Vino;
import Menu.Menu;
import Menu.ElementoMenu;


import java.io.*;

import java.io.IOException;

public class ReaderF {
    private Menu m;

    public ReaderF(Menu m) {
        this.m = m;
    }

    public void Lettura() {

        File f = new File("menu1.txt");
        try {
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while (br.ready()){
                String Line = br.readLine();
                String[] LineSplit = Line.split("\t");

                switch(Integer.parseInt(LineSplit[0])){

                    case 0:
                        Alimento carne = new Carne(LineSplit[1], LineSplit[3], LineSplit[2]);
                        ElementoMenu e1 = new ElementoMenu(Double.parseDouble(LineSplit[4]), carne);
                        m.AddEl(e1);
                        break;

                    case 1:
                        Vino vino = new Vino(LineSplit[1], LineSplit[4], Double.parseDouble(LineSplit[2]), LineSplit[3]);
                        ElementoMenu e2 = new ElementoMenu(Double.parseDouble(LineSplit[5]), vino);
                        m.AddEl(e2);
                        break;
                }

            }

        }
        catch (FileNotFoundException e){
            System.out.println("err2");
        }
        catch (IOException e) {
            System.out.println("err1");
        }
    }

    public Menu getM() {
        return m;
    }
}
