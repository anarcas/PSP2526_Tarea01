/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_2;

import java.util.Random;

/**
 *
 * @author Antonio Naranjo Castillo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // DECLARACIÓN DE VARIABLES
        String nombreGato;
        int cestaPescador;
        
        // Recurso compartido
        Cesta cestaGatos = new Cesta();
        
        // Hilos productor y consumidores
        Thread hiloPescador;
        Thread hiloGatos;

        // INICIACIÓN DE HILOS
        // HILO PESCADOR
        hiloPescador = new Thread(new Pescador(cestaGatos), "Antonio");
        hiloPescador.start();

        // HILOS GATOS
        for (int i = 1; i <= 3; i++) {
            nombreGato = String.format("[GATO %d]", i);
            hiloGatos = new Thread(new Gatos(cestaGatos,i), nombreGato);
            hiloGatos.start();

        }

    }

}
