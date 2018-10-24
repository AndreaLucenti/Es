import Bevande.*;

import java.util.Scanner;
public class TextInput {
    private Bar br;
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
//        String[] splitted = input.split("\\s+");
//        utente.newBar(splitted[0],splitted[1],splitted[2],splitted[3]);
    }else if(input.equals("2")){
        System.out.println("Inserire Id e pass");
        input = keyboard();
        String[] splitted = input.split("\\s+");
            if(utente.checkIdBar(splitted[0]).Log(splitted[0],splitted[1])){
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
            utente.newCliente(Nome, Cognome, id, pass);

//            String[] splitted = input.split("\\s+");
//            utente.newCliente(splitted[0],splitted[1],splitted[2],splitted[3]);

        }else if(input.equals("2")){
            System.out.println("Inserire Id e pass");
            input = keyboard();
            String[] splitted = input.split("\\s+");
            utente.checkIdCliente(splitted[0]).Log(splitted[0],splitted[1]);
        }
    }

    public void gestBaR(){
        Evento ev;
        Bevanda bv;
        String input, in;
        System.out.println("Selezionare:"+"\n"+"Aggiungi Evento 1"+"\t"+"Aggiungi Menu 2");
        input= keyboard();

        if (input.equals("1")){
            System.out.println("Inserire Giorno Mese Anno Descrizione");
            input = keyboard();
            String[] splitted = input.split("\\s+");
            ev = new Evento(Integer.parseInt(splitted[0]),Integer.parseInt(splitted[1]),Integer.parseInt(splitted[2]),splitted[3]);
            br.addEventi(ev);

        }else if(input.equals("2")){
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
        }

    }


}

