package PrenotazioneVoli;
// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 
import java.util.ArrayList;
import java.util.Date;
// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * Definisce tutti i dettagli relativi a ciuascun volo.
 * @author se-17-user
 *
 */
public class Volo
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
	 * @param partenza String
	 * @param destinazione String
	 * @param codiceVolo int
	 * @param dataPartenza Date
	 * @param compagniaAerea String
	 * @param costo double
	 * @param posti int
	 * @param posto ArrayList<Posto>
	 */
	public Volo(String partenza, String destinazione, int codiceVolo, Date dataPartenza, String compagniaAerea,
			double costo, int posti, ArrayList<Posto> posto) {
		super();
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.codiceVolo = codiceVolo;
		this.dataPartenza = dataPartenza;
		this.compagniaAerea = compagniaAerea;
		this.costo = costo;
		this.posti = posti;
		this.posto = posto;
	}
	/** Attributes */
    private String partenza;
    private String destinazione;
    private int codiceVolo;
    private Date dataPartenza;
    private String compagniaAerea;
    private double costo;
    private int posti;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
    /** Associations */
    private ArrayList<Posto> posto;
    // ## Implementation preserve start class associations. 
    // ## Implementation preserve end class associations. 
    // ## Implementation preserve start class other.operations. 
    // ## Implementation preserve end class other.operations. 
    /**
     * Metodo get dell'attributo partenza
     * @return String
     */
	public String getPartenza() {
		return partenza;
	}
	/**
	 * Metodo set dell'attributo partenza
	 * @param partenza String
	 */
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}
	/**
	 * Metodo get dell'attributo destinazione
	 * @return String
	 */
	public String getDestinazione() {
		return destinazione;
	}
	/**
	 * Metodo set dell'attributo destinazione
	 * @param destinazione String
	 */
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	/**
	 * Metodo get dell'attributo codiceVolo
	 * @return int
	 */
	public int getCodiceVolo() {
		return codiceVolo;
	}
	/**
	 * Metodo set dell'attributo codiceVolo
	 * @param codiceVolo int
	 */
	public void setCodiceVolo(int codiceVolo) {
		this.codiceVolo = codiceVolo;
	}
	/**
	 * Metodo get dell'attributo dataPartenza
	 * @return String
	 */
	public Date getDataPartenza() {
		return dataPartenza;
	}
	/**
	 * Metodo set dell'attributo dataPartenza
	 * @param dataPartenza String
	 */
	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	/**
	 * Metodo get dell'attributo compagniaAerea
	 * @return String
	 */
	public String getCompagniaAerea() {
		return compagniaAerea;
	}
	/**
	 * Metodo set dell'attributo compagniaAerea
	 * @param compagniaAerea String
	 */
	public void setCompagniaAerea(String compagniaAerea) {
		this.compagniaAerea = compagniaAerea;
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
	/**
	 * Metodo get dell'attributo posti
	 * @return int
	 */
	public int getPosti() {
		return posti;
	}
	/**
	 * Metodo set dell'attributo posti
	 * @param posti int
	 */
	public void setPosti(int posti) {
		this.posti = posti;
	}
	/**
	 * Metodo get dell'attributo posto
	 * @return ArrayList<Posto>
	 */
	public ArrayList<Posto> getPosto() {
		return posto;
	}
	/**
	 * Metodo set dell'attributo posto
	 * @param posto ArrayList<Posto>
	 */
	public void setPosto(ArrayList<Posto> posto) {
		this.posto = posto;
	}
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
