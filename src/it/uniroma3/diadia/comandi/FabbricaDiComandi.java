package it.uniroma3.diadia.comandi;

/**
 * FabbricaDiComandi: interfaccia per la creazione dei comandi del gioco.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @see FabbricaDiComandiFisarmonica
 * @version 2.0
 */
public interface FabbricaDiComandi {
	
	public Comando costruisciComando(String istruzione);
}
