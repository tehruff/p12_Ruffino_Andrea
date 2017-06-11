package test_strutturali;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

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

public class SettersGettersPrenotazione {

	
		
	private Prenotazione p = null;
		
		
	public static Date data = new Date(1992, 5, 5);
	public static Posto posto = new Posto(0, false, false, 0);
	public static Volo voloTrovato = new Volo("Sidney", "LAX", 815, data, "Oceanic Airlines", 500, 20, new ArrayList<Posto>());
	public static ArrayList<Posto> postiTotali = new  ArrayList<Posto>();
	public static Carta carta = new Carta(000000000001, 001, "07/2020", 500);
	public static Assicurazione assic = new Assicurazione("Standard", "", 10);
	public static CheckIn ci = new CheckIn("Online",0);
	public static BagaglioMano mano1 = new BagaglioMano(0, "", 0, 0);
	public static BagaglioStiva stiva1 = new BagaglioStiva(0, "", 0, 0);
	public static Utente utente= new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00001, 255, carta);
	
	@Before
	public void setUp() throws Exception {
		
		ArrayList<Sconto> sconti = new ArrayList<Sconto>();
		sconti.add(new Sconto(0,0.1,false));
		utente.setS(sconti);
		p = new Prenotazione(001, utente);
			
		postiTotali.clear();
		postiTotali.add(posto);
		p.setUtente(utente);
		p.setVolo(voloTrovato);
		p.setImporto(300);
		p.setNumeroPasseggeri(1);
		p.setBm(mano1);
		p.setBs(stiva1);
		p.setAssic(assic);
		p.setCheck(ci);
		p.setPosto(postiTotali);
		
	}

	@Test
	public void testShowErrore() {
		p.showErrore();
	}

	@Test
	public void testEffettuaPagamento() {
		p.effettuaPagamento();
	}

	@Test
	public void testVerificaVolo() {
		p.verificaVolo(voloTrovato);
	}

	@Test
	public void testVerificaRegistrato() {
		p.verificaRegistrato();
	}

	@Test
	public void testGetIdentificativo() {
		int res = p.getIdentificativo();
		assertEquals("Sbagliato ", 1, res);
	}

	@Test
	public void testSetIdentificativo() {
		p.setIdentificativo(5);
		int res = p.getIdentificativo();
		p.setIdentificativo(1);
		
		assertEquals("Sbagliato ", 5, res);
	}

	@Test
	public void testGetNumeroPasseggeri() {
		int res = p.getNumeroPasseggeri();
		assertEquals("Sbagliato ", 1, res);
	}

	@Test
	public void testSetNumeroPasseggeri() {
		p.setNumeroPasseggeri(5);
		int res = p.getNumeroPasseggeri();
		p.setNumeroPasseggeri(1);
		assertEquals("Sbagliato ", 5, res);
	}

	@Test
	public void testGetImporto() {
		double res = p.getImporto();
		assertEquals("Sbagliato ", 300, res, 0.0);
	}

	@Test
	public void testSetImporto() {
		p.setImporto(20);
		double res= p.getImporto();
		assertEquals("Sbagliato ", 20, res, 0.0);
	}

	@Test
	public void testGetVolo() {
		Volo res = p.getVolo();
		assertEquals("Sbagliato ", voloTrovato.getCodiceVolo(), res.getCodiceVolo());
	}

	@Test
	public void testSetVolo() {
		p.setVolo(new Volo("Sidney", "LAX", 5, data, "Oceanic Airlines", 500, 20, new ArrayList<Posto>()));
		int res = p.getVolo().getCodiceVolo();
		p.setVolo(voloTrovato);
		assertEquals("Sbagliato ", 5, res);
	}

	@Test
	public void testGetUtente() {
		Utente res = p.getUtente();
		assertEquals("Sbagliato ", 1, res.getIdentificativo());
	}

	@Test
	public void testSetUtente() {
		p.setUtente(new Utente("Mario", "Rossi", data, "maschio", "Fivizzano", "Piazza della Vittoria", 54013, "Italia", "mario.rossi@libero.it", 1234567890, 00005, 255, carta));
		int res = p.getUtente().getIdentificativo();
		p.setUtente(utente);
		assertEquals("Sbagliato ", 5, res);
	}

	@Test
	public void testGetPosto() {
		ArrayList<Posto> res = p.getPosto();
		assertEquals("Sbagliato ", 0, res.get(0).getNumero());
	}

	@Test
	public void testSetPosto() {
		postiTotali.add(postiTotali.get(0));
		p.setPosto(postiTotali);
		int res = p.getPosto().size();
		postiTotali.remove(1);
		p.setPosto(postiTotali);
		assertEquals("Sbagliato ", 2, res);
	}

	@Test
	public void testGetCheck() {
		CheckIn res = p.getCheck();
		assertEquals("Sbagliato ", "Online", res.getTipo());
		
	}

	@Test
	public void testSetCheck() {
		p.setCheck(new CheckIn("Cartaceo",0));
		String res = p.getCheck().getTipo();
		p.setCheck(ci);
		assertEquals("Sbagliato ", "Cartaceo", res);
	}

	@Test
	public void testGetAssic() {
		Assicurazione res = p.getAssic();
		assertEquals("Sbagliato ", "Standard", res.getTipo());
	}

	@Test
	public void testSetAssic() {
		p.setAssic(new Assicurazione("Premium", "", 10));
		String res = p.getAssic().getTipo();
		p.setAssic(assic);
		assertEquals("Sbagliato ", "Premium", res);
	}

	@Test
	public void testGetBs() {
		BagaglioStiva res = p.getBs();
		assertEquals("Sbagliato ", 0, res.getQuantita());
	}

	@Test
	public void testSetBs() {
		p.setBs(new BagaglioStiva(1, "", 1, 0));
		int res = p.getBs().getQuantita();
		p.setBs(stiva1);
		assertEquals("Sbagliato ", 1, res);
	}

	@Test
	public void testGetBm() {
		BagaglioMano res = p.getBm();
		assertEquals("Sbagliato ", 0, res.getQuantita());
	}

	@Test
	public void testSetBm() {
		p.setBm(new BagaglioMano(1, "", 1, 0));
		int res = p.getBm().getQuantita();
		p.setBm(mano1);
		assertEquals("Sbagliato ", 1, res);
	}

	

}
