package main;

import entities.GestioneAuto;
import gestoreConnessioni.GestoreConnessioni;
import dao.AutoDAO;

public class Main {
	
	public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/gestioneauto";
	String user = "javauser";
	String pwd = "eAbrfcjiGdMo88eE";
	
	GestioneAuto ga = new GestioneAuto();
	
	GestoreConnessioni gc = new GestoreConnessioni(url, user, pwd);
	
	
	// TEST
	
	AutoDAO.getAllAuto(gc, ga);
	
	
	System.out.println(ga.getListaAuto());
	
	}
}
