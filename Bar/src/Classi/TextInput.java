package Classi;

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

    /**
     * funzione per selezionare il tipo di utente
     **/
    public void TextualInput() {
        String input;

        do{
            System.out.println("Inserire Nome Utente e Pass\n(Premere 0 se si è un novo utente)");
            input = keyboard();
            String[] splitted = input.split("\\s+");
            if (input.equals("0")){
                nuovoUtente();
            }
            else{

                try {
                if(utente.checkIdBar(splitted[0]).Log(splitted[0],splitted[1])){
                    br = utente.checkIdBar(splitted[0]);
                    TextualBar(br);
                }}catch (Exception e){};

                try {
                if(utente.checkIdCliente(splitted[0]).Log(splitted[0],splitted[1])){
                    cl = utente.checkIdCliente(splitted[0]);
                    TextualCliente(cl);
                }}catch (Exception e){};
            }
        }while (input.isEmpty());
    }

    private String keyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**Selezione nuovo bar o nuovo cliente**/
    public void nuovoUtente(){
        String input;
        do {
            System.out.println("Selezionare:" + "\n" + "Bar 1" + "\t" + "Cliente 2");
            input = keyboard();
            if (input.equals("1")) {
              newBar();
            } else if (input.equals("2")) {
               newCliente();
            }
        } while (input.isEmpty());
    }

    /**Funzione per la creazione di un nuovo cliente**/
    public void newCliente(){
        String input;
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
        utente.newCliente(Nome, Cognome, id, pass);
    }

    /**Funzione per la creazione di un nuovo bar**/
    public void newBar(){
        String input;
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
        utente.newBar(Nome, Ubicazione, id, pass);
        gestBaR();

    }


    private void TextualBar(Bar br){
                System.out.println("\nLogged as:\t"+br.getNome()+"\n");
                System.out.println("Menu:\n"+br.getMenu());
                System.out.println("Eventi:\t");
                for (Evento ev:br.getEventi()){
                    System.out.println(ev);
                }
                gestBaR();
    }

    private void TextualCliente(Cliente cl){
                System.out.println("\nLogged as:\t"+"\n"+cl.getId()+"\n"+cl.getNome()+"\n"+cl.getCognome());
                gestCliente();
    }

    /**funzione per gestione del bar**/
    public void gestBaR(){
        String input;
        System.out.println("Selezionare:"+"\n"+"Gestione Eventi 1"+"\n"+"Gestione Menu 2"+"\n"+"Uscire 0");
        input= keyboard();

        if (input.equals("1")){
            gestEventi();

        }else if(input.equals("2")) {
            gestMenu();
        }
        else if(input.equals("0")){
        }

    }

    /**funzione per gestione cliente**/
    public void gestCliente(){
        int i = 1;
        System.out.println("Selezionare:"+"\n"+"Controllare i bar preferiti 1"+"\n"+"Aggiungere bar a preferiti 2"+"\n"+"Uscire 0");
        String input = keyboard();
        switch(input){
            case "1":
                for (Bar brpref:cl.getPreferiti()) {
                    System.out.println(""+brpref+"\n");
                }
                gestPreferiti(cl.getPreferiti());
                break;
            case "2":
                for (Bar elencoBar:utente.getBars()){
                    System.out.println("BAR NUMERO: "+i+"\n"+elencoBar);
                    i++;
                }
                System.out.println("Premere 0 per tornare alla selezione precedente\n");
                aggPreferiti(utente.getBars());
                break;
            case "0":
                break;
        }
    }

    /**Funzione per aggiungere bar preferiti**/
    public void aggPreferiti(ArrayList<Bar> bars){
        String input = keyboard();
        if((Integer.parseInt(input)-1) == -1){
            gestCliente();
        }
        else if(cl.addPref(bars.get(Integer.parseInt(input)-1))) {
            System.out.println("Aggiunto bar:\t" + bars.get(Integer.parseInt(input) - 1).getNome());
        }
        else{
            System.out.println("Bar già presente tra i preferiti.");
                gestCliente();
        }

    }

    /**Funzione per rimuovere bar preferiti**/
    public void gestPreferiti(ArrayList<Bar> bars){
        System.out.println("Selezionare: "+"\t"+"Rimuovere preferiti 1"+"\t"+"Tornare alla selezione precedente 0");
        String input = keyboard();
        switch (input){
            case "1":
                input = keyboard();
                cl.remPref(bars.get(Integer.parseInt(input)-1));
                break;
            case "0":
                gestCliente();
        }
    }

    /**Funzione per la gestione degli eventi di un bar**/
    public void gestEventi() {
        Evento ev;
        String input;
        System.out.println("Selezionare:" + "\n" + "Aggiungi Evento 1" + "\n" + "Elimina Evento 2" + "\n" + "Uscire 0");
        input = keyboard();

        if (input.equals("1")) {
            System.out.println("Inserire Giorno Mese Anno Descrizione");
            input = keyboard();
            String[] splitted = input.split("\\s+");
            ev = new Evento(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]), splitted[3]);
            br.addEventi(ev);
        }
        else if(input.equals("2")){
            int i = 1;
            for (Evento evento:br.getEventi()) {
                System.out.println(""+i+"\t"+evento+"\n");
                i++;
            }
            input = keyboard();
            br.remEventi(br.getEventi().get(Integer.parseInt(input)-1));

        }
        else if(input.equals("0")){
            gestBaR();
        }

    }

    /**Funzione per la gestione del menu di un bar**/
    public void gestMenu(){

        Bevanda bv;
        String input, in;
        System.out.println("Selezionare:"+"\n"+"Aggiungi Bevanda 1"+"\n"+"Elimina Bevanda 2"+"\n"+"Uscire 0");
        input = keyboard();
        if(input.equals("1")){
            System.out.println("Selezionare tipo bevanda:\t Analcolico 1\t Bibita 2\t Birra 3\t Drink 4");
            in = keyboard();
            switch (in) {
                case "1":
                    System.out.println("Inserire Nome e Prezzo");
                    input = keyboard();
                    String[] splitted = input.split("\\s+");
                    bv = new Analcolico(splitted[0], Double.parseDouble(splitted[1]), "ANA", 0);
                    br.getMenu().addBevanda(bv, br.getId(), "ANA", null);
                    break;
                case "2":
                    System.out.println("Inserire Nome e Prezzo");
                    input = keyboard();
                    splitted = input.split("\\s+");
                    bv = new Bibita(splitted[0], Double.parseDouble(splitted[1]), "BIB", 0);
                    br.getMenu().addBevanda(bv, br.getId(), "BIB",null);
                    break;
                case "3":
                    System.out.println("Inserire Nome, Prezzo e Gradazione");
                    input = keyboard();
                    splitted = input.split("\\s+");
                    bv = new Birra(splitted[0], Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]), "BIR");
                    br.getMenu().addBevanda(bv, br.getId(), "BIR", ((Birra) bv).getGradazione());
                    break;
                case "4":
                    System.out.println("Inserire Nome, Prezzo e Gradazione");
                    input = keyboard();
                    splitted = input.split("\\s+");
                    bv = new Drink(splitted[0], Double.parseDouble(splitted[1]),Double.parseDouble(splitted[2]), "DRI");
                    br.getMenu().addBevanda(bv, br.getId(), "DRI", ((Drink) bv).getGradazione());
                    break;
            }
        }else if(input.equals("0")) {
            gestBaR();
        }
        else if(input.equals("2")){
            System.out.println("Menu:\n"+br.getMenu());
            input = keyboard();
            br.remBev(br.getMenu().getBevande().get((Integer.parseInt(input)-1)));
        }
    }


}

