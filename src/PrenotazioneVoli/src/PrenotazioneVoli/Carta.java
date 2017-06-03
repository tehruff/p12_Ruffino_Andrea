package PrenotazioneVoli;


// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 

// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * Un oggetto di classe Carta può essere associato solo ad un utente; nel
 * TestMain prima viene creata una Carta per poter creare l'oggetto Utente
 * e poi viene associato l'utente alla carta, come parte della stessa 
 * associazione.
 * 
 * 
 * @author se-17-user
 *
 */
public class Carta
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
     * Costruttore della classe Carta: gli attributi non sono soggetti a controllo,
     * tranne denaro, perchè è oltre gli obiettivi del progetto
     * 
	 * @param numeroCarta int
	 * @param codiceSicurezza int
	 * @param scadenza String
	 * @param denaro double
	 */
	public Carta(int numeroCarta, int codiceSicurezza, String scadenza, double denaro) {
		super();
		this.numeroCarta = numeroCarta;
		this.codiceSicurezza = codiceSicurezza;
		this.scadenza = scadenza;
		this.denaro = denaro;
	}
	/** Attributes */
    private int numeroCarta;
    private int codiceSicurezza;
    private String scadenza;
    private double denaro;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
    /** Associations */
    private Utente utente;
    // ## Implementation preserve start class associations. 
    // ## Implementation preserve end class associations. 
    // ## Implementation preserve start class other.operations. 
    // ## Implementation preserve end class other.operations. 
    /**
     * Metodo get dell'attributo numeroCarta
     * @return int
     */
	public int getNumeroCarta() {
		return numeroCarta;
	}
	/**
	 * Metodo set dell'attributo numeroCarta
	 * @param numeroCarta int
	 */
	public void setNumeroCarta(int numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	/**
	 * Metodo get dell'attributo codiceSicurezza
	 * @return int
	 */
	public int getCodiceSicurezza() {
		return codiceSicurezza;
	}
	/**
	 * Metodo set dell'attributo codiceSicurezza
	 * @param codiceSicurezza int
	 */
	public void setCodiceSicurezza(int codiceSicurezza) {
		this.codiceSicurezza = codiceSicurezza;
	}
	/**
	 * Metodo get dell'attributo scadenza
	 * @return String
	 */
	public String getScadenza() {
		return scadenza;
	}
	/**
	 * Metodo set dell'attributo scadenza
	 * @param scadenza String
	 */
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	/**
	 * Metodo get dell'attributo denaro
	 * @return double
	 */
	public double getDenaro() {
		return denaro;
	}
	/**
	 * Metodo set dell'attributo denaro
	 * @param denaro double
	 */
	public void setDenaro(double denaro) {
		this.denaro = denaro;
	}
	/**
	 * Metodo get dell'attributo utente
	 * @return Utente
	 */
	public Utente getUtente() {
		return utente;
	}
	/**
	 * Metodo set dell'attributo utente
	 * @param utente Utente
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
