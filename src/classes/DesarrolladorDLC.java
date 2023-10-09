/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Bethesda;
import interfaces.Nintendo;
import java.util.concurrent.Semaphore;

public class DesarrolladorDLC extends Thread {

    public static int dlcsSubidosDriveB = 0;
    public static int dlcsSubidosDriveN = 0;
    int sueldoPorHora;
    Semaphore driveDLC;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String studio;

    public DesarrolladorDLC(Semaphore driveDLC, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        this.sueldoPorHora = 17;
        this.driveDLC = driveDLC;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.studio = studio;
    }

    public void payDayDesarrolladorDLC() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("B".equals(studio)) {
            BethesdaStudio.totalPayB += salario;
        } else {
            // Pago a Nintendo 
            NintendoStudio.totalPayN += salario;
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {
                int count = 0;

                while (count < diasParaGenerar) {
                    Thread.sleep(1000);
                    payDayDesarrolladorDLC();
                    count++;
                }
                generarDLC();
            } catch (InterruptedException ex) {
                System.out.println("Error en el hilo de DesarrolladorDLC");
            }
        }
    }

    private void generarDLC() throws InterruptedException {
        // Intento agregar el DLC al drive
        if ("B".equals(studio)) {
            if (driveDLC.availablePermits() > 0) {
                driveDLC.acquire(1);
                dlcsSubidosDriveB++;
                Bethesda.actualizarDLCsEnDrive(dlcsSubidosDriveB);
            } else {
                System.out.println("Drive DLC lleno. Esperando a que se libere espacio.");
            }
        } else {
            // Generar Nintendo
            if (driveDLC.availablePermits() > 0) {
                driveDLC.acquire(1);
                dlcsSubidosDriveN++;
                Nintendo.actualizarDLCsEnDrive(dlcsSubidosDriveN);
            } else {
                System.out.println("Drive DLC lleno. Esperando a que se libere espacio.");
            }
        }
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
