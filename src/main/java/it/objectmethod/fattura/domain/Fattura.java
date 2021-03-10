package it.objectmethod.fattura.domain;

public class Fattura {
	Articolo articolo = new Articolo();
	Ordine ordine = new Ordine();
	RigaOrdine rigaOrdine = new RigaOrdine();
	Utente utente = new Utente();
	
	public Articolo getArticolo() {
		return articolo;
	}
	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}
	public Ordine getOrdine() {
		return ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	public RigaOrdine getRigaOrdine() {
		return rigaOrdine;
	}
	public void setRigaOrdine(RigaOrdine rigaOrdine) {
		this.rigaOrdine = rigaOrdine;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	

}
