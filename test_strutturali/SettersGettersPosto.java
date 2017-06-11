package test_strutturali;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Volo;

public class SettersGettersPosto {

	public static Posto posto = new Posto(0, false, false, 0);
	public static Volo voloTrovato = new Volo("Sidney", "LAX", 815, new Date(0,0,0), "Oceanic Airlines", 500, 20, new ArrayList<Posto>());
	public static ArrayList<Posto> p = new  ArrayList<Posto>();
	public static Posto standard = new Posto(0, false, false, 0);
	
	
	@Before
	public void setUp() throws Exception {
		p.add(posto);
		
	}

	@Test
	public void testGetNumero() {
		int res = posto.getNumero();
		assertEquals("Sbagliato",0, res);
	}

	@Test
	public void testSetNumero() {
		posto.setNumero(5);
		assertEquals("Sbagliato",5, posto.getNumero());
		posto.setNumero(standard.getNumero());
	}

	@Test
	public void testGetPremium() {
		Boolean res = posto.getPremium();
		assertEquals("Sbagliato",false, posto.getPremium());
		
	}

	@Test
	public void testSetPremium() {
		posto.setPremium(true);
		assertEquals("Sbagliato",true, posto.getPremium());
		posto.setPremium(false);
	}

	@Test
	public void testGetOccupato() {
		Boolean res = posto.getOccupato();
		assertEquals("Sbagliato",false, posto.getOccupato());
	}

	@Test
	public void testSetOccupato() {
		posto.setOccupato(true);
		assertEquals("Sbagliato",true, posto.getOccupato());
		posto.setOccupato(false);
	}

	@Test
	public void testGetCosto() {
		double res = posto.getCosto();
		assertEquals("Sbagliato",0, res, 0.0);
	}

	@Test
	public void testSetCosto() {
		posto.setCosto(10);
		assertEquals("Sbagliato",10, posto.getCosto(), 0.0);
		posto.setCosto(0);
	}

}
