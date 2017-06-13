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


@RunWith(Parameterized.class)
public class TestRichiedeSconto {
	
	
	@Parameter(0) public int selection;
	@Parameter(1) public Sconto expected;
	
	private Prenotazione p = null;
	
	public static Sconto sconto1 = new Sconto(1, 0.1, false);
	public static Sconto sconto2 = new Sconto(2, 0.2, false);
	public static Sconto sconto3 = new Sconto(3, 0.3, false);
	
	public static ArrayList<Sconto> sconto = new  ArrayList<Sconto>();
	
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		sconto.clear();
		sconto.add(sconto1);
		sconto.add(sconto2);
		sconto.add(sconto3);
		
		utente.setS(sconto);
		p = new Prenotazione(001, utente);
		
	}

	
	
	
	@Test
	public void test1Richiedesconto() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenThrow(InputMismatchException.class).thenReturn(99).thenReturn(-10).thenReturn(selection);	
		p.setTest(test);
		
		Sconto result = p.richiedeSconto();
		
		assertEquals("Sbagliato ", expected.getId(), result.getId());
	}
	
	
	
	
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, sconto1},
			{1, sconto2},
			{2, sconto3},
		});
	
	}
	

}
