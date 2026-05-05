package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaNord;
    private Stanza stanzaSud;

    @BeforeEach
    public void setUp() {
        this.stanzaBloccata = new StanzaBloccata("stanza bloccata", "nord", "passepartout");
        this.stanzaNord = new Stanza("stanza nord");
        this.stanzaSud = new Stanza("stanza sud");

        this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanzaNord);
        this.stanzaBloccata.impostaStanzaAdiacente("sud", this.stanzaSud);
    }

    /* getStanzaAdiacente */

    @Test
    public void testGetStanzaAdiacenteCasoNullo() {
        assertNull(this.stanzaBloccata.getStanzaAdiacente(null));
    }

    @Test
    public void testGetStanzaAdiacenteCasoSemplice() {
        assertSame(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteCasoGenerico() {
        this.stanzaBloccata.addAttrezzo(new Attrezzo("passepartout", 1));

        assertSame(this.stanzaNord, this.stanzaBloccata.getStanzaAdiacente("nord"));
        assertSame(this.stanzaSud, this.stanzaBloccata.getStanzaAdiacente("sud"));
    }

    /* getDescrizione */

    @Test
    public void testGetDescrizioneCasoNullo() {
        StanzaBloccata stanza = new StanzaBloccata("stanza bloccata", null, null);

        assertNotNull(stanza.getDescrizione());
        assertTrue(stanza.getDescrizione().contains("stanza bloccata"));
    }

    @Test
    public void testGetDescrizioneCasoSemplice() {
        assertTrue(this.stanzaBloccata.getDescrizione().contains("nord"));
    }

    @Test
    public void testGetDescrizioneCasoGenerico() {
        String descrizione = this.stanzaBloccata.getDescrizione();

        assertTrue(descrizione.contains("stanza bloccata"));
        assertTrue(descrizione.contains("nord"));
        assertTrue(descrizione.contains("passepartout"));
    }
}