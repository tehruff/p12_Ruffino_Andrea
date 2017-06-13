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

import PrenotazioneVoli.BagaglioMano;
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
public class TestRichiedeBagaglioMano {
	
	
	@Parameter(0) public int selection;
	@Parameter(1)public BagaglioMano expected;
	
	private Prenotazione p = null;
	
	public static BagaglioMano BagaglioMano1 = new BagaglioMano(0, "", 0, 0);
	public static BagaglioMano BagaglioMano2 = new BagaglioMano(20, "45cmx40cmx20cm", 1, 0);
	public static BagaglioMano BagaglioMano3 = new BagaglioMano(20, "45cmx40cmx20cm", 1, 5);
	
	public static ArrayList<BagaglioMano> bagaglioMano = new  ArrayList<BagaglioMano>();
	
	Database db = null;
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		
		
		bagaglioMano.clear();
		bagaglioMano.add(BagaglioMano1);
		bagaglioMano.add(BagaglioMano2);
		bagaglioMano.add(BagaglioMano3);
		
		
		db = mock(Database.class);
				
		when(db.getBm()).thenReturn(bagaglioMano);
		p.setDb(db);
		
	}

	
	
	
	@Test
	public void test1RichiedeBagaglioMano() {
		assertNotNull("Prenotazione non istanziata", this.p);
		assertNotNull("Database non istanziato", this.db);
		//Prenotazione mockP = mock(Prenotazione.class);
		TestScanner test = mock(TestScanner.class);
		//int num = mock(Integer.class);
		
		when(test.nextInt()).thenReturn(selection);	
		p.setTest(test);
		
		BagaglioMano result = p.richiedeBagaglioMano();
		//System.out.println("selezione0   " + selection + " e risultato ");
		assertSame("Sbagliato ", expected, result);
	}
	
	
	
	@Test
	public void test2RichiedeBagaglioMano() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenReturn(9999);	
		p.setTest(test);
		BagaglioMano result = p.richiedeBagaglioMano();
		
		assertSame("Sbagliato ", BagaglioMano1, result);
	}
	
	
	
	@Test
	public void test3RichiedeBagaglioMano() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenThrow(InputMismatchException.class);
		//willThrow(new InputMismatchException()).given(test).nextInt();	
		
		p.setTest(test);
		BagaglioMano result = p.richiedeBagaglioMano();
		assertSame("Sbagliato ", BagaglioMano1, result);
	}
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, BagaglioMano1},
			{1, BagaglioMano2},
			{2, BagaglioMano3},
		});
	
	}
	
}
