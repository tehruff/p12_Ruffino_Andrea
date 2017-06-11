package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.CheckIn;

public class SettersGettersCheckIn {

	public static CheckIn ci = new CheckIn("Online",0);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTipo() {
		String res = ci.getTipo();
		assertEquals("Sbagliato", "Online", res);
	}

	@Test
	public void testSetTipo() {
		ci.setTipo("a");
		assertEquals("Sbagliato", "a", ci.getTipo());
		ci.setTipo("Online");
	}

	@Test
	public void testGetCosto() {
		double res = ci.getCosto();
		assertEquals("Sbagliato", 0, res,0.0);
	}

	@Test
	public void testSetCosto() {
		ci.setCosto(123);
		assertEquals("Sbagliato", 123, ci.getCosto(),0.0);
	}

}
