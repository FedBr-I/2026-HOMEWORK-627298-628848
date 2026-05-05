package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * DiaDia: classe principale di DiaDia, un semplice gioco di ruolo ambientato al DIA.
 *
 * Gestisce il ciclo della partita, mostra il messaggio di benvenuto, legge i comandi
 * tramite l'interfaccia IO e delega alla fabbrica la costruzione dei comandi.
 * L'oggetto IO viene ricevuto dall'esterno, così il gioco non dipende direttamente
 * dalla console e può essere testato anche con implementazioni simulate.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see Partita
 * @see IO
 * @see IOConsole
 * @version 2.0
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
    
    private IO io;
    private Partita partita;
    
    /**
     * Crea una nuova istanza del gioco DiaDia.
     * 
     * @param io l'oggetto utilizzato per gestire input e output
     */
    public DiaDia(IO io) {
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
        Comando comando;
        FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
        
        comando = factory.costruisciComando(istruzione);
        this.io.mostraMessaggio(comando.esegui(this.partita));
    }
    
    /**
     * Punto di ingresso del programma.
     */
    public static void main(String[] args) {
        IO io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}