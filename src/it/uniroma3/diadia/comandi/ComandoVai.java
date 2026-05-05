package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * ComandoVai: comando che sposta il giocatore in una stanza adiacente.
 *
 * Usa come parametro la direzione da seguire. Se la direzione è valida,
 * aggiorna la stanza corrente della partita e decrementa i CFU del giocatore;
 * in caso contrario restituisce un messaggio di errore.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @version 2.0
 */
public class ComandoVai implements Comando {
	private String direzione;
	
	@Override
	public String esegui(Partita partita) {
		if(partita == null) {
			return null;
		}
		
		if(this.direzione == null) {
			return "Dove vuoi andare?\nDevi specificare una direzione";
		}
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
        
        if (prossimaStanza == null) {
            return "Direzione inesistente";
        }
        
        partita.setStanzaCorrente(prossimaStanza);
        partita.getGiocatore().decrementaCfu();
        
        return partita.getStanzaCorrente().getDescrizione();
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getNome() {
		return "vai";
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
}
