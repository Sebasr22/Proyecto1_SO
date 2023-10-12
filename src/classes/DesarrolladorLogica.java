/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Bethesda;
import interfaces.Nintendo;
import java.util.concurrent.Semaphore;

/**
 *
 * @author juand
 */
public class DesarrolladorLogica extends Thread {

    public static int sistemasSubidosDriveN = 0;
    public static int sistemasSubidosDriveB = 0;

    int sueldoPorHora; // 8
    int totalPay;
    int diasParaGenerar;
    boolean activo;

    Semaphore driveSistemas;

    String studio;

    public DesarrolladorLogica(Semaphore driveSistemas, int diasParaGenerar, int totalPay, String studio, boolean activo) {

        this.sueldoPorHora = 8;
        this.totalPay = totalPay;
        this.diasParaGenerar = diasParaGenerar;
        this.driveSistemas = driveSistemas;
        this.studio = studio;
        this.activo = activo;

    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static int getSistemasSubidosDriveN() {
        return sistemasSubidosDriveN;
    }

    public static void setSistemasSubidosDriveN(int sistemasSubidosDriveN) {
        DesarrolladorLogica.sistemasSubidosDriveN -= sistemasSubidosDriveN;
    }

    public static int getSistemasSubidosDriveB() {
        return sistemasSubidosDriveB;
    }

    public static void setSistemasSubidosDriveB(int sistemasSubidosDriveB) {
        DesarrolladorLogica.sistemasSubidosDriveB -= sistemasSubidosDriveB;
    }

    public void payDayDesarrolladorLogica() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (studio == "B") {
            BethesdaStudio.totalPayB += salario;
        } else {
            // Pago de nintendo
            NintendoStudio.totalPayN += salario;
        }
    }

    public void generarSistema() throws InterruptedException {
        if ("B".equals(studio)) {
            //BETHESDA
            if (driveSistemas.availablePermits() >= 5) {
                driveSistemas.acquire(5);
                sistemasSubidosDriveB += 5;
                Bethesda.actualizarSistemasEnDrive(sistemasSubidosDriveB);

            } else if (driveSistemas.availablePermits() == 4) {
                driveSistemas.acquire(4);
                sistemasSubidosDriveB += 4;
                Bethesda.actualizarSpritesEnDrive(sistemasSubidosDriveB);
            } else if (driveSistemas.availablePermits() == 3) {
                driveSistemas.acquire(3);
                sistemasSubidosDriveB += 3;
                Bethesda.actualizarSpritesEnDrive(sistemasSubidosDriveB);
            } else if (driveSistemas.availablePermits() == 2) {
                driveSistemas.acquire(2);
                sistemasSubidosDriveB += 2;
                Bethesda.actualizarSpritesEnDrive(sistemasSubidosDriveB);
            } else if (driveSistemas.availablePermits() == 1) {
                driveSistemas.acquire(1);
                sistemasSubidosDriveB += 1;
                Bethesda.actualizarSpritesEnDrive(sistemasSubidosDriveB);
            } else {
                System.out.println("Drive lleno");
            }
        } else {
            //NINTENDO
            if (driveSistemas.availablePermits() >= 5) {
                driveSistemas.acquire(5);
                sistemasSubidosDriveN += 5;
                Nintendo.actualizarSistemasEnDrive(sistemasSubidosDriveN);
            } else if (driveSistemas.availablePermits() == 4) {
                driveSistemas.acquire(4);
                sistemasSubidosDriveN += 4;
                Nintendo.actualizarSpritesEnDrive(sistemasSubidosDriveN);
            } else if (driveSistemas.availablePermits() == 3) {
                driveSistemas.acquire(3);
                sistemasSubidosDriveN += 3;
                Nintendo.actualizarSpritesEnDrive(sistemasSubidosDriveN);
            } else if (driveSistemas.availablePermits() == 2) {
                driveSistemas.acquire(2);
                sistemasSubidosDriveN += 2;
                Nintendo.actualizarSpritesEnDrive(sistemasSubidosDriveN);
            } else if (driveSistemas.availablePermits() == 1) {
                driveSistemas.acquire(1);
                sistemasSubidosDriveN += 1;
                Nintendo.actualizarSpritesEnDrive(sistemasSubidosDriveN);
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1000);
                payDayDesarrolladorLogica();
                generarSistema();
            } catch (InterruptedException ex) {
                System.out.println("Metodo run dev Logica Catch");
            }
        }
    }

}
