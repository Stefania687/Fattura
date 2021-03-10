package it.objectmethod.fattura.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.fattura.connection.ConnectionFactory;
import it.objectmethod.fattura.dao.FatturaDao;
import it.objectmethod.fattura.domain.Articolo;
import it.objectmethod.fattura.domain.Fattura;
import it.objectmethod.fattura.domain.Ordine;
import it.objectmethod.fattura.domain.RigaOrdine;
import it.objectmethod.fattura.domain.Utente;

public class FatturaDaoImpl implements FatturaDao {

	@Override
	public List<String> getNomeUtente() {
		
		Connection conn = ConnectionFactory.getConnection();
		List<String> nomiUtenti = new ArrayList<String>();
		String sql = "SELECT nome_utente, id_utente FROM utente;";
		
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				nomiUtenti.add(rs.getString("nome_utente"));
				nomiUtenti.add(rs.getString("id_utente"));
				
			}
			rs.close();
			stm.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nomiUtenti;

	}

	@Override
	public List<Fattura> getFattura(int idUtente) {
		
		Connection conn = ConnectionFactory.getConnection();
		List<Fattura> fattura = new ArrayList<Fattura>();

		String sql = "SELECT * FROM ordine o join riga_ordine ro on o.id_ordine = ro.id_ordine "
				+ "join utente u on u.id_utente = o.id_utente join articolo a on a.id_articolo = ro.id_articolo "
				+ "WHERE nome_utente = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, idUtente);
			while (rs.next()) {
				Fattura fatture = new Fattura();

				Articolo articolo = new Articolo();
				articolo.setCodiceArticolo(rs.getString("codice_articolo"));
				articolo.setDisponibilita(rs.getInt("disponibilita"));
				articolo.setIdArticolo(rs.getInt("id_articolo"));
				articolo.setNomeArticolo(rs.getString("nome_articolo"));
				articolo.setPrezzoUnitario(rs.getInt("prezzo_unitario"));

				Ordine ordine = new Ordine();
				ordine.setDataOrdine(rs.getString("data_ordine"));
				ordine.setIdOrdine(rs.getInt("id_ordine"));
				ordine.setIdUtente(rs.getInt("id_utente"));
				ordine.setNumeroOrdine(rs.getString("numero_ordine"));

				RigaOrdine rigaOrdine = new RigaOrdine();
				rigaOrdine.setIdArticolo(rs.getInt("id_articolo"));
				rigaOrdine.setIdOrdine(rs.getInt("id_ordine"));
				rigaOrdine.setIdRigaOrdine(rs.getInt("riga_ordine"));
				rigaOrdine.setQuantita(rs.getInt("quantita"));

				Utente utente = new Utente();
				utente.setIdUtente(rs.getInt("id_utente"));
				utente.setNomeUtente(rs.getString("nome_utente"));
				utente.setPassword(rs.getString("password"));

				fatture.setArticolo(articolo);
				fatture.setOrdine(ordine);
				fatture.setRigaOrdine(rigaOrdine);
				fatture.setUtente(utente);

				fattura.add(fatture);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fattura;

	}
}
