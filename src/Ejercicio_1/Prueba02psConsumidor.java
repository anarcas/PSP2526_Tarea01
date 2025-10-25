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
public class Prueba02psConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // ... (Clases para leer del flujo de entrada)
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        String linea = null;
        try {
            System.out.println("Consumidor esperando datos...");
            linea = bf.readLine();
            while (linea != null && linea.compareTo("Fin") != 0) {
                System.out.println("CONSUMIDOR PROCESA: " + linea);
                linea = bf.readLine();
            }
        } catch (IOException ex) {
            System.err.println("Error de E/S en consumidor");
        }
    }
    
}
