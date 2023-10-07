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

    Semaphore driveSpritesB;
    Semaphore driveSpritesN;

    String estudio;

    public DesarrolladorSprites(Semaphore driveSprites, int diasParaGenerar, int totalPay, String estudio) {

        this.sueldoPorHora = 20;
        this.totalPay = totalPay;
        this.diasParaGenerar = diasParaGenerar;
        this.driveSpritesB = driveSprites;
        this.driveSpritesN = driveSprites;
        this.estudio = estudio;
        this.activo = activo;

    }

    public void payDayDesarrolladorSprites() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (estudio == "B") {
            BethesdaStudio.totalPay += salario;
        } else {
            // La clase de nintendo
        }
    }

    public void generarSprite() throws InterruptedException {

        if (estudio == "B") {
            if (driveSpritesB.availablePermits() > 0) {
                driveSpritesB.acquire(1);
                System.out.println("Se agrego un Sprite al drive");
                spritesSubidosDriveB++;
//              Aqui seria lo de abajo pero en vez de guiones Sprites
//              Bethesda.actualizarGuionesEnDrive(spritesSubidosDriveB);
            } else {
                System.out.println("Drive lleno");
            }
        } else {
            if (driveSpritesN.availablePermits() > 0) {
                driveSpritesN.acquire(1);
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
                int count = 0;

                while (count < diasParaGenerar) {
                    Thread.sleep(1000);
                    payDayDesarrolladorSprites();
                    count++;
                }
                generarSprite();
            } catch (InterruptedException ex) {
                System.out.println("Metodo Run Desarrollador Sprites Catch");
            }
        }
    }

}
