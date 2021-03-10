package it.objectmethod.fattura.domain;

public class Articolo {
	private int idArticolo;
	private int disponibilita;
	private String codiceArticolo;
	private String nomeArticolo;
	private int prezzoUnitario;
	
	public int getIdArticolo() {
		return idArticolo;
	}
	public void setIdArticolo(int idArticolo) {
		this.idArticolo = idArticolo;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public String getCodiceArticolo() {
		return codiceArticolo;
	}
	public void setCodiceArticolo(String codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}
	public String getNomeArticolo() {
		return nomeArticolo;
	}
	public void setNomeArticolo(String nomeArticolo) {
		this.nomeArticolo = nomeArticolo;
	}
	public int getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public void setPrezzoUnitario(int prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

}
