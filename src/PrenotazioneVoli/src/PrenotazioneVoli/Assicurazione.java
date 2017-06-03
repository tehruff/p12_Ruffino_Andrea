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
public class Assicurazione
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
     * 
     * Costruttore della classe Assicurazione: normalmente, sono definiti tre oggetti
     * assicurazione, di tipo "Nessuno", "Standard" e "Premium"
     * 
	 * @param tipo String
	 * @param descrizione String
	 * @param costo double
	
	 */
	public Assicurazione(String tipo, String descrizione, double costo) {
		super();
		this.tipo = tipo;
		this.descrizione = descrizione;
		this.costo = costo;
		
	}
	/** Attributes */
    private String tipo;
    private String descrizione;
    private double costo;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
    
    /**
     * Metodo get per l'attributo tipo
     * @return String
     */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Metodo set per l'attributo tipo
	 * @param tipo String
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Metodo get per l'attributo descrizione
	 * @return String
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * Metodo set per l'attributo descrizione
	 * @param descrizione String
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * Metodo get per l'attributo costo
	 * @return double
	 */
	public double getCosto() {
		return costo;
	}
	/**
	 * Metodo set per l'attributo costo
	 * @param costo double
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
