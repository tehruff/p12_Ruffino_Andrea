package PrenotazioneVoli;
import java.util.ArrayList;
import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//inizializzazione degli oggetti
		Database db = new Database();
		int id = 001;
		Date dataNascita = new Date(1992, 5, 5);
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		carta.setUtente(utente);
		utente.setS(db.getSconto());
		Prenotazione p = new Prenotazione(id, utente);
		String[] par ={"","",""};
		
		ArrayList<Volo> voli = new ArrayList<Volo>();
		
		//richiede i parametri finchè non vengono trovati dei risultati
		while(voli.isEmpty()){
			par = p.richiedeParametri();
			voli = p.ricercaVolo(par);
		}
		//viene chiesto di decidere il volo da prenotare
		Volo volo = p.visualizzaRisultati(voli);
		
		p.setVolo(volo);
		p.verificaRegistrato();
		
		
		//richiede i passeggeri di questa prenotazione
		int numeroPasseggeri = 0;
		Boolean checked = false;
		numeroPasseggeri= p.richiedePasseggeri();
		
		//se il numero di passeggeri è troppo grande viene chiesto di riimmettere il numero
		while(!checked) {
			
			if(p.verificaPosti(numeroPasseggeri)) {
				checked = true;
			} else {
				numeroPasseggeri= p.richiedePasseggeri();
			}	
		} 
		p.setNumeroPasseggeri(numeroPasseggeri);
		
		//richiede quindi di inserire un posto disponibile sul volo per ciascun passeggero
		ArrayList<Posto> posti = new ArrayList<Posto>();
		
		posti = p.richiedePosti();
			
		p.setPosto(posti);
		
		//richiede di scegliere le restanti opzioni 
		BagaglioStiva bs= p.richiedeBagaglioStiva();
		p.setBs(bs);
		BagaglioMano bm= p.richiedeBagaglioMano();
		p.setBm(bm);
		CheckIn ci = p.richiedeCheckIn();
		p.setCheck(ci);
		Assicurazione as = p.richiedeAssicurazione();
		p.setAssic(as);
		
		//calcola la somma da pagare
		double totale = p.calcolaImporto(volo, as, posti, ci, bm, bs, numeroPasseggeri);
		p.setImporto(totale);
		
		//visualizza anteprima e dà accesso alle feature di applicare sconto e cambiare 
		//carta. Infine scegliere se accettare o cancellare la prenotazione
		if(p.visualizzaAnteprima()) {
			System.out.println("Prenotazione completata, grazie e buon viaggio!");
			utente.setPrenot(p);
		} else {
			System.out.println("Prenotazione annullata.");
		}
		
		
	}

}

