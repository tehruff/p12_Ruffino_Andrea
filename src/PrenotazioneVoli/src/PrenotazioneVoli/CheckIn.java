package PrenotazioneVoli;
// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 

// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * 
 * Rappresenta un elemento facente parte della classe Prenotazione; l'utente
 * durante la procedura di prenotazione può assegnare i valori desiderati a un oggetto
 * di questa classe da aggiungere come attributo alla Prenotazione da personalizzare.
 * 
 * @author se-17-user
 *
 */
public class CheckIn
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
     * Costruttore della classe CheckIn
	 * @param tipo String
	 * @param costo double
	 */
	public CheckIn(String tipo, double costo) {
		super();
		this.tipo = tipo;
		this.costo = costo;
	}
	/** Attributes */
    private String tipo;
    private double costo;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
   
    // ## Implementation preserve start class associations. 
    // ## Implementation preserve end class associations. 
    // ## Implementation preserve start class other.operations. 
    // ## Implementation preserve end class other.operations. 
    /**
     * Metodo get dell'attributo tipo
     * @return String
     */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Metodo set dell'attributo tipo
	 * @param tipo String
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Metodo get dell'attributo costo
	 * @return double
	 */
	public double getCosto() {
		return costo;
	}
	/**
	 * Metodo set dell'attributo costo
	 * @param costo double
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
