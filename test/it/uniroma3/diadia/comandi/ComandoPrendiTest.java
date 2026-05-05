package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

    private Partita partita;
    private ComandoPrendi comando;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPrendi();
    }

    /* esegui */

    @Test
    public void testEseguiCasoNullo() {
        assertNull(this.comando.esegui(null));
    }

    @Test
    public void testEseguiCasoSemplice() {
        String messaggio = this.comando.esegui(this.partita);

        assertTrue(messaggio.contains("Quale attrezzo vuoi prendere?"));
    }

    @Test
    public void testEseguiCasoGenerico() {
        Attrezzo osso = new Attrezzo("spada", 1);
        this.partita.getStanzaCorrente().addAttrezzo(osso);

        this.comando.setParametro("spada");
        String messaggio = this.comando.esegui(this.partita);

        assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
        assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
        assertTrue(messaggio.contains("spada"));
    }

    /* setParametro */

    @Test
    public void testSetParametroCasoNullo() {
        this.comando.setParametro(null);

        assertNull(this.comando.getParametro());
    }

    @Test
    public void testSetParametroCasoSemplice() {
        this.comando.setParametro("osso");

        assertEquals("osso", this.comando.getParametro());
    }

    @Test
    public void testSetParametroCasoGenerico() {
        this.comando.setParametro("martello");

        assertEquals("martello", this.comando.getParametro());
    }

    /* getNome */

    @Test
    public void testGetNomeCasoNullo() {
        ComandoPrendi comandoVuoto = new ComandoPrendi();

        assertEquals("prendi", comandoVuoto.getNome());
    }

    @Test
    public void testGetNomeCasoSemplice() {
        assertEquals("prendi", this.comando.getNome());
    }

    @Test
    public void testGetNomeCasoGenerico() {
        this.comando.setParametro("osso");

        assertEquals("prendi", this.comando.getNome());
    }

    /* getParametro */

    @Test
    public void testGetParametroCasoNullo() {
        assertNull(this.comando.getParametro());
    }

    @Test
    public void testGetParametroCasoSemplice() {
        this.comando.setParametro("osso");

        assertEquals("osso", this.comando.getParametro());
    }

    @Test
    public void testGetParametroCasoGenerico() {
        this.comando.setParametro("spada");

        assertEquals("spada", this.comando.getParametro());
    }
}