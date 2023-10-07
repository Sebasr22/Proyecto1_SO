/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author juand
 */
public class BethesdaStudio {
    
    final private boolean active = true;
    private int videojuegosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);
//    private final Semaphore synchPmAndDirector = new Semaphore(1);
    private final double[] utilityOverTime = new double [200];


    int totalDayCounter = 0;



    public BethesdaStudio(int dayDuration, int daysUntilLaunch){
        

        this.dayDuration = dayDuration;

    }
    
}
