import Bevande.*;

import java.util.ArrayList;
import java.util.Scanner;
public class TextInput {
    private Bar br;
    private Cliente cl;
    private Utente utente;

    public TextInput(Utente utente) {
        this.utente = utente;
    }

    /** funzione per selezionare il tipo di utente **/
    public void TextualInput(){
        String input;
        do{
            System.out.println("Selezionare:"+"\n"+"Bar 1"+"\t"+"Cliente 2");
            input = keyboard();
            if (input.equals("1")){
                TextualBar();
            }
            else if(input.equals("2")){
                TextualCliente();
            }
        }while (input.isEmpty());
    }

    private String keyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**funzione per gestione del bar**/
    private void TextualBar(){
        String input;
        System.out.println("Selezionare:"+"\n"+"Nuovo Bar 1"+"\t"+"Bar Presente 2");
        input= keyboard();

        if (input.equals("1")){
            System.out.println("Inserire nome:");
            input = keyboard();
            String Nome = input;
            System.out.println("Inserire ubicazione:");
            input = keyboard();
            String Ubicazione = input;
            System.out.println("Inserire ID:");
            input = keyboard();
            String id = input;
            System.out.println("Inserire password");
            input = keyboard();
            String pass = input;
            utente.newBar(Nome, Ubicazione,id, pass);
            gestBaR();
//        String[] splitted = input.split("\\s+");
//        utente.newBar(splitted[0],splitted[1],splitted[2],splitted[3]);
    }else if(input.equals("2")){
        System.out.println("Inserire Id e pass");
        input = keyboard();
        String[] splitted = input.split("\\s+");
            if((utente.checkIdBar(splitted[0]) != null) && utente.checkIdBar(splitted[0]).Log(splitted[0],splitted[1])){
                br = utente.checkIdBar(splitted[0]);
                System.out.println("\nLogged as:\t"+br.getNome()+"\n");
                System.out.println("Menu:\n"+br.getMenu());
                System.out.println("Eventi:\t");
                for (Evento ev:br.getEventi()){
                    System.out.println(ev);
                }
                System.out.println("");
                gestBaR();
            }else{
                System.out.println("Error LogIn");
            }
        }
    }
/**funzione per gestione cliente**/
    private void TextualCliente(){
        String input;
        System.out.println("Selezionare:"+"\n"+"Nuovo Cliente 1"+"\t"+"Cliente Presente 2");
        input= keyboard();

        if (input.equals("1")){
            System.out.println("Inserire nome:");
            input = keyboard();
            String Nome = input;
            System.out.println("Inserire cognome:");
            input = keyboard();
            String Cognome = input;
            System.out.println("Inserire ID:");
            input = keyboard();
            String id = input;
            System.out.println("Inserire password");
            input = keyboard();
            String pass = input;
            cl = utente.newCliente(Nome, Cognome, id, pass);

            System.out.println("Scegliere bar preferiti");
            aggPreferiti(utente.getBars());

//            String[] splitted = input.split("\\s+");
//            utente.newCliente(splitted[0],splitted[1],splitted[2],splitted[3]);

        }else if(input.equals("2")){
            System.out.println("Inserire Id e pass");
            input = keyboard();
            String[] splitted = input.split("\\s+");

            if ((utente.checkIdCliente(splitted[0]) != null) && utente.checkIdCliente(splitted[0]).Log(splitted[0], splitted[1])) {
                    cl = utente.checkIdCliente(splitted[0]);
                    System.out.println("\nLogged as:\t" + "\n" + cl.getId() + "\n" + cl.getNome() + "\n" + cl.getCognome());
                    gestCliente();
            }else{
                System.out.println("Error LogIn");
            }
        }
    }

    public void gestBaR(){
        Bevanda bv;
        String input, in;
        int i = 1;
        System.out.println("Selezionare:"+"\n"+"Gestione Eventi 1"+"\t"+"Gestione Menu 2");
        input= keyboard();

        if (input.equals("1")){
            for (Evento ev:br.getEventi()){
                System.out.println("evento"+i+":\n"+ev);
                i++;
            }
            gestEventi();

        }else if(input.equals("2")){
            System.out.println(br.getMenu());
            gestMenu();

        }

    }

    public void gestEventi(){
        System.out.println("Selezionare:\tAggiungere Evento 1 \tRimuovere Evento 2");
        String input = keyboard();
        switch (input){
            case "1":
                System.out.println("Inserire Giorno Mese Anno Descrizione");
                input = keyboard();
                String[] splitted = input.split("\\s+");
                Evento ev = new Evento(Integer.parseInt(splitted[0]),Integer.parseInt(splitted[1]),Integer.parseInt(splitted[2]),splitted[3]);
                br.addEventi(ev);
                break;
            case "2":
                if(br.getEventi().size() == 0){
                    System.out.println("Nessun evento da rimuovere");
                    break;
                }
                System.out.println("Selezionare l'evento da rimuovere");
                input = keyboard();
                br.remEventi(br.getEventi().get(Integer.parseInt(input)-1));
                break;
        }
    }

    public void gestMenu(){

        Bevanda bv;
        String in, input;
        System.out.println("Selezionare:\tAggiungere bevanda 1\tRimuovere bevanda 2\n");
        input = keyboard();
        switch (input){
        case "1":
            System.out.println("Selezionare tipo bevanda:\t Analcolico 1\t Bibita 2\t Birra 3\t Drink 4");
            in = keyboard();
            switch (in) {
                case "1":
                    System.out.println("Inserire Nome e Prezzo");
                    input = keyboard();
                    String[] splitted = input.split("\\s+");
                    bv = new Analcolico(splitted[0], Double.parseDouble(splitted[1]));
                    br.getMenu().addBevanda(bv, br.getId(), "ANA", null);
                    break;
                case "2":
                    System.out.println("Inserire Nome e Prezzo");
                    input = keyboard();
                    splitted = input.split("\\s+");
                    bv = new Bibita(splitted[0], Double.parseDouble(splitted[1]));
                    br.getMenu().addBevanda(bv, br.getId(), "BIB",null);
                    break;
                case "3":
                    System.out.println("Inserire Nome, Prezzo e Gradazione");
                    input = keyboard();
                    splitted = input.split("\\s+");
                    bv = new Birra(splitted[0], Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]));
                    br.getMenu().addBevanda(bv, br.getId(), "BIR", ((Birra) bv).getGradazione());
                    break;
                case "4":
                    System.out.println("Inserire Nome, Prezzo e Gradazione");
                    input = keyboard();
                    splitted = input.split("\\s+");
                    bv = new Drink(splitted[0], Double.parseDouble(splitted[1]),Double.parseDouble(splitted[2]));
                    br.getMenu().addBevanda(bv, br.getId(), "DRI", ((Drink) bv).getGradazione());
                    break;
            }
            break;
            case "2":
                System.out.println("Selezionare la bevanda da rimuovere");
                input = keyboard();
                bv = br.getMenu().getBevande().get(Integer.parseInt(input)-1);
                System.out.println(bv.getClass().getTypeName());
                if(bv instanceof Birra) {
                    br.getMenu().remBevande(bv, br.getId(), ((Birra) bv).getGradazione());
                }
                else if(bv instanceof Drink){
                br.getMenu().remBevande(bv, br.getId(), ((Drink) bv).getGradazione());
                }
                else if(bv instanceof Analcolico|| bv instanceof Bibita){
                    br.getMenu().remBevande(bv, br.getId(), 0.0);
                }

                // br.getMenu().remBevande(br.getMenu().(Integer.parseInt(input)-1));
              // br.getMenu().remBevande();
                break;

        }
    }

    public void gestCliente(){
        int i = 1;
        System.out.println("Selezionare:"+"\n"+"Controllare i bar preferiti 1"+"\n"+"Aggiungere bar a preferiti 2");
        String input = keyboard();
        switch(input){
            case "1":
                for (Bar brpref:cl.getPreferiti()) {
                    System.out.println("BAR NUMERO: "+i+"\n"+brpref+"\n");
                }
                gestPreferiti(cl.getPreferiti());
                break;
            case "2":
//                for (Bar elencoBar:utente.getBars()){
//                    System.out.println("BAR NUMERO: "+i+"\n"+elencoBar+"\n");
//                    i++;
//                }
                aggPreferiti(utente.getBars());
                break;
        }
    }

    public void aggPreferiti(ArrayList<Bar> bars){
        int i = 1;
        for (Bar elencoBar:utente.getBars()){
            System.out.println("BAR NUMERO: "+i+"\n"+elencoBar+"\n");
            i++;
        }
        String input = keyboard();
        if(cl.addPref(bars.get(Integer.parseInt(input)-1))) {
            System.out.println("Aggiunto bar:\t" + bars.get(Integer.parseInt(input) - 1).getNome());
        }
        else{
            System.out.println("Bar già presente tra i preferiti.");
        }

    }

    public void gestPreferiti(ArrayList<Bar> bars){
        System.out.println("Selezionare: "+"\t"+"Rimuovere preferiti 1"+"\t"+"Tornare alla selezione precedente 2");
        String input = keyboard();
        switch (input){
            case "1":
                System.out.println("Eliminare preferito numero:");
                input = keyboard();
                cl.remPref(bars.get(Integer.parseInt(input)-1));
                break;
            case "2":
                gestCliente();
        }
    }

}

