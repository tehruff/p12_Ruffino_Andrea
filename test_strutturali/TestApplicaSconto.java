package test_strutturali;
import org.junit.*;
import static org.junit.Assert.*;

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
import PrenotazioneVoli.Prenotazione;
import PrenotazioneVoli.Sconto;
import PrenotazioneVoli.Utente;
@RunWith(Parameterized.class)
public class TestApplicaSconto {
	
	@Parameter(0) public Sconto sconto;
	@Parameter(1)public double expected;
	

	/*@Parameters
	public static double[][] = new double[][]{
		{0.1,0.2,0.3}
	};
	
	@Parameter(0) public double expected;*/
	
	
	private Prenotazione p = null;
	private  static Sconto test1 = new Sconto(01, 0.1, false);
	private  static Sconto test2 = new Sconto(01, 0.2, false);
	private  static Sconto test3 = new Sconto(01, 0.3, false);
	@Before
	public void setUp() throws Exception {
		
	
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		p.setImporto(100);
		
	}
	

	

	@Test
	public void testApplicaSconto() {
		assertNotNull("Prenotazione non istanziata", this.p);
	
		p.applicaSconto(this.sconto);
		assertEquals(this.expected, p.getImporto(), 0.0);
	}

	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{test1,90},
			{test2,80},
			{test3,70},
		});
	
	}
}
