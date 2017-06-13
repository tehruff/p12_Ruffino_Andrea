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

import PrenotazioneVoli.CheckIn;
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
public class TestRichiedeCheckin {
	
	
	@Parameter(0) public int selection;
	@Parameter(1)public CheckIn expected;
	
	private Prenotazione p = null;
	
	public static CheckIn checkIn1 = new CheckIn("Online", 0);
	public static CheckIn checkIn2 = new CheckIn("Cartaceo", 5);
	
	
	public static ArrayList<CheckIn> checkIn = new  ArrayList<CheckIn>();
	
	Database db = null;
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		
		
		checkIn.clear();
		checkIn.add(checkIn1);
		checkIn.add(checkIn2);
		
		
		db = mock(Database.class);
				
		when(db.getIn()).thenReturn(checkIn);
		p.setDb(db);
		
	}

	
	
	
	@Test
	public void test1RichiedeCheckIn() {
		assertNotNull("Prenotazione non istanziata", this.p);
		assertNotNull("Database non istanziato", this.db);
		//Prenotazione mockP = mock(Prenotazione.class);
		TestScanner test = mock(TestScanner.class);
		//int num = mock(Integer.class);
		
		when(test.nextInt()).thenReturn(selection);	
		p.setTest(test);
		
		CheckIn result = p.richiedeCheckIn();
		//System.out.println("selezione0   " + selection + " e risultato ");
		assertEquals("Sbagliato ", expected.getTipo(), result.getTipo());
	}
	
	
	
	@Test
	public void test2RichiedeCheckIn() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenReturn(9999);	
		p.setTest(test);
		CheckIn result = p.richiedeCheckIn();
		
		assertEquals("Sbagliato ", checkIn1.getTipo(), result.getTipo());
	}
	
	
	
	@Test
	public void test3RichiedeCheckIn() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenThrow(InputMismatchException.class);
		//willThrow(new InputMismatchException()).given(test).nextInt();	
		
		p.setTest(test);
		CheckIn result = p.richiedeCheckIn();
		assertEquals("Sbagliato ", checkIn1.getTipo(), result.getTipo());
	}
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, checkIn1},
			{1, checkIn2},
			{2, checkIn1}
		});
	
	}

}
