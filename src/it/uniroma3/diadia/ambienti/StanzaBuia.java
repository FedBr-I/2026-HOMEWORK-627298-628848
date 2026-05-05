package it.uniroma3.diadia.ambienti;

/**
 * StanzaBuia: stanza speciale la cui descrizione dipende da un attrezzo luminoso.
 *
 * Se nella stanza non è presente l'attrezzo indicato nel costruttore, il metodo
 * getDescrizione() restituisce soltanto il messaggio di buio pesto. Quando invece
 * l'attrezzo luminoso è presente, la stanza mostra la descrizione completa usuale.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Stanza
 * @version 2.0
 */
public class StanzaBuia extends Stanza{
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	
	public StanzaBuia(String nome) {
		this(nome, null);
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.attrezzoLuminoso)) {
			return super.getDescrizione();
		}
		
		return "qui c'è buio pesto";
    }
}
