package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * ComandoAiuto: comando che mostra l'elenco dei comandi disponibili.
 *
 * Non modifica lo stato della partita e non usa parametri.
 * Restituisce un messaggio testuale con i nomi dei comandi che il giocatore può inserire.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @version 2.0
 */
public class ComandoAiuto implements Comando {
	private String[] elencoComandi = { 
            "aiuto", "fine", "guarda", "posa", "prendi", "vai"
    };
	
	/**
	 * esecuzione del comando
	 */
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder messaggio = new StringBuilder();
		messaggio.append("Elenco Comandi:\n");
		for(String comando : this.elencoComandi) {
			messaggio.append(comando + " ");
		}
        return messaggio.toString();
	}
	
	@Override
	public void setParametro(String parametro) { }
	
	public String getNome() {
		return "aiuto";
	}
	
	public String getParametro() {
		return null;
	}
}
