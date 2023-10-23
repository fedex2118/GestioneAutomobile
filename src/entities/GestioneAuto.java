package entities;

import java.util.ArrayList;
import java.util.Scanner;

import dao.AutoDAO;
import gestoreConnessioni.GestoreConnessioni;

public class GestioneAuto {

	private ArrayList<Auto> listaAuto = new ArrayList<>();
	private String nomeFile;
	private Utente utente;
	private Scanner scanner = new Scanner(System.in);
	private GestoreConnessioni gc;

	public GestioneAuto(GestoreConnessioni gc) {
		this.gc = gc;
	}

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
	
	public Auto cercaAutoPerId(int id) {
		for(Auto auto: listaAuto) {
			if(id == auto.getId())
				return auto;
		}
		return null;
	}
	
	private String retrieveAutoTarga() {
		 return inserisciTarga();
	}
	
	public Auto cercaAutoPerTarga(String targa) {
		for(Auto auto: listaAuto) {
			if(targa.equals(auto.getTarga()))
				return auto;
		}
		return null;
	}

	// METODO MANAGER GESTIONE UTENTE
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
				displayOpzioniUtente();
				break;
			case 2:
				exit = true;
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
			}
		}
	}

	// METODO DISPLAYOPZIONIUTENTE
	public void displayOpzioniUtente() {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("Benvenuto " + utente.getNome());
			System.out.println("Scegli una di queste opzioni");
			System.out.println("1. Aggiungi auto");
			System.out.println("2. Modifica auto");
			System.out.println("3. Elimina auto");
			System.out.println("4. Visualizza tutte le auto");
			System.out.println("5. Esci");
			System.out.println("Risposta: ");

			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				Auto auto = creaAuto();
				AutoDAO.insertAuto(gc, this, auto);
				break;
			case 2:
				displayOpzioniModifica();
				break;
			case 3:
				String targa = inserisciTarga();
				Auto automobileDaEliminare = cercaAutoPerTarga(targa);
				AutoDAO.deleteAuto(gc, this, automobileDaEliminare);
				break;
			case 4:
				visualizzaAuto();
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
			}
		}
	}

	// CREAZIONE UTENTE
	private Utente creaUtente() {
		System.out.println("Inserisci il nome dell'utente:");
		String nomeAdmin = scanner.nextLine();
		System.out.println("Inserisci password dell'utente:");
		String password = scanner.nextLine();
		return new Utente(nomeAdmin, password);
	}
	
	//CREAZIONE AUTO
		private Auto creaAuto() {
			System.out.println("Inserisci la marca dell'auto:");
			String marca = scanner.nextLine();
			System.out.println("Inserisci il modello dell'auto:");
			String modello = scanner.nextLine();
			System.out.println("Inserisci l'anno dell'auto:");
			int anno = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Inserisci la targa dell'auto:");
			String targa = scanner.nextLine();
			System.out.println("Inserisci il prezzo dell'auto:");
			float prezzo = scanner.nextFloat();
			scanner.nextLine();
			System.out.println("Inserisci il tipo di carburante dell'auto:");
			String tipoCarburante = scanner.nextLine();
			return new Auto(marca, modello, anno, targa, prezzo, tipoCarburante);
		}

		// SOTTOMENU
		public void displayOpzioniModifica() {
			Scanner scanner = new Scanner(System.in);
			boolean exit = false;
			
			String targa = retrieveAutoTarga();
			Auto auto = cercaAutoPerTarga(targa);
			
			while (!exit) {
				System.out.println("Scegli una di queste opzioni");
				System.out.println("1. Modifica marca");
				System.out.println("2. Modifica modello");
				System.out.println("3. Modifica anno");
				System.out.println("4. Modifica targa");
				System.out.println("5. Modifica prezzo");
				System.out.println("6. Modifica tipo di carburante");
				System.out.println("7. Torna al menù principale");
				System.out.println("Risposta: ");

				int scelta = scanner.nextInt();
				scanner.nextLine();

				switch (scelta) {
				case 1:
					// Modifica marca
					modificaAutoMarca(auto);
					break;
				case 2:
					// Modifica modello
					modificaAutoModello(auto);
					break;
				case 3:
					// Modifica anno
					modificaAutoAnno(auto);
					break;
				case 4:
					// Modifica targa
					modificaAutoTarga(auto);
					break;
				case 5:
					// Modifica prezzo
					modificaAutoPrezzo(auto);
					break;
				case 6:
					// Modifica tipo di carburante
					modificaAutoTipoCarburante(auto);
					break;
				case 7: // torna al menù principale
					exit = true;
					break;
				default:
					System.out.println("Scelta non valida. Riprova.");
				}
			}
			
			// torna al menù principale
			displayOpzioniUtente();
		}
		
		private String inserisciTarga() {
			System.out.println("Inserisci la targa:");
			return scanner.nextLine();
		}
		
		public void modificaAutoMarca(Auto auto) {
			Scanner scanner = this.scanner;
			
			System.out.println("Inserisci la marca:");
			String nuovaMarca = scanner.nextLine();
			
			AutoDAO.modificaAutoMarca(gc, auto, nuovaMarca);
		}
		
		public void modificaAutoModello(Auto auto) {
			Scanner scanner = this.scanner;
			
			System.out.println("Inserisci il modello:");
			String nuovoModello = scanner.nextLine();
			
			AutoDAO.modificaAutoModello(gc, auto, nuovoModello);
		}
		
		public void modificaAutoAnno(Auto auto) {
			Scanner scanner = this.scanner;
			
			System.out.println("Inserisci l'anno:");
			int nuovoAnno = scanner.nextInt();
			scanner.nextLine();
			
			AutoDAO.modificaAutoAnno(gc, auto, nuovoAnno);
		}
		
		public void modificaAutoTarga(Auto auto) {
			Scanner scanner = this.scanner;
			
			System.out.println("Inserisci la targa:");
			String nuovaTarga = scanner.nextLine();
			
			AutoDAO.modificaAutoTarga(gc, auto, nuovaTarga);
		}
		
		public void modificaAutoPrezzo(Auto auto) {
			Scanner scanner = this.scanner;
			
			System.out.println("Inserisci il prezzo:");
			float nuovoPrezzo = scanner.nextFloat();
			scanner.nextLine();
			
			AutoDAO.modificaAutoPrezzo(gc, auto, nuovoPrezzo);
		}
		
		public void modificaAutoTipoCarburante(Auto auto) {
			Scanner scanner = this.scanner;
			
			System.out.println("Inserisci il tipo carburante:");
			String nuovoCarburante = scanner.nextLine();
			
			AutoDAO.modificaAutoCarburante(gc, auto, nuovoCarburante);
		}

	// METODI GESTIONE AUTO
	public void aggiungiAuto(Auto auto) {
		listaAuto.add(auto);
	}

	public void modificaAuto() {

	}

	public void eliminaAuto(Auto auto) {
		listaAuto.remove(auto);
	}

	public void visualizzaAuto() {
		System.out.println(listaAuto);
	}

	public void leggiDaFile() {

	}

	public void scriviSuFile() {

	} 
}
