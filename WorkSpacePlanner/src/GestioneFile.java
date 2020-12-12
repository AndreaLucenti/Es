import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GestioneFile {
    private  final String PATH_FILE;

    public GestioneFile(String pathFile){ this.PATH_FILE = pathFile;}

    public ArrayList<String[]> readFile() {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(PATH_FILE));
            ArrayList<String[]> openedFile = split(bReader);
            bReader.close();
            return openedFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Funzione che riceve i dati copiati dal file e li divide dopo ogni carattere di "Tab".
     * @param bReader reader associato al file.
     */
    private ArrayList<String[]> split(BufferedReader bReader) {
        ArrayList<String[]> dataSplit = new ArrayList<>();
        String row;

        try {
            while ((row = bReader.readLine()) != null) {
                if (!row.contains("*") && !row.isEmpty()) {
                    String[] rowDataSplit = row.split("\t");
                    dataSplit.add(rowDataSplit);
                }
            }
            return dataSplit;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Funzione per la scrittura su file dei dati di interesse.
     * @param writing stringa da accodare al file contenente le informazioni necessarie.
     */
    public void writeFile(String writing) {
        try {
            FileWriter writer = new FileWriter(PATH_FILE, true);
            writer.write("\n" + writing + "\t");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *  Funzione per rimuovere una linea di testo utilizzando un nuovo file e eliminando il file vecchio
     * @param lineRem stringa da rimuovere del file
     */

    public boolean remRow(String lineRem) {
        File inputFile = new File(PATH_FILE);
        File tempFile = new File("src/FILETXT/TempFile.txt");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineRem)) continue;
                writer.write(currentLine+"\n");
            }
            writer.close();
            reader.close();
            inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);
            return successful;
        }catch (IOException e){e.printStackTrace();}
        return false;
    }

    /**
     * Funzione per ottenere data e ora locali.
     * @return strDate dati desiderati.
     */
    private String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Stringa per data, ora, tempo
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    /**
     * Funzione per la sovrascrittura di una specifica riga di testo.
     * @param currentLine riga da aggiornare.
     * @param newLine nuova riga che sovrascriverà la riga selezionata.
     */
    public void overwriteFile(String newLine, String currentLine) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_FILE));
        String line;
        String input = "";

        while ((line = bufferedReader.readLine()) != null) {
            input += line + System.lineSeparator();
        }

        input = input.replace(currentLine, newLine);

        FileOutputStream outputStream = new FileOutputStream(PATH_FILE);
        outputStream.write(input.getBytes());

        bufferedReader.close();
        outputStream.close();
    }

    /**
     * Funzione che restituisce un arrayList del file senza le righe con gli asterischi.
     */
    public ArrayList<String> readFileNotSplitted() {
        ArrayList<String> arrayListNotSplitted = new ArrayList<>();
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(PATH_FILE));
            String tmp;
            while ((tmp = bReader.readLine()) != null) {
                if (!tmp.contains("*")) {
                    arrayListNotSplitted.add(tmp);
                }
            }
            bReader.close();
            return arrayListNotSplitted;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayListNotSplitted;
    }
}
