package it.uniroma3.diadia;

/**
 * IOSimulator: implementazione simulata dell'interfaccia IO.
 *
 * Permette di fornire al gioco una sequenza prefissata di comandi e
 * conserva i messaggi prodotti durante l'esecuzione. È utile per testare
 * automaticamente intere partite senza input manuale da tastiera.
 *
 * @author Mat. 627298 | Mat. 628848
 * @see IO
 * @see DiaDia
 * @version 2.0
 */
public class IOSimulator implements IO {

    private String[] righeDaLeggere;
    private String[] messaggiProdotti;

    private int indiceLettura;
    private int indiceMessaggi;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.messaggiProdotti = new String[100];
        this.indiceLettura = 0;
        this.indiceMessaggi = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiProdotti[this.indiceMessaggi] = messaggio;
        this.indiceMessaggi++;
    }

    @Override
    public String leggiRiga() {
        if (this.indiceLettura >= this.righeDaLeggere.length) {
            return "fine";
        }

        String riga = this.righeDaLeggere[this.indiceLettura];
        this.indiceLettura++;
        return riga;
    }

    public String getMessaggio(int indice) {
        return this.messaggiProdotti[indice];
    }

    public String[] getMessaggiProdotti() {
        return this.messaggiProdotti;
    }

    public int getNumeroMessaggiProdotti() {
        return this.indiceMessaggi;
    }
}