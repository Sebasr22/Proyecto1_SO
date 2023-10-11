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

    public static int getSpritesSubidosDriveN() {
        return spritesSubidosDriveN;
    }

    public static void setSpritesSubidosDriveN(int spritesSubidosDriveN) {
        DesarrolladorSprites.spritesSubidosDriveN -= spritesSubidosDriveN;
    }

    public static int getSpritesSubidosDriveB() {
        return spritesSubidosDriveB;
    }

    public static void setSpritesSubidosDriveB(int spritesSubidosDriveB) {
        DesarrolladorSprites.spritesSubidosDriveB -= spritesSubidosDriveB;
    }
    
    public void payDayDesarrolladorSprites() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (studio == "B") {
            BethesdaStudio.totalPayB += salario;
        } else {
            // Pago de nintendo
            NintendoStudio.totalPayN += salario;
        }
    }

    public void generarSprite() throws InterruptedException {

        if (studio == "B") {
            //BETHESDA
            if (driveSprites.availablePermits() > 1) {
                driveSprites.acquire(2);
//                System.out.println("Se agrego un Sprite al drive");
                spritesSubidosDriveB += 2;
                Bethesda.actualizarSpritesEnDrive(spritesSubidosDriveB);
            } else if (driveSprites.availablePermits() == 1) {
                driveSprites.acquire(1);
//                System.out.println("Se agrego un Sprite al drive");
                spritesSubidosDriveB += 1;
                Bethesda.actualizarSpritesEnDrive(spritesSubidosDriveB);
            } else {
                System.out.println("Drive lleno");
            }
        } else {
            //NINTENDO
            if (driveSprites.availablePermits() > 1) {
                driveSprites.acquire(2);
//                System.out.println("Se agrego un Sprite al drive");
                spritesSubidosDriveN += 2;
                Nintendo.actualizarSpritesEnDrive(spritesSubidosDriveN);
            } else if (driveSprites.availablePermits() == 1) {
                driveSprites.acquire(1);
//                System.out.println("Se agrego un Sprite al drive");
                spritesSubidosDriveN += 1;
                Nintendo.actualizarSpritesEnDrive(spritesSubidosDriveN);
            } else {
                System.out.println("Drive lleno");
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
