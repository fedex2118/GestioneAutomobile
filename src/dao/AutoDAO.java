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

	public static ArrayList<Auto> insertAuto(GestoreConnessioni gc, GestioneAuto ga) {
		return null;

	}

//	public static ArrayList<Auto> modificaAuto(GestoreConnessioni gc, GestioneAuto ga) {
//		return null;
//
//	}
	
	public static void modificaAutoMarca(GestoreConnessioni gc, Auto auto, String marca) {
		
		String query = ("UPDATE Auto SET Marca=? WHERE id=\"" + auto.getId() + "\"");
		try {
			Connection conn = gc.getConn();
			
			PreparedStatement prstmt = conn.prepareStatement(query);
			
			prstmt.setString (1, marca);
			
			prstmt.executeUpdate();
			
			System.out.println("Modifica inserita correttamente");
			
			auto.setMarca(marca);
		                                                             }
		catch (SQLException ex) {
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
