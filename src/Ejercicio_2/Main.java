/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que inicializa y gestiona la simulación del patrón
 * Productor-Consumidor (Pescador-Gatos). Su función es crear el recurso
 * compartido (la Cesta), lanzar el hilo productor (Pescador) y varios hilos
 * consumidores (Gatos), y esperar a que todos ellos finalicen antes de terminar
 * el programa.
 *
 * @author Antonio Naranjo Castillo
 */
public class Main {

    /**
     * Método principal de la clase Main
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        // DECLARACIÓN/INSTANCIACIÓN DE VARIABLES
        String nombreGato;
        List<Thread> hilosGatos = new ArrayList<>();

        // Recurso compartido
        Cesta cestaGatos = new Cesta();

        // Hilos productor (pescador) e hilos consumidores (gatos)
        Thread hiloPescador;
        Thread hiloGatos;

        // INSTANCIACIÓN/INICIACIÓN DE HILOS
        // Hilo pescador
        hiloPescador = new Thread(new Pescador(cestaGatos), "pescador");
        hiloPescador.start();

        // Hilos gatos
        for (int i = 1; i <= 3; i++) {
            nombreGato = String.format("[GATO %d]", i);
            hiloGatos = new Thread(new Gatos(cestaGatos), nombreGato);
            hilosGatos.add(hiloGatos);
            hiloGatos.start();

        }

        // Los hilos se esperan antes de terminar el programa
        hiloPescador.join();

        for (Thread hilo : hilosGatos) {
            hilo.join();
        }

        // Mensaje de salida del programa mostrado en pantalla
        System.out.println("¡Otro día de pesca finalizado!");

    }

}
