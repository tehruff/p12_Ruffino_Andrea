package PrenotazioneVoli;
// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 
// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * Definisce ogni informazione relativa a un singolo posto su un volo.
 * 
 * 
 * @author se-17-user
 *
 */
public class Posto
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
	 * @param numero int
	 * @param premium Boolean
	 * @param occupato Boolean
	 * @param costo double
	 */
	public Posto(int numero, Boolean premium, Boolean occupato, double costo) {
		super();
		this.numero = numero;
		this.premium = premium;
		this.occupato = occupato;
		this.costo = costo;
	}
	/** Attributes */
    private int numero;
    private Boolean premium;
    private Boolean occupato;
    private double costo;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
   
    // ## Implementation preserve start class associations. 
    // ## Implementation preserve end class associations. 
    // ## Implementation preserve start class other.operations. 
    // ## Implementation preserve end class other.operations. 
    /**
     * Metodo get dell'attributo numero
     * @return int 
     */
	public int getNumero() {
		return numero;
	}
	/**
	 * Metodo set dell'attributo numero
	 * @param numero int
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * Metodo get dell'attributo premium
	 * @return Boolean
	 */
	public Boolean getPremium() {
		return premium;
	}
	/**
	 * Metodo set dell'attributo premium
	 * @param premium Boolean
	 */
	public void setPremium(Boolean premium) {
		this.premium = premium;
	}
	/**
	 * Metodo get dell'attributo occupato
	 * @return Boolean
	 */
	public Boolean getOccupato() {
		return occupato;
	}
	/**
	 * Metodo set dell'attributo occupato
	 * @param occupato Boolean
	 */
	public void setOccupato(Boolean occupato) {
		this.occupato = occupato;
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
