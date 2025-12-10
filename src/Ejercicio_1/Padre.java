/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que actúa como coordinador principal de la aplicación, simulando el rol
 * de un padre. Su función es leer comandos o peticiones de la entrada estándar
 * (simulando a la Madre), ejecutar un proceso externo (la clase Hijo) pasándole
 * esa petición como argumento, y luego procesar el código de salida y la
 * respuesta del Hijo.
 *
 * @author Antonio Naranjo Castillo
 */
public class Padre {

    /**
     * Método main de la clase Padre Lee continuamente líneas de la entrada
     * estándar (System.in). Por cada línea, ejecuta la clase 'Hijo' y utiliza
     * el contenido de la línea como argumento. Espera a que el proceso 'Hijo'
     * termine y verifica su código de salida.
     *
     * @param args the command line arguments
     * @throws java.lang.InterruptedException Si el hilo principal es
     * interrumpido mientras espera la finalización del Hijo.
     * @throws java.io.IOException Si ocurre un error de E/S durante la lectura
     * de la entrada o el manejo del proceso.
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here

        // Declaración de variables
        BufferedReader bfMadre;
        String lineaMadre;

        ProcessBuilder pbHijo;
        Process psHijo;
        BufferedReader brHijo;
        String lineaHijo;
        int exit;

        // Se imprime la petición de la madre usando configuración UTF-8
        bfMadre = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
        while ((lineaMadre = bfMadre.readLine()) != null) {
            System.out.println("Madre: " + lineaMadre);

            // Se llama al proceso hijo
            pbHijo = new ProcessBuilder("java", "Hijo.java", lineaMadre);
            psHijo = pbHijo.start();

            // Se recoge el mensaje del proceso Hijo usando configuración UTF-8
            brHijo = new BufferedReader(new InputStreamReader(psHijo.getInputStream(),"UTF-8"));
            // Se espera que el proceso Hijo responda
            System.out.println("(Despertando a Mario)");
            // Se espera a que el proceso Hijo termine
            // Se emplea waitFor() aunque readLine() sea bloqueante, de cara a una ampliación futura de la aplicación
            exit = psHijo.waitFor();
            // Una vez ha terminado el proceso Hijo se muestra en pantalla su respuesta
            if (exit == 1) {
                while ((lineaHijo = brHijo.readLine()) != null) {
                    System.out.println("Dice Mario que '" + lineaHijo + "'");
                }
            } else {
                System.out.println("El niño no se ha despertado...");
            }
        }
    }
}
