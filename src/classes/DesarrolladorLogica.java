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
        if (studio == "B") {
            //BETHESDA
            if (driveSistemas.availablePermits() > 0) {
                driveSistemas.acquire(5);// Puse directo 5 ya que el ultimo dijito del carnet de Juan y mio coincide con el numero de sistemas que se generan.
//                System.out.println("Se agregaron 5 Sistemas al drive");
                sistemasSubidosDriveB += 5;
                Bethesda.actualizarSistemasEnDrive(sistemasSubidosDriveB);
            } else {
                System.out.println("Drive lleno");
            }
        } else {
            //NINTENDO
            if (driveSistemas.availablePermits() > 0) {
                driveSistemas.acquire(5);
//                System.out.println("Se agregaron 5 sistemas al drive");
                sistemasSubidosDriveN += 5;
                Nintendo.actualizarSistemasEnDrive(sistemasSubidosDriveN);
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {
//                int count = 0;

//                while (count < diasParaGenerar) {
                Thread.sleep(1000);
                payDayDesarrolladorLogica();
//                    count++;
//                }
                generarSistema();
            } catch (InterruptedException ex) {
                System.out.println("Metodo run dev Logica Catch");
            }
        }
    }

}
