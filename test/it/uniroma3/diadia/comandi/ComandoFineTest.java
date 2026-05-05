package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

public class ComandoFineTest {

    private ComandoFine comando;
    private Partita partita;

    @BeforeEach
    public void setUp() {
        this.comando = new ComandoFine();
        this.partita = new Partita();
    }

    /* esegui */

    @Test
    public void testEseguiCasoNullo() {
        assertNull(this.comando.esegui(null));
    }

    @Test
    public void testEseguiCasoSemplice() {
        String messaggio = this.comando.esegui(this.partita);

        assertEquals("Grazie di aver giocato!", messaggio);
    }

    @Test
    public void testEseguiCasoGenerico() {
        assertFalse(this.partita.isFinita());

        this.comando.esegui(this.partita);

        assertTrue(this.partita.isFinita());
    }

    /* setParametro */

    @Test
    public void testSetParametroCasoNullo() {
        this.comando.setParametro(null);

        assertNull(this.comando.getParametro());
    }

    @Test
    public void testSetParametroCasoSemplice() {
        this.comando.setParametro("qualcosa");

        assertNull(this.comando.getParametro());
    }

    @Test
    public void testSetParametroCasoGenerico() {
        this.comando.setParametro("nord");

        assertNull(this.comando.getParametro());
    }

    /* getNome */

    @Test
    public void testGetNomeCasoNullo() {
        ComandoFine comandoVuoto = new ComandoFine();

        assertEquals("fine", comandoVuoto.getNome());
    }

    @Test
    public void testGetNomeCasoSemplice() {
        assertEquals("fine", this.comando.getNome());
    }

    @Test
    public void testGetNomeCasoGenerico() {
        this.comando.setParametro("inutile");

        assertEquals("fine", this.comando.getNome());
    }

    /* getParametro */

    @Test
    public void testGetParametroCasoNullo() {
        assertNull(this.comando.getParametro());
    }

    @Test
    public void testGetParametroCasoSemplice() {
        this.comando.setParametro("fine");

        assertNull(this.comando.getParametro());
    }

    @Test
    public void testGetParametroCasoGenerico() {
        this.comando.setParametro("qualsiasiParametro");

        assertNull(this.comando.getParametro());
    }
}