/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author juand
 */
import java.util.concurrent.Semaphore;

public class ProjectManager extends Thread {
    private int daysToDeliverGames;
    private float totalEarnings;
    private boolean isWatchingStreams;
    private Semaphore semaphore;

    public ProjectManager(int initialDaysToDeliverGames, Semaphore semaphore) {
        this.daysToDeliverGames = initialDaysToDeliverGames;
        this.totalEarnings = 0;
        this.isWatchingStreams = false;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int currentTime = 0;
        int streamInterval = 30 * 60 * 1000; // 30 minutos en milisegundos
        int workInterval = 30 * 60 * 1000;   // 30 minutos en milisegundos
        int totalWorkTime = 16 * 60 * 60 * 1000; // 16 horas en milisegundos
        int totalDayTime = 24 * 60 * 60 * 1000;  // 24 horas en milisegundos

        while (true) {
            try {
                if (currentTime < totalWorkTime) {
                    if (currentTime % totalDayTime < totalWorkTime) {
                        // El PM trabaja revisando el avance del proyecto
                        work();
                    } else {
                        // El PM cambia el contador con los días restantes
                        changeDaysRemaining();
                    }
                } else {
                    // El PM ve streams durante las últimas 8 horas del día
                    watchStreams();
                }

                // Simula el paso del tiempo
                Thread.sleep(1000); // 1 segundo
                currentTime += 1000;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void work() {
        try {
            isWatchingStreams = false;
            // Realiza tareas de revisión del avance del proyecto
            Thread.sleep(30 * 60 * 1000); // 30 minutos en milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void watchStreams() {
        try {
            isWatchingStreams = true;
            // Ve streams de E-sports durante 30 minutos
            Thread.sleep(30 * 60 * 1000); // 30 minutos en milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void changeDaysRemaining() {
        try {
            semaphore.acquire(); // Adquiere el semáforo para asegurar la exclusión mutua

            // Cambia el contador de días restantes
            daysToDeliverGames--;

            semaphore.release(); // Libera el semáforo

            // Simula el tiempo que lleva cambiar el contador
            Thread.sleep(100); // Tiempo despreciable
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getDaysToDeliverGames() {
        return daysToDeliverGames;
    }

    public void addEarnings(float earnings) {
        totalEarnings += earnings;
    }

    public boolean isWatchingStreams() {
        return isWatchingStreams;
    }

    public float getTotalEarnings() {
        return totalEarnings;
    }
}
