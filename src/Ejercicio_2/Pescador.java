/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

import java.util.Random;

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
    int eleccionPescador;
    int numCestas = 2;

    // Constructor
    public Pescador(Cesta cestaGatos) {
        this.cesta = cestaGatos;
    }

    @Override
    public void run() {
        // Saludo al inicar el método run del hilo pescador-productor
        cesta.saludoPescador();

        try {
            // Mientras el número de peces de la cesta del pescador sea menor de 10, el pescador intentará volver a pescar un pez simulando previamente un tiempo de pesca empleando el método estático sleep() de la clase Thread
            while (cesta.numPecesCestaPescador < 10) {
                // Tiempo de simulación de pesca aleatorio entre 1 y 5 segundos
                tiempoEsperaPescador = (numAleatorio.nextLong(5) + 1) * 1000;
                Thread.sleep(tiempoEsperaPescador);

                //  El pescador elige aleatoriamente entre depositar en su cesta personal (hasta 10) o en la cesta de los gatos (capacidad máxima de 2)
                // Cesta elegida por el pescador, de manera aleatoria: 1-> colocará el pez en la cesta del pescador, 2-> colocará el pez en la cesta de los gatos
                eleccionPescador = numAleatorio.nextInt(numCestas) + 1;

                // Una vez elegida la cesta, se procede a depositar el pez en ella estableciendo una estructura selectiva
                switch (eleccionPescador) {

                    case 1:
                        // Si el número de peces en la cesta del pescador es inferior a 10, entonces se incrementa un pez más en su cesta personal
                        if (cesta.numPecesCestaPescador < 10) {
                            cesta.numPecesCestaPescador++;
                            System.out.println(String.format("%sEl pescador guarda un pez en su cesta personal. (CestaPescador: %d)%s", cesta.cian, cesta.numPecesCestaPescador, cesta.reset));
                        }
                        break;
                    case 2:
                        // El pescador alimenta a los gatos intentando colocar un pez en la cesta de los gatos
                        cesta.alimentarGatos();
                        break;
                    default:
                        // En caso que el usuario cambie la variable numCestas>2 entoces se lanzará un mensaje de error que advierta al programador que debe actualizar la estructura selectiva.
                        System.out.println(String.format("%sExiste un error en la elección tomada por el pescador o existen más de dos cestas.%s", cesta.rojo, cesta.reset));
                }

            }

            // Una vez el pescador ha completado su cesta con 10 peces, notifica a los gatos en espera que se marcha hasta otro día
            cesta.despedidaPescador();

        } catch (InterruptedException ex) {
            System.err.println(String.format("Hilo %s interrumpido: %s", Thread.currentThread().getName(), ex.getMessage()));
            Thread.currentThread().interrupt();
        }

    }

}
