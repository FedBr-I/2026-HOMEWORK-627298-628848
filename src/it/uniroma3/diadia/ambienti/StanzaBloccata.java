package it.uniroma3.diadia.ambienti;

/**
 * StanzaBloccata: stanza speciale con una direzione temporaneamente bloccata.
 *
 * Una direzione indicata nel costruttore non può essere percorsa finché nella
 * stanza non è presente lo specifico attrezzo sbloccante. Le altre direzioni
 * mantengono il comportamento normale di una stanza ordinaria.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Stanza
 * @version 2.0
 */
public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
    public Stanza getStanzaAdiacente(String direzione) {
		if(direzione == null) return null;
		
		if(!direzione.equals(this.direzioneBloccata))
			return super.getStanzaAdiacente(direzione);
		
		if(this.hasAttrezzo(this.attrezzoSbloccante))
			return super.getStanzaAdiacente(direzione);
		
		return this;
    }
	
	@Override
	public String getDescrizione() {
	    if (this.hasAttrezzo(this.attrezzoSbloccante)) {
	        return super.getDescrizione()
	                + "\nLa direzione " + this.direzioneBloccata + " è sbloccata.";
	    }

	    return super.getDescrizione()
	            + "\nLa direzione " + this.direzioneBloccata
	            + " è bloccata. Serve: " + this.attrezzoSbloccante;
	}
}
