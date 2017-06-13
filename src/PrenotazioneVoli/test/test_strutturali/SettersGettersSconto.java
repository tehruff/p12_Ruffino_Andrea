package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.Sconto;

public class SettersGettersSconto {

	public static Sconto s = new Sconto(0,0.1,false);
	
	
	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testGetPercentuale() {
		double res =s.getPercentuale();
		assertEquals("Sbagliato",0.1, res,0.0);
	}

	@Test
	public void testSetPercentuale() {
		s.setPercentuale(0);
		assertEquals("Sbagliato",0, s.getPercentuale(),0.0);
		s.setPercentuale(0.1);
	}

	@Test
	public void testGetDisponibile() {
		assertEquals("Sbagliato",false, s.getDisponibile());
	}

	@Test
	public void testSetDisponibile() {
		s.setDisponibile(true);
		assertEquals("Sbagliato",true, s.getDisponibile());
		s.setDisponibile(false);
	}

	@Test
	public void testGetId() {
		assertEquals("Sbagliato",0, s.getId(),0.0);
	}

	@Test
	public void testSetId() {
		s.setId(1);
		assertEquals("Sbagliato",1, s.getId());
		s.setId(0);
	}

}
