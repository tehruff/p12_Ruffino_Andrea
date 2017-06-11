package PrenotazioneVoli;
// ## Implementation preserve start class opening. 
// ## Implementation preserve end class opening. 

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import PrenotazioneVoli.TestScanner;


// ## Implementation preserve start class import. 
// ## Implementation preserve end class import. 
/**
 * Prenotazione è la classe principale per lo svolgimento degli use cases del progetto.
 * Contiene tutti i metodi per personalizzare un prenotazione di un volo; questi metodi
 * vengono richiamati nel giusto ordine dalla classe di TestMain, che si occupa di
 * inizializzare gli oggetti principali come Prenotazione e Utente, e validare i risultati ottenuti.
 * L'inizializzazione degli oggetti, ove serve, viene effettuata con valori casuali o con degli attributi della classe Database,
 * che contiene valori predefiniti, come specifici voli e posti a sedere; dato che non
 * è richiesto creare un sistema dinamico utilizzando un vero database esterno, Database 
 * serve a fornire valori di esempio per poter testare il comportamento del sistema, in 
 * numero limitato.
 *  
 * Oltre alla classe Database viene usata una classe wrapper TestScanner che contiene
 * metodi che consentono di richiedere input da console (oggetti Scanner).
 * Ogni input richiesto all'interno dei metodi di questa classe è controllato in modo
 * da non generare eccezioni o errori come InputMismatchException o ParseError:
 * il richiamo dei metodi next() o nextInt() della classe TestScanner è circondato da
 * try/catch e cicli while, in questo modo l'algoritmo forza l'utente a inserire
 * l'input atteso richiedendoglielo ad ogni errore commesso.
 *  
 * @author se-17-user
 *
 */
public class Prenotazione
// ## Implementation preserve start class extends. 
// ## Implementation preserve end class extends. 

// ## Implementation preserve start class inheritence. 
// ## Implementation preserve end class inheritence. 

{
    /**
     * La prenotazione viene istanziata con l'id e associato ad un utente, gli altri
     * parametri vengono settati durante la procedura di Prenotazione Volo
     * 
	 * @param identificativo int
	 * @param utente Utente
	 */
	public Prenotazione(int identificativo, Utente utente) {
		super();
		this.identificativo = identificativo;
		this.utente = utente;
		this.db = new Database();
		test = new TestScanner();
	}
	/** Attributes */
    private int identificativo;
    private int numeroPasseggeri;
    private double importo;
    // ## Implementation preserve start class attributes. 
    // ## Implementation preserve end class attributes. 
    /** Associations */
    private Volo volo;
    private Utente utente;
    private ArrayList<Posto> posto;
    private CheckIn check;
    private Assicurazione assic;
    private BagaglioStiva bs;
    private BagaglioMano bm;
    
    private Database db;
    private TestScanner test;
    // ## Implementation preserve start class associations. 
    // ## Implementation preserve end class associations. 
   
    /**
     * 
     *
     * Verifica che il numero di viaggiatori ottenuto in input dal metodo richiedePasseggeri
     * non ecceda il numero di posti non occupati disponibili sull'aereo.
     *
     * @param numeroPasseggeri int
     * @return Boolean
     */
    public Boolean verificaPosti ( int numeroPasseggeri)
    {
    	Volo volo = this.getVolo();
    	ArrayList<Posto> liberi = new ArrayList<Posto>();
    	
    	//ottengo una lista di posti liberi
    	for(int k=0; k < volo.getPosti();k++){
    		if(!(volo.getPosto().get(k).getOccupato())) {
    			liberi.add(volo.getPosto().get(k));
    		}
    	}
    	
    	//confronto il numero di passeggeri immessi con il numero di posti liberi
    	if(numeroPasseggeri > liberi.size()) {
    		this.showErrore();
    		return false;
    	} else {
    		return true;
    	}
        // ## Implementation preserve start class method.verificaPosti@Boolean@@@int 
        // ## Implementation preserve end class method.verificaPosti@Boolean@@@int 
    }
   
    /**
     * 
     *
     * Viene chiamata nel caso non ci siano abbastanza posti disponibili per la
     * prenotazione per mostrare un messaggio di errore
     */
    public void showErrore (  )
    {
    	System.out.println("Non ci sono abbastanza posti liberi sull'aereo selezionato: riprova modificando questo parametro della prenotazione");
        
    	// ## Implementation preserve start class method.showErrore@void@@ 
        // ## Implementation preserve end class method.showErrore@void@@ 
    }
    /**
     * 
     *
     * Recupera i dati dagli attributi della prenotazione e calcola l'importo 
     * totale da pagare 
     *
     * @param volo Volo
     * @param ass Assicurazione
     * @param posto ArrayList<Posto>
     * @param ci CheckIn
     * @param bm BagaglioMano
     * @param bs BagaglioStiva
     * @param numeroPasseggeri int
     * @return double 
     */
    public double calcolaImporto ( Volo volo, Assicurazione ass, ArrayList<Posto> posto, CheckIn ci, BagaglioMano bm, BagaglioStiva bs, int numeroPasseggeri)
    {
    	double totale;
    	totale = 0;
        // ## Implementation preserve start class method.calcolaImporto@double@@@Volo@Assicurazione@Posto@CheckIn@BagaglioMano@BagaglioStiva 
        // ## Implementation preserve end class method.calcolaImporto@double@@@Volo@Assicurazione@Posto@CheckIn@BagaglioMano@BagaglioStiva 
    	int i;
    	totale = totale + volo.getCosto();
    	totale = totale * numeroPasseggeri;
    	totale = totale + ass.getCosto();
    	totale = totale + ci.getCosto();
    	totale = totale + bs.getCostoBs();
    	totale = totale + bm.getCostoBm();
    	for(i=0; i < posto.size(); i++){
    
    		totale = totale + posto.get(i).getCosto();
    	}
    	return totale;
    }
    /**
     * 
     *
     * Gestisce la parte del pagamento effettuata dal sistema; 
     * visto che non rientra nei requisiti da implementare del mio progetto,
     * mostra una stringa in output.
     */
    public void effettuaPagamento (  )
    {
    	System.out.println("Il pagamento è stato gestito con successo");
        // ## Implementation preserve start class method.effettuaPagamento@void@@ 
        // ## Implementation preserve end class method.effettuaPagamento@void@@ 
    }
    /**
     * 
     *
     * Prende come parametro lo sconto scelto nel metodo visualizzaSconti
     * e calcola il nuovo importo totale, settandolo come attributo
     * 
     * @param sconto Sconto
     * 
     */
    public void applicaSconto ( Sconto sconto )
    {
    	double totale = this.getImporto();
    	totale = totale - totale*sconto.getPercentuale();
    	this.setImporto(totale);
        // ## Implementation preserve start class method.applicaSconto@void@@@Sconto 
        // ## Implementation preserve end class method.applicaSconto@void@@@Sconto 
    }
    /**
     * 
     *
     * Procedura per settare una nuova carta dell'utente con cui pagare la prenotazione.
     * Questa nuova carta viene usata solo in questo ambito e non viene associata all'
     * account. La parte di verifica della legittimità del numero, codice e scadenza 
     * va oltre lo scopo di questo progetto, quindi possono essere degli input qualsiasi;
     * per lo stesso motivo si richiede di inserire direttamente la somma di denaro 
     * disponibile, in quanto non è implementato un metodo di verifica bancaria.
     * 
     * @return Carta
     */
    public Carta cambiaCarta (  )
    {
    	int numCarta=0;
    	int codSicurezza=0;
    	String scadenza="";
    	double denaro=0;
    	Boolean checked = false;
    	//inserisci carta
    	while(!checked){
    		
    		try{
    			System.out.println("Inserisci il numero della nuova carta per effettuare il pagamento");
    		
    			
    			numCarta = test.nextInt();
    			System.out.println(numCarta);
    	
    			System.out.println("Inserisci il numero di sicurezza della nuova carta");
    			
    			codSicurezza= test.nextInt();
    			System.out.println(codSicurezza);
    	
    			System.out.println("Inserisci la scadenza della nuova carta");
    			
    			scadenza = test.next();
    			System.out.println(scadenza);
    	
    			System.out.println("Inserisci la quantità di denaro sulla nuova carta");
    			
    			denaro=test.nextInt();
    			System.out.println(denaro);
    			
    			checked = true;
    		}
    		catch(InputMismatchException e){
    			System.out.println("Input errato:      riprova per favore");
				

    		}
    	}
    	Carta carta = new Carta(numCarta, codSicurezza, scadenza, denaro);
    	
    	return carta;
        // ## Implementation preserve start class method.cambiaCarta@Carta@@@int@int@Date 
        // ## Implementation preserve end class method.cambiaCarta@Carta@@@int@int@Date 
    }
    /**
     * 
     *
     * Verifica che la carta inserita nel metodo cambiaCarta contenga denaro
     * sufficiente per pagare l'importo della prenotazione
     * 
     * @param carta Carta
     * @return Boolean
     */
    public Boolean verificaCarta ( Carta carta )
    {
        // ## Implementation preserve start class method.verificaCarta@Boolean@@@Carta 
        // ## Implementation preserve end class method.verificaCarta@Boolean@@@Carta
    	if(carta.getDenaro() > this.getImporto()) {
    		return true;
    	} else {
    		System.out.println("Denaro insufficiente per gestire la prenotazione");
    		return false;
    	}
    }
    /**
     * 
     * 
     * metodo che richiede in input i parametri di ricerca del volo: i primi due sono
     * delle stringhe che corrispondono alle città di partenza e di arrivo 
     * rispettivamente, mentre l'ultima è una data da inserire col pattern dd/mm/yyyy
     * 
     * @return String[]
     */
    public String[] richiedeParametri (  )
    {
    	String[] parametri = {"","", ""};
    	System.out.println("Inserisci la città di partenza [inserire solo milano, londra, madrid, barcellona, berlino]");
    	String partenza;
    	//inserisci la partenza
    	
    	
    	
    	partenza = test.next();
    	
    	System.out.println("Inserisci la città di arrivo [inserire solo parigi]");
    	String destinazione;
    	//inserisci la destinazione
    	
    	
    	destinazione = test.next();
    	Boolean checked = false;
    	String data ="";
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	while(!checked) {
    		System.out.println("Inserisci la data del volo [inserire numeri nel formato dd/mm/yyyy]");
    	
    		//inserisci la data oltre la quale si vuole partire
    	
    		
    		data = test.next();
    	
    		try {

    			Date date = formatter.parse(data);
    			checked = true;

    		} catch (ParseException e) {
    		}
    	}
    	
    	//
    	
    	parametri[0]=partenza;
    	parametri[1]=destinazione;
    	parametri[2]=data;
    	
    	
    	return parametri;
        // ## Implementation preserve start class method.richiedeParametri@String[]@@ 
        // ## Implementation preserve end class method.richiedeParametri@String[]@@ 
    }
    /**
     * 
     * 
     * Visualizza i risultati dei voli in base ai parametri immessi nel
     * metodo richiedeParametri, in data uguale o successiva a quella indicata
     * 
     * 
     * @param risultati ArrayList<Volo>
     * 
     * @return Volo
     */
    public Volo visualizzaRisultati ( ArrayList<Volo> risultati )
    {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	String date ="";
    	System.out.println("Lista voli successivi alla data indicata");
    	
    	//visualizza i risultati trovati in ricercaVolo
    	for(int i=0; i < risultati.size(); i++){
    		date= formatter.format(risultati.get(i).getDataPartenza());
    		System.out.println(i +") " + date + "  " + risultati.get(i).getPartenza() + "--" + risultati.get(i).getDestinazione() + "   Euro:"+ risultati.get(i).getCosto());
    	}
    	System.out.println("Inserisci il numero del volo che vuoi prenotare");
    	int conferma=0;
    	
    	//richiede di inserire la scelta del volo
    	Boolean checked = false;
    	while(!checked){
    		Scanner S=new Scanner(System.in);
    		try {
    			
    			conferma = test.nextInt();
    			if(!(conferma < risultati.size() && (conferma >= 0))) {
    		
    				System.out.println("Input errato:              Scegli un volo esistente");
    				conferma = 0;
    			} else {
    				checked = true;
    			}
    		}
    			catch(InputMismatchException e){
    				System.out.println("Input errato:              Scegli un volo esistente");
    				S.reset();
    				conferma = 0;
    			}
    	}
    	Volo selezionato = risultati.get(conferma);
    	
    	return selezionato;
        
    }
    /**
     * 
     * 
     * Permette all'utente di inserire il numero dei passeggeri per i quali si vuole
     * prenotare il volo.
     * 
     * @return int
     */
    public int richiedePasseggeri (  )
    {
    	int num = 0;
    	System.out.println("Inserisci il numero di passeggeri");
    	Boolean checked = false;
    	
    	while(!checked){
    		
    		try {
    			
    			num = test.nextInt();
    			if(num <= 0){
    				System.out.println("Non puoi prenotare un volo per zero persone o meno...");
    			}
    			else{
    				checked = true;
    			}
    		} 
    		catch(InputMismatchException e){
				System.out.println("Input errato:              riprova");
				
			}
    	}
    	return num;
       
    }
    /**
     * 
     *
     * Chiede all'utente di inserire quali posti si vuole 
     * digitando il numero dell'indice dell'oggetto che si intende selezionare
     * Viene effettuato prima un controllo sui posti non occupati sull'aereo,
     * per aggiungerli a una lista temporanea nonOccupati, e poi
     * si richiede di scegliere un posto fino a che non se ne sono prenotati tanti
     * quanti sono i passeggeri per la prenotazione corrente. A ogni passo è
     * aggiornata la disponibilità delle postazioni nell'attributo "posto" dell'oggetto Volo
     * 
     * 
     * @return ArrayList<Posto> 
     */
    public ArrayList<Posto> richiedePosti (  )
    {
    	ArrayList<Posto> nonOccupati = new ArrayList<Posto>();
    	ArrayList<Posto> selezionati = new ArrayList<Posto>();
    	
    	for(int j=0; j < this.getNumeroPasseggeri(); j++){
    		System.out.println("Lista dei posti disponibili sull'aereo");
    		nonOccupati.clear();
    		
    		//inserisce i posti disponibili in una lista temporanea
    		for(int i=0; i < this.getVolo().getPosto().size(); i++){
        		
        		if(!(this.getVolo().getPosto().get(i).getOccupato())) {
        				nonOccupati.add(this.getVolo().getPosto().get(i));
        		}
        		
        	}
    		
    		//visualizza i risultati
    		for(int i=0; i < nonOccupati.size(); i++){
    			String tipo ="";
    			if(nonOccupati.get(i).getPremium()) {
    				tipo = "Premium ";
    			} else {
    				tipo = "Standard ";
    			}
    			System.out.println(i +") "+ nonOccupati.get(i).getNumero() +"   Tipo:" + tipo + " Euro:"+ nonOccupati.get(i).getCosto());
    		
    		}
    		System.out.println("Inserisci il numero del posto che vuoi prenotare ");
    		int num = 0;
    		
    		
    			//chiede di inserire la scelta
    			Boolean checked = false;
    	    	
    	    	while(!checked){
    	    		
    	    		try {
    	    			
    	    			num = test.nextInt();
    	    			if(!(num < nonOccupati.size() && (num >= 0))){
    	    				System.out.println("Posto non disponibile:              Scegli un posto libero");
    	    			}
    	    			else {
    	    				checked = true;
    	    				
    	    			}
    	    				
    	    		}
    	    				
    	    		catch(InputMismatchException e){
    					System.out.println("Input errato:              riprova");
    					
    				}
    	    	}
    	    	
    	    	//inserisce il posto selezionato all'interno della lista dei posti della 
    	    	//prenotazione e aggiorna i posti occupati sul volo selezionato
    	    	int id = nonOccupati.get(num).getNumero();
    	    	selezionati.add(nonOccupati.get(num));
    	    	this.getVolo().getPosto().get(id).setOccupato(true);
    	}
    	
    	return selezionati;
    }
    	
        
    
    /**
     * 
     * 
     * Chiede all'utente di inserire quale delle tipologie di bagaglio in stiva si vuole 
     * digitando il numero dell'indice dell'oggetto che si intende selezionare
     * 
     * 
     * @return BagaglioStiva
     */
    public BagaglioStiva richiedeBagaglioStiva (  )
    {	
    	ArrayList<BagaglioStiva> bagagli = db.getBs();
    
    	System.out.println("Inserisci il numero del tipo di bagaglio a stiva desiderato o  premi un tasto qualsiasi per non scegliere\n");
    	
    	for(int i=0; i< bagagli.size();i++){
    	
    		
    		System.out.println(i + ") "+ bagagli.get(i).getQuantita() + "x " + bagagli.get(i).getDimensioni() + "  Peso:"+ bagagli.get(i).getPeso() + " Costo: Euro " + bagagli.get(i).getCostoBs());
    	
    	}
    	int num;
    	
    	
    	
    	try {
    		
    		
   			num= test.nextInt();
    		if(num == 0){
   				return bagagli.get(0);
   			}
   			else {
   				if(num == 1){
   					return bagagli.get(1);
   				}
   				else{
   					if(num == 2){
   						return bagagli.get(2);
   					}
   					else return bagagli.get(0);
   				}
   			}
    			
   		}
   		catch(InputMismatchException e) {
   			return bagagli.get(0);
   		}
   	}
        // ## Implementation preserve start class method.richiedeBagaglioStiva@BagaglioStiva@@ 
        // ## Implementation preserve end class method.richiedeBagaglioStiva@BagaglioStiva@@ 
    
    /**
     * 
     * 
     * Chiede all'utente di inserire quale delle tipologie di bagaglio a mano si vuole 
     * digitando il numero dell'indice dell'oggetto che si intende selezionare
     * 
     * 
     * @return BagaglioMano
     */
    public BagaglioMano richiedeBagaglioMano (  )
    {
    	ArrayList<BagaglioMano> bagagli = db.getBm();
        
    	System.out.println("Inserisci il numero del tipo di bagaglio a mano desiderato o  premi un tasto qualsiasi per non scegliere\n");
    	
    	for(int i=0; i< bagagli.size();i++){
    	
    		
    		System.out.println(i + ") "+ bagagli.get(i).getQuantita() + "x " + bagagli.get(i).getDimensioni() + "  Peso:"+ bagagli.get(i).getPeso() + " Costo: Euro " + bagagli.get(i).getCostoBm());
    	
    	}
    	int num;
    	
    	
    	try{
    		
    		num = test.nextInt();
    		if(num == 0){
    			return bagagli.get(0);
    		}
    		else {
    			if(num == 1){
    				return bagagli.get(1);
    			}
    			else{
    				if(num == 2){
    					return bagagli.get(2);
    				}
    				else return bagagli.get(0);
    			}
    		}
    	}
    	catch(InputMismatchException e) {
			return bagagli.get(0);
		}
        // ## Implementation preserve start class method.richiedeBagaglioMano@BagaglioMano@@ 
        // ## Implementation preserve end class method.richiedeBagaglioMano@BagaglioMano@@ 
    }
    /**
     * 
     * 
     * Chiede all'utente di inserire quale delle tipologie di assicurazione si vuole 
     * digitando il numero dell'indice dell'oggetto che si intende selezionare
     * 
     * @return Assicurazione
     */
    public Assicurazione richiedeAssicurazione (  )
    {
    	// ## Implementation preserve start class method.richiedeAsssicurazione@Assicurazione@@ 
        // ## Implementation preserve end class method.richiedeAsssicurazione@Assicurazione@@
    	System.out.println("Richiede assicurazione");
    	ArrayList<Assicurazione> assicurazioni = null;
    	
    	assicurazioni = db.getAssic();
    	
    	System.out.println("Inserisci il numero del tipo di assicurazione sul viaggio desiderata o  premi un tasto qualsiasi per non scegliere\n");
    	
    	for(int i=0; i< assicurazioni.size();i++){
    	
    		
    		System.out.println(i + ") "+ assicurazioni.get(i).getTipo() + ": " + assicurazioni.get(i).getDescrizione() + " Costo: Euro " + assicurazioni.get(i).getCosto());
    	
    	}
    	int num;
    	
    	
    	try{
    		
    		
        	num = this.test.nextInt();
        	
    		
    		
    		if(num == 0){
    			return assicurazioni.get(0);
    		}
    		else {
    			if(num == 1){
    				return assicurazioni.get(1);
    			}
    			else{
    				if(num == 2){
    					return assicurazioni.get(2);
    				}
    				else return assicurazioni.get(0);
    			}
    		}
    	}
    	catch(InputMismatchException e) {
       		return assicurazioni.get(0);
       	}
    }
    /**
     * 
     * 
     * Chiede all'utente di inserire quale delle tipologie di check in si vuole 
     * digitando il numero dell'indice dell'oggetto che si intende selezionare
     * 
     * @return CheckIn
     */
    public CheckIn richiedeCheckIn (  )
    {
    	// ## Implementation preserve start class method.richiedeCheckIn@CheckIn@@ 
        // ## Implementation preserve end class method.richiedeCheckIn@CheckIn@@ 
    	
    	ArrayList<CheckIn> ci = db.getIn();
        
    	System.out.println("Inserisci il numero del tipo di check-in desiderato o  premi un tasto qualsiasi per scegliere 'Online'\n");
    	
    	for(int i=0; i< ci.size();i++){
    	
    		
    		System.out.println(i + ") "+ ci.get(i).getTipo() + " Costo: Euro " + ci.get(i).getCosto());
    	
    	}
    	int num;
    	
    	
    	try {
    		
    		num= test.nextInt();
    		if(num == 0){
    			return ci.get(0);
    		}
    		else {
    			if(num == 1){
    				return ci.get(1);
    			}
    			else{
    				if(num == 2){
    					return ci.get(0);
    				}
    				else return ci.get(0);
    			}
    		}
    	}
    	catch(InputMismatchException e) {
   			return ci.get(0);
   		}
    }
    /**
     * 
     * 
     * Mostra in output tutte le informazioni relative alla prenotazione creata e da la
     * possibilità di completare la procedura, annullarla e accedere alle funzionalità
     * di cambiare carta per pagare o applicare uno sconto disponibile.
     * I controlli per evitare che possa essere riusato uno sconto o che si possa applicare più
     * di  uno sconto alla stessa prenotazione sono implementati in questo metodo, oltre
     * a richiamare i metodi di verificaCarta e verificaVolo per validare la buona riuscita della prenotazione.
     * 
     * @return Boolean
     */
    public Boolean visualizzaAnteprima (  )
    {
    	Boolean giaUsato = false;
    	Carta carta = this.getUtente().getCarta();
    	
    	//visualizza tutti i dettagli della prenotazione personalizzata fino ad ora
    	System.out.println("\n 							ANTEPRIMA DI PRENOTAZIONE\n");  
    	System.out.println(this.getIdentificativo() +"   Volo " + this.getVolo().getPartenza()+ "--"+ this.getVolo().getDestinazione() + " cod."+ this.getVolo().getCodiceVolo());
    	System.out.println(this.getUtente().getNome() + " " + this.getUtente().getCognome()+ " ID."+ this.getUtente().getIdentificativo());
    	System.out.println("Data: " + this.getVolo().getDataPartenza()+ ";    Passeggeri: "+ this.getNumeroPasseggeri() + "\n");
    	System.out.println("Posti prenotati: ");
    	for(int k =0; k< this.getPosto().size(); k++){
    		System.out.println(this.getPosto().get(k).getNumero());
    	}
    	System.out.println("Assicurazione: "+ this.getAssic().getTipo() + "; Check-in: "+ this.getCheck().getTipo()+ "; Bagaglio in Stiva: "+ this.getBs().getQuantita() + "; Bagaglio a Mano: "+ this.getBm().getQuantita());
    	System.out.println("Euro "+ this.getImporto());
    	String conferma="";
    	
    	//richiede una scelta: proseguire o accedere alle feature i sconto o cambio carta
    	//il ciclo permette di rimanere nella fase di anteprima fino a che non si accetta (y) o rifiuta (n)
    	
    	int index;
    	while(!(conferma.equals("y") || conferma.equals("n"))){
    		System.out.println("\n                                Confermi? [y/n per proseguire, c per cambiare carta, s per applicare uno sconto]");
        	
    		
    		//questo ciclo permette di ritornare alla possibilità di scelta dopo un input
    		//errato o una scelta di una feature aggiuntiva( che non implica la fine della prenotazione)
    		
    		conferma=test.next();
    		while(!(conferma.equals("y") || conferma.equals("n") || conferma.equals("s") || conferma.equals("c"))){
    			System.out.println("Input errato:                   Confermi?[y/n/c/s]");
    			
    			conferma=test.next();
    		}
    		
    		//dopo la conferma si effettua un ultimo controllo sulla sufficienza di dcenaro sulla carta
    		if(conferma.equals("y")){
    		
    			Boolean checkCard = false;
				while(!checkCard){
					
					checkCard = this.verificaCarta(carta);
					if(!checkCard){
						
						carta = this.cambiaCarta();
					}
				}
    			this.verificaVolo(volo);
    			this.effettuaPagamento();
    			
    			return true;
    		}
    		else {
    			if(conferma.equals("c")) { 
    				Boolean checkCard = false;
    				while(!checkCard){
    					
    					//inserisci num carta codice sicurezza e scadenza per la nuova carta
    					carta = this.cambiaCarta();
    					checkCard = this.verificaCarta(carta);
    				}
    			}
    			if(conferma.equals("s")){   	//feature per applicare sconto
    				if(giaUsato 
    							|| this.getUtente().getSconti().isEmpty()){
    					System.out.println("Non hai più sconti disponibili per questa prenotazione!");
    				} else {
    				Sconto s = this.richiedeSconto();
    				this.applicaSconto(s);
    				index = this.getUtente().getSconti().indexOf(s);
    				this.getUtente().getSconti().remove(index);
    				giaUsato=true;
    				}
    			}
    			if(conferma.equals("n")){
    				
    				return false;
    			}
    		}
    	}
    	//il tester non potrà mai raggiungere questa zona: ogni selezione è gestita dentro
    	//al ciclo, ma il compilatore necessita di uno statement di return anche fuori da esso
    	return true;
    	
    }
    /**
     * 
     * 
     * Ricerca i risultati dei voli che corrispondono ai parametri immessi nel
     * metodo richiedeParametri in data uguale o successiva a quella indicata
     * fra i parametri della classe Database.
     * Se la lista dei risultati è vuota è gestito nel TestMain che l'utente debba 
     * inserire nuovamente i parametri di ricerca nel metodo richiedeParametri.
     * @param String[]
     * @return ArrayList<Volo>
     */
    @SuppressWarnings("deprecation")
	public ArrayList<Volo> ricercaVolo ( String[] parametri )
    {
    	
    	ArrayList<Volo> soluzioni = new ArrayList<Volo>();
    	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         String dateInString = parametri[2];
         Date date1 = new Date();
         Date date2 = new Date();
         try {

             date1 = formatter.parse(dateInString);
            
         } catch (ParseException e) {
            return soluzioni;
         }
         ArrayList<Volo> tuttiVoli = db.getVolo();
         System.out.println(date2.toString());
         System.out.println(date1.toString());
    	for(int i=0; i < tuttiVoli.size(); i++){
    		
    		
    		date2 = db.getVolo().get(i).getDataPartenza();
    		if(date1.before(date2) 
    					&& parametri[0].equals(db.getVolo().get(i).getPartenza()) 
    					&& parametri[1].equals(db.getVolo().get(i).getDestinazione())) {
    		
    			soluzioni.add(db.getVolo().get(i));
    			
    			}
    	}
    	
    	if(soluzioni.isEmpty()){
    		System.out.println("Nessun risultato trovato.");
    	}
    	
    	
    	return soluzioni;
        // ## Implementation preserve start class method.ricercaVolo@ArrayList<Volo>@@ 
        // ## Implementation preserve end class method.ricercaVolo@ArrayList<Volo>@@ 
    }
    
  
    /**
     * 
     *
     * Ottiene una lista di sconti disponibili per l'utente corrente e li
     * visualizza, quindi richiede di sceglierne uno che verrà passato
     * al metodo applicaSconto 
     *
     * @return Sconto
     */
    public Sconto richiedeSconto (  )
    {
    
    	ArrayList<Sconto> s = new ArrayList<Sconto>();
    	System.out.println("Lista sconti accreditati al tuo account");
    	for(int i=0; i < this.getUtente().getSconti().size(); i++){
    		
    		System.out.println("Sconto "+ i +") "+ this.getUtente().getSconti().get(i).getPercentuale());
    		
    		s.add(this.getUtente().getSconti().get(i));
    		
    	}
    	System.out.println("Inserisci il numero dello sconto che vuoi utilizzare ");
    	int conferma=0;
    	
    	Boolean checked = false;
    	
    	while(!checked){
    		
    		try{
    			
    			conferma=test.nextInt();
    			if(!(conferma < this.getUtente().getSconti().size() && (conferma >= 0))){
    				System.out.println("Input errato:              Scegli uno sconto");
    				
    			} else{
    				checked = true;
    			}
    		}
    		catch(InputMismatchException e){
    			System.out.println("Input errato:              Scegli uno sconto");
    			
    		}
    		
    		}
    	Sconto sconto = s.get(conferma);
    	
    	return sconto;
        // ## Implementation preserve start class method.getSconti@ArrayList<Sconti>@@ 
        // ## Implementation preserve end class method.getSconti@ArrayList<Sconti>@@ 
    }
    /**
     * 
     *
     * Operazione gestita dal sistema che dovrebbe verificare sul Database la correttezza
     * della prenotazione che si vuole effettuare riguardo al volo scelto, cosa che
     * esula da questo progetto, per questo mostra una stringa e ritorna un successo
     *
     * @param v Volo
     * @return Boolean
     */
    public Boolean verificaVolo ( Volo v )
    {
    	System.out.println("Volo verificato: accesso alla feature di pagamento.   .   .   .");
    	return true;
        // ## Implementation preserve start class method.verificaVolo@Boolean@@@Volo 
        // ## Implementation preserve end class method.verificaVolo@Boolean@@@Volo 
    }
    /**
     * 
     *
     * Verifica che l'utente attuale sia registrato in ordine da poter accedere alla
     * funzione di prenotazione dalla feature di ricerca volo: in questa implementazione
     * semplicemente ritorna un successo
     *
     * @return Boolean
     */
    public Boolean verificaRegistrato (  )
    {
    	System.out.println("Utente registrato: accesso alla feature di prenotazione volo");
    	return true;
        // ## Implementation preserve start class method.verificaRegistrato@Boolean@@ 
        // ## Implementation preserve end class method.verificaRegistrato@Boolean@@ 
    }
    // ## Implementation preserve start class other.operations. 
    // ## Implementation preserve end class other.operations. 
    
    /**
     * 
     * 
     * Ritorna l'attributo identificativo della classe
     * 
     * @return int
     */
	public int getIdentificativo() {
		return identificativo;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo identificativo
	 * 
	 * @param identificativo int
	 */
	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo numeroPasseggeri della classe
     * 
     * @return int
     */
	public int getNumeroPasseggeri() {
		return numeroPasseggeri;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo numeroPasseggeri
	 * 
	 * @param numeroPasseggeri int
	 */
	public void setNumeroPasseggeri(int numeroPasseggeri) {
		this.numeroPasseggeri = numeroPasseggeri;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo importo della classe
     * 
     * @return double
     */
	public double getImporto() {
		return importo;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo importo
	 * 
	 * @param importo double
	 */
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo volo della classe
     * 
     * @return Volo
     */
	public Volo getVolo() {
		return volo;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo volo
	 * 
	 * @param volo Volo
	 */
	public void setVolo(Volo volo) {
		this.volo = volo;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo utente della classe
     * 
     * @return Utente
     */
	public Utente getUtente() {
		return utente;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo utente
	 * 
	 * @param utente Utente
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo posto della classe
     * 
     * @return ArrayList<Posto>
     */
	public ArrayList<Posto> getPosto() {
		return posto;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo posto
	 * 
	 * @param posto ArrayList<Posto>
	 */
	public void setPosto(ArrayList<Posto> posto) {
		this.posto = posto;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo check della classe
     * 
     * @return CheckIn
     */
	public CheckIn getCheck() {
		return check;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo check
	 * 
	 * @param check CheckIn
	 */
	public void setCheck(CheckIn check) {
		this.check = check;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo assic della classe
     * 
     * @return Assicurazione
     */
	public Assicurazione getAssic() {
		return assic;
	}
	
	/**
	 * 
	 * Setta l'attributo assic
	 * 
	 * @param assic Assicurazione
	 */
	public void setAssic(Assicurazione assic) {
		this.assic = assic;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo bs della classe
     * 
     * @return BagaglioStiva
     */
	public BagaglioStiva getBs() {
		return bs;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo bs
	 * 
	 * @param bs BagaglioStiva
	 */
	public void setBs(BagaglioStiva bs) {
		this.bs = bs;
	}
	
	/**
     * 
     * 
     * Ritorna l'attributo bm della classe
     * 
     * @return BagaglioMano
     */
	public BagaglioMano getBm() {
		return bm;
	}
	
	/**
	 * 
	 * 
	 * Setta l'attributo bm
	 * 
	 * @param bm BagaglioMano
	 */
	public void setBm(BagaglioMano bm) {
		this.bm = bm;
	}

	public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	public TestScanner getTest() {
		return test;
	}

	public void setTest(TestScanner test) {
		this.test = test;
	}
}





