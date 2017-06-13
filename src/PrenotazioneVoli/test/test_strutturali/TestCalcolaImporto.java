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
public class TestCalcolaImporto {
	
	@Parameter(0) public Volo volo;
	@Parameter(1)public Assicurazione assicurazione;
	@Parameter(2) public ArrayList<Posto> posto;
	@Parameter(3)public CheckIn checkIn;
	@Parameter(4) public BagaglioMano bm;
	@Parameter(5)public BagaglioStiva bs;
	@Parameter(6) public int numeroPass;
	@Parameter(7)public double expected;
	
	
	private Prenotazione p = null;

	public static Date dpar1= new Date(117, 7, 5);
	public static Date dpar2= new Date(117, 7, 15);
	public static Date dpar3= new Date(117, 7, 25);
	
	public static Posto posto1= new Posto(0, false, false, 0); 
	public static Posto posto2= new Posto(1, false, false, 10); 
	public static Posto posto3= new Posto(2, false, false, 20); 
	public static ArrayList<Posto> postoT1 = new ArrayList<Posto>();
	
	
	public static ArrayList<Posto> postoT2 = new ArrayList<Posto>();
	
	
	public static ArrayList<Posto> postoT3 = new ArrayList<Posto>();
	
	
	public static Volo volo1 = new Volo("budapest", "parigi", 100, dpar1, "RyanAir", 220, 1, postoT1);
	public static Volo volo2 = new Volo("budapest", "parigi", 101, dpar2, "Chczech Airlines", 240, 2, postoT2);
	public static Volo volo3 = new Volo("budapest", "parigi", 102, dpar3, "British Airlines", 200, 3, postoT3);
	
	public static Assicurazione ass1 = new Assicurazione("Nessuna", "Prenotazione non coperta da assicurazione", 0);
	public static Assicurazione ass2 = new Assicurazione("Standard", "Rimborso del 50% del biglietto in caso di imprevisti", 10);
	public static Assicurazione ass3 = new Assicurazione("Premium", "Rimborso totale del biglietto in caso di imprevisti e cesto regalo in omaggio", 30);
	
	public static BagaglioStiva stiva1 = new BagaglioStiva(0, "", 0, 0);
	public static BagaglioStiva stiva2 = new BagaglioStiva(20, "119cmx119cmx81cm", 1, 15);
	public static BagaglioStiva stiva3 = new BagaglioStiva(20, "119cmx119cmx81cm", 2, 25);
	
	public static BagaglioMano mano1 = new BagaglioMano(0, "", 0, 0);
	public static BagaglioMano mano2 = new BagaglioMano(20, "45cmx40cmx20cm", 1, 0);
	public static BagaglioMano mano3 = new BagaglioMano(20, "45cmx40cmx20cm", 2, 5);
	
	public static CheckIn in1 = new CheckIn("Online", 0);
	public static CheckIn in2 = new CheckIn("Cartaceo", 5);
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
	
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		Date dataNascita = new Date(1992, 5, 5);
		Utente utente= new Utente("Mario", "Rossi", dataNascita, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		p.setImporto(100);
		
		postoT1.clear();
		postoT2.clear();
		postoT3.clear();
		
		postoT1.add(posto1);
		
		postoT2.add(posto1);
		postoT2.add(posto2);
		
		postoT3.add(posto1);
		postoT3.add(posto2);
		postoT3.add(posto3);
		
		
		
	}
	
	@Test
	public void testCalcolaImporto() {
		assertNotNull("Prenotazione non istanziata", this.p);
	
		double result = p.calcolaImporto(volo, assicurazione, posto, checkIn, bm, bs, numeroPass);
		System.out.println(volo.getCosto() +" + " + assicurazione.getCosto() + " + " +  checkIn.getCosto() + " + " + bm.getCostoBm() + " + " + bs.getCostoBs() + " + " + numeroPass);
		System.out.println("posti   " + posto.size());
		assertEquals(this.expected, result, 0.0);
	}

	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{volo1, ass3, postoT1, in1, mano3, stiva1, 1, 255},
			{volo2, ass2, postoT2, in2, mano2, stiva3, 2, 530},
			{volo3, ass1, postoT3, in1, mano1, stiva1, 3, 630},
			{volo1, ass2, postoT1, in1, mano3, stiva2, 1, 250},
			{volo2, ass3, postoT2, in2, mano1, stiva3, 2, 550},
			{volo3, ass2, postoT3, in2, mano2, stiva2, 3, 660},
			{volo1, ass1, postoT1, in2, mano1, stiva1, 1, 225},
			{volo2, ass3, postoT2, in1, mano3, stiva2, 2, 540},
		});
	
	}
}

