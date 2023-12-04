package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EditTxt {
    public static void generarArchivo(String poner){
        String miTxt = "documento.txt";

        File myFile = new File(miTxt);

        try (FileWriter escritor = new FileWriter(myFile)) 
        {
            escritor.write(poner.replace("\n","\r\n"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String readFile(){
        String miTxt = "documento.txt";

        File myFile = new File(miTxt);
        String poner = "";
        
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextLine()) {
                poner += scanner.nextLine()+"\n";
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return poner;
    }
}
