/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_1;

/**
 * Clase que simula el comportamiento de un hijo al recibir una orden
 * o mensaje. Contiene el punto de entrada principal del programa (main)
 * para procesar la entrada del primer argumento.
 *
 * @author Antonio Naranjo Castillo
 */
public class Hijo {

    /**
     * Método main del la clase Hijo
     * Este método procesa el primer argumento de la línea de comandos (args[0])
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        if (args[0].length() == 0) {
            // Si el argumento es una cadena vacía, simula que el hijo no entiende.
            System.out.println("No entiendo... ¿me puedes repetir papá?");
        } else {
            // Si el argumento tiene contenido, simula que el hijo acepta la orden.
            System.out.println("Vaaaaale");
        }

        System.exit(1);
    }

}
