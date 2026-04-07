package it.uniroma3.diadia;

/**
 * Comando: Rappresenta un comando inserito dall'utente.
 * Un comando è composto da un nome e, opzionalmente, da un parametro.
 * 
 * @author  Mat. 627298 | Mat. 628848
 * @version Revisionata
 */
public class Comando {

    private String nome;
    private String parametro;

    /**
     * Costruisce un comando a partire da una riga di testo.
     * La prima parola viene interpretata come nome del comando,
     * la seconda come eventuale parametro.
     * 
     * @param istruzione la riga inserita dall'utente
     */
    public Comando(String istruzione) {
        String[] parole = istruzione.split(" ");

        // prima parola: nome del comando
        if (parole.length > 0 && !parole[0].isEmpty())
            this.nome = parole[0]; 

        // seconda parola: eventuale parametro
        if (parole.length > 1)
            this.parametro = parole[1];
    }

    /**
     * Restituisce il nome del comando.
     * 
     * @return il nome del comando
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce il parametro del comando, se presente.
     * 
     * @return il parametro del comando oppure null
     */
    public String getParametro() {
        return this.parametro;
    }

    /**
     * Controlla se il comando è sconosciuto.
     * Un comando è sconosciuto se non ha un nome valido.
     * 
     * @return true se il comando è sconosciuto, false altrimenti
     */
    public boolean sconosciuto() {
        return this.nome == null;
    }
}