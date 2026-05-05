package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * StanzaProtected: versione alternativa di Stanza con campi protetti.
 *
 * Rappresenta una stanza del labirinto analoga a Stanza, ma rende protette le variabili di istanza.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Stanza
 * @see StanzaMagicaProtected
 * @version 2.0
 */
public class StanzaProtected {
    
    static final private int NUMERO_MASSIMO_DIREZIONI = 4;
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;
    
    protected String nome;
    
    protected Attrezzo[] attrezzi;
    protected int numeroAttrezzi;
    
    protected Stanza[] stanzeAdiacenti;
    protected int numeroStanzeAdiacenti;
    
    protected String[] direzioni;
    
    /**
     * Crea una stanza con il nome specificato.
     * Inizialmente la stanza non contiene attrezzi e non ha collegamenti.
     * 
     * @param nome il nome della stanza
     */
    public StanzaProtected(String nome) {
       this.nome = nome;
       this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
       this.numeroAttrezzi = 0;
       this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
       this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
       this.numeroStanzeAdiacenti = 0;
    }

    /**
     * Imposta una stanza adiacente in una certa direzione.
     * Se la direzione esiste già, la stanza collegata viene aggiornata.
     * Se invece è una nuova direzione e c'è ancora spazio, viene aggiunta.
     * 
     * @param direzione la direzione del collegamento
     * @param stanza la stanza da collegare
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        if(direzione == null || stanza == null) {
            return;
        }
        
        for(int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            if(direzione.equals(this.direzioni[i])) {
                this.stanzeAdiacenti[i] = stanza;
                return;
            }
        }
        
        if(this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
            this.direzioni[this.numeroStanzeAdiacenti] = direzione;
            this.stanzeAdiacenti[this.numeroStanzeAdiacenti] = stanza;
            this.numeroStanzeAdiacenti++;   
        }
    }

    /**
     * Restituisce la stanza adiacente nella direzione indicata.
     * 
     * @param direzione la direzione richiesta
     * @return la stanza adiacente, oppure null se non esiste
     */
    public Stanza getStanzaAdiacente(String direzione) {
        if(direzione == null) {
            return null;
        }
        
        for(int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            if(direzione.equals(this.direzioni[i])){
                return this.stanzeAdiacenti[i];
            }
        }
        
        return null;
    }

    /**
     * Restituisce il nome della stanza.
     * 
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce una descrizione della stanza.
     * 
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce l'array degli attrezzi contenuti nella stanza.
     * 
     * @return l'array degli attrezzi
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Aggiunge un attrezzo alla stanza, se possibile.
     * 
     * @param attrezzo l'attrezzo da aggiungere
     * @return true se aggiunto correttamente, false altrimenti
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null) {
            return false;
        }
        if (this.numeroAttrezzi >= NUMERO_MASSIMO_ATTREZZI) {
            return false;
        }
        
        this.attrezzi[this.numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
        return true;
    }

    /**
     * Controlla se nella stanza è presente un attrezzo con il nome dato.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo da cercare
     * @return true se l'attrezzo è presente, false altrimenti
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    /**
     * Cerca un attrezzo nella stanza in base al nome.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo cercato
     * @return l'attrezzo trovato, oppure null se assente
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        if(nomeAttrezzo == null) {
            return null;
        }
        
        for(int i=0; i < this.numeroAttrezzi; i++) {
            if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                return this.attrezzi[i];
            }
        }
        
        return null;
    }

    /**
     * Rimuove un attrezzo dalla stanza.
     * Se lo trova, compatta anche l'array degli attrezzi.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo da rimuovere
     * @return l'attrezzo rimosso, oppure null se non esiste
     */
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        if(nomeAttrezzo == null) {
            return null;
        }
        
        for(int i = 0; i < this.numeroAttrezzi; i++) {
            if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                Attrezzo attrezzoRimosso = this.attrezzi[i];
                
                for(int j = i; j < this.numeroAttrezzi - 1; j++) {
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
     * Restituisce l'elenco delle direzioni effettivamente disponibili.
     * 
     * @return un array contenente le direzioni usabili
     */
    public String[] getDirezioni() {
        String[] direzioni = new String[this.numeroStanzeAdiacenti];
        for(int i = 0; i<this.numeroStanzeAdiacenti; i++) {
            direzioni[i] = this.direzioni[i];
        }
        return direzioni;
    }
    
    /**
     * Restituisce una descrizione completa della stanza,
     * con nome, uscite e attrezzi presenti.
     * 
     * @return la descrizione testuale della stanza
     */
    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        
        risultato.append(this.nome);
        risultato.append("\nUscite: ");
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            risultato.append(this.direzioni[i]).append(" ");
        }
        
        risultato.append("\nAttrezzi nella stanza: ");
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            risultato.append(this.attrezzi[i]).append(" ");
        }
        
        return risultato.toString().trim();
    }
}