package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LabirintoTest {

    private Labirinto labirinto;

    @BeforeEach
    public void setUp() {
        this.labirinto = new Labirinto();
    }

    /* Costruttore */

    @Test
    public void testCostruttoreStanzaInizialeNonNull() {
        assertNotNull(this.labirinto.getStanzaIniziale());
    }

    @Test
    public void testCostruttoreStanzaFinaleNonNull() {
        assertNotNull(this.labirinto.getStanzaFinale());
    }

    @Test
    public void testCostruttoreCollegaAtrioABibliotecaANord() {
        assertEquals("Biblioteca",
                this.labirinto.getStanzaIniziale().getStanzaAdiacente("nord").getNome());
    }

    /* getStanzaIniziale */

    @Test
    public void testGetStanzaInizialeCasoSemplice() {
        assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
    }

    @Test
    public void testGetStanzaInizialeCasoGeneraleNonNull() {
        assertNotNull(this.labirinto.getStanzaIniziale());
    }

    @Test
    public void testGetStanzaInizialeCasoGeneraleContieneOsso() {
        assertTrue(this.labirinto.getStanzaIniziale().hasAttrezzo("osso"));
    }

    /* getStanzaFinale */

    @Test
    public void testGetStanzaFinaleCasoSemplice() {
        assertEquals("Biblioteca", this.labirinto.getStanzaFinale().getNome());
    }

    @Test
    public void testGetStanzaFinaleCasoGeneraleNonNull() {
        assertNotNull(this.labirinto.getStanzaFinale());
    }

    @Test
    public void testGetStanzaFinaleCasoGeneraleDiversaDaStanzaIniziale() {
        assertNotSame(this.labirinto.getStanzaIniziale(), this.labirinto.getStanzaFinale());
    }
}