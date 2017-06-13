package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.Assicurazione;

public class SettersGettersAssicurazione {

	public static Assicurazione assic = new Assicurazione("Standard", "", 10);
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetTipo() {
		String res = assic.getTipo();
		assertEquals("Sbagliato", "Standard", res);
	}

	@Test
	public void testSetTipo() {
		assic.setTipo("a");
		assertEquals("Sbagliato", "a", assic.getTipo());
		assic.setTipo("Standard");
	}

	@Test
	public void testGetDescrizione() {
		String res = assic.getDescrizione();
		assertEquals("Sbagliato", "", res);
	}

	@Test
	public void testSetDescrizione() {
		assic.setDescrizione("a");
		assertEquals("Sbagliato", "a", assic.getDescrizione());
		assic.setDescrizione("");
	}

	@Test
	public void testGetCosto() {
		double res = assic.getCosto();
		assertEquals("Sbagliato", 10, res,0.0);
	}

	@Test
	public void testSetCosto() {
		assic.setCosto(0);
		assertEquals("Sbagliato", 0, assic.getCosto(),0.0);
		assic.setCosto(10);
	}

}
