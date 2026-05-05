
package it.uniroma3.diadia.comandi;
import java.util.Scanner;

/**
 * FabbricaDiComandiFisarmonica: fabbrica concreta dei comandi di DiaDia.
 *
 * Analizza l'istruzione testuale dell'utente, riconosce il nome del comando
 * e l'eventuale parametro, quindi costruisce l'oggetto Comando corrispondente.
 * Se l'istruzione non è riconosciuta, produce un ComandoNonValido.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see FabbricaDiComandi
 * @see Comando
 * @see ComandoNonValido
 * @version 2.0
 */
public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		
		if(nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
	}
}
