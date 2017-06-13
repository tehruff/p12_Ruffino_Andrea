package test_strutturali;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import PrenotazioneVoli.Carta;
import PrenotazioneVoli.Database;
import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Prenotazione;
import PrenotazioneVoli.TestScanner;
import PrenotazioneVoli.Utente;
import PrenotazioneVoli.Volo;

@RunWith(Parameterized.class)
public class TestVerificaPosti {

	@Parameter(0) public int numero;
	@Parameter(1)public Boolean expected;
	
private Prenotazione p = null;
	
	public static Posto postoSingolo1 = new Posto(0, false, false, 0);
	public static Posto postoSingolo2 = new Posto(1, true, false, 10);
	public static Posto postoSingolo3 = new Posto(2, false, true, 0);
	
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
		Volo volo = new Volo("milano", "parigi", 3, dataNascita, "RyanAir", 200, 3, postiTotali);
		p.setVolo(volo);
		
	}


	@Test
	public void testVerificaPosti() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		Boolean result = p.verificaPosti(numero);
		
		assertEquals("Sbagliato ", expected, result);
	}

	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{0, true},
			{200, false}
		});
	
	}
	
}
