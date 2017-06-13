package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.BagaglioStiva;


public class SettersGettersBagaglioStiva {

	public static BagaglioStiva stiva = new BagaglioStiva(0, "", 0, 0);
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPeso() {
		int res = stiva.getPeso();
		assertEquals("Sbagliato", 0, res);
	}

	@Test
	public void testSetPeso() {
		stiva.setPeso(2);
		assertEquals("Sbagliato", 2, stiva.getPeso());
		stiva.setPeso(0);
	}

	@Test
	public void testGetDimensioni() {
		String res = stiva.getDimensioni();
		assertEquals("Sbagliato", "", res);
	}

	@Test
	public void testSetDimensioni() {
		stiva.setDimensioni("grande");
		assertEquals("Sbagliato", "grande", stiva.getDimensioni());
		stiva.setDimensioni("");
	}

	@Test
	public void testGetQuantita() {
		int res = stiva.getQuantita();
		assertEquals("Sbagliato", 0, res);
		
	}

	@Test
	public void testSetQuantita() {
		stiva.setQuantita(34);
		assertEquals("Sbagliato", 34, stiva.getQuantita());
		stiva.setQuantita(0);
	}

	@Test
	public void testGetCostoBm() {
		double res = stiva.getCostoBs();
		assertEquals("Sbagliato", 0, res,0.0);
	}

	@Test
	public void testSetCostoBm() {
		stiva.setCostoBs(23);
		assertEquals("Sbagliato", 23, stiva.getCostoBs(), 0.0);
		stiva.setCostoBs(0);
	}

}
