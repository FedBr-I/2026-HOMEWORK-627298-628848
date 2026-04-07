package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ComandoTest {

    /* Costruttore */

    @Test
    public void testCostruttoreCasoSempliceSoloNome() {
        Comando comando = new Comando("aiuto");
        assertEquals("aiuto", comando.getNome());
    }

    @Test
    public void testCostruttoreCasoGeneraleNomeEParametro() {
        Comando comando = new Comando("vai nord");
        assertEquals("vai", comando.getNome());
        assertEquals("nord", comando.getParametro());
    }

    /* getNome */

    @Test
    public void testGetNomeCasoSemplice() {
        Comando comando = new Comando("fine");
        assertEquals("fine", comando.getNome());
    }

    @Test
    public void testGetNomeCasoGenerale() {
        Comando comando = new Comando("prendi osso");
        assertEquals("prendi", comando.getNome());
    }

    @Test
    public void testGetNomeCasoStringaVuota() {
        Comando comando = new Comando("");
        assertNull(comando.getNome());
    }

    /* getParametro */

    @Test
    public void testGetParametroCasoSempliceAssente() {
        Comando comando = new Comando("aiuto");
        assertNull(comando.getParametro());
    }

    @Test
    public void testGetParametroCasoGeneralePresente() {
        Comando comando = new Comando("vai nord");
        assertEquals("nord", comando.getParametro());
    }

    @Test
    public void testGetParametroCasoGeneraleSecondaParola() {
        Comando comando = new Comando("prendi osso");
        assertEquals("osso", comando.getParametro());
    }

    /* sconosciuto */

    @Test
    public void testSconosciutoCasoSempliceFalse() {
        Comando comando = new Comando("aiuto");
        assertFalse(comando.sconosciuto());
    }

    @Test
    public void testSconosciutoCasoGeneraleFalseConParametro() {
        Comando comando = new Comando("vai nord");
        assertFalse(comando.sconosciuto());
    }

    @Test
    public void testSconosciutoCasoStringaVuotaTrue() {
        Comando comando = new Comando("");
        assertTrue(comando.sconosciuto());
    }
}