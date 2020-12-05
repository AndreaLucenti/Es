import Arredamento.Armadio;
import Arredamento.Mobili;
import Arredamento.Tavolo;
import BHO.Porta;
import BHO.Vincoli;
import BHO.Finestra;
import BHO.Termosifone;

import java.util.Scanner;

public class TextInput {
    private Room room;

    public TextInput(Room room) {
        this.room = room;
    }

    public void TextualIn() {

            Dim();
            Vincoli();
            Mob();

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
                        case "FINESTRA":
                            Vincoli finestra = new Finestra((i+1),Integer.parseInt(splitted[j+1]));
                            room.setVin(finestra);
                            break;

                        case "TERMOSIFONE":
                            Vincoli termosifone = new Termosifone((i+1),Integer.parseInt(splitted[j+1]));
                            room.setVin(termosifone);
                            break;

                        case "PORTA":
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
    public void Mob(){
            String input;
            String[] splitted;

            System.out.println("[INSERIRE I MOBILI DESIDERATI LE DIMENSIONI E IL NUMERO]\n(TAVOLO ARMADIO)");
            input = keyboard();
            splitted = input.split("\\s");

            while (!splitted[0].isEmpty()) {
                if (Double.parseDouble(splitted[1]) <= 0 || Double.parseDouble(splitted[2]) <= 0 || Integer.parseInt(splitted[3]) <= 0) {
                    System.out.println("ERRORE DATI INSERITI");
                    break;
                }

                switch (splitted[0]) {
                    case "ARMADIO":
                        Mobili armadio = new Armadio(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]), Integer.parseInt(splitted[3]));
                        room.setMob(armadio);
                        break;

                    case "TAVOLO":
                        Mobili tavolo = new Tavolo(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]), Integer.parseInt(splitted[3]));
                        room.setMob(tavolo);
                        break;
                }
            }
    }


    private String keyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



}
