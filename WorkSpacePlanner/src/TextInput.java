import Arredamento.*;
import BHO.Porta;
import BHO.Vincoli;
import BHO.Finestra;
import BHO.Termosifone;
import SetRoom.Room;
import SetRoom.SalaRiunioni;
import SetRoom.UfficioSingolo;
import SetRoom.Utilizzo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TextInput {
    private Room room;
    private ArrayList<Mobili> mobili;

    public TextInput(Room room) {
        this.room = room;
        mobili = new ArrayList<Mobili>();

    }

    public void TextualIn() {
        lettFile();

        String input;
        String[] splitted;
        System.out.println("[INSERIRE SCALA RAPPRESENTAZIONE]");
        input = keyboard();
        splitted = input.split("\\s");
        room.SetScala(Integer.parseInt(splitted[0]));

        Dim();
        Vincoli();
        Util();


    }
    /**FUNZIONE PER SELEZIONARE L?UTILIZZO DELLA STANZA**/

    public void Util(){
        String input;
        String[] splitted;

        System.out.println("[SELEZIONARE UTILIZZO]\n[SALA RIUNIONI - UFFICIO SINGOLO]");
        input = keyboard();
        splitted = input.split("\\s");

        switch (input) {
            case "1":
                Utilizzo salaR = new SalaRiunioni();
                room.setUtilizzo(salaR);
                ImportPreSet();
                break;
            case "2":
                Utilizzo uffS = new UfficioSingolo();
                room.setUtilizzo(uffS);
                ImportPreSet();
                break;
        }
    }
    // TODO SISTEMARE CICLI IF
    public void ImportPreSet(){
        System.out.println("[1 PER IMPORTARE IL PRE-SET DEI MOBILI]");
        String input = keyboard();
        String[] splitted = input.split("\\s");

        if (!splitted[0].isEmpty() && splitted.length == 1){

            if(splitted[0].equals("1")){
                room.addPreSet();
                System.out.println("[1 PER AGGIUNGERE ALTRI MOBILI]");
                input = keyboard();
                splitted = input.split("\\s");

                if(splitted[0].equals("1")){
                    Mob();
                }
            }
            else{
                Mob();
            }

        }
        else{
            System.out.println("ERRORE");
        }
    }

    /**
    * DIMENSIONI LATI STANZA
    * **/
    public void Dim(){
        String input;
        int check = 0;

        String[] splitted;
        System.out.println("[INSERIRE DIMENSIONI LATI STANZA (in metri)]");
        input = keyboard();
        splitted = input.split("\\s");

        for(int i = 0; i < splitted.length; i++) {
            if (Double.parseDouble(splitted[i]) >= 2 && splitted.length == 4) {
            }
            else if(splitted.length != 4){
                System.out.println("[INSERIRE TUTE LE DIMENSIONI]");
                check = 1;
            }
            else if (Double.parseDouble(splitted[i]) < 2){
                System.out.println("[VALORE "+(i+1)+" NON ACCETTABILE]");
                check = 1;
            }
        }

        if(check != 1) {
            room.SetDimension(splitted);
        }else{
            Dim();
        }
    }



    /**
     // VINCOLI PER I LATI LASCIARE VUOTO SE NON CI SONO
     **/
    public void Vincoli(){
        String input;
        String[] splitted;

        System.out.println("[INSERIRE PER LATO I VINCOLI E LE DIMENSIONI]");
        int i =0;
        for(i = 0; i < 4; i++) {
            System.out.println("[INSERIRE PER IL LATO "+(i+1)+" I VINCOLI]\n(FINESTRA TERMOSIFONE PORTA)\t(LASCIARE VUOTO SE NON CI SONO)");
            input = keyboard();
            splitted = input.split("\\s");

            if(splitted[0].isEmpty()){
            }
            else{
                for (int j = 0; j < splitted.length; j += 2){
                    if((splitted.length % 2) != 0){
                        System.out.println("[MANCANZA DIMENSIONI]");
                        i -=1 ;
                        break;
                    }

                    switch (splitted[i]){
                        case "1":
                            Vincoli finestra = new Finestra((i+1),Integer.parseInt(splitted[j+1]));
                            room.setVin(finestra);
                            break;

                        case "2":
                            Vincoli termosifone = new Termosifone((i+1),Integer.parseInt(splitted[j+1]));
                            room.setVin(termosifone);
                            break;

                        case "3":
                            Vincoli porta = new Porta((i+1), Integer.parseInt(splitted[j+1]));
                            room.setVin(porta);
                            break;
                    }

                }
            }
        }

    }

    /**
     // MOBILI PER LA STANZA
     **/
    // TODO CONTROLLARE SE VA BENE L'ADDIZIONE DEL NUMERO E PERCHE AGGIUNGE NUOVI MOBILI
    public void Mob(){
            String input;
            String[] splitted;

            System.out.println("[INSERIRE I MOBILI DESIDERATI E IL NUMERO]\n"); //(TAVOLO ARMADIO CASSETTIERA LIBRERIA)**/");

            for(int i = 0; i < mobili.size(); i++){
                System.out.println(i+1+") "+mobili.get(i));
            }

            input = keyboard();
            splitted = input.split("\\s");
            int i = Integer.parseInt(splitted[0])-1;

           if(!splitted[0].isEmpty() && splitted.length == 2) {
                if (Double.parseDouble(splitted[0]) <= 0 || Double.parseDouble(splitted[1]) <= 0) {
                    System.out.println("ERRORE DATI INSERITI");
                }else {
                    if(room.checkMob(mobili.get(i).getNome(), Integer.parseInt(splitted[1])) == 1) {
                    }
                    else{
                        switch (mobili.get(i).getClass().getSimpleName()) {
                            case "Armadio":
                                Mobili armadio = new Armadio(mobili.get(i).getDim_x(), mobili.get(i).getDim_y());
                                armadio.setNum(Integer.parseInt(splitted[1]));
                                room.setMob(armadio);
                                break;
                            case "Scrivania":
                                Mobili scrivania = new Scrivania(mobili.get(i).getDim_x(), mobili.get(i).getDim_y());
                                scrivania.setNum(Integer.parseInt(splitted[1]));
                                room.setMob(scrivania);
                                break;
                            case "Cassettiera":
                                Mobili cass = new Cassettiera(mobili.get(i).getDim_x(), mobili.get(i).getDim_y());
                                cass.setNum(Integer.parseInt(splitted[1]));
                                room.setMob(cass);
                                break;
                            case "Libreria":
                                Mobili lib = new Libreria(mobili.get(i).getDim_x(), mobili.get(i).getDim_y());
                                lib.setNum(Integer.parseInt(splitted[1]));
                                room.setMob(lib);
                                break;
                        }
                    }
                }
            }else{
               System.out.println("[INSERIRE NUMERO DESIDERATO]");
               Mob();
           }

            for(int j = 0; j < room.getMobili().size(); j++){
                System.out.println(room.getMobili().get(j));
            }
    }

    //TODO RISOLVERE IL PROBLEMA DEL PATHFILE e trovare dove metterle la funzione
    private  void lettFile(){

        Path currentDir = Paths.get(".");
        System.out.println("\n"+currentDir.toAbsolutePath());
        GestioneFile cc = new GestioneFile(".\\src\\FILETXT\\Elenco.txt");
        ArrayList<String[]> line = cc.readFile();

        for(int i =0; i < line.size(); i++){
                switch (line.get(i)[0]){
                    case "SCRIVANIA":
                        Mobili scrivania = new Scrivania(Integer.parseInt(line.get(i)[1]),Integer.parseInt(line.get(i)[2]));
                        mobili.add(scrivania);
                        break;
                    case "CASSETTIERA":
                        Mobili cass = new Cassettiera(Integer.parseInt(line.get(i)[1]),Integer.parseInt(line.get(i)[2]));
                        mobili.add(cass);
                        break;
                    case "ARMADIO":
                        Mobili armadio = new Armadio(Integer.parseInt(line.get(i)[1]),Integer.parseInt(line.get(i)[2]));
                        mobili.add(armadio);
                        break;
                    case "LIBRERIA":
                        Mobili libr = new Libreria(Integer.parseInt(line.get(i)[1]),Integer.parseInt(line.get(i)[2]));
                        mobili.add(libr);
                        break;
                }
        }
    }

    private String keyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



}
