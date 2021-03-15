package it.objectmethod.fattura.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.fattura.connection.ConnectionFactory;
import it.objectmethod.fattura.dao.FatturaDao;
import it.objectmethod.fattura.domain.Fattura;

public class FatturaDaoImpl implements FatturaDao {

	@Override
	public List<Fattura> getOrdini() {
		Connection conn = ConnectionFactory.getConnection();
		List<Fattura> ordini = new ArrayList<Fattura>();
		String sql = "SELECT id_ordine, numero_ordine FROM ordine";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Fattura ordine = new Fattura();
				ordine.setIdOrdine(rs.getInt("id_ordine"));
				ordine.setNumeroOrdine(rs.getString("numero_ordine"));
				ordini.add(ordine);
			}
			System.out.println("connessa al db");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("no database connection");
		}

		return ordini;

	}

	@Override
	public List<Fattura> getFattura(String numeroOrdine) {

		Connection conn = ConnectionFactory.getConnection();
		List<Fattura> fatture = new ArrayList<Fattura>();

		String sql = "SELECT * FROM ordine o join riga_ordine ro on o.id_ordine = ro.id_ordine "
				+ "join utente u on u.id_utente = o.id_utente join articolo a on a.id_articolo = ro.id_articolo "
				+ "WHERE numero_ordine = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, numeroOrdine);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fattura fattura = new Fattura();

				fattura.setDataOrdine(rs.getString("data_ordine"));
				fattura.setIdOrdine(rs.getInt("id_ordine"));
				fattura.setIdUtente(rs.getInt("id_utente"));
				fattura.setNumeroOrdine(rs.getString("numero_ordine"));
				fattura.setCodiceArticolo(rs.getString("codice_articolo"));
				fattura.setDisponibilita(rs.getInt("disponibilita"));
				fattura.setIdArticolo(rs.getInt("id_articolo"));
				fattura.setNomeArticolo(rs.getString("nome_articolo"));
				fattura.setPrezzoUnitario(rs.getInt("prezzo_unitario"));
				fattura.setIdRigaOrdine(rs.getInt("id_riga_ordine"));
				fattura.setQuantita(rs.getInt("quantita"));
				fattura.setNomeUtente(rs.getString("nome_utente"));
				fattura.setPassword(rs.getString("password"));

				fatture.add(fattura);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fatture;

	}

}
