package it.uniroma3.diadia.giocatore;

/**
 * Giocatore: Rappresenta il giocatore della partita.
 * Il giocatore ha un certo numero di CFU e possiede una borsa.
 * 
 * @author  Mat. 627298 | Mat. 628848
 * @see Borsa
 * @version Revisionata
 */
public class Giocatore {
    private static final int CFU_INIZIALI = 20;

    private int cfu;
    private Borsa borsa;

    /**
     * Crea un giocatore con i CFU iniziali e una borsa vuota.
     */
    public Giocatore() {
        this.cfu = CFU_INIZIALI;
        this.borsa = new Borsa();
    }

    /**
     * Decrementa di 1 i CFU del giocatore,
     * ma solo se il valore è maggiore di zero.
     */
    public void decrementaCfu() {
        if(this.cfu > 0) {
            this.cfu--;
        }
    }

    /**
     * Imposta manualmente il numero di CFU del giocatore (solo non negativi).
     * 
     * @param cfu il nuovo valore dei CFU
     */
    public void setCfu(int cfu) {
        if(cfu < 0){
            this.cfu = 0;
            return;
        }
        this.cfu = cfu;
    }

    /**
     * Restituisce i CFU attuali del giocatore.
     * 
     * @return i CFU del giocatore
     */
    public int getCfu() {
        return this.cfu;
    }

    /**
     * Restituisce la borsa posseduta dal giocatore.
     * 
     * @return la borsa del giocatore
     */
    public Borsa getBorsa() {
        return this.borsa;
    }
}