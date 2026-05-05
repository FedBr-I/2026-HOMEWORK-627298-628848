package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandi fabbrica;

    @BeforeEach
    public void setUp() {
        this.fabbrica = new FabbricaDiComandiFisarmonica();
    }

    /* costruisciComando */

    @Test
    public void testCostruisciComandoCasoNullo() {
        Comando comando = this.fabbrica.costruisciComando("");

        assertEquals("NonValido", comando.getNome());
        assertNull(comando.getParametro());
    }

    @Test
    public void testCostruisciComandoCasoSemplice() {
        Comando comando = this.fabbrica.costruisciComando("vai nord");

        assertEquals("vai", comando.getNome());
        assertEquals("nord", comando.getParametro());
    }

    @Test
    public void testCostruisciComandoCasoGenerico() {
        Comando comandoAiuto = this.fabbrica.costruisciComando("aiuto");
        Comando comandoFine = this.fabbrica.costruisciComando("fine");
        Comando comandoGuarda = this.fabbrica.costruisciComando("guarda");
        Comando comandoPrendi = this.fabbrica.costruisciComando("prendi osso");
        Comando comandoPosa = this.fabbrica.costruisciComando("posa osso");
        Comando comandoNonValido = this.fabbrica.costruisciComando("salta");

        assertEquals("aiuto", comandoAiuto.getNome());
        assertNull(comandoAiuto.getParametro());

        assertEquals("fine", comandoFine.getNome());
        assertNull(comandoFine.getParametro());

        assertEquals("guarda", comandoGuarda.getNome());
        assertNull(comandoGuarda.getParametro());

        assertEquals("prendi", comandoPrendi.getNome());
        assertEquals("osso", comandoPrendi.getParametro());

        assertEquals("posa", comandoPosa.getNome());
        assertEquals("osso", comandoPosa.getParametro());

        assertEquals("NonValido", comandoNonValido.getNome());
        assertNull(comandoNonValido.getParametro());
    }
}