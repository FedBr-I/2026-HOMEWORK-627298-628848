package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * DiaDia: Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * 
 * Si occupa di gestire il ciclo del gioco, leggere i comandi dell'utente
 * ed eseguire le azioni principali.
 * 
 * @author Mat. 627298 | Mat. 628848
 * @see Partita
 * @see IOConsole
 * @see Comando
 * @version Revisionata
 */
public class DiaDia {
    static final private String MESSAGGIO_BENVENUTO =
              "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
            + "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
            + "I locali sono popolati da strani personaggi, "
            + "alcuni amici, altri... chissa!\n"
            + "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
            + "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" 
            + "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
            + "Per conoscere le istruzioni usa il comando 'aiuto'.";
    
    static final private String[] elencoComandi = { 
            "vai", "aiuto", "fine", "prendi", "posa"
    };
    
    private IOConsole io;
    private Partita partita;
    
    /**
     * Crea una nuova istanza del gioco DiaDia.
     * 
     * @param io l'oggetto utilizzato per gestire input e output
     */
    public DiaDia(IOConsole io) {
        this.partita = new Partita();
        this.io = io;
    }
    
    /**
     * Avvia il ciclo principale del gioco.
     * Mostra il messaggio iniziale, legge i comandi uno per volta
     * e continua finché la partita non termina.
     */
    public void gioca() {
        this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        
        // Ciclo principale
        String istruzione;
        do {
            istruzione = this.io.leggiRiga();
            this.processaIstruzione(istruzione);
        } while(!this.partita.isFinita());
        
        // Controllo su stato fine partita
        if(this.partita.vinta())
            this.io.mostraMessaggio("Hai vinto!");
        else if(this.partita.getGiocatore().getCfu() == 0)
            this.io.mostraMessaggio("Hai finito i CFU!");
    }
    
    /**
     * Interpreta l'istruzione inserita dall'utente e richiama
     * il metodo corrispondente al comando riconosciuto.
     * 
     * @param istruzione la riga inserita dall'utente
     */
    private void processaIstruzione(String istruzione) {
        Comando comando = new Comando(istruzione);

        if (comando.sconosciuto()) {
            this.io.mostraMessaggio("Comando sconosciuto");
            return;
        }

        switch (comando.getNome()) {
            case "fine":
                this.fine();
                break;
            case "aiuto":
                this.aiuto();
                break;
            case "vai":
                this.vai(comando.getParametro());
                break;
            case "prendi":
                this.prendi(comando.getParametro());
                break;
            case "posa":
                this.posa(comando.getParametro());
                break;
            default:
                io.mostraMessaggio("Comando sconosciuto");
        }
    }
    
    /**
     * Mostra l'elenco dei comandi disponibili.
     */
    private void aiuto() {
        String elenco = "";
        for(String comando : elencoComandi) {
            elenco += comando + " ";
        }
        
        this.io.mostraMessaggio(elenco);
    }
    
    /**
     * Sposta il giocatore nella direzione indicata.
     * Se la direzione non è valida oppure non esiste una stanza adiacente,
     * viene mostrato un messaggio di errore.
     * Se lo spostamento riesce, il giocatore perde un CFU
     * e viene mostrata la descrizione della nuova stanza.
     * 
     * @param direzione la direzione in cui muoversi
     */
    private void vai(String direzione) {
        if(direzione==null) {
            this.io.mostraMessaggio("Dove vuoi andare? ");
            return;
        }
            
        if (this.partita.getStanzaCorrente().getStanzaAdiacente(direzione) == null) {
            this.io.mostraMessaggio("Direzione inesistente");
            return;
        }
        
        this.partita.setStanzaCorrente(this.partita.getStanzaCorrente().getStanzaAdiacente(direzione));
        this.partita.getGiocatore().decrementaCfu();
        this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
    }
    
    /**
     * Permette al giocatore di prendere un attrezzo dalla stanza corrente
     * e metterlo nella propria borsa.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo da prendere
     */
    private void prendi(String nomeAttrezzo) {
        if(nomeAttrezzo == null) {
            this.io.mostraMessaggio("Quale attrezzo vuoi premdere?");
            return;
        }
        
        Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        
        if(attrezzo == null) {
            this.io.mostraMessaggio("Attrezzo inesistente nella stanza");
            return;
        }
        
        if(!this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
            this.io.mostraMessaggio("Non riersco a prendere l'attrezzo");
            return;
        }
        
        this.partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
        this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
    }
    
    /**
     * Permette al giocatore di posare nella stanza corrente
     * un attrezzo presente nella propria borsa.
     * 
     * @param nomeAttrezzo il nome dell'attrezzo da posare
     */
    private void posa(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            this.io.mostraMessaggio("Quale attrezzo vuoi posare?");
            return;
        }
        
        Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
        
        if(attrezzo == null) {
            this.io.mostraMessaggio("Attrezzo inesistente nella borsa");
            return;
        }
        
        if(!this.partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
            this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
            this.io.mostraMessaggio("Non pui posare l'attrezzo qui");
            return;
        }
        
        this.io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " posato.");
        this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
    }
    
    /**
     * Termina la partita e mostra un messaggio finale.
     */
    private void fine() {
        this.partita.setFinita();
        this.io.mostraMessaggio("Grazie di aver giocato!");
    }
    
    /**
     * Punto di ingresso del programma.
     * 
     * @param args eventuali argomenti da linea di comando
     */
    public static void main(String[] args) {
        IOConsole io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}