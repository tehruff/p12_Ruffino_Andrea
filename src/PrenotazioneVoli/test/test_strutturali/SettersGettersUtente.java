package test_strutturali;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.Carta;
import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Prenotazione;
import PrenotazioneVoli.Sconto;
import PrenotazioneVoli.Utente;

public class SettersGettersUtente {
	public static Date data = new Date(1992, 5, 5);
	public static ArrayList<Posto> postiTotali = new  ArrayList<Posto>();
	public static Posto posto = new Posto(0, false, false, 0);
	public static Carta carta = new Carta(000000000001, 001, "07/2020", 500);
	public static Utente utente = null;
	public static Utente standard= new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
	
	@Before
	public void setUp() throws Exception {
		
		postiTotali.clear();
		postiTotali.add(posto);
		ArrayList<Sconto> sc = new ArrayList<Sconto>();
		Sconto sconto1 = new Sconto(1,0.1,false);
		utente= new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		sc.add(sconto1);
		utente.setS(sc);
		standard.setC(carta);
		standard.setS(sc);
	}

	@Test
	public void testUtente() {
		Utente utente= new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		String res = utente.getNome();
		assertEquals("Sbagliato ", "Mario", res);
	}

	@Test
	public void testGetNome() {
		String res = utente.getNome();
		assertEquals("Sbagliato ", "Mario", res);
		
	}

	@Test
	public void testSetNome() {
		utente.setNome("Giulio");
		assertEquals("Sbagliato ", "Giulio", utente.getNome());
		utente.setNome(standard.getNome());
	}

	@Test
	public void testGetCognome() {
		String res = utente.getCognome();
		assertEquals("Sbagliato ", "Rossi", res);
	}

	@Test
	public void testSetCognome() {
		utente.setCognome("Bianchi");
		assertEquals("Sbagliato ", "Bianchi", utente.getCognome());
		utente.setCognome(standard.getCognome());
	}

	@Test
	public void testGetDataNascita() {
		Date res =utente.getDataNascita();
		assertEquals("Sbagliato ", 1992, res.getYear());
	}

	@Test
	public void testSetDataNascita() {
		utente.setDataNascita(new Date(1990,5,5));
		assertEquals("Sbagliato ", 1990, utente.getDataNascita().getYear());
		utente.setDataNascita(standard.getDataNascita());
	}

	@Test
	public void testGetSesso() {
		String res = utente.getSesso();
		assertEquals("Sbagliato ", "maschio", res);
	}

	@Test
	public void testSetSesso() {
		utente.setSesso("femmina");
		assertEquals("Sbagliato ", "femmina", utente.getSesso());
		utente.setSesso(standard.getSesso());
	}

	@Test
	public void testGetCitta() {
		String res = utente.getCitta();
		assertEquals("Sbagliato ", "Fivizzano", res);
	}

	@Test
	public void testSetCitta() {
		utente.setCitta("Genova");
		assertEquals("Sbagliato ", "Genova", utente.getCitta());
		utente.setCitta(standard.getCitta());
	}

	@Test
	public void testGetIndirizzo() {
		String res = utente.getIndirizzo();
		assertEquals("Sbagliato ", "Piazza della Vittoria", res);
	}

	@Test
	public void testSetIndirizzo() {
		utente.setIndirizzo("Via Prato");
		assertEquals("Sbagliato ", "Via Prato", utente.getIndirizzo());
		utente.setIndirizzo(standard.getIndirizzo());
	}

	@Test
	public void testGetCAP() {
		int res = utente.getCAP();
		assertEquals("Sbagliato ", 54013, res);
	}

	@Test
	public void testSetCAP() {
		utente.setCAP(1);
		assertEquals("Sbagliato ", 1, utente.getCAP());
		utente.setCAP(standard.getCAP());
	}

	@Test
	public void testGetPaese() {
		String res = utente.getPaese();
		assertEquals("Sbagliato ", "Italia", res);
	}

	@Test
	public void testSetPaese() {
		utente.setPaese("Ruanda");
		assertEquals("Sbagliato ", "Ruanda", utente.getPaese());
		utente.setPaese(standard.getPaese());
	}

	@Test
	public void testGetEmail() {
		String res = utente.getEmail();
		assertEquals("Sbagliato ", "mario.rossi@libero.it", res);
	}

	@Test
	public void testSetEmail() {
		utente.setEmail("a");
		assertEquals("Sbagliato ", "a", utente.getEmail());
		utente.setEmail(standard.getEmail());
	}

	@Test
	public void testGetCellulare() {
		int res = utente.getCellulare();
		assertEquals("Sbagliato ", 1234567890, res);
	}

	@Test
	public void testSetCellulare() {
		utente.setCellulare(123);
		assertEquals("Sbagliato ", 123, utente.getCellulare());
		utente.setCellulare(standard.getCellulare());
	}

	@Test
	public void testGetIdentificativo() {
		int res = utente.getIdentificativo();
		assertEquals("Sbagliato ", 1, res);
	}

	@Test
	public void testSetIdentificativo() {
		utente.setIdentificativo(2);
		assertEquals("Sbagliato ", 2, utente.getIdentificativo());
		utente.setIdentificativo(standard.getIdentificativo());
	}

	@Test
	public void testGetMiglia() {
		int res =utente.getMiglia();
		assertEquals("Sbagliato ", 255, res);
	}

	@Test
	public void testSetMiglia() {
		utente.setMiglia(300);
		assertEquals("Sbagliato ", 300, utente.getMiglia());
		utente.setMiglia(standard.getMiglia());
	}

	@Test
	public void testGetSconti() {
		ArrayList<Sconto> res = utente.getSconti();
		assertEquals("Sbagliato ", 1, res.size());
	}

	@Test
	public void testSetS() {
		ArrayList<Sconto> res = utente.getSconti();
		res.add(res.get(0));
		utente.setS(res);
		assertEquals("Sbagliato ", 2, utente.getSconti().size());	
		utente.setS(standard.getSconti());
	}

	@Test
	public void testGetCarta() {
		Carta res = utente.getCarta();
		assertEquals("Sbagliato ", 1, res.getNumeroCarta());
	}

	@Test
	public void testSetC() {
		utente.setC(new Carta(2,2,"a",2));
		assertEquals("Sbagliato ", 2, utente.getCarta().getNumeroCarta());
		utente.setC(standard.getCarta());
	}

	@Test
	public void testGetPrenot() {
		Prenotazione p = new Prenotazione(1, utente);
		utente.setPrenot(p);
		int res = utente.getPrenot().getIdentificativo();
		assertEquals("Sbagliato ", 1, res);
	}

}
