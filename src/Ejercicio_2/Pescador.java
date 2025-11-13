/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Naranjo Castillo
 */
public class Pescador implements Runnable {

    // Declaración de variables
    private final Cesta cesta;

    long tiempoEsperaPescador;
    Random numAleatorio = new Random();

    // Colores 
    public final String reset = "\u001B[0m";
    public final String negro = "\u001B[30m";
    public final String rojo = "\u001B[31m";
    public final String verde = "\u001B[32m";
    public final String amarillo = "\u001B[33m";
    public final String azul = "\u001B[34m";
    public final String magenta = "\u001B[35m";
    public final String cian = "\u001B[36m";
    public final String blanco = "\u001B[37m";

    // Constructor
    public Pescador(Cesta cestaGatos) {
        this.cesta = cestaGatos;
    }

    @Override
    public void run() {
        System.out.println(String.format("%sHola soy el pescador %s %s", cian, Thread.currentThread().getName(), reset));
        try {
            while (cesta.numPecesCestaPescador < 10) {
                tiempoEsperaPescador = (numAleatorio.nextLong(5) + 1) * 1000;

                Thread.sleep(tiempoEsperaPescador);

                cesta.pescarPez();
            }

            while (cesta.numPecesCestaGatos != 0) {
                tiempoEsperaPescador = (numAleatorio.nextLong(5) + 1) * 1000;

                Thread.sleep(tiempoEsperaPescador);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Pescador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Recogiendo caña.");
    }

}
