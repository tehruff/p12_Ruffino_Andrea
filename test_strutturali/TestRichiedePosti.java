package test_strutturali;

import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import PrenotazioneVoli.Posto;
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



public class TestRichiedePosti {
	
	
	
	private Prenotazione p = null;
	
	public static Posto postoSingolo1 = new Posto(0, false, false, 0);
	public static Posto postoSingolo2 = new Posto(1, true, false, 10);
	public static Posto postoSingolo3 = new Posto(2, false, false, 0);
	
	public static ArrayList<Posto> posto1 = new  ArrayList<Posto>();
	public static ArrayList<Posto> posto2 = new  ArrayList<Posto>();
	public static ArrayList<Posto> posto3 = new  ArrayList<Posto>();
	public static ArrayList<Posto> postiTotali = new  ArrayList<Posto>();
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		posto1.clear();
		posto2.clear();
		posto3.clear();
		posto1.add(postoSingolo1);
		posto2.add(postoSingolo2);
		posto3.add(postoSingolo3);
		postiTotali.clear();
		postiTotali.add(postoSingolo1);
		postiTotali.add(postoSingolo2);
		postiTotali.add(postoSingolo3);
		int numeroPasseggeri = 1;
		p.setNumeroPasseggeri(numeroPasseggeri);
		Volo volo = new Volo("milano", "parigi", 01, dataNascita, "RyanAir", 200, 4, postiTotali);
		p.setVolo(volo);
		
	}

	
	@Test
	public void test1RichiedePosto() {
		assertNotNull("Prenotazione non istanziata", this.p);
		posto1.add(postoSingolo1);
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenReturn(900).thenReturn(-10).thenReturn(0);	
		p.setTest(test);
		
		ArrayList<Posto> result = p.richiedePosti();
		
		assertEquals("Sbagliato ", postiTotali.get(1).getNumero(), result.get(0).getNumero());
	}
	
	@Test
	public void testException() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenThrow(InputMismatchException.class).thenReturn(0);
		//willThrow(new InputMismatchException()).given(test).nextInt();	
		
		p.setTest(test);
		ArrayList<Posto> result = p.richiedePosti();
		
		assertEquals("Sbagliato ", postiTotali.get(0).getNumero(), result.get(0).getNumero());
	}
	
}
