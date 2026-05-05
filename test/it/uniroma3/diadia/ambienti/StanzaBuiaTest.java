package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;

    @BeforeEach
    public void setUp() {
        this.stanzaBuia = new StanzaBuia("stanza buia", "lanterna");
    }

    /* getDescrizione */

    @Test
    public void testGetDescrizioneCasoNullo() {
        StanzaBuia stanza = new StanzaBuia("stanza buia", null);

        assertEquals("qui c'è buio pesto", stanza.getDescrizione());
    }

    @Test
    public void testGetDescrizioneCasoSemplice() {
        assertEquals("qui c'è buio pesto", this.stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetDescrizioneCasoGenerico() {
        this.stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 1));

        assertTrue(this.stanzaBuia.getDescrizione().contains("stanza buia"));
        assertTrue(this.stanzaBuia.getDescrizione().contains("lanterna"));
    }
}