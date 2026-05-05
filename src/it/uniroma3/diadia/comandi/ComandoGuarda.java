package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * ComandoGuarda: comando che mostra lo stato corrente del gioco.
 *
 * Restituisce le informazioni sulla stanza corrente e sul giocatore,
 * inclusi gli attrezzi presenti nella stanza e il contenuto della borsa.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @version 2.0
 */
public class ComandoGuarda implements Comando{
	
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		s.append("Informazioni Stanza:\n");
		s.append(partita.getStanzaCorrente().getDescrizione() + "\n\n");
		s.append("Informazioni Giocatore:\n");
		s.append(partita.getGiocatore().toString());
		
		return s.toString();
	}
	
	@Override 
	public void setParametro(String parametro) {}
	
	public String getNome() {
		return "guarda";
	}
	
	public String getParametro() {
		return null;
	}
}
