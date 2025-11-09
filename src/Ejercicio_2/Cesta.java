/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

/**
 *
 * @author anaranjo
 */
public class Cesta {

    private int numPeces = 0;

    public synchronized void comerPez() throws InterruptedException {
        
        while (numPeces < 1) {
            wait();
        }
        numPeces--;
    }

    public void pescarPez() {
        numPeces++;
    }

}
