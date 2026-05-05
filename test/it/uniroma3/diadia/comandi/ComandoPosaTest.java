package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

    private Partita partita;
    private ComandoPosa comando;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPosa();
    }

    /* esegui */

    @Test
    public void testEseguiCasoNullo() {
        assertNull(this.comando.esegui(null));
    }

    @Test
    public void testEseguiCasoSemplice() {
        String messaggio = this.comando.esegui(this.partita);

        assertTrue(messaggio.contains("Quale attrezzo vuoi posare?"));
    }

    @Test
    public void testEseguiCasoGenerico() {
        Attrezzo osso = new Attrezzo("osso", 1);
        this.partita.getGiocatore().getBorsa().addAttrezzo(osso);

        this.comando.setParametro("osso");
        String messaggio = this.comando.esegui(this.partita);

        assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
        assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("osso"));
        assertTrue(messaggio.contains("posato"));
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
        ComandoPosa comandoVuoto = new ComandoPosa();

        assertEquals("posa", comandoVuoto.getNome());
    }

    @Test
    public void testGetNomeCasoSemplice() {
        assertEquals("posa", this.comando.getNome());
    }

    @Test
    public void testGetNomeCasoGenerico() {
        this.comando.setParametro("osso");

        assertEquals("posa", this.comando.getNome());
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