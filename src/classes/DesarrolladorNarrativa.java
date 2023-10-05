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
public class DesarrolladorNarrativa extends Thread {

    int guionesGenerados;
    int diasTrabajados;
    int capacidadDrive;
    int guionesEnDrive;
    int sueldoPorHora;
    Semaphore driveGuion;
    boolean activo;
    int totalPay;
    char diasParaGenerar;

    public DesarrolladorNarrativa(int guionesGenerados, int diasTrabajados, int capacidadDrive, int guinesEnDrive, int sueldoPorHora, Semaphore semaforoDrive, int totalPay, boolean activo, char diasParaGenerar) {

        this.guionesGenerados = guionesGenerados;
        this.diasTrabajados = diasTrabajados;
        this.capacidadDrive = 25;
        this.guionesEnDrive = guionesEnDrive;
        this.sueldoPorHora = 10;
        this.driveGuion = new Semaphore(5);
        this.totalPay = 0;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
    }

    public void payDayDesarrolladorNarrativa() {
        this.totalPay += (sueldoPorHora * 24);
    }

    public void guionesFinalizados() {
        this.guionesEnDrive += guionesGenerados;
    }

    @Override
    public void run() {
        while (this.activo) {
            try {
                Thread.sleep(diasParaGenerar * 1000); // Simular días de trabajo
                generarGuion();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");
            }
        }
    }
    
    private void generarGuion() throws InterruptedException {
        // Simulación de generación de guión
        Thread.sleep(1000); // Tiempo de generación (NO HACE FALTA, la generacion del guion es automatica despues de finalizar los 4 dias de trabajo que se hacen en el run.
        // Intento agregar el guion al drive
        if (driveGuion.availablePermits() > 0) {
            driveGuion.acquire(1);
            System.out.println("Guion agregado al Drive por Desarrollador ");
        } else {
            System.out.println("Drive lleno. Esperando a que se libere espacio.");
            driveGuion.release(1);
            System.out.println("Se libero un guion del drive SUUUUU");
        }
    }

}
