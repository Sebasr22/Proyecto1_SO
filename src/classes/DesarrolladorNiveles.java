/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juand
 */
public class DesarrolladorNiveles extends Thread{
    
    int nivelesGenerados;
    int diasTrabajados;
    int capacidadDrive;
    int nivelesEnDrive;
    int sueldoPorHora;
    Semaphore semaforoDrive;
    boolean activo;
    int totalPay;
   
    
  public DesarrolladorNiveles(int nivelesGenerados, int diasTrabajados, int capacidadDrive, int nivelesEnDrive, int sueldoPorHora, Semaphore semaforoDrive, int totalPay, boolean activo) {
    
        this.nivelesGenerados = nivelesGenerados;
        this.diasTrabajados = diasTrabajados;
        this.capacidadDrive = 25;
        this.nivelesEnDrive = nivelesEnDrive;
        this.sueldoPorHora = 13;
        this.semaforoDrive = new Semaphore(1);
        this.totalPay = 0;
        this.activo = activo;
    }
     
  public void payDayDesarrolladorNiveles(){
        this.totalPay += (sueldoPorHora * 24);
    }
    
    public void nivelesFinalizados(){
        this.nivelesEnDrive += nivelesGenerados;
    }
    
      @Override
public void run() {
    while (activo) { 
        try {
           
            generarNiveles();
            // Simula el paso de un día de trabajo
            diasTrabajados++;
            
            // Pausa la ejecución del hilo para representar un día de trabajo
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public void generarNiveles() {
 
    
    // Actualiza la cantidad de niveles en el Drive
    nivelesEnDrive += nivelesGenerados;
}

    }

