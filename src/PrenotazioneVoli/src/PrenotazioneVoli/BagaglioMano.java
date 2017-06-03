package PrenotazioneVoli;
// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 

// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * Rappresenta un elemento facente parte della classe Prenotazione; l'utente
 * durante la procedura di prenotazione può assegnare i valori desiderati a un oggetto
 * di questa classe da aggiungere come attributo alla Prenotazione da personalizzare.
 * 
 * @author se-17-user
 *
 */
public class BagaglioMano
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
     * Costruttore della classe BagaglioMano: si possono istanziare oggetti che indicano
     * il numero, il peso, le dimensioni delle valigie e il costo per portarle sull'aereo.
     * 
	 * @param peso int
	 * @param dimensioni String
	 * @param quantita int
	 * @param costoBm double
	 * 
	 */
	public BagaglioMano(int peso, String dimensioni, int quantita, double costoBm) {
		super();
		this.peso = peso;
		this.dimensioni = dimensioni;
		this.quantita = quantita;
		this.costoBm = costoBm;
		
	}
	/** Attributes */
    private int peso;
    private String dimensioni;
    private int quantita;
    private double costoBm;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
    /**
     * Metodo get dell'attributo peso
     * @return int
     */
	public int getPeso() {
		return peso;
	}
	/**
	 * 
	 * @param peso int
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	/**
	 * Metodo get dell'attributo dimensioni
     * 
	 * @return String
	 */
	public String getDimensioni() {
		return dimensioni;
	}
	/**
	 *  Metodo set dell'attributo dimensioni
	 * @param dimensioni String
	 */
	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}
	/**
	 *  Metodo get dell'attributo quantita
	 * @return int
	 */
	public int getQuantita() {
		return quantita;
	}
	/**
	 *  Metodo set dell'attributo quantita
	 * @param quantita int
	 */
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	/**
	 *  Metodo get dell'attributo costoBm
	 * @return double
	 */
	public double getCostoBm() {
		return costoBm;
	}
	/**
	 *  Metodo set dell'attributo costoBm
	 * @param costoBm double
	 */
	public void setCostoBm(double costoBm) {
		this.costoBm = costoBm;
	}
	
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
