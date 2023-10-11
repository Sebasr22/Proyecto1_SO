/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;
import interfaces.Bethesda;
import interfaces.Nintendo;

/**
 *
 * @author Sebastian Rodriguez
 */
public class DesarrolladorNarrativa extends Thread {

    public static int guionesSubidosDriveB = 0;
    public static int guionesSubidosDriveN = 0;
    int sueldoPorHora;
    Semaphore driveGuion;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String studio;

    public DesarrolladorNarrativa(Semaphore driveGuion, int totalPay, int diasParaGenerar, String studio, boolean activo) {

        this.sueldoPorHora = 10;
        this.driveGuion = driveGuion;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.studio = studio;

    }

    public void payDayDesarrolladorNarrativa() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (studio == "B") {
            BethesdaStudio.totalPayB += salario;
        } else {
            // Pago de nintendo
            NintendoStudio.totalPayN += salario;
        }

    }

    @Override
    public void run() {
        while (activo) {
            try {
                int count = 0;

                while (count < diasParaGenerar) { // Para poder hacer los pagos por cada dia de trabajo que pasa.
                    Thread.sleep(1000);
                    payDayDesarrolladorNarrativa();
                    count++;

                }
                generarGuion();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }
    }

    private void generarGuion() throws InterruptedException {
        // Intento agregar el guion al drive
        if (studio == "B") {
            if (driveGuion.availablePermits() > 0) {
                driveGuion.acquire(1);
                //System.out.println("Guion agregado al Drive por Desarrollador ");

                guionesSubidosDriveB++; // Incrementa el contador 
                Bethesda.actualizarGuionesEnDrive(guionesSubidosDriveB);
                //System.out.println("Pago total:" + BethesdaStudio.totalPay);

            } else {
                System.out.println("Drive GUIONES Lleno esperando libere espacio.");

            }

//            driveGuion.release(1);
//            System.out.println("Se libero un guion del drive SUUUUU");  //LIBERAR ESPACIO DEL DRIVE PRUEBA
        } else {
            // Generar Nintendo
            if (driveGuion.availablePermits() > 0) {
                driveGuion.acquire(1);
                guionesSubidosDriveN++;
                Nintendo.actualizarGuionesEnDrive(guionesSubidosDriveN);
            } else {
                System.out.println("Drive GUIONES lleno. Esperando a que se libere espacio.");
            }
        }

    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static int getGuionesSubidosDriveB() {
        return guionesSubidosDriveB;
    }

    public static void setGuionesSubidosDriveB(int guionesSubidosDriveB) {
        DesarrolladorNarrativa.guionesSubidosDriveB -= guionesSubidosDriveB;
    }

    public static int getGuionesSubidosDriveN() {
        return guionesSubidosDriveN;
    }

    public static void setGuionesSubidosDriveN(int guionesNecesarios) {
        DesarrolladorNarrativa.guionesSubidosDriveN -= guionesSubidosDriveN;
    }
    
}
