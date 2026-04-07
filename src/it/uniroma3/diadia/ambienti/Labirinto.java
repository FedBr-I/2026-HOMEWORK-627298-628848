package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Labirinto: Rappresenta il labirinto del gioco.
 * Si occupa di creare le stanze, collegarle tra loro
 * e definire stanza iniziale e stanza finale.
 * 
 * @author  Mat. 627298 | Mat. 628848
 * @see Stanza
 * @version Revisionata
 */
public class Labirinto {
    private Stanza stanzaIniziale;
    private Stanza stanzaFinale;

    /**
     * Crea un labirinto e inizializza automaticamente le sue stanze.
     */
    public Labirinto() {
        this.creaStanze();
    }

    /**
     * Crea tutte le stanze del labirinto, i collegamenti tra esse
     * e posiziona alcuni attrezzi iniziali.
     */
    private void creaStanze() {
        /* crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        Attrezzo osso = new Attrezzo("osso", 1);

        /* crea stanze del labirinto */
        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new Stanza("Laboratorio Campus");
        Stanza biblioteca = new Stanza("Biblioteca");

        /* collega le stanze */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);

        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);

        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);

        laboratorio.impostaStanzaAdiacente("est", atrio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);

        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);

        /* stanza iniziale e finale */
        this.stanzaIniziale = atrio;
        this.stanzaFinale = biblioteca;
    }

    /**
     * Restituisce la stanza iniziale del labirinto.
     * 
     * @return la stanza iniziale
     */
    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    /**
     * Restituisce la stanza finale del labirinto.
     * 
     * @return la stanza finale
     */
    public Stanza getStanzaFinale() {
        return this.stanzaFinale;
    }
}