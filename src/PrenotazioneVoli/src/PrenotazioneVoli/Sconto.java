package PrenotazioneVoli;
// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 

// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * Definisce gli sconti applicabili all'importo di una prenotazione.
 * I controlli per evitare che possa essere riusato o che si possa applicare più
 * di uno sconto alla stessa prenotazione sono implementati nel metodo
 * visualizzaAnteprima della classe Prenotazione.
 * @author se-17-user
 *
 */
public class Sconto
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
	 * @param id int
	 * @param percentuale double
	 * @param disponibile Boolean
	 */
	public Sconto(int id, double percentuale, Boolean disponibile) {
		super();
		this.id = id;
		this.percentuale = percentuale;
		this.disponibile = disponibile;
	}
	/** Attributes */
	private int id;
    private double percentuale;
    private Boolean disponibile;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
    
    /**
     * Metodo get dell'attributo percentuale
     * @return double
     */
	public double getPercentuale() {
		return percentuale;
	}
	/**
	 * Metodo set dell'attributo percentuale
	 * @param percentuale double
	 */
	public void setPercentuale(double percentuale) {
		this.percentuale = percentuale;
	}
	/**
	 * Metodo get dell'attributo disponibile
	 * @return Boolean
	 */
	public Boolean getDisponibile() {
		return disponibile;
	}
	/**
	 * Metodo set dell'attributo disponibile
	 * @param disponibile Boolean
	 */
	public void setDisponibile(Boolean disponibile) {
		this.disponibile = disponibile;
	}
	/**
	 * Metodo get dell'attributo id
	 * @return int
	 */
	public int getId() {
		return id;
	}
	/**
	 * Metodo set dell'attributo id
	 * @param id int
	 */
	public void setId(int id) {
		this.id = id;
	}
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
