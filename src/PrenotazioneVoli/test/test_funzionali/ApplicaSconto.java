package test_funzionali;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.Assicurazione;
import PrenotazioneVoli.BagaglioMano;
import PrenotazioneVoli.BagaglioStiva;
import PrenotazioneVoli.Carta;
import PrenotazioneVoli.CheckIn;
import PrenotazioneVoli.Database;
import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Prenotazione;
import PrenotazioneVoli.Sconto;
import PrenotazioneVoli.TestScanner;
import PrenotazioneVoli.Utente;
import PrenotazioneVoli.Volo;


/**
 * 
 * Scenario principale di Applica Sconto
 * 
 * @author se-17-user
 *
 */

public class ApplicaSconto {

	Prenotazione p = null;
	Utente utente = null;
	
	@Before
	public void setUp() throws Exception {
		
		Database db = new Database();
		int id = 001;
		Date dataNascita = new Date(1992, 5, 5);
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 1250);
		utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		carta.setUtente(utente);
		ArrayList<Sconto> s = new ArrayList<Sconto>();
		s.add(new Sconto(1, 0.01, false));
		utente.setS(s);
		p = new Prenotazione(id, utente);
		
		
		
	}

	@Test
	public void test() {
		//richiede i parametri finchè non vengono trovati dei risultati
				
		
		TestScanner test = mock(TestScanner.class);
		when(test.next()).thenReturn("milano").thenReturn("parigi").thenReturn("10/8/2017");	
		p.setTest(test);
		
		ArrayList<Volo> voli = new ArrayList<Volo>();
		String[] par ={"","",""};
		while(voli.isEmpty()){
			par = p.richiedeParametri();
			voli = p.ricercaVolo(par);
		}
				//viene chiesto di decidere il volo da prenotare
		
		
		when(test.nextInt()).thenReturn(0);	
		p.setTest(test);
		
		Volo volo = p.visualizzaRisultati(voli);
				
		p.setVolo(volo);
		p.verificaRegistrato();
				
				
				//richiede i passeggeri di questa prenotazione
		int numeroPasseggeri = 0;
		Boolean checked = false;
		
		when(test.nextInt()).thenReturn(10);	
		p.setTest(test);
		
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
		
		
		when(test.nextInt()).thenReturn(0);	
		p.setTest(test);
		
		posti = p.richiedePosti();
					
		p.setPosto(posti);
				
				//richiede di scegliere le restanti opzioni 
		
	
		when(test.nextInt()).thenReturn(0);	
		p.setTest(test);
		
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
		
		when(test.next()).thenReturn("s").thenReturn("y");
		when(test.nextInt()).thenReturn(0);	
		p.setTest(test);
		
		if(p.visualizzaAnteprima()) {
			System.out.println("Prenotazione completata, grazie e buon viaggio!");
			utente.setPrenot(p);
		} else {
			System.out.println("Prenotazione annullata.");
		}
		assertEquals("Sbagliato", 1237.5, p.getImporto(), 0.0);
	}

	
}
