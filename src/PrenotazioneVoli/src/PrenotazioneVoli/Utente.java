package PrenotazioneVoli;
// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 

import java.util.ArrayList;
import java.util.Date;


// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * Definisce l'account dell'utente a cui è associata la procedura di prenotazione volo.
 * In questo progetto è definito un solo oggetto Utente con anagrafica predefinita e 
 * una lista di sconti accreditati prefissata.
 * 
 * 
 * @author se-17-user
 *
 */
public class Utente
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
     * Costruttore della classe Utente: definisce tutti i dettagli relativi l'anagrafica
     * dell'account dell'utente corrente. Non vengono memorizzate le diverse prenotazioni
     * e i pagamenti effettuati. L'utente per questo progetto è uno solo di default,
     * quindi nel main verrà istanziato un solo oggetto Utente, usando attributi generici,
     * in quanto non servirà verificarne l'autenticazione e la legittimità dei dati anagrafici.
     * La prenotazione della procedura corrente viene settata come valore dell'attributo prenot
     * solo in caso di esito positivo del metodo visualizzaAnteprima.
     * 
	 * @param nome String
	 * @param cognome String
	 * @param dataNascita Date
	 * @param sesso String
	 * @param citta String
	 * @param indirizzo String
	 * @param CAP int
	 * @param paese String
	 * @param email String
	 * @param cellulare int
	 * @param identificativo int
	 * @param miglia int
	 * 
	 */
	public Utente(String nome, String cognome, Date dataNascita, String sesso, String citta, String indirizzo, int cAP,
			String paese, String email, int cellulare, int identificativo, int miglia, Carta c) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.CAP = cAP;
		this.paese = paese;
		this.email = email;
		this.cellulare = cellulare;
		this.identificativo = identificativo;
		this.miglia = miglia;
		this.carta = c;
	}
	/** Attributes */
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String sesso;
    private String citta;
    private String indirizzo;
    private int CAP;
    private String paese;
    private String email;
    private int cellulare;
    private int identificativo;
    private int miglia;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
    /** Associations */
    
    private ArrayList<Sconto> sconti;
    private Carta carta;
    private Prenotazione prenot;
    // ## Implementation preserve start class associations. 
    // ## Implementation preserve end class associations. 
    // ## Implementation preserve start class other.operations. 
    // ## Implementation preserve end class other.operations. 
    /**
     * Metodo get dell'attributo nome
     * @return String
     */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo set dell'attributo nome
	 * @param nome String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
     * Metodo get dell'attributo cognome
     * @return String
     */
	public String getCognome() {
		return cognome;
	}
	/**
	 * Metodo set dell'attributo cognome
	 * @param cognome String
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
     * Metodo get dell'attributo dataNascita
     * @return Date
     */
	public Date getDataNascita() {
		return dataNascita;
	}
	/**
	 * Metodo set dell'attributo dataNascita
	 * @param dataNascita Date
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	/**
     * Metodo get dell'attributo sesso
     * @return String
     */
	public String getSesso() {
		return sesso;
	}
	/**
	 * Metodo set dell'attributo sesso
	 * @param sesso String
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	/**
     * Metodo get dell'attributo citta
     * @return String
     */
	public String getCitta() {
		return citta;
	}
	/**
	 * Metodo set dell'attributo citta
	 * @param citta String
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	/**
     * Metodo get dell'attributo indirizzo
     * @return String
     */
	public String getIndirizzo() {
		return indirizzo;
	}
	/**
	 * Metodo set dell'attributo indirizzo
	 * @param indirizzo String
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	/**
     * Metodo get dell'attributo CAP
     * @return int
     */
	public int getCAP() {
		return CAP;
	}
	/**
	 * Metodo set dell'attributo CAP
	 * @param cAP int
	 */
	public void setCAP(int cAP) {
		this.CAP = cAP;
	}
	/**
     * Metodo get dell'attributo paese
     * @return String
     */
	public String getPaese() {
		return paese;
	}
	/**
	 * Metodo get dell'attributo paese
	 * @param paese String
	 */
	public void setPaese(String paese) {
		this.paese = paese;
	}
	/**
     * Metodo get dell'attributo email
     * @return String
     */
	public String getEmail() {
		return email;
	}
	/**
	 * Metodo set dell'attributo email
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
     * Metodo get dell'attributo cellulare
     * @return int
     */
	public int getCellulare() {
		return cellulare;
	}
	/**
	 * Metodo set dell'attributo cellulare
	 * @param cellulare int
	 */
	public void setCellulare(int cellulare) {
		this.cellulare = cellulare;
	}
	/**
     * Metodo get dell'attributo identificativo
     * @return int
     */
	public int getIdentificativo() {
		return identificativo;
	}
	/**
	 * Metodo set dell'attributo identificativo
	 * @param identificativo int
	 */
	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}
	/**
     * Metodo get dell'attributo miglia
     * @return int
     */
	public int getMiglia() {
		return miglia;
	}
	/**
	 * Metodo set dell'attributo miglia
	 * @param miglia int
	 */
	public void setMiglia(int miglia) {
		this.miglia = miglia;
	}
	/**
     * Metodo get dell'attributo sconti
     * @return ArrayList<Sconto>
     */
	public ArrayList<Sconto> getSconti() {
		return sconti;
	}
	/**
	 * Metodo set dell'attributo sconti
	 * @param sconti ArrayList<Sconto>
	 */
	public void setS(ArrayList<Sconto> sconti) {
		this.sconti = sconti;
	}
	/**
     * Metodo get dell'attributo carta
     * @return Carta
     */
	public Carta getCarta() {
		return carta;
	}
	/**
	 * Metodo set dell'attributo carta
	 * @param c Carta
	 */
	public void setC(Carta c) {
		this.carta = c;
	}
	/**
     * Metodo get dell'attributo prenot
     * @return Prenotazione
     */
	public Prenotazione getPrenot() {
		return prenot;
	}
	/**
	 * Metodo set dell'attributo prenot
	 * @param prenot Prenotazione
	 */
	public void setPrenot(Prenotazione prenot) {
		this.prenot = prenot;
	}
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
