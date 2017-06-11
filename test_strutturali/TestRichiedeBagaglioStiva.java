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

import PrenotazioneVoli.BagaglioStiva;
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
public class TestRichiedeBagaglioStiva {
	
	
	@Parameter(0) public int selection;
	@Parameter(1) public BagaglioStiva expected;
	
	private Prenotazione p = null;
	
	public static BagaglioStiva BagaglioStiva1 = new BagaglioStiva(0, "", 0, 0);
	public static BagaglioStiva BagaglioStiva2 = new BagaglioStiva(20, "119cmx119cmx81cm", 1, 15);
	public static BagaglioStiva BagaglioStiva3 = new BagaglioStiva(20, "119cmx119cmx81cm", 1, 25);
	
	public static ArrayList<BagaglioStiva> bagaglioStiva = new  ArrayList<BagaglioStiva>();
	
	Database db = null;
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		
		
		bagaglioStiva.clear();
		bagaglioStiva.add(BagaglioStiva1);
		bagaglioStiva.add(BagaglioStiva2);
		bagaglioStiva.add(BagaglioStiva3);
		
		
		db = mock(Database.class);
				
		when(db.getBs()).thenReturn(bagaglioStiva);
		p.setDb(db);
		
	}

	
	
	
	@Test
	public void test1RichiedeBagaglioStiva() {
		assertNotNull("Prenotazione non istanziata", this.p);
		assertNotNull("Database non istanziato", this.db);
		//Prenotazione mockP = mock(Prenotazione.class);
		TestScanner test = mock(TestScanner.class);
		//int num = mock(Integer.class);
		
		when(test.nextInt()).thenReturn(selection);	
		p.setTest(test);
		
		BagaglioStiva result = p.richiedeBagaglioStiva();
		//System.out.println("selezione0   " + selection + " e risultato ");
		assertSame("Sbagliato ", expected, result);
	}
	
	
	
	@Test
	public void test2RichiedeBagaglioStiva() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenReturn(9999);	
		p.setTest(test);
		BagaglioStiva result = p.richiedeBagaglioStiva();
		
		assertSame("Sbagliato ", BagaglioStiva1, result);
	}
	
	
	
	@Test
	public void test3RichiedeBagaglioStiva() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenThrow(InputMismatchException.class);
		//willThrow(new InputMismatchException()).given(test).nextInt();	
		
		p.setTest(test);
		BagaglioStiva result = p.richiedeBagaglioStiva();
		assertSame("Sbagliato ", BagaglioStiva1, result);
	}
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, BagaglioStiva1},
			{1, BagaglioStiva2},
			{2, BagaglioStiva3},
		});
	
	}
	
	/*@Test
	public void test3RichiedeBagaglioStiva() {
		assertNotNull("Prenotazione non istanziata", this.p);
		assertNotNull("Database non istanziato", this.db);
		//Prenotazione mockP = mock(Prenotazione.class);
		TestScanner test = mock(TestScanner.class);
		//int num = mock(Integer.class);
		
		when(test.nextInt()).thenReturn(2);	
		p.setTest(test);
		BagaglioStiva result = p.richiedeBagaglioStiva();
		//System.out.println("selezione0   " + selection + " e risultato ");
		assertEquals("Sbagliato ", BagaglioStiva3.getTipo(), result.getTipo());
	}*/

}
