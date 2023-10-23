package dao;

import java.sql.ResultSet;
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

	public static ArrayList<Auto> modificaAuto(GestoreConnessioni gc, GestioneAuto ga) {
		return null;

	}

	public static ArrayList<Auto> deleteAuto(GestoreConnessioni gc, GestioneAuto ga) {
		return null;

	}

	public static ArrayList<Auto> cercaAutoPerTarga(GestoreConnessioni gc, GestioneAuto ga) {
		return null;

	}
}
