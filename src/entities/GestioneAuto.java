package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioneAuto {
	
	private ArrayList<Auto> listaAuto;
	private String nomeFile;
	private Utente utente;
	private Scanner scanner;
	
	public GestioneAuto(ArrayList<Auto> listaAuto, String nomeFile) {
		this.listaAuto = listaAuto;
		this.nomeFile = nomeFile;
	}

	public ArrayList<Auto> getListaAuto() {
		return listaAuto;
	}

	public void setListaAuto(ArrayList<Auto> listaAuto) {
		this.listaAuto = listaAuto;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	
	//METODO MANAGER GESTIONE UTENTE
	public void displayOpzioni() {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		
		while (!exit) {
			System.out.println("Benvenuto nella gestioneAuto!");
			System.out.println("1. Accedi");
			System.out.println("2. Esci");
			System.out.println("Risposta: ");

			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				utente = creaUtente();
				//IMPLEMENTARE UN METODO CHE RICHIAMI TUTTI I METODI CHE PUò USARE L'UTENTE
				break;
			case 2:
				exit = true;
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
			}
		}
	}
	
	//CREAZIONE UTENTE
		private Utente creaUtente() {
			System.out.println("Inserisci il nome dell'utente:");
	        String nomeAdmin = scanner.nextLine();
	        System.out.println("Inserisci password dell'utente:");
	        String password = scanner.nextLine();
	        return new Utente(nomeAdmin, password);
		}
	
	//METODI GESTIONE AUTO
	public void aggiungiAuto(Auto auto) {
		listaAuto.add(auto);
	}
	
	public void modificaAuto() {
		
	}
	
	public void eliminaAuto() {
		
	}
	
	public ArrayList<Auto> visualizzaAuto() {
		return listaAuto;
	}
	
	public void cercaAutoPerTarga() {
		
	}
	
	public void leggiDaFile() {
		
	}
	
	public void scriviSuFile() {
		
	}
	
	
}
