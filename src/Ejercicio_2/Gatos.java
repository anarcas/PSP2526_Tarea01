/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz Runnable y simula el rol de los Consumidores
 * en el patrón Productor-Consumidor, los gatos. Los hilos Gatos intentan
 * consumir peces de la Cesta compartida de forma continua mientras la condición
 * de finalización (la Cesta del Pescador con menos de 10 peces) no se cumpla.
 * Tras consumir un pez, simulan un tiempo de espera mediante el método estatico
 * sleep() de la clase Thread para representar el tiempo que tardan en comer.
 *
 * @author Antonio Naranjo Castillo
 */
public class Gatos implements Runnable {

    // Declaración de variables
    private final Cesta cesta;
    long tiempoComiendoPez = 25000; // Tiempo de simulación de los gatos comiendo un pez de 25 segundos.

    // Constructor
    public Gatos(Cesta cestaGatos) {
        this.cesta = cestaGatos;
    }

    // Se sobreescribe el método run
    @Override
    public void run() {

        while (cesta.numPecesCestaPescador < 10) {

            // Los gatos saludan al pescador indicando que se encuentra disponibles para coger un pez de la cesta de los gatos
            cesta.saludoGato();

            // Mientras el número de peces de la cesta del pescador sea menor de 10, cada gato saludará y tratará de coger un pez de la cesta de los gatos, posteriormente simulará un tiempo de 25 segundos comiéndose el pez empleando el método estático sleep() de la clase Thread 
            try {

                cesta.comerPez();
                Thread.sleep(tiempoComiendoPez);

            } catch (InterruptedException ex) {
                Logger.getLogger(Gatos.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
        }
        // Una vez se haya completado la cesta del pescador con 10 peces, los gatos se marcharán indicando el recuento de peces consumidos
        cesta.despedidaGato();
    }

}
