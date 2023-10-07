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

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Director extends Thread {
    private int daysRemaining;
    private float totalIncome;
    private Semaphore semaphore;

    public Director(int initialDaysRemaining, Semaphore semaphore) {
        this.daysRemaining = initialDaysRemaining;
        this.totalIncome = 0;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (daysRemaining == 0) {
                    //envia a las tiendas
                } else {
                  //sigue trabajando y chequea al Project Manager
                }

                // Simula el paso del tiempo
                Thread.sleep(1000); // 1 segundo

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

