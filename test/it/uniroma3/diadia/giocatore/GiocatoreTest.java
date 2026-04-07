package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    public void setUp() {
        this.giocatore = new Giocatore();
    }

    /* Costruttore */

    @Test
    public void testCostruttoreIniziaCon20Cfu() {
        assertEquals(20, this.giocatore.getCfu());
    }

    @Test
    public void testCostruttoreCreaUnaBorsa() {
        assertNotNull(this.giocatore.getBorsa());
    }

    @Test
    public void testCostruttoreBorsaInizialmenteVuota() {
        assertTrue(this.giocatore.getBorsa().isEmpty());
    }

    /* DecrementaCfu */

    @Test
    public void testDecrementaCfuCasoSemplice() {
        this.giocatore.decrementaCfu();
        assertEquals(19, this.giocatore.getCfu());
    }

    @Test
    public void testDecrementaCfuCasoGeneralePiuVolte() {
        this.giocatore.decrementaCfu();
        this.giocatore.decrementaCfu();
        this.giocatore.decrementaCfu();
        assertEquals(17, this.giocatore.getCfu());
    }

    @Test
    public void testDecrementaCfuCasoZeroNonVaSottoZero() {
        this.giocatore.setCfu(0);
        this.giocatore.decrementaCfu();
        assertEquals(0, this.giocatore.getCfu());
    }

    /* setCfu */

    @Test
    public void testSetCfuCasoSemplice() {
        this.giocatore.setCfu(10);
        assertEquals(10, this.giocatore.getCfu());
    }

    @Test
    public void testSetCfuCasoGenerale() {
        this.giocatore.setCfu(3);
        assertEquals(3, this.giocatore.getCfu());
    }

    @Test
    public void testSetCfuCasoValoreNegativo() {
        this.giocatore.setCfu(-2);
        assertEquals(0, this.giocatore.getCfu());
    }

    /* getCfu */

    @Test
    public void testGetCfuCasoIniziale() {
        assertEquals(20, this.giocatore.getCfu());
    }

    @Test
    public void testGetCfuCasoDopoSet() {
        this.giocatore.setCfu(8);
        assertEquals(8, this.giocatore.getCfu());
    }

    @Test
    public void testGetCfuCasoDopoDecremento() {
        this.giocatore.decrementaCfu();
        assertEquals(19, this.giocatore.getCfu());
    }

    /* getBorsa */

    @Test
    public void testGetBorsaCasoSemplice() {
        assertNotNull(this.giocatore.getBorsa());
    }

    @Test
    public void testGetBorsaCasoGeneraleStessaIstanza() {
        assertSame(this.giocatore.getBorsa(), this.giocatore.getBorsa());
    }

    @Test
    public void testGetBorsaCasoBorsaVuotaAllInizio() {
        assertTrue(this.giocatore.getBorsa().isEmpty());
    }
}