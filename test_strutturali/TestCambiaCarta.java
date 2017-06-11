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

import PrenotazioneVoli.Carta;
import PrenotazioneVoli.BagaglioMano;
import PrenotazioneVoli.BagaglioStiva;
import PrenotazioneVoli.Carta;
import PrenotazioneVoli.Carta;
import PrenotazioneVoli.Database;
import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Prenotazione;
import PrenotazioneVoli.Sconto;
import PrenotazioneVoli.TestScanner;
import PrenotazioneVoli.Utente;
import PrenotazioneVoli.Volo;


@RunWith(Parameterized.class)
public class TestCambiaCarta {
	
	
	@Parameter(0) public int selection;
	@Parameter(1) public String data;
	@Parameter(2) public Carta expected;
	
	private Prenotazione p = null;
	
	public static Carta carta = new Carta(0, 0, "data", 0);
	
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		
	}

	
	
	
	@Test
	public void testCambiaCarta() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		TestScanner test = mock(TestScanner.class);
		
		when(test.nextInt()).thenReturn(selection);	
		when(test.next()).thenThrow(InputMismatchException.class).thenReturn(data);	
		p.setTest(test);
		
		Carta result = p.cambiaCarta();
		assertEquals("Sbagliato ", expected.getNumeroCarta(), result.getNumeroCarta());
	}
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, "data", carta},
		});
	
	}

}
