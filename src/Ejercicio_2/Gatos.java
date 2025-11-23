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
    long tiempoComiendoPez = 25000; // Tiempo de simulación de los gatos comiendo un pez de 25 segundos.

    // Constructor
    public Gatos(Cesta cestaGatos) {
        this.cesta = cestaGatos;
    }

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
