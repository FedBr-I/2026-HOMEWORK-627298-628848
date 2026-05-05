package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * ComandoPrendi: comando che raccoglie un attrezzo dalla stanza corrente.
 *
 * Usa come parametro il nome dell'attrezzo da prendere. Se l'attrezzo è presente
 * nella stanza e la borsa può contenerlo, lo rimuove dalla stanza corrente e lo
 * aggiunge all'inventario del giocatore.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @version 2.0
 */
public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	
	@Override
	public String esegui(Partita partita) {
		if(partita == null) {
			return null;
		}
		
		if(this.nomeAttrezzo == null) {
            return "Quale attrezzo vuoi prendere?";
        }
        	
        Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
        
        if(attrezzo == null) {
            return "Attrezzo non presente nella stanza";
        }
        
        if(!partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
            return "La borsa è piena, non riesco a prendere l'attrezzo";
        }
        
        partita.getStanzaCorrente().removeAttrezzo(this.nomeAttrezzo);
        return partita.getGiocatore().getBorsa().toString();
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
