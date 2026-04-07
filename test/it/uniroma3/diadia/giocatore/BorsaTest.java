package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

    private Borsa borsa;
    private Attrezzo osso;
    private Attrezzo lanterna;
    private Attrezzo libro;

    @BeforeEach
    public void setUp() {
        this.borsa = new Borsa();
        this.osso = new Attrezzo("osso", 1);
        this.lanterna = new Attrezzo("lanterna", 3);
        this.libro = new Attrezzo("libro", 8);
    }

    /* Costruttore */

    @Test
    public void testCostruttoreDefaultPesoMassimoCorretto() {
        assertEquals(10, this.borsa.getPesoMax());
    }

    @Test
    public void testCostruttoreDefaultBorsaVuota() {
        assertTrue(this.borsa.isEmpty());
    }

    @Test
    public void testCostruttoreConParametroPesoMassimoCorretto() {
        Borsa borsaPiccola = new Borsa(5);
        assertEquals(5, borsaPiccola.getPesoMax());
    }

    /* addAttrezzo */

    @Test
    public void testAddAttrezzoCasoNullo() {
        assertFalse(this.borsa.addAttrezzo(null));
    }

    @Test
    public void testAddAttrezzoCasoSemplice() {
        assertTrue(this.borsa.addAttrezzo(this.osso));
    }

    @Test
    public void testAddAttrezzoCasoGeneralePesoSuperato() {
        assertTrue(this.borsa.addAttrezzo(this.libro));
        assertFalse(this.borsa.addAttrezzo(this.lanterna));
    }

    /* getPesoMax */

    @Test
    public void testGetPesoMaxCasoSemplice() {
        assertEquals(10, this.borsa.getPesoMax());
    }

    @Test
    public void testGetPesoMaxCasoGenerale() {
        Borsa borsaGrande = new Borsa(15);
        assertEquals(15, borsaGrande.getPesoMax());
    }

    @Test
    public void testGetPesoMaxCasoAltroValore() {
        Borsa borsaPiccola = new Borsa(1);
        assertEquals(1, borsaPiccola.getPesoMax());
    }

    /* getAttrezzo */

    @Test
    public void testGetAttrezzoCasoNullo() {
        assertNull(this.borsa.getAttrezzo(null));
    }

    @Test
    public void testGetAttrezzoCasoSemplice() {
        this.borsa.addAttrezzo(this.osso);
        assertSame(this.osso, this.borsa.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzoCasoGeneraleAttrezzoAssente() {
        this.borsa.addAttrezzo(this.osso);
        assertNull(this.borsa.getAttrezzo("lanterna"));
    }

    /* getPeso */

    @Test
    public void testGetPesoCasoBorsaVuota() {
        assertEquals(0, this.borsa.getPeso());
    }

    @Test
    public void testGetPesoCasoSemplice() {
        this.borsa.addAttrezzo(this.osso);
        assertEquals(1, this.borsa.getPeso());
    }

    @Test
    public void testGetPesoCasoGeneralePiuAttrezzi() {
        this.borsa.addAttrezzo(this.osso);
        this.borsa.addAttrezzo(this.lanterna);
        assertEquals(4, this.borsa.getPeso());
    }

    /* isEmpty */

    @Test
    public void testIsEmptyCasoIniziale() {
        assertTrue(this.borsa.isEmpty());
    }

    @Test
    public void testIsEmptyCasoSemplice() {
        this.borsa.addAttrezzo(this.osso);
        assertFalse(this.borsa.isEmpty());
    }

    @Test
    public void testIsEmptyCasoGeneraleDopoRimozione() {
        this.borsa.addAttrezzo(this.osso);
        this.borsa.removeAttrezzo("osso");
        assertTrue(this.borsa.isEmpty());
    }

    /* hasAttrezzo */

    @Test
    public void testHasAttrezzoCasoNullo() {
        assertFalse(this.borsa.hasAttrezzo(null));
    }

    @Test
    public void testHasAttrezzoCasoSemplice() {
        this.borsa.addAttrezzo(this.osso);
        assertTrue(this.borsa.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzoCasoGeneraleAttrezzoAssente() {
        this.borsa.addAttrezzo(this.osso);
        assertFalse(this.borsa.hasAttrezzo("lanterna"));
    }

    /* removeAttrezzo */

    @Test
    public void testRemoveAttrezzoCasoNullo() {
        assertNull(this.borsa.removeAttrezzo(null));
    }

    @Test
    public void testRemoveAttrezzoCasoSemplice() {
        this.borsa.addAttrezzo(this.osso);
        assertSame(this.osso, this.borsa.removeAttrezzo("osso"));
    }

    @Test
    public void testRemoveAttrezzoCasoGeneraleAttrezzoAssente() {
        this.borsa.addAttrezzo(this.osso);
        assertNull(this.borsa.removeAttrezzo("lanterna"));
    }

    /* toString */

    @Test
    public void testToStringCasoBorsaVuota() {
        assertEquals("Borsa vuota", this.borsa.toString());
    }

    @Test
    public void testToStringCasoSemplice() {
        this.borsa.addAttrezzo(this.osso);
        assertTrue(this.borsa.toString().contains("osso (1kg)"));
    }

    @Test
    public void testToStringCasoGenerale() {
        this.borsa.addAttrezzo(this.osso);
        this.borsa.addAttrezzo(this.lanterna);
        String descrizione = this.borsa.toString();
        assertTrue(descrizione.contains("Contenuto borsa"));
        assertTrue(descrizione.contains("osso (1kg)"));
        assertTrue(descrizione.contains("lanterna (3kg)"));
    }
}