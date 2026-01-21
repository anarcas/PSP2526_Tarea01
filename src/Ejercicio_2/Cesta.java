/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

/**
 ** Clase que representa el recurso compartido central entre el hilo productor
 * (Pescador) y los hilos consumidores (Gatos).
 *
 * Gestiona dos cestas: la cesta personal del pescador (límite de 10 peces para
 * finalizar) y la cesta de los gatos (capacidad máxima de 2 peces). Contiene la
 * lógica sincronizada (wait/notify) para manejar la concurrencia y evitar el
 * desbordamiento o agotamiento del recurso de los gatos. También gestiona
 * contadores de peces y la presentación en consola con colores.
 *
 * @author Antonio Naranjo Castillo
 */
public class Cesta {

    // Declaración de variables e iniciación si procede
    int numPecesCestaGatos = 0;
    int numPecesCestaPescador = 0;

    String mensajeGatos = "Miau!";
    int[] numPecesComidos = {0, 0, 0};

    // Colores 
    public final String reset = "\u001B[0m";
    public final String rojo = "\u001B[31m";
    public final String verde = "\u001B[32m";
    public final String amarillo = "\u001B[33m";
    public final String magenta = "\u001B[35m";
    public final String cian = "\u001B[36m";

    // Metodo saludoPescador() el hilo productor (pescador) imprime por pantalla su llegada al área de pesca. No se pide en la tarea, pero lo considero necesario como mensaje de inicio del hilo productor, de esta manera queda correspondido con el saludo de los gatos
    public void saludoPescador() {

        System.out.println(String.format("El %s acaba de llegar al área recreativa y da comienzo su jornada de pesca.", Thread.currentThread().getName()));

    }

    /**
     * Método sincronizado ejecutado por el hilo Pescador (Productor) para
     * depositar un pez en la cesta de los gatos. Si la cesta de los gatos está
     * llena, el pescador se bloquea (wait). Si añade un pez a la cesta de los
     * gatos, notifica a los gatos o hilos Consumidores (notifyAll).
     *
     * @throws InterruptedException Si el hilo es interrumpido mientras espera.
     */
    public synchronized void alimentarGatos() throws InterruptedException {
        // Mientras el número de peces de la cesta de los gatos sea igual a 2, el pescador espera que un gato coja un pez antes de depositarlo
        while (numPecesCestaGatos == 2) {
            System.out.println(String.format("%sEl pescador espera para dejar un pez en la cesta de los gatos. (CestaGatos: %d)%s", magenta, numPecesCestaGatos, reset));
            wait();
        }
        // Si no se cumple la condición del bucle while anterior entonces incrementa el número de peces de la cesta de los gatos y notifica a los gatos que hay un nuevo pez en su cesta
        numPecesCestaGatos++;
        System.out.println(String.format("%sEl pescador deja un pez en la cesta de los gatos. (CestaGatos: %d)%s", cian, numPecesCestaGatos, reset));
        notifyAll();
    }

    /**
     * Método sincronizado ejecutado por los hilos Gatos (Consumidores) para
     * tomar un pez de su cesta. Si la cesta de los gatos está vacía y el
     * pescador aún no ha terminado (menos de 10 peces), el gato se bloquea
     * (wait). Si hay peces disponibles, consume uno, actualiza su contador
     * personal de peces consumidos y notifica a otros hilos (notifyAll).
     *
     * @throws InterruptedException Si el hilo es interrumpido mientras espera.
     */
    public synchronized void comerPez() throws InterruptedException {

        // Mientras no existan peces en la cesta, los gatos esperan y el número de peces de la cesta del pescador no haya alcanzado 10 piezas
        while (numPecesCestaGatos < 1 && numPecesCestaPescador < 10) {
            // El gato espera según las condiciones anteriores
            wait();
        }

        // Si existe algún pez en la cesta de los gatos el gato lo cogerá
        if (numPecesCestaGatos > 0) {
            numPecesCestaGatos--;
            // El gato notifica al pescador (y al resto de los gatos) que ha cogido un pez, debe ser notifyAll() para asegurarnos que no llame a otro gato que se encuentre en espera y se quede la aplicación en un bucle infinito
            notifyAll();
            String[] numGato = Thread.currentThread().getName().split(" ");
            int idGato = Integer.parseInt(numGato[1].split("]")[0]);

            // Dependiendo del gato que esté dentro del método sincronizado se mostrará en pantalla del color correspondiente
            switch (idGato) {
                case 1:
                    numPecesComidos[0]++;
                    System.out.println(String.format("%s%s ha cogido un pez.%s", rojo, Thread.currentThread().getName(), reset));
                    break;
                case 2:
                    numPecesComidos[1]++;
                    System.out.println(String.format("%s%s ha cogido un pez.%s", verde, Thread.currentThread().getName(), reset));
                    break;
                case 3:
                    numPecesComidos[2]++;
                    System.out.println(String.format("%s%s ha cogido un pez.%s", amarillo, Thread.currentThread().getName(), reset));
                    break;
                default:
            }

        }

    }

    /**
     * Método sincronizado para llevar a cabo la despedida del pescador una vez
     * alcanzados los 10 peces en su cesta personal. Si la condición de
     * finalización se cumple (10 peces), se notifica a todos los hilos en
     * espera (notifyAll) para sacarlos de un posible bloqueo infinito.
     *
     * @throws InterruptedException Si el hilo es interrumpido.
     */
    public synchronized void despedidaPescador() throws InterruptedException {
        if (numPecesCestaPescador == 10) {
            System.out.println("El pescador ha alcanzado 10 peces, recogiendo la caña.");
            notifyAll();
        }
    }

    /**
     * Método saludoGato() donde los hilos consumidores (los gatos) muestran un
     * mensaje en pantalla de un determinado color según el ID del gato. Imprime
     * un mensaje de saludo (Miau!) de un color específico que está ejecutando
     * el método.
     */
    public void saludoGato() {

        String[] numGato = Thread.currentThread().getName().split(" ");
        int idGato = Integer.parseInt(numGato[1].split("]")[0]);

        // Según número de gato se muestra un determinado color en pantalla
        switch (idGato) {

            case 1:
                System.out.println(String.format("%s%s %s %s", rojo, Thread.currentThread().getName(), mensajeGatos, reset));
                break;
            case 2:
                System.out.println(String.format("%s%s %s %s", verde, Thread.currentThread().getName(), mensajeGatos, reset));
                break;
            case 3:
                System.out.println(String.format("%s%s %s %s", amarillo, Thread.currentThread().getName(), mensajeGatos, reset));
                break;
            default:
        }
    }

    /**
     * Muestra en pantalla el mensaje de despedida del hilo Gato (consumidor)
     * junto con el recuento total de peces que ese gato ha logrado consumir
     * durante la simulación.
     */
    public void despedidaGato() {

        String[] numGato = Thread.currentThread().getName().split(" ");
        int idGato = Integer.parseInt(numGato[1].split("]")[0]);

        switch (idGato) {

            case 1:
                System.out.println(String.format("%sEl gato %d terminó. Peces comidos: %d", rojo, idGato, numPecesComidos[0], reset));
                break;
            case 2:
                System.out.println(String.format("%sEl gato %d terminó. Peces comidos: %d", verde, idGato, numPecesComidos[1], reset));
                break;
            case 3:
                System.out.println(String.format("%sEl gato %d terminó. Peces comidos: %d", amarillo, idGato, numPecesComidos[2], reset));
                break;
            default:
        }
    }

}
