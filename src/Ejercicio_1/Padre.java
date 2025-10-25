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
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        String linea = null;
        try {
            linea = bf.readLine();
            while (linea != null && linea.compareTo("Fin") != 0) {
                System.out.println("Hola Mamá respondo Papá a: " + linea);
                linea = bf.readLine();
            }
        } catch (IOException ex) {
            System.err.println("Se ha producido un error en E/S");
        }
        
    }

}
