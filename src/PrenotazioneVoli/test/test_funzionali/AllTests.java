package test_funzionali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Risultati del calcolo dell'adeguatezza della test suite utilizzando Mutazioni.
 * 
 * Il Mutation Test è stato effettuato utilizzando il plugin PitClipse (http://pitest.org/)
 * (AllTests.java -> Run as -> PIT Mutation Test)
 * 
 * Mutanti generati: 294
 * 
 * Survived: 99
 * 
 * No Coverage: 69
 * 
 * Killed: 87
 * 
 * Timed Out: 36
 * 
 * 
 * Mutation Score = ((87 + 39) / (99 +69)) = 126/294 = 0,43
 * 
 * 
 * 
 * @author se-17-user
 *
 */




@RunWith(Suite.class)
@Suite.SuiteClasses({AnnullaPrenotazione.class,ApplicaSconto.class,CambiaCarta.class,
					 DenaroInsufficiente.class,IllegalInputs.class,PrenotazioneVoloPrincipale.class})
public class AllTests {


}

