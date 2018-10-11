import java.util.Scanner;
public class TextInput {
    private Utente utente;

    public TextInput(Utente utente) {
        this.utente = utente;
    }

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

    private void TextualBar(){
        String input;
        System.out.println("Selezionare:"+"\n"+" Nuovo Bar 1"+"\t"+"Bar Presente 2");
        input= keyboard();

        if (input.equals("1")){
        System.out.println("Inserire nome ubicazione id e nuova pass");
        input = keyboard();
        String[] splitted = input.split("\\s+");
        utente.newBar(splitted[0],splitted[1],splitted[2],splitted[3]);
    }else if(input.equals("2")){
        System.out.println("Inserire Id e pass");
        input = keyboard();
        String[] splitted = input.split("\\s+");
        utente.checkIdBar(splitted[0]).Log(splitted[0],splitted[1]);
    }
        }

    private void TextualCliente(){
        String input;
        System.out.println("Selezionare:"+"\n"+" Nuovo Cliente 1"+"\t"+"Cliente Presente 2");
        input= keyboard();

        if (input.equals("1")){
            System.out.println("Inserire nome cognome id e nuova pass");
            input = keyboard();
            String[] splitted = input.split("\\s+");
            utente.newCliente(splitted[0],splitted[1],splitted[2],splitted[3]);
        }else if(input.equals("2")){
            System.out.println("Inserire Id e pass");
            input = keyboard();
            String[] splitted = input.split("\\s+");
            utente.checkIdCliente(splitted[0]).Log(splitted[0],splitted[1]);
        }
    }


}

