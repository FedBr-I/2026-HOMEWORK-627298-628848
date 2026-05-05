package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IOSimulatorTest {

    @Test
    public void testPartitaTerminataConComandoFine() {
        String[] comandi = {"fine"};
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(io.getNumeroMessaggiProdotti() >= 2);
        assertTrue(contieneMessaggio(io, "Grazie"), tuttiMessaggi(io));
    }

    @Test
    public void testPartitaVintaAndandoNord() {
        String[] comandi = {"vai nord"};
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(contieneMessaggio(io, "Hai vinto"), tuttiMessaggi(io));
    }

    @Test
    public void testPartitaConComandoNonValidoPoiFine() {
        String[] comandi = {"salta", "fine"};
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(contieneMessaggio(io, "Comando non valido"), tuttiMessaggi(io));
        assertTrue(contieneMessaggio(io, "Grazie"), tuttiMessaggi(io));
    }

    @Test
    public void testPartitaConGuardaPoiFine() {
        String[] comandi = {"guarda", "fine"};
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(contieneMessaggio(io, "Informazioni Stanza"), tuttiMessaggi(io));
        assertTrue(contieneMessaggio(io, "Informazioni Giocatore"), tuttiMessaggi(io));
    }

    @Test
    public void testPartitaConAiutoPoiFine() {
        String[] comandi = {"aiuto", "fine"};
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(contieneMessaggio(io, "vai"), tuttiMessaggi(io));
        assertTrue(contieneMessaggio(io, "fine"), tuttiMessaggi(io));
        assertTrue(contieneMessaggio(io, "Grazie"), tuttiMessaggi(io));
    }

    @Test
    public void testPartitaConPrendiPosaPoiFine() {
        String[] comandi = {"prendi osso", "posa osso", "fine"};
        IOSimulator io = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(contieneMessaggio(io, "osso"), tuttiMessaggi(io));
        assertTrue(contieneMessaggio(io, "Grazie"), tuttiMessaggi(io));
    }

    private boolean contieneMessaggio(IOSimulator io, String testo) {
        for (int i = 0; i < io.getNumeroMessaggiProdotti(); i++) {
            String messaggio = io.getMessaggio(i);

            if (messaggio != null && messaggio.contains(testo)) {
                return true;
            }
        }

        return false;
    }

    private String tuttiMessaggi(IOSimulator io) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < io.getNumeroMessaggiProdotti(); i++) {
            sb.append(i);
            sb.append(": ");
            sb.append(io.getMessaggio(i));
            sb.append("\n");
        }

        return sb.toString();
    }
}