package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Partita: Rappresenta lo stato complessivo della partita.
 * Tiene insieme giocatore, labirinto, stanza corrente
 * e informazione sulla fine del gioco.
 * 
 * @author  Mat. 627298 | Mat. 628848
 * @see Stanza
 * @see Labirinto
 * @see Giocatore
 * @version Revisionata
 */
public class Partita {
    private Giocatore giocatore;
    private Labirinto labirinto;
    private Stanza stanzaCorrente;
    private boolean finita;

    /**
     * Crea una nuova partita.
     * All'inizio viene creato un nuovo labirinto, un nuovo giocatore
     * e la stanza corrente coincide con la stanza iniziale.
     */
    public Partita(){
        this.labirinto = new Labirinto();
        this.giocatore = new Giocatore();
        this.stanzaCorrente = labirinto.getStanzaIniziale();
        this.finita = false;
    }

    /**
     * Controlla se la partita è stata vinta.
     * La partita è vinta quando la stanza corrente coincide con la stanza finale.
     * 
     * @return true se la partita è vinta, false altrimenti
     */
    public boolean vinta() {
        return this.getStanzaCorrente() == this.labirinto.getStanzaFinale();
    }

    /**
     * Controlla se la partita è finita.
     * Una partita finisce se è stata interrotta, se è stata vinta
     * oppure se il giocatore ha esaurito i CFU.
     * 
     * @return true se la partita è finita, false altrimenti
     */
    public boolean isFinita() {
        return this.finita || this.vinta() || this.giocatore.getCfu() == 0;
    }

    /**
     * Restituisce il labirinto associato alla partita.
     * 
     * @return il labirinto della partita
     */
    public Labirinto getLabirinto() {
        return this.labirinto;
    }
    
    /**
     * Restituisce il giocatore della partita.
     * 
     * @return il giocatore corrente
     */
    public Giocatore getGiocatore() {
        return this.giocatore;
    }

    /**
     * Restituisce la stanza corrente in cui si trova il giocatore.
     * 
     * @return la stanza corrente
     */
    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    /**
     * Imposta una nuova stanza corrente.
     * 
     * @param stanzaCorrente la nuova stanza corrente
     */
    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }
    
    /**
     * Segna la partita come conclusa.
     */
    public void setFinita() {
        this.finita = true;
    }

    /**
     * Restituisce la stanza finale, cioè la stanza che fa vincere la partita.
     * 
     * @return la stanza vincente
     */
    public Stanza getStanzaVincente() {
        return this.labirinto.getStanzaFinale();
    }
}