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

    Semaphore capacidadDrive;

    int guionesEnDrive;
    int sueldoPorHora;
    Semaphore driveGuion;
    boolean activo;
    int totalPay;
    int diasParaGenerar;


    public DesarrolladorNarrativa(int guionesGenerados, int diasTrabajados, int guinesEnDrive, int sueldoPorHora, Semaphore semaforoDrive, int totalPay, boolean activo, int diasParaGenerar) {

        this.guionesGenerados = guionesGenerados;
        this.diasTrabajados = diasTrabajados; // No hace falta por la manera en la que se esta realizando el pago.
        this.capacidadDrive = capacidadDrive;

 
        this.guionesEnDrive = guionesEnDrive;
        this.sueldoPorHora = 10;
        this.driveGuion = driveGuion;
        this.totalPay = 0;
        this.activo = activo;

        this.diasParaGenerar = diasParaGenerar;

    }

    public void guionesFinalizados() {
        this.guionesEnDrive += guionesGenerados;
    }

    public void payDayDesarrolladorNarrativa() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        totalPay += salario;
    }

    @Override
    public void run() {
        while (activo) {
            try {
//                int tiempoGeneracion = 4;
//                Thread.sleep(tiempoGeneracion * 1000); // Simular días de trabajo
                int count = 0;

                while (count < diasParaGenerar) { // Para poder hacer los pagos por cada dia de trabajo que pasa.
                    Thread.sleep(1000);
                    payDayDesarrolladorNarrativa();
                    count++;
                    System.out.println(totalPay);

                }
                generarGuion();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");
            }
        }
    }

    private void generarGuion() throws InterruptedException {
        // Simulación de generación de guión
//        Thread.sleep(1000); // Tiempo de generación (NO HACE FALTA, la generacion del guion es automatica despues de finalizar los 4 dias de trabajo que se hacen en el run.
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
