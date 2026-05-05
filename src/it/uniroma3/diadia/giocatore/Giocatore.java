package it.uniroma3.diadia.giocatore;

/**
 * Giocatore: rappresenta il giocatore della partita.
 *
 * Mantiene i CFU disponibili e la borsa degli attrezzi raccolti. I CFU
 * diminuiscono durante gli spostamenti e la borsa viene usata dai comandi
 * che prendono o posano attrezzi.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Borsa
 * @version 2.0
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
    
    @Override
    public String toString() {
    	StringBuilder descrizione = new StringBuilder();
    	
    	descrizione.append("Cfu Giocatore: " + cfu + "\n");
    	descrizione.append(this.borsa.toString());
    	
    	return descrizione.toString();
    }
}