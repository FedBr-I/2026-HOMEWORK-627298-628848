package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Borsa: Rappresenta la borsa del giocatore.
 * Qui vengono conservati gli attrezzi raccolti durante la partita.
 * La borsa ha un peso massimo e un numero massimo di attrezzi contenibili.
 * 
 * @author  Mat. 627298 | Mat. 628848
 * @see Attrezzo
 * @version Revisionata
 */
public class Borsa {
    private static final int DEFAULT_PESO_MAX_BORSA = 10;
    private static final int NUMERO_MASSIMO_ATTREZZI = 10;
    
    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;
    private int pesoMax;
    
    /**
     * Crea una borsa con peso massimo di default.
     */
    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }
    
    /**
     * Crea una borsa con il peso massimo specificato.
     * 
     * @param pesoMax il peso massimo trasportabile dalla borsa
     */
    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.numeroAttrezzi = 0;
    }
    
    /**
     * Prova ad aggiungere un attrezzo alla borsa.
     * L'aggiunta riesce solo se l'attrezzo non è nullo, se c'è spazio
     * e se il peso massimo non viene superato.
     * 
     * @param attrezzo l'attrezzo da aggiungere
     * @return true se l'attrezzo è stato aggiunto, false altrimenti
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if(attrezzo == null) {
            return false;
        }
        
        if (this.numeroAttrezzi >= NUMERO_MASSIMO_ATTREZZI) {
            return false;
        }
        
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
            return false;
        }

        this.attrezzi[this.numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
        return true;
    }
    
    /**
     * Restituisce il peso massimo della borsa.
     * 
     * @return il peso massimo trasportabile
     */
    public int getPesoMax() {
        return pesoMax;
    }
    
    /**
     * Cerca un attrezzo nella borsa in base al nome.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo da cercare
     * @return l'attrezzo trovato, oppure null se non esiste
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            return null;
        }
        
        for(int i = 0; i < this.numeroAttrezzi; i++) {
            if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                return this.attrezzi[i];
            }
        }
        return null;
    }
    
    /**
     * Calcola il peso totale attuale della borsa,
     * sommando il peso di tutti gli attrezzi contenuti.
     * 
     * @return il peso totale della borsa
     */
    public int getPeso() {
        int peso = 0;
        for (int i= 0; i<this.numeroAttrezzi; i++) {
            peso += this.attrezzi[i].getPeso();
        }
        return peso;
    }
    
    /**
     * Controlla se la borsa è vuota.
     * 
     * @return true se non contiene attrezzi, false altrimenti
     */
    public boolean isEmpty() {
        return this.numeroAttrezzi == 0;
    }
    
    /**
     * Controlla se nella borsa è presente un attrezzo con il nome dato.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo cercato
     * @return true se presente, false altrimenti
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }
    
    /**
     * Rimuove dalla borsa l'attrezzo con il nome specificato.
     * Se l'attrezzo viene trovato compatta l'array dopo averlo rimosso.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo da rimuovere
     * @return l'attrezzo rimosso, oppure null se non trovato
     */
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        if(nomeAttrezzo == null) {
            return null;
        }
        
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                Attrezzo attrezzoRimosso = this.attrezzi[i];

                for (int j = i; j < this.numeroAttrezzi - 1; j++) {
                    this.attrezzi[j] = this.attrezzi[j + 1];
                }

                this.attrezzi[this.numeroAttrezzi - 1] = null;
                this.numeroAttrezzi--;
                return attrezzoRimosso;
            }
        }
        return null;
    }
    
    /**
     * Restituisce una descrizione testuale del contenuto della borsa.
     * Se è vuota, viene restituito un messaggio semplice.
     * 
     * @return una stringa che descrive la borsa
     */
    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "Borsa vuota";
        }
        
        StringBuilder s = new StringBuilder();
        s.append("Contenuto borsa(" + this.getPeso() + "kg/");
        s.append(this.getPesoMax() + "kg): ");
        
        for(int i = 0; i < this.numeroAttrezzi; i++) {
            s.append(this.attrezzi[i]);
            if(i < this.numeroAttrezzi - 1) {
                s.append(" ");
            }
        }
        
        return s.toString();
    }
}