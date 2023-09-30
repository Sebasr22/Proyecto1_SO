/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classesNintendo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sebastian Rodriguez
 */
public class DesarrolladorNarrativa extends Empleado{
    
    public DesarrolladorNarrativa(String nombre, double costoPorHora, int numeroCarnet, Semaphore driveSemaphore) {
        super(nombre, costoPorHora, numeroCarnet, driveSemaphore);
    }
    
}
