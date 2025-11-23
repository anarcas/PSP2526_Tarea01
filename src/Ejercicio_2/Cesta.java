/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

import java.util.Random;

/**
 *
 * @author Antonio Naranjo Castillo
 */
public class Cesta {

    // Declaración de variables e iniciación si procede
    int numPecesCestaGatos = 0;
    int numPecesCestaPescador = 0;
    int numCestas = 2;
    Random numAleatorio = new Random();
    int eleccionPescador;
    String mensajeGatos = "Miau!";
    int[] numPecesComidos = {0, 0, 0};

    // Colores 
    public final String reset = "\u001B[0m";
    //public final String negro = "\u001B[30m";
    public final String rojo = "\u001B[31m";
    public final String verde = "\u001B[32m";
    public final String amarillo = "\u001B[33m";
    //public final String azul = "\u001B[34m";
    public final String magenta = "\u001B[35m";
    public final String cian = "\u001B[36m";
    //public final String blanco = "\u001B[37m";

    // Metodo saludo del pescador al llegar al área de pesca
    public void saludoPescador() {

        System.out.println(String.format("Hola soy %s y empiezo mi día de pesca, lanzando caña...", Thread.currentThread().getName()));

    }

    // Método sincronizado pescarPez que será ejecutado por el pescador, hilo productor
    public synchronized void pescarPez() throws InterruptedException {

        // Elección del pescador, 1-> colocará el pez en la cesta del pescador, 2-> colocará el pez en la cesta de los gatos
        eleccionPescador = numAleatorio.nextInt(numCestas) + 1;
        switch (eleccionPescador) {

            case 1:
                if (numPecesCestaPescador < 10) {
                    numPecesCestaPescador++;
                    System.out.println(String.format("%sEl pescador guarda un pez en su cesta personal. (CestaPescador:%d)%s", cian, numPecesCestaPescador, reset));
                }
                break;
            case 2:
//                if (numPecesCestaGatos < 2) {
//                    numPecesCestaGatos++;
//                    System.out.println(String.format("%sEl pescador deja un pez en la cesta de los gatos. (CestaGatos:%d)%s", cian, numPecesCestaGatos, reset));
//                    notifyAll();
//                } else {
//                    System.out.println(String.format("%sEl pescador espera para dejar un pez en la cesta de los gatos. (CestaGatos:%d)%s", magenta, numPecesCestaGatos, reset));
//                    wait();
//                    numPecesCestaGatos++;
//                    System.out.println(String.format("%sEl pescador deja un pez en la cesta de los gatos. (CestaGatos:%d)%s", cian, numPecesCestaGatos, reset));
//                    notifyAll();
//                }
                while (numPecesCestaGatos >= 2) {
                    System.out.println(String.format("%sEl pescador espera para dejar un pez en la cesta de los gatos. (CestaGatos:%d)%s", magenta, numPecesCestaGatos, reset));
                    wait();
                }
                numPecesCestaGatos++;
                System.out.println(String.format("%sEl pescador deja un pez en la cesta de los gatos. (CestaGatos:%d)%s", cian, numPecesCestaGatos, reset));
                notifyAll();
                break;
            default:
                System.out.println(String.format("%sExiste un error en la elección tomada por el pescador o existen más de dos cestas.%s", rojo, reset));
        }
    }

    // Método sincronizado comerPez que será ejecutado por los gatos, hilos consumidores
    public synchronized void comerPez() throws InterruptedException {

        // Mientras no existan peces en la cesta, los gatos esperan
        while (numPecesCestaGatos < 1 && numPecesCestaPescador < 10) {
            // El gato notifica que está en estado de espera hasta que o bien en la cesta de los gatos exista un pez o bien el número de peces de la cesta del pescador sea menor de 10
            notifyAll();
            // El gato espera según las condiciones anteriores
            wait();
        }

        if (numPecesCestaGatos > 0) {
            numPecesCestaGatos--;
            String[] numGato = Thread.currentThread().getName().split(" ");
            int idGato = Integer.parseInt(numGato[1].split("]")[0]);

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
     * alcanzados los 10 peces en su cesta personal De esta manera se pueden
     * advertir a los gatos para evitar que queden es espera infinita
     *
     * @throws InterruptedException
     */
    public synchronized void despedidaPescador() throws InterruptedException {
        if (numPecesCestaPescador == 10) {
            System.out.println("El pescador ha alcanzado 10 peces, recogiendo la caña.");
            notifyAll();
        }
    }

    public void saludoGato() {

        String[] numGato = Thread.currentThread().getName().split(" ");
        int idGato = Integer.parseInt(numGato[1].split("]")[0]);

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
     *
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
