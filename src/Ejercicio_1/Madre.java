/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_1;

/**
 * Clase que simula el rol de la madre como origen o fuente de las peticiones Su
 * función principal es generar un mensaje predefinido y enviarlo a la salida
 * estándar, para ser capturado por la clase Padre a través de tubería
 *
 * @author Antonio Naranjo Castillo
 */
public class Madre {

    /**
     * Método main de la clase Madre
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String mensaje;
        mensaje = "Dile al niño que haga los deberes";
        System.out.println(mensaje);
    }

}
