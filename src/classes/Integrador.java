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
 * @author Sebastian Rodriguez
 */
public class Integrador extends Thread {

    public static int countJuegosGeneradosB = 0;
    public static int countJuegosGeneradosN = 0;

    public static int countJuegosDLCGeneradosB = 0;
    public static int countJuegosDLCGeneradosN = 0;

    // Estudios para el cual trabaja
    String studio;

    // Drive del desarrollador de Narrativa
    Semaphore driveN;
    Semaphore driveNivel;
    Semaphore driveDLC;
    Semaphore driveLogic;
    Semaphore driveSprites;

    // Parametros propios del Integrador
    int sueldoPorHora;
    int totalPay;
    int diasParaGenerar;
    boolean activo;
    Semaphore driveJuegos;
    int juegosGenerados;
    int juegosDLCGenerados;
    int countJuegos;

    // Parametros para videojuego estandar
    int guionesNecesarios;
    int nivelesNecesarios;
    int spritesNecesarios;
    int sistemasNecesarios;
    int DLCNecesarios;
    int gananciaPorJuego;

    // Parametros para videojuego con DLC
    //LOS DLC es un semaforo, ya que cuando se crean 5 juegos se agarran 2 DLC del drive donde se almacenan.
    public Integrador(Semaphore driveJuegos, Semaphore driveN, Semaphore driveNivel, Semaphore driveDLC, Semaphore driveLogic, Semaphore driveSprites, int juegosGenerados, int juegosDLCGenerados, int diasParaGenerar, int guionesNecesarios, int nivelesNecesarios, int spritesNecesarios, int sistemasNecesarios, int DLCNecesarios, String studio, boolean activo) {

        this.studio = studio;

        this.driveN = driveN;
        this.driveNivel = driveNivel;
        this.driveDLC = driveDLC;
        this.driveLogic = driveLogic;
        this.driveSprites = driveSprites;

        this.sueldoPorHora = 25;
        this.totalPay = 0;
        this.diasParaGenerar = diasParaGenerar;
        this.driveJuegos = driveJuegos;
        this.juegosGenerados = juegosGenerados;
        this.juegosDLCGenerados = juegosDLCGenerados;
        this.countJuegos = 0;

        this.guionesNecesarios = guionesNecesarios;
        this.nivelesNecesarios = nivelesNecesarios;
        this.spritesNecesarios = spritesNecesarios;
        this.sistemasNecesarios = sistemasNecesarios;
        this.DLCNecesarios = DLCNecesarios;

    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void payDayEnsamblador() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (studio == "B") {
            BethesdaStudio.totalPayB += salario;
        } else {
            NintendoStudio.totalPayN += salario;
        }
    }

    public void generarVideoJuego() {
        if ("B".equals(studio)) {
            if (countJuegos == 7) {
                if (DesarrolladorNarrativa.getGuionesSubidosDriveB() >= guionesNecesarios && DesarrolladorNiveles.getNivelesSubidosDriveB() >= nivelesNecesarios && DesarrolladorDLC.getDlcsSubidosDriveB() >= DLCNecesarios && DesarrolladorLogica.getSistemasSubidosDriveB() >= sistemasNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveN.release(guionesNecesarios);
                        DesarrolladorNarrativa.setGuionesSubidosDriveB(guionesNecesarios);

                        // Niveles
                        driveNivel.release(nivelesNecesarios);
                        DesarrolladorNiveles.setNivelesSubidosDriveB(nivelesNecesarios);

                        // DLC
                        driveDLC.release(DLCNecesarios);
                        DesarrolladorDLC.setDlcsSubidosDriveB(DLCNecesarios);

                        // Sistemas
                        driveLogic.release(sistemasNecesarios);
                        DesarrolladorLogica.setSistemasSubidosDriveB(sistemasNecesarios);

                        // Sprites
                        driveSprites.release(spritesNecesarios);
                        DesarrolladorSprites.setSpritesSubidosDriveB(spritesNecesarios);

                        countJuegosDLCGeneradosB++;
                        Bethesda.actualizarJuegosDLCGenerados(countJuegosDLCGeneradosB);
                        countJuegos = 0; // Se reinicia el contador de juegos para poder contar otra vez la cantidad de juegos necesarios para desarrollar uno con DLC.
                        System.out.println("SE GENERO UN JUEGOIOOOOOOOOOOOOO");
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            } else {
                if (DesarrolladorNarrativa.getGuionesSubidosDriveB() >= guionesNecesarios && DesarrolladorNiveles.getNivelesSubidosDriveB() >= nivelesNecesarios && DesarrolladorLogica.getSistemasSubidosDriveB() >= sistemasNecesarios && DesarrolladorSprites.getSpritesSubidosDriveB() >= spritesNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveN.release(guionesNecesarios);
                        DesarrolladorNarrativa.setGuionesSubidosDriveB(guionesNecesarios);

                        // Niveles
                        driveNivel.release(nivelesNecesarios);
                        DesarrolladorNiveles.setNivelesSubidosDriveB(nivelesNecesarios);

                        // Sistemas
                        driveLogic.release(sistemasNecesarios);
                        DesarrolladorLogica.setSistemasSubidosDriveB(sistemasNecesarios);

                        // Sprites
                        driveSprites.release(spritesNecesarios);
                        DesarrolladorSprites.setSpritesSubidosDriveB(spritesNecesarios);

                        countJuegosGeneradosB++;
                        Bethesda.actualizarJuegosGenerados(countJuegosGeneradosB);
                        countJuegos++;
                        System.out.println("SE GENERO UN JUEGOIOOOOOOOOOOOOO");
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            }
        } else {
            // NINTENDO
            if (countJuegos == 5) {
                if (DesarrolladorNarrativa.getGuionesSubidosDriveN() >= guionesNecesarios && DesarrolladorNiveles.getNivelesSubidosDriveN() >= nivelesNecesarios && DesarrolladorDLC.getDlcsSubidosDriveN() >= DLCNecesarios && DesarrolladorLogica.getSistemasSubidosDriveN() >= sistemasNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveN.release(guionesNecesarios);
                        DesarrolladorNarrativa.setGuionesSubidosDriveN(guionesNecesarios);

                        // Niveles
                        driveNivel.release(nivelesNecesarios);
                        DesarrolladorNiveles.setNivelesSubidosDriveN(nivelesNecesarios);

                        // DLC
                        driveDLC.release(DLCNecesarios);
                        DesarrolladorDLC.setDlcsSubidosDriveN(DLCNecesarios);

                        // Sistemas
                        driveLogic.release(sistemasNecesarios);
                        DesarrolladorLogica.setSistemasSubidosDriveN(sistemasNecesarios);

                        // Sprites
                        driveSprites.release(spritesNecesarios);
                        DesarrolladorSprites.setSpritesSubidosDriveN(spritesNecesarios);

                        countJuegosDLCGeneradosN++;
                        Nintendo.actualizarJuegosDLCGenerados(countJuegosDLCGeneradosN);
                        countJuegos = 0; // Se reinicia el contador de juegos para poder contar otra vez la cantidad de juegos necesarios para desarrollar uno con DLC.
                        System.out.println("SE GENERO UN JUEGOOOOOOOOOOOOOO");
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            } else {
                if (DesarrolladorNarrativa.getGuionesSubidosDriveN() >= guionesNecesarios && DesarrolladorNiveles.getNivelesSubidosDriveN() >= nivelesNecesarios && DesarrolladorLogica.getSistemasSubidosDriveN() >= sistemasNecesarios && DesarrolladorSprites.getSpritesSubidosDriveN() >= spritesNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveN.release(guionesNecesarios);
                        DesarrolladorNarrativa.setGuionesSubidosDriveN(guionesNecesarios);

                        // Niveles
                        driveNivel.release(nivelesNecesarios);
                        DesarrolladorNiveles.setNivelesSubidosDriveN(nivelesNecesarios);

                        // Sistemas
                        driveLogic.release(sistemasNecesarios);
                        DesarrolladorLogica.setSistemasSubidosDriveN(sistemasNecesarios);

                        // Sprites
                        driveSprites.release(spritesNecesarios);
                        DesarrolladorSprites.setSpritesSubidosDriveN(spritesNecesarios);

                        countJuegosGeneradosN++;
                        Nintendo.actualizarJuegosGenerados(countJuegosGeneradosN);
                        countJuegos++;
                        System.out.println("SE GENERO UN JUEGOOOOOOOOOOOOOO");
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                payDayEnsamblador();
                generarVideoJuego();
            } catch (InterruptedException ex) {
                System.out.println("TESTTTT Ensamblador catch");
            }
        }
    }

}
