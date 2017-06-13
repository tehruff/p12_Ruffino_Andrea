package test_strutturali;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import PrenotazioneVoli.Carta;
import PrenotazioneVoli.Database;
import PrenotazioneVoli.Posto;
import PrenotazioneVoli.Prenotazione;
import PrenotazioneVoli.TestScanner;
import PrenotazioneVoli.Utente;
import PrenotazioneVoli.Volo;

@RunWith(Parameterized.class)
public class TestRicercaVolo {

	@Parameter(0) public String[] parametri;
	@Parameter(1) public ArrayList<Volo> expected;
	
	public static Formatter f = new Formatter();
	private Prenotazione p = null;
	public static GregorianCalendar c = new GregorianCalendar();
	public static GregorianCalendar c2 = new GregorianCalendar();
	public static Date data = Date.from(c.toInstant());
	public static long l = 1239999;
	public static String[] par1 = {"Sidney", "LAX", "5/5/1990"};
	public static String[] par2 = {"sdgga", "LAX", c.toInstant().toString()};
	public static String[] par3 = {"Sidney", "LAX", c.toInstant().toString()};
	public static String[] par4 = {"Sidney", "DFASD", "0/0/0"};
	public static String[] par5 = {"fafasd", "SFGS", "5/5/1992"};
	public static String[] par6 = {"Sidney", "VUGH", "5/5/2020"};
	public static String[] par7 = {"sgfshh", "FSHDD", "5/5/2020"};
	public static String[] par8 = {"fuyjhu", "LAX", "5/5/2020"};
	public static String[] par9 = {"Sidney", "LAX", "10/6/2017"};
	public static String[] par10 = {"Sidney", "LAX", c2.toInstant().minusMillis(l).toString()};
	public static String[] par11 = {"sdgga", "LAX", "cfndfh"};
	public static String[] par12 = {"Sidney", "LAX", "5/5/1990"};
	public static String[] par13 = {"Sidney", "DFASD", "cfndfh"};
	public static String[] par14 = {"fafasd", "SFGS", "cfndfh"};
	public static String[] par15 = {"Sidney", "VUGH", "cfndfh"};
	public static String[] par16 = {"sgfshh", "FSHDD", "cfndfh"};
	public static String[] par17 = {"fuyjhu", "LAX", "cfndfh"};
	
	
	Volo voloTrovato = new Volo("Sidney", "LAX", 815, data, "Oceanic Airlines", 500, 20, new ArrayList<Posto>());
	public static ArrayList<Volo> risultatoTrovato = new ArrayList<Volo>();
	public static ArrayList<Volo> risultatoNonTrovato = new ArrayList<Volo>();
	
	@Before
	public void setUp() throws Exception {
		
		String scadenzaCarta= "07/2019";
		Carta carta = new Carta(000000000001, 001, scadenzaCarta, 500);
		
		Utente utente= new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
		
		p = new Prenotazione(001, utente);
		
		risultatoTrovato.clear();
		risultatoTrovato.add(voloTrovato);
		
		Database db = mock(Database.class);
		when(db.getVolo()).thenReturn(risultatoTrovato);
		p.setDb(db);
	}


	@Test
	public void testVerificaPosti() {
		assertNotNull("Prenotazione non istanziata", this.p);
		
		ArrayList<Volo> result = p.ricercaVolo(parametri);
		
		assertEquals("Sbagliato ", expected.isEmpty(), result.isEmpty());
	}

	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{par1, risultatoTrovato},
			{par2, risultatoNonTrovato},
			{par3, risultatoNonTrovato},
			{par4, risultatoNonTrovato},
			{par5, risultatoNonTrovato},
			{par6, risultatoNonTrovato},
			{par7, risultatoNonTrovato},
			{par8, risultatoNonTrovato},
			{par9, risultatoTrovato},
			{par10, risultatoNonTrovato},
			{par11, risultatoNonTrovato},
			{par12, risultatoTrovato},
			{par13, risultatoNonTrovato},
			{par14, risultatoNonTrovato},
			{par15, risultatoNonTrovato},
			{par16, risultatoNonTrovato},
			{par17, risultatoNonTrovato},
		});
	
	}
	
}
