package com.example.Command;

     /**
     * Interfaccia comune ai comandi dell'applicazione
     */
public interface Command {
    /**
     * Metodo per eseguire il comando
     */
    void execute();
    /**
     * Metodo per eseguire il comando
     */
    void undo();

}
