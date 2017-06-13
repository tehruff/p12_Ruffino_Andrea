package test_strutturali;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Sconto;
import PrenotazioneVoli.Volo;

public class SettersGettersVolo {

	public static Date data = new Date(1992, 5, 5);
	public static Posto posto = new Posto(0, false, false, 0);
	public static Volo volo = new Volo("Sidney", "LAX", 815, data, "Oceanic Airlines", 500, 1, new ArrayList<Posto>());
	public static ArrayList<Posto> postiTotali = new  ArrayList<Posto>();
	public static Volo standard = new Volo("Sidney", "LAX", 815, data, "Oceanic Airlines", 500, 1, new ArrayList<Posto>());
	@Before
	public void setUp() throws Exception {
		postiTotali.add(posto);
		volo.setPosto(postiTotali);
		standard.setPosto(postiTotali);
		
	}

	@Test
	public void testVolo() {
		Volo volo2 = new Volo("Sidney", "LAX", 815, data, "Oceanic Airlines", 500, 20, new ArrayList<Posto>());
		assertEquals("Sbagliato", "Sidney", volo2.getPartenza());
	}

	@Test
	public void testGetPartenza() {
		String res = volo.getPartenza();
		assertEquals("Sbagliato", "Sidney", res);
		
	}

	@Test
	public void testSetPartenza() {
		volo.setPartenza("milano2");
		
		assertEquals("Sbagliato", "milano2", volo.getPartenza());
		
		volo.setPartenza(standard.getPartenza());
	}

	@Test
	public void testGetDestinazione() {
		String res = volo.getDestinazione();
		assertEquals("Sbagliato", "LAX", res);
	}

	@Test
	public void testSetDestinazione() {
		volo.setDestinazione("Caltanissetta");
		assertEquals("Sbagliato", "Caltanissetta", volo.getDestinazione());
		volo.setDestinazione(standard.getDestinazione());
	}

	@Test
	public void testGetCodiceVolo() {
		int res = volo.getCodiceVolo();
		assertEquals("Sbagliato", 815, res);
	}

	@Test
	public void testSetCodiceVolo() {
		volo.setCodiceVolo(12);
		assertEquals("Sbagliato", 12, volo.getCodiceVolo());
		volo.setCodiceVolo(standard.getCodiceVolo());
	}

	@Test
	public void testGetDataPartenza() {
		int res = volo.getDataPartenza().getYear();
		assertEquals("Sbagliato", 1992, res);
	}

	@Test
	public void testSetDataPartenza() {
		volo.setDataPartenza(new Date(1990, 5,5));
		assertEquals("Sbagliato", 1990, volo.getDataPartenza().getYear());
		volo.setDataPartenza(standard.getDataPartenza());
	}

	@Test
	public void testGetCompagniaAerea() {
		String res = volo.getCompagniaAerea();
		assertEquals("Sbagliato", "Oceanic Airlines", res);
	}

	@Test
	public void testSetCompagniaAerea() {
		volo.setCompagniaAerea("Ryanair");
		assertEquals("Sbagliato", "Ryanair", volo.getCompagniaAerea());
		volo.setCompagniaAerea("Oceanic Airlines");
		
	}

	@Test
	public void testGetCosto() {
		double res = volo.getCosto();
		assertEquals("Sbagliato", 500, res,0.0);
	}

	@Test
	public void testSetCosto() {
		volo.setCosto(2);
		assertEquals("Sbagliato", 2, volo.getCosto(),0.0);
		volo.setCosto(standard.getCosto());
	}

	@Test
	public void testGetPosti() {
		int res = volo.getPosti();
		assertEquals("Sbagliato", 1, res);
	}

	@Test
	public void testSetPosti() {
		volo.setPosti(3);
		assertEquals("Sbagliato", 3, volo.getPosti());
		volo.setPosti(standard.getPosti());
	}

	@Test
	public void testGetPosto() {
		ArrayList<Posto> res = volo.getPosto();
		assertEquals("Sbagliato", 0, res.get(0).getNumero());
	}

	@Test
	public void testSetPosto() {
		ArrayList<Posto> res = volo.getPosto();
		res.add(res.get(0));
		volo.setPosto(res);
		assertEquals("Sbagliato ", 0, volo.getPosto().get(1).getNumero());
		volo.setPosto(standard.getPosto());
	}

}
