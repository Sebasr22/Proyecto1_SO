/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sebastian Rodriguez
 */
public class Integrador extends Thread {

    // Drive del desarrollador de Narrativa
    Semaphore driveN;

    // Parametros propios del Integrador
    int sueldoPorHora;
    int totalPay;
    int diasParaEnsamblar;

    // Parametros para videojuego estandar
    int guionesNecesarios;
    int nivelesNecesarios;
    int spritesNecesarios;
    int sistemasJuegos;
    int gananciaPorJuego;

    // Parametros para videojuego con DLC
    //LOS DLC es un semaforo, ya que cuando se crean 5 juegos se agarran 2 DLC del drive donde se almacenan.
    public Integrador(Semaphore driveN, int diasParaEnsamblar, int guionesNecesarios, int nivelesNecesarios, int spritesNecesarios, int sistemasJuegos) {

        this.driveN = driveN;

        this.sueldoPorHora = 25;
        this.totalPay = 0;
        this.diasParaEnsamblar = diasParaEnsamblar;

        this.guionesNecesarios = guionesNecesarios;
        this.nivelesNecesarios = nivelesNecesarios;
        this.spritesNecesarios = spritesNecesarios;
        this.sistemasJuegos = sistemasJuegos;

    }

    public void payDayEnsamblador() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        totalPay += salario;
    }

    public void generarVideoJuego() {
        if (driveN.availablePermits() >= guionesNecesarios) { // Se pueden agregar a la condicion del if, todo lo necesario para generar el juego con los relases de todos los drives.
            driveN.release(guionesNecesarios);
        } else {
            System.out.println("No hay recursos suficientes para generar el juego");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                int count = 0;

                while (count < diasParaEnsamblar) {
                    Thread.sleep(1000);
                    payDayEnsamblador();
                    count++;
                }
                generarVideoJuego();
            } catch (InterruptedException ex) {
                System.out.println("TESTTTT Ensamblador catch");
            }
        }
    }

}
