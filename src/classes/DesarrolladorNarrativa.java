/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sebastian Rodriguez
 */
public class DesarrolladorNarrativa extends Thread{
    
    int guionesGenerados;
    int diasTrabajados;
    int capacidadDrive;
    int guionesEnDrive;
    int sueldoPorHora;
    Semaphore semaforoDrive;
    boolean activo;
    int totalPay;
    
    public DesarrolladorNarrativa(int guionesGenerados, int diasTrabajados, int capacidadDrive, int guinesEnDrive, int sueldoPorHora, Semaphore semaforoDrive, int totalPay, boolean activo) {
    
        this.guionesGenerados = guionesGenerados;
        this.diasTrabajados = diasTrabajados;
        this.capacidadDrive = 25;
        this.guionesEnDrive = guionesEnDrive;
        this.sueldoPorHora = 10;
        this.semaforoDrive = new Semaphore(1);
        this.totalPay = 0;
        this.activo = activo;
    }

    public void payDayDesarrolladorNarrativa(){
        this.totalPay += (sueldoPorHora * 24);
    }
    
    public void guionesFinalizados(){
        this.guionesEnDrive += guionesGenerados;
    }
    
    @Override
    public void run(){
        while(this.activo){
            try {
                System.out.println("TESTTT1");
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");
            }
        }
    }
    
    
    
}
