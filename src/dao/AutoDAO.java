package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Auto;
import entities.GestioneAuto;
import gestoreConnessioni.GestoreConnessioni;

public class AutoDAO {
	public static ArrayList<Auto> getAllAuto(GestoreConnessioni gc, GestioneAuto ga) {
		String query = "SELECT * FROM auto";

		ResultSet rs = gc.eseguiStatementQuery(query);

		ArrayList<Auto> automobili = ga.getListaAuto();

		try {
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String marca = rs.getString(2);
				String modello = rs.getString(3);
				int anno = Integer.parseInt(rs.getString(4));
				String targa = rs.getString(5);
				float prezzo = Float.parseFloat(rs.getString(6));
				String tipoCarburante = rs.getString(7);
				Auto autombile = new Auto(id, marca, modello, anno, targa, prezzo, tipoCarburante);
				automobili.add(autombile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return automobili;

	}

	public static void insertAuto(GestoreConnessioni gc, GestioneAuto ga, Auto auto) {
		String query = ("INSERT INTO auto (marca, modello, anno, targa, prezzo, tipocarburante) "
				+ "VALUES (?, ?, ?, ?, ?, ?)");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setString(1, auto.getMarca());
			prstmt.setString(2, auto.getModello());
			prstmt.setInt(3, auto.getAnno());
			prstmt.setString(4, auto.getTarga());
			prstmt.setFloat(5, auto.getPrezzo());
			prstmt.setString(6, auto.getTipoCarburante());
			
			
			prstmt.execute();
			
			System.out.println("insert eseguito correttamente");
			
			ga.aggiungiAuto(auto);
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

//	public static ArrayList<Auto> modificaAuto(GestoreConnessioni gc, GestioneAuto ga) {
//		return null;
//
//	}
	
	public static void modificaAutoMarca(GestoreConnessioni gc, Auto auto, String marca) {

		String query = ("UPDATE Auto SET Marca=? WHERE targa=\"" + auto.getTarga() + "\"");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setString(1, marca);

			prstmt.executeUpdate();

			System.out.println("Modifica inserita correttamente");

			auto.setMarca(marca);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void modificaAutoModello(GestoreConnessioni gc, Auto auto, String modello) {

		String query = ("UPDATE Auto SET Modello=? WHERE targa=\"" + auto.getTarga() + "\"");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setString(1, modello);

			prstmt.executeUpdate();

			System.out.println("Modifica inserita correttamente");

			auto.setModello(modello);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void modificaAutoAnno(GestoreConnessioni gc, Auto auto, int anno) {

		String query = ("UPDATE Auto SET Anno=? WHERE targa=\"" + auto.getTarga() + "\"");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setInt(1, anno);

			prstmt.executeUpdate();

			System.out.println("Modifica inserita correttamente");

			auto.setAnno(anno);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void modificaAutoTarga(GestoreConnessioni gc, Auto auto, String targa) {

		String query = ("UPDATE Auto SET Targa=? WHERE targa=\"" + auto.getTarga() + "\"");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setString(1, targa);

			prstmt.executeUpdate();

			System.out.println("Modifica inserita correttamente");

			auto.setTarga(targa);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void modificaAutoPrezzo(GestoreConnessioni gc, Auto auto, float prezzo) {

		String query = ("UPDATE Auto SET Prezzo=? WHERE targa=\"" + auto.getTarga() + "\"");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setFloat(1, prezzo);

			prstmt.executeUpdate();

			System.out.println("Modifica inserita correttamente");

			auto.setPrezzo(prezzo);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void modificaAutoCarburante(GestoreConnessioni gc, Auto auto, String carburante) {

		String query = ("UPDATE Auto SET tipocarburante=? WHERE targa=\"" + auto.getTarga() + "\"");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setString(1, carburante);

			prstmt.executeUpdate();

			System.out.println("Modifica inserita correttamente");

			auto.setTipoCarburante(carburante);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void deleteAuto(GestoreConnessioni gc, GestioneAuto ga, Auto auto) {
		String query = ("DELETE FROM Auto WHERE id=?");

		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			int id = auto.getId();

			prstmt.setString(1, id + "");

			System.out.println("Delete eseguita correttamente");

			prstmt.execute();
			
			ga.eliminaAuto(auto);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<Auto> cercaAutoPerTarga(GestoreConnessioni gc, GestioneAuto ga) {
		return null;

	}
}
