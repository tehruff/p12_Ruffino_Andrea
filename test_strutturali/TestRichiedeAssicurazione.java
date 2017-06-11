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
public class TestRichiedeAssicurazione {
	
	
	@Parameter(0) public int selection;
	@Parameter(1)public Assicurazione expected;
	
	private Prenotazione p = null;
	
	public static Assicurazione assicurazione1 = new Assicurazione("Nessuna", "", 0);
	public static Assicurazione assicurazione2 = new Assicurazione("Standard","any", 10);
	public static Assicurazione assicurazione3 = new Assicurazione("Premium","any", 30);
	
	public static ArrayList<Assicurazione> assicurazione = new  ArrayList<Assicurazione>();
	Sconto sc;
	Database db = null;
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		
		
		assicurazione.clear();
		assicurazione.add(assicurazione1);
		assicurazione.add(assicurazione2);
		assicurazione.add(assicurazione3);
		
		
		db = mock(Database.class);
				
		when(db.getAssic()).thenReturn(assicurazione);
		p.setDb(db);
		
	}

	
	
	
	@Test
	public void test1RichiedeAssicurazione() {
		assertNotNull("Prenotazione non istanziata", this.p);
		assertNotNull("Database non istanziato", this.db);
		//Prenotazione mockP = mock(Prenotazione.class);
		TestScanner test = mock(TestScanner.class);
		//int num = mock(Integer.class);
		
		when(test.nextInt()).thenReturn(selection);	
		p.setTest(test);
		
		Assicurazione result = p.richiedeAssicurazione();
		//System.out.println("selezione0   " + selection + " e risultato ");
		assertEquals("Sbagliato ", expected.getTipo(), result.getTipo());
	}
	
	
	
	@Test
	public void test2RichiedeAssicurazione() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenReturn(9999);	
		p.setTest(test);
		Assicurazione result = p.richiedeAssicurazione();
		
		assertEquals("Sbagliato ", assicurazione1.getTipo(), result.getTipo());
	}
	
	
	
	@Test
	public void test3RichiedeAssicurazione() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenThrow(InputMismatchException.class);
		//willThrow(new InputMismatchException()).given(test).nextInt();	
		
		p.setTest(test);
		Assicurazione result = p.richiedeAssicurazione();
		assertEquals("Sbagliato ", assicurazione1.getTipo(), result.getTipo());
	}
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, assicurazione1},
			{1, assicurazione2},
			{2, assicurazione3},
		});
	
	}
	
	/*@Test
	public void test3RichiedeAssicurazione() {
		assertNotNull("Prenotazione non istanziata", this.p);
		assertNotNull("Database non istanziato", this.db);
		//Prenotazione mockP = mock(Prenotazione.class);
		TestScanner test = mock(TestScanner.class);
		//int num = mock(Integer.class);
		
		when(test.nextInt()).thenReturn(2);	
		p.setTest(test);
		Assicurazione result = p.richiedeAssicurazione();
		//System.out.println("selezione0   " + selection + " e risultato ");
		assertEquals("Sbagliato ", assicurazione3.getTipo(), result.getTipo());
	}*/

}
