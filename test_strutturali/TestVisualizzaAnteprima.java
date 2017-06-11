package test_strutturali;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

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


public class TestVisualizzaAnteprima {

	
	private Prenotazione p = null;
	
	
	public static Date data = new Date(1992, 5, 5);
	public static Posto posto = new Posto(0, false, false, 0);
	public static Volo voloTrovato = new Volo("Sidney", "LAX", 815, data, "Oceanic Airlines", 500, 20, new ArrayList<Posto>());
	public static ArrayList<Posto> postiTotali = new  ArrayList<Posto>();
	
	
	
	@Before
	public void setUp() throws Exception {
		
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		ArrayList<Sconto> sconti = new ArrayList<Sconto>();
		sconti.add(new Sconto(0,0.1,false));
		Utente utente= new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		utente.setS(sconti);
		p = new Prenotazione(001, utente);
		
		Assicurazione assic = new Assicurazione("Standard", "", 10);
		CheckIn ci = new CheckIn("Online",0);
		BagaglioMano mano1 = new BagaglioMano(0, "", 0, 0);
		BagaglioStiva stiva1 = new BagaglioStiva(0, "", 0, 0);
		
		
		postiTotali.clear();
		postiTotali.add(posto);
		p.setUtente(utente);
		p.setVolo(voloTrovato);
		p.setImporto(300);
		p.setNumeroPasseggeri(1);
		p.setBm(mano1);
		p.setBs(stiva1);
		p.setAssic(assic);
		p.setCheck(ci);
		p.setPosto(postiTotali);
		
	}


	@Test
	public void testConferma() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenReturn("y");	
		p.setTest(test);
		Boolean result = p.visualizzaAnteprima();
		
		assertEquals("Sbagliato ", true, result);
	}

	@Test
	public void testDeclina() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenReturn("n");	
		p.setTest(test);
		Boolean result = p.visualizzaAnteprima();
		
		assertEquals("Sbagliato ", false, result);
	}
	

	@Test
	public void testPocoDenaro() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenReturn("y");	
		when(test.nextInt()).thenReturn(2000);	
		p.setTest(test);
		
		p.setImporto(1000);
		
		
		Boolean result = p.visualizzaAnteprima();
		
		assertEquals("Sbagliato ", true, result);
	}
	
	@Test
	public void testCambiaCarta() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenReturn("c").thenReturn("y");	
		when(test.nextInt()).thenReturn(2000);	
		p.setTest(test);
		
		p.setImporto(1000);
		
		
		Boolean result = p.visualizzaAnteprima();
		
		assertEquals("Sbagliato ", true, result);
	}
	
	@Test
	public void testSconto() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenReturn("s").thenReturn("s").thenReturn("y");	
		when(test.nextInt()).thenReturn(0);	
		p.setTest(test);
		
		
		Boolean result = p.visualizzaAnteprima();
		
		assertEquals("Sbagliato ", true, result);
	}
	
	@Test
	public void testInputStrani() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenReturn("x").thenReturn("c").thenReturn("dataScadenzaCarta1").thenReturn("datascadenzacarta2").thenReturn("s").thenReturn("s").thenReturn("y");	
		when(test.nextInt()).thenReturn(0).thenReturn(0).thenReturn(0).thenReturn(0).thenReturn(0).thenReturn(301).thenReturn(0).thenReturn(0);	
		p.setTest(test);
		
		
		Boolean result = p.visualizzaAnteprima();
		
		assertEquals("Sbagliato ", true, result);
	}
	
	@Test
	public void testNessunoSconto() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		ArrayList<Sconto> scontiFiniti = p.getUtente().getSconti();
		scontiFiniti.clear();
		p.getUtente().setS(scontiFiniti);
		when(test.next()).thenReturn("s").thenReturn("s").thenReturn("y");	
			
		p.setTest(test);
		
		
		Boolean result = p.visualizzaAnteprima();
		
		assertEquals("Sbagliato ", true, result);
	}
	
}
