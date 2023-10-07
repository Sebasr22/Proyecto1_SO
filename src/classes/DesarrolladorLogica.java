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
public class DesarrolladorLogica extends Thread {

    public static int sistemasSubidosDriveN = 0;
    public static int spritesSubidosDriveB = 0;

    int sueldoPorHora; // 8
    int totalPay;
    int diasParaGenerar;
    boolean activo;

    Semaphore driveSistemasB;
    Semaphore driveSistemasN;
    
    String estudio;

    public DesarrolladorLogica(Semaphore driveSistemas, int diasParaGenerar, int totalPay, String estudio) {

        this.sueldoPorHora = 8;
        this.totalPay = totalPay;
        this.diasParaGenerar = diasParaGenerar;
        this.driveSistemasB = driveSistemas;
        this.driveSistemasN = driveSistemas;
        this.estudio = estudio;
        this.activo = activo;

    }

    public void payDayDesarrolladorLogica() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (estudio == "B") {
            BethesdaStudio.totalPay += salario;
        } else {
            // La clase de nintendo
        }
    }

    public void generarSistema() throws InterruptedException {
        if (estudio == "B") {
            if (driveSistemasB.availablePermits() > 0) {
                driveSistemasB.acquire(5);// Puse directo 5 ya que el ultimo dijito del carnet de Juan y mio coincide con el numero de sistemas que se generan.
                System.out.println("Se agregaron 5 Sistemas al drive");
                spritesSubidosDriveB++;
                // Aqui seria actualizar los sistemas en bethesda como esta en Desarrollador Sprites.
            } else {
                System.out.println("Drive lleno");
            }
        } else {
            if (driveSistemasN.availablePermits() > 0) {
                driveSistemasN.acquire(5);
                System.out.println("Se agregaron 5 sistemas al drive");
                sistemasSubidosDriveN++;
                // Aqui seria atualizar los sistemas en nintendo.
            }
        }
    }
    
    @Override
    public void run() {
        while (activo) {
            try {
                int count = 0;
                
                while (count < diasParaGenerar) {
                    Thread.sleep(1000);
                    payDayDesarrolladorLogica();
                    count++;
                }
                generarSistema();
            } catch (InterruptedException ex) {
                System.out.println("Metodo run dev Logica Catch");
            }
        }
    }

}
