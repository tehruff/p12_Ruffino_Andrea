package test_strutturali;

/**
 * Risultati di coverage della Test Suite.
 * 
 * Eseguendo tutti i test di questa test suite si raggiunge uno statement coverage del 92,3%.  
 * 
 * Il non raggiungimento del 100% è dato dai seguenti elementi:
 * 
 * 1) 	Le classi Database e TestScanner sono classi di appoggio che non fanno strettamente
 * 		parte del SUT, ma agiscono da classi di stub e wrapper e quindi la loro non completa 
 * 		copertura non influisce nel testing del sistema (Database coperto al 97,8% e TestScanner al 22%).
 * 
 * 2) 	Ovviamente il TestMain, necessario unicamente a controllare la corretta esecuzione 
 * 		del programma non è stato testato (copertura del 0%)
 * 
 * 3) 	Nella classe Prenotazione (copertura al 99,4%) gli unici statement non coperti sono
 * 		quelli dei metodi getDb() e getTest() (vedere punto 1) e da uno statement di return
 * 		nel metodo visualizzaAnteprima() visto che il tester non potrà mai raggiungere quella 
 * 		zona: ogni selezione da parte dell'utente è gestita dentro al ciclo while, ma il 
 * 		compilatore necessita di uno statement di return anche fuori da esso, per cui non sarà mai coperto.
 * 
 * Tutte le altre classi sono coperte al 100%; se consideriamo solo le classi indicate nel
 * diagramma delle classi in sdd_p12_Ruffino_Andrea.odt possiamo affermare che la copertura
 * ottenuta è del 100%.
 */


import static org.junit.Assert.*;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
@RunWith(Suite.class)
@Suite.SuiteClasses({SettersGettersAssicurazione.class, SettersGettersPrenotazione.class,SettersGettersCarta.class, SettersGettersVolo.class, SettersGettersSconto.class, SettersGettersBagaglioMano.class, SettersGettersBagaglioStiva .class, 
	SettersGettersCheckIn.class, SettersGettersPosto.class, SettersGettersUtente.class, TestVerificaPosti.class, TestVerificaCarta.class, TestRichiedeSconto.class, TestRichiedePosti.class, TestRichiedePasseggeri.class,
	TestRichiedeParametri.class, TestRichiedeCheckin.class, TestRichiedeBagaglioStiva.class, TestRichiedeBagaglioMano.class, TestRichiedeAssicurazione.class, TestRicercaVolo.class, TestCambiaCarta.class, TestCalcolaImporto.class,
	TestApplicaSconto.class, TestVisualizzaAnteprima.class, TestVisualizzaRisultati.class})
public class AllTest extends TestSuite{

}
