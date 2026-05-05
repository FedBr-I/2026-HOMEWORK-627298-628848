package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

/**
 * Comando: interfaccia comune per tutti i comandi del gioco.
 *
 * Ogni comando sa eseguire un'azione su una Partita, può ricevere un parametro
 * testuale e fornisce nome e parametro riconosciuti dalla fabbrica di comandi.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see FabbricaDiComandi
 * @version 2.0
 */
public interface Comando {
	/**
	 * esecuzione del comando
	 * @param partita
	 */
	public String esegui(Partita partita);

	/**
	 * set parametro del comando
	 * @param parametro
	 */
	public void setParametro(String parametro);
	
	public String getNome();
	
	public String getParametro();
}