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
public class DesarrolladorSprites extends Thread {

    public static int spritesSubidosDriveN = 0;
    public static int spritesSubidosDriveB = 0;

    int sueldoPorHora; // 20
    int totalPay;
    int diasParaGenerar;
    boolean activo;

    Semaphore driveSprites;

    String studio;

    public DesarrolladorSprites(Semaphore driveSprites, int diasParaGenerar, int totalPay, String studio, boolean activo) {

        this.sueldoPorHora = 20;
        this.totalPay = totalPay;
        this.diasParaGenerar = diasParaGenerar;
        this.driveSprites = driveSprites;
        this.studio = studio;
        this.activo = activo;

    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void payDayDesarrolladorSprites() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (studio == "B") {
            BethesdaStudio.totalPay += salario;
        } else {
            // La clase de nintendo
        }
    }

    public void generarSprite() throws InterruptedException {

        if (studio == "B") {
            if (driveSprites.availablePermits() > 0) {
                driveSprites.acquire(2);
                System.out.println("Se agrego un Sprite al drive");
                spritesSubidosDriveB += 2;
                Bethesda.actualizarSpritesEnDrive(spritesSubidosDriveB);
            } else {
                System.out.println("Drive lleno");
            }
        } else {
            if (driveSprites.availablePermits() > 0) {
                driveSprites.acquire(1);
                System.out.println("Se agrego un Sprite al drive");
                spritesSubidosDriveN++;
                // El actualizar guiones drive 
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {

                Thread.sleep(1000);
                payDayDesarrolladorSprites();
                generarSprite();
                
            } catch (InterruptedException ex) {
                System.out.println("Metodo Run Desarrollador Sprites Catch");
            }
        }
    }

}
