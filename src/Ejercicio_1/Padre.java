/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author anaranjo
 */
public class Padre {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here

        BufferedReader bfMadre;
        String lineaMadre;

        ProcessBuilder pbHijo;
        Process psHijo;
        BufferedReader brHijo;
        String lineaHijo;
        int exit;

        // Se imprime la petición de la madre
        bfMadre = new BufferedReader(new InputStreamReader(System.in));
        while ((lineaMadre = bfMadre.readLine()) != null) {
            System.out.println("Madre: " + lineaMadre);

            // Se llama al proceso hijo
            pbHijo = new ProcessBuilder("java", "Hijo.java", lineaMadre);
            psHijo = pbHijo.start();

            // Se recoge el mensaje del proceso Hijo
            brHijo = new BufferedReader(new InputStreamReader(psHijo.getInputStream()));
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
