/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.util.concurrent.Semaphore;
import interfaces.Bethesda;
/**
 *
 * @author Sebastian Rodriguez
 */
public class DesarrolladorNarrativa extends Thread {
    
    public static int guionesSubidosDrive = 0;
    int sueldoPorHora;
    Semaphore driveGuion;
    boolean activo; // No creo que haga falta????
    int diasParaGenerar;
    int totalPay;
    
    public DesarrolladorNarrativa(Semaphore driveGuion, int totalPay, boolean activo, int diasParaGenerar) {

        this.sueldoPorHora = 10;
        this.driveGuion = driveGuion;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;

    }

    public void payDayDesarrolladorNarrativa() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        BethesdaStudio.totalPay += salario;
        
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
        if (driveGuion.availablePermits() > 0) {
            driveGuion.acquire(1);
            System.out.println("Guion agregado al Drive por Desarrollador ");
            guionesSubidosDrive++; // Incrementa el contador  
            Bethesda.actualizarGuionesEnDrive(guionesSubidosDrive);
            System.out.println("Pago total:" + BethesdaStudio.totalPay);
            System.out.println("Guiones subidos al Drive "+ guionesSubidosDrive);
        } 
        else {
            System.out.println("Drive lleno. Esperando a que se libere espacio.");
//            driveGuion.release(1);
//            System.out.println("Se libero un guion del drive SUUUUU");  //LIBERAR ESPACIO DEL DRIVE PRUEBA
        }
    }

   
}
