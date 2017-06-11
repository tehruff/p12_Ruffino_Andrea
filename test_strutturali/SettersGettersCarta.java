package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.Carta;
import PrenotazioneVoli.Utente;

public class SettersGettersCarta {

	public static Date data = new Date(1992, 5, 5);
	public static Carta carta = new Carta(000000000001, 001, "07/2020", 500);
	public static Utente utente= new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
	public static Carta standard = new Carta(000000000001, 001, "07/2020", 500);
	
	
	@Before
	public void setUp() throws Exception {
		carta.setUtente(utente);
		standard.setUtente(utente);
	}

	
	@Test
	public void testGetNumeroCarta() {
		int res = carta.getNumeroCarta();
		assertEquals("Sbagliato", 1,res);
	}

	@Test
	public void testSetNumeroCarta() {
		carta.setNumeroCarta(0);
		assertEquals("Sbagliato", 0,carta.getNumeroCarta());
		carta.setNumeroCarta(standard.getNumeroCarta());
	}

	@Test
	public void testGetCodiceSicurezza() {
		int res = carta.getCodiceSicurezza();
		assertEquals("Sbagliato", 1,res);
	}

	@Test
	public void testSetCodiceSicurezza() {
		carta.setCodiceSicurezza(0);
		assertEquals("Sbagliato", 0,carta.getCodiceSicurezza());
		carta.setCodiceSicurezza(standard.getCodiceSicurezza());
	}

	@Test
	public void testGetScadenza() {
		String res = carta.getScadenza();
		assertEquals("Sbagliato", standard.getScadenza(),res);
	}

	@Test
	public void testSetScadenza() {
		carta.setScadenza("a");
		assertEquals("Sbagliato", "a",carta.getScadenza());
		carta.setScadenza(standard.getScadenza());
	}

	@Test
	public void testGetDenaro() {
		double res = carta.getDenaro();
		assertEquals("Sbagliato", standard.getDenaro(),res,0.0);
	}

	@Test
	public void testSetDenaro() {
		carta.setDenaro(0);
		assertEquals("Sbagliato", 0,carta.getDenaro(),0.0);
		carta.setDenaro(standard.getDenaro());
	}

	@Test
	public void testGetUtente() {
		Utente res = carta.getUtente();
		assertEquals("Sbagliato", standard.getUtente().getIdentificativo(),res.getIdentificativo());
	}

	@Test
	public void testSetUtente() {
		carta.setUtente(new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 256, carta));
		assertEquals("Sbagliato", 256,carta.getUtente().getMiglia());
		carta.setUtente(standard.getUtente());
	}

}
