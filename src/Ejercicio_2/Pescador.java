/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz Runnable y simula el rol del Productor en el
 * patrón Productor-Consumidor. El hilo Pescador se encarga de generar el
 * recurso, los peces, y depositarlos en la Cesta compartida de forma
 * intermitente. La duración de la pausa entre cada acción de pesca se determina
 * de forma aleatoria. La actividad del pescador cesa al alcanzar su cuota de 10
 * peces.
 *
 * @author Antonio Naranjo Castillo
 */
public class Pescador implements Runnable {

    // Declaración/instanciación de variables
    private final Cesta cesta;
    long tiempoEsperaPescador;
    Random numAleatorio = new Random();

    // Constructor
    public Pescador(Cesta cestaGatos) {
        this.cesta = cestaGatos;
    }

    @Override
    public void run() {
        // Saludo al inicar el método run del hilo pescador-productor
        cesta.saludoPescador();

        // Mientras el número de peces de la cesta del pescador sea menor de 10, el pescador intentará volver a pescar un pez simulando previamente un tiempo de pesca empleando el método estático sleep() de la clase Thread 
        try {

            while (cesta.numPecesCestaPescador < 10) {
                // Tiempo de simulación de pesca aleatorio entre 1 y 5 segundos
                tiempoEsperaPescador = (numAleatorio.nextLong(5) + 1) * 1000;
                Thread.sleep(tiempoEsperaPescador);
                cesta.pescarPez();
            }

            // Una vez el pescador ha completado su cesta con 10 peces, notifica a los gatos en espera que se marcha hasta otro día
            cesta.despedidaPescador();

        } catch (InterruptedException ex) {
            Logger.getLogger(Pescador.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }

    }

}
