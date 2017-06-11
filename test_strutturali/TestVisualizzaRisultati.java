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
import PrenotazioneVoli.Volo;
import PrenotazioneVoli.TestScanner;
import PrenotazioneVoli.Utente;
import PrenotazioneVoli.Volo;


@RunWith(Parameterized.class)
public class TestVisualizzaRisultati {
	
	@Parameter(0) public int selection;
	@Parameter(1) public Volo expected;
	
	private Prenotazione p = null;
		
	public static Volo voloTrovato = new Volo("Sidney", "LAX", 815, new Date(1992, 5, 5), "Oceanic Airlines", 500, 20, new ArrayList<Posto>());
	public static ArrayList<Volo> risultatoTrovato = new ArrayList<Volo>();
	
	
	
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		risultatoTrovato.clear();
		risultatoTrovato.add(voloTrovato);
		p = new Prenotazione(001, utente);
		p.setVolo(voloTrovato);
			
	}

	
	
	
	@Test
	public void test1VisualizzaRisultati() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		//Prenotazione mockP = mock(Prenotazione.class);
		TestScanner test = mock(TestScanner.class);
		//int num = mock(Integer.class);
		
		when(test.nextInt()).thenThrow(InputMismatchException.class).thenReturn(99).thenReturn(-10).thenReturn(selection);	
		p.setTest(test);
		
		Volo result = p.visualizzaRisultati(risultatoTrovato);
		//System.out.println("selezione0   " + selection + " e risultato ");
		assertEquals("Sbagliato ", expected.getCodiceVolo(), result.getCodiceVolo());
	}
	
	
	
	
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, voloTrovato}
			
		});
	
	}
	

}
