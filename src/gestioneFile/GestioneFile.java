package gestioneFile;

import java.nio.file.*;
import java.io.*;
import java.net.URL;


public class GestioneFile {


//    private static final String RESOURCES_FOLDER = "/resources/";
    
    public static final String PATH = "/resources/DBAutomobili.txt";


//    public static void leggiFile(Path path) throws IOException {
//        path = Paths.get(RESOURCES_FOLDER + path.toString());
//        try (BufferedReader reader = Files.newBufferedReader(path)) {
//            String currentLine = reader.readLine();
//            System.out.println(currentLine);
//        }
//    }


    public static void leggiFile(String path) throws IOException {
        try (InputStream resource = GestioneFile.class.getResourceAsStream(path)) {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
        	String currentLine = reader.readLine();
        	System.out.println(currentLine);
        	
        	reader.close();
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }


    // Metodo principale per testare
    public static void main(String[] args) {
        try {
            leggiFile(PATH);
//            leggiFile("DBAutomobili.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
