package gestioneFile;

import java.nio.file.*;
import java.io.*;


public class GestioneFile {


    private static final String RESOURCES_FOLDER = "resources/";


    public static void leggiFile(Path path) throws IOException {
        path = Paths.get(RESOURCES_FOLDER + path.toString());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String currentLine = reader.readLine();
            System.out.println(currentLine);
        }
    }


    public static void leggiFile(String path) throws IOException {
        path = RESOURCES_FOLDER + path;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String currentLine = reader.readLine();
            System.out.println(currentLine);
        }
    }


    // Metodo principale per testare
    public static void main(String[] args) {
        try {
            leggiFile(Paths.get("DBAutomobili.txt"));
            leggiFile("DBAutomobili.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
