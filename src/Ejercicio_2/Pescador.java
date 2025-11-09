/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_2;

/**
 *
 * @author anaranjo
 */
public class Pescador implements Runnable {

    private final Cesta cesta;

    public Pescador(Cesta cestaPescador) {
        this.cesta = cestaPescador;
    }

    @Override
    public void run() {
        System.out.println("\u001B[34m" + "Hola soy el pescador " + Thread.currentThread().getName());
    }

}
