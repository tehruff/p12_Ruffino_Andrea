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
public class BagaglioStiva
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
     * Costruttore della classe BagaglioStiva: si possono istanziare oggetti che indicano
     * il numero, il peso, le dimensioni delle valigie e il costo per portarle sull'aereo.
     * 
	 * @param peso int
	 * @param dimensioni String
	 * @param quantita int
	 * @param costoBs double
	 * 
	 */
	public BagaglioStiva(int peso, String dimensioni, int quantita, double costoBs) {
		super();
		this.peso = peso;
		this.dimensioni = dimensioni;
		this.quantita = quantita;
		this.costoBs = costoBs;
		
	}
	/** Attributes */
    private int peso;
    private String dimensioni;
    private int quantita;
    private double costoBs;
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
	 * Metodo set dell'attributo peso
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
	 *  Metodo get dell'attributo costoBs
	 * @return double
	 */
	public double getCostoBs() {
		return costoBs;
	}
	/**
	 *  Metodo set dell'attributo costoBs
	 * @param costoBs double
	 */
	public void setCostoBs(double costoBs) {
		this.costoBs = costoBs;
	}
	
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
