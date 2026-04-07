package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

    private Stanza atrio;
    private Stanza biblioteca;
    private Stanza laboratorio;
    private Attrezzo osso;
    private Attrezzo lanterna;

    @BeforeEach
    public void setUp() {
        this.atrio = new Stanza("Atrio");
        this.biblioteca = new Stanza("Biblioteca");
        this.laboratorio = new Stanza("Laboratorio");
        this.osso = new Attrezzo("osso", 1);
        this.lanterna = new Attrezzo("lanterna", 3);
    }

    /* Costruttore */

    @Test
    public void testCostruttoreImpostaNomeCorretto() {
        assertEquals("Atrio", this.atrio.getNome());
    }

    @Test
    public void testCostruttoreStanzaSenzaAttrezzi() {
        assertFalse(this.atrio.hasAttrezzo("osso"));
    }

    @Test
    public void testCostruttoreStanzaSenzaUscite() {
        assertEquals(0, this.atrio.getDirezioni().length);
    }

    /* impostaStanzaAdiacente */

    @Test
    public void testImpostaStanzaAdiacenteCasoNullo() {
        this.atrio.impostaStanzaAdiacente(null, this.biblioteca);
        assertNull(this.atrio.getStanzaAdiacente("nord"));
    }

    @Test
    public void testImpostaStanzaAdiacenteCasoSemplice() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        assertSame(this.biblioteca, this.atrio.getStanzaAdiacente("nord"));
    }

    @Test
    public void testImpostaStanzaAdiacenteCasoGeneraleAggiornamento() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        this.atrio.impostaStanzaAdiacente("nord", this.laboratorio);
        assertSame(this.laboratorio, this.atrio.getStanzaAdiacente("nord"));
    }

    /* getStanzaAdiacente */

    @Test
    public void testGetStanzaAdiacenteCasoNullo() {
        assertNull(this.atrio.getStanzaAdiacente(null));
    }

    @Test
    public void testGetStanzaAdiacenteCasoSemplice() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        assertSame(this.biblioteca, this.atrio.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteCasoGeneraleDirezioneAssente() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        assertNull(this.atrio.getStanzaAdiacente("sud"));
    }

    /* getNome */

    @Test
    public void testGetNomeCasoSemplice() {
        assertEquals("Atrio", this.atrio.getNome());
    }

    @Test
    public void testGetNomeCasoGenerale() {
        assertEquals("Biblioteca", this.biblioteca.getNome());
    }

    @Test
    public void testGetNomeCasoAltroNome() {
        Stanza nuova = new Stanza("Aula N11");
        assertEquals("Aula N11", nuova.getNome());
    }

    /* getDescrizione */

    @Test
    public void testGetDescrizioneCasoSemplice() {
        assertTrue(this.atrio.getDescrizione().contains("Atrio"));
    }

    @Test
    public void testGetDescrizioneCasoGeneraleConUscite() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        assertTrue(this.atrio.getDescrizione().contains("nord"));
    }

    @Test
    public void testGetDescrizioneCasoGeneraleConAttrezzi() {
        this.atrio.addAttrezzo(this.osso);
        assertTrue(this.atrio.getDescrizione().contains("osso (1kg)"));
    }

    /* getAttrezzi */

    @Test
    public void testGetAttrezziCasoIniziale() {
        assertNotNull(this.atrio.getAttrezzi());
    }

    @Test
    public void testGetAttrezziCasoSemplice() {
        this.atrio.addAttrezzo(this.osso);
        assertSame(this.osso, this.atrio.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezziCasoGeneralePiuAttrezzi() {
        this.atrio.addAttrezzo(this.osso);
        this.atrio.addAttrezzo(this.lanterna);
        assertNotNull(this.atrio.getAttrezzi()[0]);
        assertNotNull(this.atrio.getAttrezzi()[1]);
    }

    /* addAttrezzo */

    @Test
    public void testAddAttrezzoCasoNullo() {
        assertFalse(this.atrio.addAttrezzo(null));
    }

    @Test
    public void testAddAttrezzoCasoSemplice() {
        assertTrue(this.atrio.addAttrezzo(this.osso));
    }

    @Test
    public void testAddAttrezzoCasoGeneraleCapienzaMassima() {
        for (int i = 0; i < 10; i++) {
            assertTrue(this.atrio.addAttrezzo(new Attrezzo("a" + i, 1)));
        }
        assertFalse(this.atrio.addAttrezzo(new Attrezzo("ultimo", 1)));
    }

    /* hasAttrezzo */

    @Test
    public void testHasAttrezzoCasoNullo() {
        assertFalse(this.atrio.hasAttrezzo(null));
    }

    @Test
    public void testHasAttrezzoCasoSemplice() {
        this.atrio.addAttrezzo(this.osso);
        assertTrue(this.atrio.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzoCasoGeneraleAttrezzoAssente() {
        this.atrio.addAttrezzo(this.osso);
        assertFalse(this.atrio.hasAttrezzo("lanterna"));
    }

    /* getAttrezzo */

    @Test
    public void testGetAttrezzoCasoNullo() {
        assertNull(this.atrio.getAttrezzo(null));
    }

    @Test
    public void testGetAttrezzoCasoSemplice() {
        this.atrio.addAttrezzo(this.osso);
        assertSame(this.osso, this.atrio.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzoCasoGeneraleAssente() {
        this.atrio.addAttrezzo(this.osso);
        assertNull(this.atrio.getAttrezzo("lanterna"));
    }

    /* removeAttrezzo */

    @Test
    public void testRemoveAttrezzoCasoNullo() {
        assertNull(this.atrio.removeAttrezzo(null));
    }

    @Test
    public void testRemoveAttrezzoCasoSemplice() {
        this.atrio.addAttrezzo(this.osso);
        assertSame(this.osso, this.atrio.removeAttrezzo("osso"));
    }

    @Test
    public void testRemoveAttrezzoCasoGeneraleAssente() {
        this.atrio.addAttrezzo(this.osso);
        assertNull(this.atrio.removeAttrezzo("lanterna"));
    }

    /* getDirezioni */

    @Test
    public void testGetDirezioniCasoIniziale() {
        assertEquals(0, this.atrio.getDirezioni().length);
    }

    @Test
    public void testGetDirezioniCasoSemplice() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        assertEquals("nord", this.atrio.getDirezioni()[0]);
    }

    @Test
    public void testGetDirezioniCasoGeneralePiuDirezioni() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        this.atrio.impostaStanzaAdiacente("est", this.laboratorio);
        assertEquals(2, this.atrio.getDirezioni().length);
    }

    /* toString */

    @Test
    public void testToStringCasoSemplice() {
        assertTrue(this.atrio.toString().contains("Atrio"));
    }

    @Test
    public void testToStringCasoGeneraleConUscite() {
        this.atrio.impostaStanzaAdiacente("nord", this.biblioteca);
        assertTrue(this.atrio.toString().contains("nord"));
    }

    @Test
    public void testToStringCasoGeneraleConAttrezzi() {
        this.atrio.addAttrezzo(this.osso);
        assertTrue(this.atrio.toString().contains("osso (1kg)"));
    }
}