package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
    
    private Partita partita;
    
    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
    }
    
    /* Costruttore */
    
    @Test
    public void testPartitaInizialeNellAtrio() {
        assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());
    }
    
    @Test
    public void testPartitaHaComeStanzaVincenteBiblioteca() {
        assertEquals("Biblioteca", this.partita.getStanzaVincente().getNome());
    }
    
    @Test
    public void testPartitaIniziaCon20Cfu() {
        assertEquals(20, this.partita.getGiocatore().getCfu());
    }
    
    @Test
    public void testPartitaAppenaCreataNonEFinita() {
        assertFalse(this.partita.isFinita());
    }
    
    /* getStanzaVincente */
    
    @Test
    public void testGetStanzaVincenteRestituzioneCorretta() {
        assertEquals("Biblioteca", this.partita.getStanzaVincente().getNome());
    }
    
    /* setStanzaCorrente */
    
    @Test
    public void testSetStanzaCorrenteImpostaCorrettamente() {
        Stanza nuovaStanza = new Stanza("Nuova");
        this.partita.setStanzaCorrente(nuovaStanza);
        assertSame(nuovaStanza, this.partita.getStanzaCorrente());
    }
    
    /* getStanzaCorrente */
    
    @Test
    public void testGetStanzaCorrenteRestituzioneCorretta() {
        assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());
    }
    
    /* vinta */
    
    @Test
    public void testVintaRestituzioneFalseAllInizio() {
        assertFalse(this.partita.vinta());
    }
    
    @Test
    public void testVintaRestituzioneTrueSeStanzaCorrenteUgualeVincente() {
        this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
        assertTrue(this.partita.vinta());
    }
    
    /* isFinita */
    
    @Test
    public void testIsFinitaRestituzioneFalseAllInizio() {
        assertFalse(this.partita.isFinita());
    }
    
    @Test
    public void testIsFinitaRestituzioneTrueQuandoPartitaVinta() {
        this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
        assertTrue(this.partita.isFinita());
    }
    
    @Test
    public void testIsFinitaRestituzioneTrueQuandoCfuSonoZero() {
        this.partita.getGiocatore().setCfu(0);
        assertTrue(this.partita.isFinita());
    }
    
    @Test
    public void testIsFinitaRestituzioneTrueSeForzoFinita() {
        this.partita.setFinita();
        assertTrue(this.partita.isFinita());
    }
    
    /* setFinita */
    
    @Test
    public void testSetFinitaImpostaCorrettamenteFinita() {
        this.partita.setFinita();
        assertTrue(this.partita.isFinita());
    }
}