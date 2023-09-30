/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classesNintendo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sebastian Rodriguez
 */
public class Empleado extends Thread {

    private String nombre;
    private double costoPorHora;
    private int numeroCarnet;
    private Semaphore driveSemaphore;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(double costoPorHora) {
        this.costoPorHora = costoPorHora;
    }

    public int getNumeroCarnet() {
        return numeroCarnet;
    }

    public void setNumeroCarnet(int numeroCarnet) {
        this.numeroCarnet = numeroCarnet;
    }

    public Semaphore getDriveSemaphore() {
        return driveSemaphore;
    }

    public void setDriveSemaphore(Semaphore driveSemaphore) {
        this.driveSemaphore = driveSemaphore;
    }

    public Empleado(String nombre, double costoPorHora, int numeroCarnet, Semaphore driveSemaphore) {
        this.nombre = nombre;
        this.costoPorHora = costoPorHora;
        this.numeroCarnet = numeroCarnet;
        this.driveSemaphore = driveSemaphore;
    }

    @Override
    public void run() {
        try {
            // Aqui podemos agregar la logica para que el trabajador realice su 
            // trabajo, como generar guiones, niveles, etc.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
