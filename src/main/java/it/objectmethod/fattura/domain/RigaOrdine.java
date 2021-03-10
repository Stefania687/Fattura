package it.objectmethod.fattura.domain;

public class RigaOrdine {
	private int idOrdine;
	private int idArticolo;
	private int quantita;
	private int idRigaOrdine;
	
	public int getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public int getIdArticolo() {
		return idArticolo;
	}
	public void setIdArticolo(int idArticolo) {
		this.idArticolo = idArticolo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public int getIdRigaOrdine() {
		return idRigaOrdine;
	}
	public void setIdRigaOrdine(int idRigaOrdine) {
		this.idRigaOrdine = idRigaOrdine;
	}

}
