package test_strutturali;


import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.text.ParseException;
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
public class TestRichiedeParametri {
	
	
	@Parameter(0) public String selection;
	@Parameter(1) public String[] expected;
	
	private Prenotazione p = null;
	
	static String[] exp = {"7/7/2017", "7/7/2017", "7/7/2017"};
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		
	}

	
	
	
	@Test
	public void test1RichiedeParametri() {
		assertNotNull("Prenotazione non istanziata", this.p);
	
		
		TestScanner test = mock(TestScanner.class);
		
			
		when(test.next()).thenReturn(selection);	
		p.setTest(test);
		
		String[] result = p.richiedeParametri();
		
		assertEquals("Sbagliato ", expected, result);
	}
	
	
	
	@Test
	public void test2RichiedeParametri() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenReturn("sdf").thenReturn("sdf").thenReturn("sdf").thenReturn("5/5/5");	
		p.setTest(test);
		String[] result = p.richiedeParametri();
		String[] parExp = {"sdf","sdf","5/5/5"};
		assertEquals("Sbagliato ", parExp, result);
	}
	
	
	
	@Test(expected = InputMismatchException.class)
	public void test3RichiedeParametri() {
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.next()).thenThrow(InputMismatchException.class);
		//willThrow(new InputMismatchException()).given(test).nextInt();	
		String[] parExp = {"5/5/5","5/5/5","5/5/5"};
		p.setTest(test);
		String[] result = p.richiedeParametri();
		
	}
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"7/7/2017", exp},
			
		});
	
	}
	
	

}
