/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_2;

/**
 *
 * @author anaranjo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // DECLARACIÓN DE VARIABLES
        String nombreGato;

        Cesta cestaGatos = new Cesta();
        Cesta cestaPescador = new Cesta();

        Thread hiloPescador;
        Thread hiloGato;

        // INICIACIÓN DE HILOS
        // HILO PESCADOR
        hiloPescador = new Thread(new Pescador(cestaPescador), "Pescador");
        hiloPescador.start();

        // HILOS GATOS
        for (int i = 1; i <= 3; i++) {
            nombreGato = String.format("[GATO %d]", i);
            hiloGato = new Thread(new Gatos(cestaGatos,i), nombreGato);
            hiloGato.start();

        }

    }

}
