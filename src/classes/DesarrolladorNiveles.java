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
public class DesarrolladorNiveles extends Thread{
public static int guionesSubidosDrive = 0;
    int sueldoPorHora;
    Semaphore driveNivel;
    boolean activo; // No creo que haga falta????
    int diasParaGenerar;
    int totalPay;
    
    public DesarrolladorNiveles(Semaphore driveNivel, int totalPay, boolean activo, int diasParaGenerar) {

        this.sueldoPorHora = 10;
        this.driveNivel = driveNivel;
        this.totalPay = 0;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;

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
        if (driveNivel.availablePermits() > 0) {
            driveNivel.acquire(1);
            System.out.println("Nivel agregado al Drive por Desarrollador ");
            guionesSubidosDrive++; // Incrementa el contador  
            Bethesda.actualizarGuionesEnDrive(nivelesSubidosDrive);
            System.out.println("Niveles subidos al Drive "+ nivelesSubidosDrive);
        } 
        else {
            System.out.println("Drive lleno. Esperando a que se libere espacio.");
//            driveGuion.release(1);
//            System.out.println("Se libero un guion del drive SUUUUU");  //LIBERAR ESPACIO DEL DRIVE PRUEBA
        }
    }
    }

