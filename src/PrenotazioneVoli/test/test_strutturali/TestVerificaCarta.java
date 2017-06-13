package test_strutturali;

import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

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

import PrenotazioneVoli.Assicurazione;
import PrenotazioneVoli.BagaglioMano;
import PrenotazioneVoli.BagaglioStiva;
import PrenotazioneVoli.Carta;
import PrenotazioneVoli.CheckIn;
import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Prenotazione;
import PrenotazioneVoli.Sconto;
import PrenotazioneVoli.Utente;
import PrenotazioneVoli.Volo;

@RunWith(Parameterized.class)
public class TestVerificaCarta {

	@Parameter(0) public Carta carta;
	@Parameter(1)public double importo;
	@Parameter(2)public Boolean expected;
	
	private Prenotazione p = null;
	
	public static Carta carta1 = new Carta(1,1,"any", 10);
	public static Carta carta2 = new Carta(1,1,"any", 100);
	public static Carta carta3 = new Carta(1,1,"any", 1001);
	public static Carta carta4 = new Carta(1,1,"any", 0);
	public static Carta carta5 = new Carta(1,1,"any", -10);
	public static Carta carta6 = new Carta(1,1,"any", 1000);
	
	@Before
	public void setUp() throws Exception {
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		p.setImporto(importo);
	}

	@Test
	public void testVerificaCarta() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		Boolean result = p.verificaCarta(carta);
		System.out.println("importo   " + importo + " e denaro " + carta.getDenaro());
		assertEquals("Sbagliato ", this.expected, result);
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{carta1, 0, true},
			{carta2, 10, true},
			{carta3, 1000, true},
			{carta4, 0, false},
			{carta5, 10, false},
			{carta6, 1000, false} //le carte non permettono di usare tutto il denaro, il metodo simula questa condizione
		});
	
	}

}
