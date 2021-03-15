package it.objectmethod.fattura.dao;

import java.util.List;

import it.objectmethod.fattura.domain.Fattura;

public interface FatturaDao {

	public List<Fattura> getOrdini();

	public List<Fattura> getFattura(String numeroOrdine);

}
