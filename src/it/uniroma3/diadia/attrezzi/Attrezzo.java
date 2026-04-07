package it.uniroma3.diadia.attrezzi;

/**
 * Attrezzo: Rappresenta un attrezzo del gioco.
 * Ogni attrezzo ha un nome e un peso.
 * 
 * @author  Mat. 627298 | Mat. 628848
 * @version Revisionata
 */
public class Attrezzo {

    private String nome;
    private int peso;

    /**
     * Crea un attrezzo specificando nome e peso.
     * 
     * @param nome il nome dell'attrezzo
     * @param peso il peso dell'attrezzo
     */
    public Attrezzo(String nome, int peso) {
        this.peso = peso;
        this.nome = nome;
    }

    /**
     * Restituisce il nome dell'attrezzo.
     * 
     * @return il nome dell'attrezzo
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce il peso dell'attrezzo.
     * 
     * @return il peso dell'attrezzo
     */
    public int getPeso() {
        return this.peso;
    }

    /**
     * Restituisce una rappresentazione testuale dell'attrezzo.
     * 
     * @return una stringa con nome e peso
     */
    @Override
    public String toString() {
        return this.getNome()+" ("+this.getPeso()+"kg)";
    }
}