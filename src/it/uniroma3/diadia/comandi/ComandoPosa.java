package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * ComandoPosa: comando che deposita nella stanza corrente un attrezzo della borsa.
 *
 * Usa come parametro il nome dell'attrezzo da posare. Se l'attrezzo è presente
 * nella borsa e la stanza può accoglierlo, lo rimuove dall'inventario del
 * giocatore e lo aggiunge alla stanza corrente.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Comando
 * @version 2.0
 */
public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	
	@Override
	public String esegui(Partita partita) {
		if (partita == null) {
			return null;
		}
		
		if (this.nomeAttrezzo == null) {
            return "Quale attrezzo vuoi posare?";
        }
        
        Attrezzo attrezzo = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
        
        if(attrezzo == null) {
            return "Attrezzo non presente nella borsa";
        }
        
        if(!partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
            partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
            return "Non puoi posare l'attrezzo qui";
        }
        
        StringBuilder message = new StringBuilder();
        
        message.append("Attrezzo " + nomeAttrezzo + " posato.\n");
        message.append(partita.getGiocatore().getBorsa().toString());
        
        return message.toString();
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "posa";
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
