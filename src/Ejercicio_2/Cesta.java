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

    // Método comerPez que será ejecutado por los gatos, hilos consumidores
    public synchronized void comerPez() throws InterruptedException {

        

        // Mientras no existan peces en la cesta, los gatos esperan
        while (numPecesCestaGatos < 1 && numPecesCestaPescador<10) {
           // System.out.println(Thread.currentThread().getName()+" Hola pescador quiero un pez");
            notifyAll();
           // System.out.println(Thread.currentThread().getName()+" me quedo esperando un pez");
            wait();
//            if (numPecesCestaGatos != 0) {
//                numPecesCestaGatos--;
//            } else {
//                notifyAll();
//            }

        }
        if (numPecesCestaGatos>0){
        numPecesCestaGatos--;
                            System.out.println(String.format("%s ha cogido un pez. (CestaGatos: %d).", Thread.currentThread().getName(),numPecesCestaGatos));

        }
        //despedida();
    }

    // Método pescarPez que será ejecutado por el pescador, hilo productor
    public synchronized void pescarPez() throws InterruptedException {

        // Elección del pescador, 1-> colocará el pez en la cesta del pescador, 2-> colocará el pez en la cesta de los gatos
        eleccionPescador = numAleatorio.nextInt(numCestas) + 1;
        switch (eleccionPescador) {

            case 1:
                if (numPecesCestaPescador < 10) {
                    numPecesCestaPescador++;
                    System.out.println(String.format("El pescador guarda un pez en su cesta personal. (CestaPescador:%d)", numPecesCestaPescador));
                }
                break;
            case 2:
                if (numPecesCestaGatos < 2) {
                    numPecesCestaGatos++;
                    System.out.println(String.format("El pescador deja un pez en la cesta de los gatos. (CestaGatos:%d)", numPecesCestaGatos));
                    notifyAll();
                //} else if (numPecesCestaPescador < 10) {
                    } else {
                    System.out.println(String.format("%sEl pescador espera para dejar un pez en la cesta de los gatos. (CestaGatos:%d)%s", magenta, numPecesCestaGatos, reset));
                    wait();
                    numPecesCestaGatos++;
                    System.out.println(String.format("El pescador deja un pez en la cesta de los gatos. (CestaGatos:%d)", numPecesCestaGatos));
                    notifyAll();
                }
                break;
            default:
                System.out.println("\u001B[31m" + "Existe un error en la elección tomada por el pescador o existen más de dos cestas." + "\u001B[0m");
        }
    }

    /**
     *
     * @throws InterruptedException
     */
    public synchronized void despedidaPescador() throws InterruptedException {
        if (numPecesCestaPescador == 10) {
            System.out.println("Que me voy!!! se despide: " + Thread.currentThread().getName());
            System.out.println("Recogiendo caña.");
            notifyAll();

        }
    }
    
    public void saludoGato(){
        
        String [] numGato=Thread.currentThread().getName().split(" ");
        int idGato=Integer.parseInt(numGato[1].split("]")[0]);
    
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
    public void despedidaGato(){
        
        String [] numGato=Thread.currentThread().getName().split(" ");
        int idGato=Integer.parseInt(numGato[1].split("]")[0]);
    
        switch (idGato) {

                case 1:
                    System.out.println(String.format("%s%s %s %s", rojo, Thread.currentThread().getName(), "hasta la vista", reset));
                    break;
                case 2:
                    System.out.println(String.format("%s%s %s %s", verde, Thread.currentThread().getName(), "nos vemos mañana", reset));
                    break;
                case 3:
                    System.out.println(String.format("%s%s %s %s", amarillo, Thread.currentThread().getName(), "ya si eso nos vemos", reset));
                    break;
                default:
            }}
        
     public void saludoPescador(){
         
         System.out.println(String.format("Hola soy %s y empiezo mi día de pesca, lanzando caña...",Thread.currentThread().getName()));
         
     }
        
    }

