/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio_1;

import static java.awt.PageAttributes.MediaType.C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author anaranjo
 */
public class Prueba04psManejador {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        try {

            Process nuevoProceso1, nuevoProceso2;
            String osName = System.getProperty("os.name");
            String ubArchivoCons;
            ubArchivoCons = "java C:\\Users\\anaranjo\\dam\\2526\\PSP2526_Tarea01\\src\\Ejercicio_1\\Prueba03psProductor.java 20 30";
            String linea;
            if (osName.toUpperCase().contains("WIN")) {

                // Primera manera de ejecutar un proceso
                System.out.println("Primera manera de ejecutar un proceso desde NetBeans:");
                nuevoProceso1 = Runtime.getRuntime().exec(ubArchivoCons);
                BufferedReader br1 = new BufferedReader(new InputStreamReader(nuevoProceso1.getInputStream()));

                while ((linea = br1.readLine()) != null) {
                    System.out.println(linea);
                }

                // Segunda manera y oficial de ejecutar un proceso
                System.out.println("Segunda manera de ejecutar un proceso desde Netbeans:");
                ProcessBuilder pb = new ProcessBuilder("java", "C:\\Users\\anaranjo\\dam\\2526\\PSP2526_Tarea01\\src\\Ejercicio_1\\Prueba03psProductor.java", "20", "30");
                nuevoProceso2 = pb.start();
                BufferedReader br2 = new BufferedReader(new InputStreamReader(nuevoProceso2.getInputStream()));
                while ((linea = br2.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error de E/S");
        }
    }

}
