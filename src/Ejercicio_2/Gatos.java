/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaranjo
 */
public class Gatos implements Runnable {

    // Declaración de variables
    private final Cesta cesta;
    private int idGato;
    
    // Colores 
    public final String reset = "\u001B[0m";
    public final String rojo = "\u001B[91m";
    public final String azul = "\u001B[94m";
    public final String verde = "\u001B[92m";
    public final String amarillo = "\u001B[93m";

    // Constructor
    public Gatos(Cesta cestaGatos, int idGato) {
        this.cesta = cestaGatos;
        this.idGato=idGato;
        

    }

    @Override
    public void run() {
        switch (idGato){
            
            case 1:
                System.out.println(String.format("%s%s %d %s",rojo,Thread.currentThread().getName(),idGato,reset));
                System.out.println("\u001B[96mhola soy " + Thread.currentThread().getName());
                break;
            case 2:
                System.out.println(String.format("%s%s%s",verde,Thread.currentThread().getName(),reset));
                break;
            case 3:
                System.out.println(String.format("%s%s%s",amarillo,Thread.currentThread().getName(),reset));
                break;
            default:
        }
        
        try {
            cesta.comerPez();
        } catch (InterruptedException ex) {
            Logger.getLogger(Gatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
