package PrenotazioneVoli;
import java.util.ArrayList;
import java.util.Date;
/**
 * Classe usata come insieme di dati statici predefiniti in modo da simulare un vero 
 * database esterno. Questa scelta è stata effettuata per motivi di praticità e non
 * risulta nel diagramma dei modelli: l'applicazione infatti richiederebbe l'uso di un
 * server esterno al sistema, ma la sua realizzazione va oltre i fini di questo progetto.
 * È stato definito che ogni volo abbia la stessa serie di 20 posti.
 * La presenza di questa classe rappresenta una differenza con il diagramma delle classi.
 * 
 * @author se-17-user
 *
 */
public class Database {
	
	private static ArrayList<Posto> posto;
	private static ArrayList<Volo> volo;
	private static ArrayList<Sconto> sconto;
	private static ArrayList<Assicurazione> assic;
	private static ArrayList<BagaglioStiva> bs;
	private static ArrayList<BagaglioMano> bm;
	private static ArrayList<CheckIn> in;
	/**
	 * Il costruttore definisce gli attributi della classe, rendendoli pronti per l'utilizzo.
	 * Dovrebbe essere istanziato un oggetto Database nel costruttore della classe che lo utilizza,
	 * o nel TestMain, in modo da poter recuperare i dati con i metodi get.
	 * 
	 */
	public Database(){
		super();
		Date dpar1= new Date(117, 7, 5);
		Date dpar2= new Date(117, 7, 15);
		Date dpar3= new Date(117, 7, 25);
		Date dpar4= new Date(117, 7, 10);
		Date dpar5= new Date(117, 7, 12);
		Date dpar6= new Date(117, 8, 5);
		Date dpar7= new Date(117, 8, 15);
		Date dpar8= new Date(117, 8, 25);
		Date dpar9= new Date(117, 8, 7);
		Date dpar10= new Date(117, 9, 5);
		Date dpar11= new Date(117, 9, 15);
		Date dpar12= new Date(117, 9, 24);
		
		String milano = "milano";
		String parigi= "parigi";
		String budapest = "budapest";
		String londra = "londra";
		String madrid = "madrid";
		String barcellona = "barcellona";
		String berlino = "berlino";
		
		
		Sconto sconto1 = new Sconto(0, 0.1, true);
		Sconto sconto2 = new Sconto(1, 0.2, true);
		Sconto sconto3 = new Sconto(2, 0.3, true);
		
		
		
		
		
		ArrayList<Sconto> scontoT = new ArrayList<Sconto>();
		scontoT.add(sconto1);
		scontoT.add(sconto2);
		scontoT.add(sconto3);
		
		this.sconto = scontoT;
		
		
		Posto posto1= new Posto(0, false, false, 0); 
		Posto posto2= new Posto(1, false, false, 0); 
		Posto posto3= new Posto(2, false, false, 0); 
		Posto posto4= new Posto(3, false, true, 0); 
		Posto posto5= new Posto(4, false, true, 0); 
		Posto posto6= new Posto(5, false, false, 0); 
		Posto posto7= new Posto(6, false, false, 0); 
		Posto posto8= new Posto(7, false, true, 0); 
		Posto posto9= new Posto(8, false, true, 0); 
		Posto posto10= new Posto(9, false, false, 0); 
		Posto posto11= new Posto(10, true, false, 10); 
		Posto posto12= new Posto(11, true, true, 10); 
		Posto posto13= new Posto(12, true, false, 10); 
		Posto posto14= new Posto(13, true, true, 10); 
		Posto posto15= new Posto(14, true, true, 10); 
		Posto posto16= new Posto(15, true, true, 10); 
		Posto posto17= new Posto(16, true, true, 10); 
		Posto posto18= new Posto(17, true, false, 10); 
		Posto posto19= new Posto(18, true, false, 10); 
		Posto posto20= new Posto(19, true, true, 10); 
		

		
		
		ArrayList<Posto> postoT = new ArrayList<Posto>();
		postoT.add(posto1);
		postoT.add(posto2);
		postoT.add(posto3);
		postoT.add(posto4);
		postoT.add(posto5);
		postoT.add(posto6);
		postoT.add(posto7);
		postoT.add(posto8);
		postoT.add(posto9);
		postoT.add(posto10);
		postoT.add(posto11);
		postoT.add(posto12);
		postoT.add(posto13);
		postoT.add(posto14);
		postoT.add(posto15);
		postoT.add(posto16);
		postoT.add(posto17);
		postoT.add(posto18);
		postoT.add(posto19);
		postoT.add(posto20);
		
		
		this.posto = postoT;
		
		Volo volo1 = new Volo(budapest, parigi, 100, dpar1, "RyanAir", 220, 20, posto);
		Volo volo2 = new Volo(budapest, parigi, 101, dpar2, "Chczech Airlines", 240, 20, posto);
		Volo volo3 = new Volo(budapest, parigi, 102, dpar3, "British Airlines", 200, 20, posto);
		Volo volo4 = new Volo(milano, parigi, 103, dpar4, "Alitalia", 110, 20, posto);
		Volo volo5 = new Volo(milano, parigi, 104, dpar5, "RyanAir", 120, 20, posto);
		Volo volo6 = new Volo(milano, parigi, 105, dpar6, "Turkish Airlines", 130, 20, posto);
		Volo volo7 = new Volo(londra, parigi, 106, dpar7, "RyanAir", 100, 20, posto);
		Volo volo8 = new Volo(londra, parigi, 107, dpar8, "RyanAir", 120, 20, posto);
		Volo volo9 = new Volo(londra, parigi, 108, dpar9, "American Airlines", 120, 20, posto);
		Volo volo10 = new Volo(barcellona, parigi, 109, dpar11, "RyanAir", 220, 20, posto);
		Volo volo11 = new Volo(milano, parigi, 110, dpar12, "AirOne", 320, 20, posto);
		Volo volo12 = new Volo(londra, parigi, 111, dpar1, "RyanAir", 120, 20, posto);
		Volo volo13 = new Volo(berlino, parigi, 112, dpar2, "RyanAir", 440, 20, posto);
		Volo volo14 = new Volo(berlino, parigi, 113, dpar3, "AirOne", 520, 20, posto);
		Volo volo15 = new Volo(berlino, parigi, 114, dpar4, "Malaysia Airlines", 20, 20, posto);
		Volo volo16 = new Volo(madrid, parigi, 115, dpar5, "RyanAir", 220, 20, posto);
		Volo volo17 = new Volo(madrid, parigi, 116, dpar6, "American Airlines", 320, 20, posto);
		Volo volo18 = new Volo(madrid, parigi, 117, dpar7, "RyanAir", 120, 20, posto);
		Volo volo19 = new Volo(barcellona, parigi, 118, dpar8, "RyanAir", 180, 20, posto);
		Volo volo20 = new Volo("Sidney", "LAX", 815, dpar9, "Oceanic Airlines", 500, 20, posto);
		
		
		
		
		
		
		ArrayList<Volo> voloT = new ArrayList<Volo>();
		voloT.add(volo1);
		voloT.add(volo2);
		voloT.add(volo3);
		voloT.add(volo4);
		voloT.add(volo5);
		voloT.add(volo6);
		voloT.add(volo7);
		voloT.add(volo8);
		voloT.add(volo9);
		voloT.add(volo10);
		voloT.add(volo11);
		voloT.add(volo12);
		voloT.add(volo13);
		voloT.add(volo14);
		voloT.add(volo15);
		voloT.add(volo16);
		voloT.add(volo17);
		voloT.add(volo18);
		voloT.add(volo19);
		voloT.add(volo20);
		
		this.volo = voloT;
		
		
		Assicurazione ass1 = new Assicurazione("Nessuna", "Prenotazione non coperta da assicurazione", 0);
		Assicurazione ass2 = new Assicurazione("Standard", "Rimborso del 50% del biglietto in caso di imprevisti", 10);
		Assicurazione ass3 = new Assicurazione("Premium", "Rimborso totale del biglietto in caso di imprevisti e cesto regalo in omaggio", 30);
		
		
		
		
		ArrayList<Assicurazione> assicT = new ArrayList<Assicurazione>();
		assicT.add(ass1);
		assicT.add(ass2);
		assicT.add(ass3);
		
		this.assic = assicT;
		
		
		BagaglioStiva stiva1 = new BagaglioStiva(0, "", 0, 0);
		BagaglioStiva stiva2 = new BagaglioStiva(20, "119cmx119cmx81cm", 1, 15);
		BagaglioStiva stiva3 = new BagaglioStiva(20, "119cmx119cmx81cm", 2, 25);
		
		BagaglioMano mano1 = new BagaglioMano(0, "", 0, 0);
		BagaglioMano mano2 = new BagaglioMano(20, "45cmx40cmx20cm", 1, 0);
		BagaglioMano mano3 = new BagaglioMano(20, "45cmx40cmx20cm", 2, 5);
		
		
		
		
		ArrayList<BagaglioStiva> bsT = new ArrayList<BagaglioStiva>();
		bsT.add(stiva1);
		bsT.add(stiva2);
		bsT.add(stiva3);
		
		this.bs = bsT;
		
		ArrayList<BagaglioMano> bmT = new ArrayList<BagaglioMano>();
		bmT.add(mano1);
		bmT.add(mano2);
		bmT.add(mano3);
		
		this.bm = bmT;
		
		
		CheckIn in1 = new CheckIn("Online", 0);
		CheckIn in2 = new CheckIn("Cartaceo", 5);
		
		
		
		ArrayList<CheckIn> inT = new ArrayList<CheckIn>();
		inT.add(in1);
		inT.add(in2);
		
		this.in = inT;
	}

	/**
	 * Metodo get dell'attributo posto
	 * @return ArrayList<Posto>
	 */
	public static ArrayList<Posto> getPosto() {
		return posto;
	}

	
	/**
	 * Metodo get dell'attributo volo
	 * @return ArrayList<Volo>
	 */
	public static ArrayList<Volo> getVolo() {
		return volo;
	}

	
	/**
	 * Metodo get dell'attributo sconto
	 * @return ArrayList<Sconto>
	 */
	public static ArrayList<Sconto> getSconto() {
		return sconto;
	}

	
	/**
	 * Metodo get dell'attributo assic 
	 * @return ArrayList<Assicurazione>
	 */
	public static ArrayList<Assicurazione> getAssic() {
		return assic;
	}

	
	/**
	 * Metodo get dell'attributo bs
	 * @return ArrayList<BagaglioStiva>
	 */
	public static ArrayList<BagaglioStiva> getBs() {
		return bs;
	}

	
	/**
	 * Metodo get dell'attributo bm
	 * @return ArrayList<BagaglioMano>
	 */
	public static ArrayList<BagaglioMano> getBm() {
		return bm;
	}

	
	/**
	 * Metodo get dell'attributo in
	 * @return ArrayList<CheckIn>
	 */
	public static ArrayList<CheckIn> getIn() {
		return in;
	}

	
	
	
	
	
}
