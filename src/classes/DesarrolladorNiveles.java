/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Bethesda;
import java.util.concurrent.Semaphore;

/**
 *
 * @author juand
 */
public class DesarrolladorNiveles extends Thread {

    public static int nivelesSubidosDriveB = 0;
    public static int nivelesSubidosDriveN = 0;
    int sueldoPorHora;
    Semaphore driveNivel;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String studio;

    public DesarrolladorNiveles(Semaphore driveNivel, int totalPay, int diasParaGenerar, String studio, boolean activo) {

        this.sueldoPorHora = 13;
        this.driveNivel = driveNivel;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.studio = studio;

    }

    public void payDayDesarrolladorNiveles() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (studio == "B") {
            BethesdaStudio.totalPay += salario;
            
        } else {
            //sE LE PAGA A NINTENDO 
        }

    }

    @Override
    public void run() {
        while (activo) {
            try {
                int count = 0;

                while (count < diasParaGenerar) { // Para poder hacer los pagos por cada dia de trabajo que pasa.
                    Thread.sleep(1000);
                    payDayDesarrolladorNiveles();
                    count++;
                }
                generarNivel();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");
            }
        }
    }

    private void generarNivel() throws InterruptedException {
        // Intento agregar el nuvel al drive
        if ("B".equals(studio)) {
            if (driveNivel.availablePermits() > 0) {
                driveNivel.acquire(1);
                //System.out.println("Nivel agregado al Drive por Desarrollador ");

                nivelesSubidosDriveB++; // Incrementa el contador 
                Bethesda.actualizarNivelesEnDrive(nivelesSubidosDriveB);
                //System.out.println("Pago total:" + BethesdaStudio.totalPay);
                //System.out.println("Niveles subidos al Drive " + nivelesSubidosDriveB);
            } else {
                System.out.println("Drive NIVELES lleno. Esperando a que se libere espacio.");
//            driveGuion.release(1);
//            System.out.println("Se libero un guion del drive SUUUUU");  //LIBERAR ESPACIO DEL DRIVE PRUEBA
            }
        } else {
            // NINTENDO

        }

    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
