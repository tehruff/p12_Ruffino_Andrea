package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.BagaglioMano;

public class SettersGettersBagaglioMano {

	public static BagaglioMano mano = new BagaglioMano(0, "", 0, 0);
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPeso() {
		int res = mano.getPeso();
		assertEquals("Sbagliato", 0, res);
	}

	@Test
	public void testSetPeso() {
		mano.setPeso(2);
		assertEquals("Sbagliato", 2, mano.getPeso());
		mano.setPeso(0);
	}

	@Test
	public void testGetDimensioni() {
		String res = mano.getDimensioni();
		assertEquals("Sbagliato", "", res);
	}

	@Test
	public void testSetDimensioni() {
		mano.setDimensioni("grande");
		assertEquals("Sbagliato", "grande", mano.getDimensioni());
		mano.setDimensioni("");
	}

	@Test
	public void testGetQuantita() {
		int res = mano.getQuantita();
		assertEquals("Sbagliato", 0, res);
		
	}

	@Test
	public void testSetQuantita() {
		mano.setQuantita(34);
		assertEquals("Sbagliato", 34, mano.getQuantita());
		mano.setQuantita(0);
	}

	@Test
	public void testGetCostoBm() {
		double res = mano.getCostoBm();
		assertEquals("Sbagliato", 0, res,0.0);
	}

	@Test
	public void testSetCostoBm() {
		mano.setCostoBm(23);
		assertEquals("Sbagliato", 23, mano.getCostoBm(), 0.0);
		mano.setCostoBm(0);
	}

}
