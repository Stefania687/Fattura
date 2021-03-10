package it.objectmethod.fattura.dao;

import java.util.List;

import it.objectmethod.fattura.domain.Fattura;

public interface FatturaDao {
	
	public List<String> getNomeUtente();

	public List<Fattura> getFattura(int idUtente);

}
