package it.uniroma3.diadia.attrezzi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttrezzoTest {

    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        this.attrezzo = new Attrezzo("lanterna", 3);
    }

    /* Costruttore */

    @Test
    public void testCostruttoreCasoSemplice() {
        assertEquals("lanterna", this.attrezzo.getNome());
    }

    @Test
    public void testCostruttoreCasoGenerale() {
        Attrezzo osso = new Attrezzo("osso", 1);
        assertEquals(1, osso.getPeso());
    }

    @Test
    public void testCostruttoreCasoNomeNullo() {
        Attrezzo attrezzoNullo = new Attrezzo(null, 2);
        assertNull(attrezzoNullo.getNome());
    }

    /* getNome */

    @Test
    public void testGetNomeCasoSemplice() {
        assertEquals("lanterna", this.attrezzo.getNome());
    }

    @Test
    public void testGetNomeCasoGenerale() {
        Attrezzo martello = new Attrezzo("martello", 5);
        assertEquals("martello", martello.getNome());
    }

    @Test
    public void testGetNomeCasoNullo() {
        Attrezzo attrezzoNullo = new Attrezzo(null, 4);
        assertNull(attrezzoNullo.getNome());
    }

    /* getPeso */

    @Test
    public void testGetPesoCasoSemplice() {
        assertEquals(3, this.attrezzo.getPeso());
    }

    @Test
    public void testGetPesoCasoGenerale() {
        Attrezzo libro = new Attrezzo("libro", 7);
        assertEquals(7, libro.getPeso());
    }

    @Test
    public void testGetPesoCasoZero() {
        Attrezzo piuma = new Attrezzo("piuma", 0);
        assertEquals(0, piuma.getPeso());
    }

    /* toString */

    @Test
    public void testToStringCasoSemplice() {
        assertEquals("lanterna (3kg)", this.attrezzo.toString());
    }

    @Test
    public void testToStringCasoGenerale() {
        Attrezzo osso = new Attrezzo("osso", 1);
        assertEquals("osso (1kg)", osso.toString());
    }

    @Test
    public void testToStringCasoNomeNullo() {
        Attrezzo attrezzoNullo = new Attrezzo(null, 2);
        assertEquals("null (2kg)", attrezzoNullo.toString());
    }
}