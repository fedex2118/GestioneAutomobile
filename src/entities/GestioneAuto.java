package entities;

import java.util.ArrayList;

public class GestioneAuto {
	
	private ArrayList<Auto> listaAuto;
	private String nomeFile;
	
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
