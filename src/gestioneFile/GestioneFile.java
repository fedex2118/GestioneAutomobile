package gestioneFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestioneFile {
	String file ="src/resources/DBautomobili.txt";
    
	
	
	public void leggiFile(String path) throws IOException {	
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine = reader.readLine();

		reader.close();

	}
}
