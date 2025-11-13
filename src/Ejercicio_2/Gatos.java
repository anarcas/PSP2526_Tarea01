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
public class Gatos implements Runnable {

    // Declaración de variables
    private final Cesta cesta;
    private int idGato;

    // Declaración de variables auxiliares
    long tiempoComiendoPez;
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
    public Gatos(Cesta cestaGatos, int idGato) {
        this.cesta = cestaGatos;
        this.idGato = idGato; // De momento no se ha necesitado este identificador único
    }

    @Override
    public void run() {

        //do {
//            switch (idGato) {
//
//                case 1:
//                    System.out.println(String.format("%s%s %s %s", rojo, Thread.currentThread().getName(), cesta.mensajeGatos, reset));
//                    break;
//                case 2:
//                    System.out.println(String.format("%s%s %s %s", verde, Thread.currentThread().getName(), cesta.mensajeGatos, reset));
//                    break;
//                case 3:
//                    System.out.println(String.format("%s%s %s %s", amarillo, Thread.currentThread().getName(), cesta.mensajeGatos, reset));
//                    break;
//                default:
//            }
            try {
                while (cesta.numPecesCestaPescador < 10) {

                    cesta.comerPez();
                    System.out.println(String.format("%s ha cogido un pez. (CestaGatos: %d).", Thread.currentThread().getName(),cesta.numPecesCestaGatos));
                    Thread.sleep(25000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Gatos.class.getName()).log(Level.SEVERE, null, ex);
            }

        //} while (cesta.numPecesCestaPescador < 10);
    }

}
