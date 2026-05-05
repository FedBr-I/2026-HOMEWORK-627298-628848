package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * ComandoNonValido: comando usato quando l'istruzione dell'utente non è riconosciuta.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @see FabbricaDiComandiFisarmonica
 * @version 2.0
 */
public class ComandoNonValido implements Comando {
	/**
	 * esecuzione del comando
	 */
	@Override
	public String esegui(Partita partita) {
        return "Comando non valido";
	}
	
	@Override
	public void setParametro(String parametro) { }
	
	public String getNome() {
		return "NonValido";
	}
	
	public String getParametro() {
		return null;
	}
}
