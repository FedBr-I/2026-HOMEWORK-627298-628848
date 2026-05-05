package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * ComandoFine: comando che termina volontariamente la partita.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @version 2.0
 */
public class ComandoFine implements Comando {	
	@Override
	public String esegui(Partita partita) {
		if(partita == null) {
			return null;
		}
		
        partita.setFinita();
        return "Grazie di aver giocato!";
	}
	
	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public String getNome() {
		return "fine";
	}
	
	@Override
	public String getParametro() {
		return null;
	}
}
