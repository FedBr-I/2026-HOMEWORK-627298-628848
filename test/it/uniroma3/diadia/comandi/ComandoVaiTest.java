package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

public class ComandoVaiTest {

    private Partita partita;
    private ComandoVai comando;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoVai();
    }

    /* esegui */

    @Test
    public void testEseguiCasoNullo() {
        assertNull(this.comando.esegui(null));
    }

    @Test
    public void testEseguiCasoSemplice() {
        String messaggio = this.comando.esegui(this.partita);

        assertTrue(messaggio.contains("Dove vuoi andare"));
    }

    @Test
    public void testEseguiCasoGenerico() {
        this.comando.setParametro("nord");

        String messaggio = this.comando.esegui(this.partita);

        assertEquals("Biblioteca", this.partita.getStanzaCorrente().getNome());
        assertEquals(19, this.partita.getGiocatore().getCfu());
        assertTrue(messaggio.contains("Biblioteca"));
    }

    /* setParametro */

    @Test
    public void testSetParametroCasoNullo() {
        this.comando.setParametro(null);

        assertNull(this.comando.getParametro());
    }

    @Test
    public void testSetParametroCasoSemplice() {
        this.comando.setParametro("nord");

        assertEquals("nord", this.comando.getParametro());
    }

    @Test
    public void testSetParametroCasoGenerico() {
        this.comando.setParametro("sud");

        assertEquals("sud", this.comando.getParametro());
    }

    /* getNome */

    @Test
    public void testGetNomeCasoNullo() {
        ComandoVai comandoVuoto = new ComandoVai();

        assertEquals("vai", comandoVuoto.getNome());
    }

    @Test
    public void testGetNomeCasoSemplice() {
        assertEquals("vai", this.comando.getNome());
    }

    @Test
    public void testGetNomeCasoGenerico() {
        this.comando.setParametro("nord");

        assertEquals("vai", this.comando.getNome());
    }

    /* getParametro */

    @Test
    public void testGetParametroCasoNullo() {
        assertNull(this.comando.getParametro());
    }

    @Test
    public void testGetParametroCasoSemplice() {
        this.comando.setParametro("nord");

        assertEquals("nord", this.comando.getParametro());
    }

    @Test
    public void testGetParametroCasoGenerico() {
        this.comando.setParametro("est");

        assertEquals("est", this.comando.getParametro());
    }
}