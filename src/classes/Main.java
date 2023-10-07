///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package classes;

/**
 *
 * @author Sebastian Rodriguez
 */
import classes.DesarrolladorNarrativa;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int capacidadDrive = 25;
        Semaphore driveN = new Semaphore(capacidadDrive);

        // Se crea una lista para mantener un seguimiento del numero de hilos de desarrolladores que hay activos
        List<DesarrolladorNarrativa> desarrolladoresNarrativaX = new ArrayList<>();

        int valorSpinner = 3;
        int cantidadActual = desarrolladoresNarrativaX.size();

        if (valorSpinner > cantidadActual) {
            // Se agregan nuevos hilos si se aumenta el valor del spinner
            for (int i = 0; i < valorSpinner - cantidadActual; i++) {
                String nombreHilo = "empleadoNarrativaX" + i;
                DesarrolladorNarrativa empleadoNarrativaX = new DesarrolladorNarrativa(driveN, 0, true, 4);
                // Se setea un nombre al hilo creado.
                empleadoNarrativaX.setName(nombreHilo);
                empleadoNarrativaX.start();
                // Se agrega a la lista de desarrolladoresNarrativaX el nuevo empleado.
                desarrolladoresNarrativaX.add(empleadoNarrativaX);
                System.out.println(desarrolladoresNarrativaX);
                System.out.println(desarrolladoresNarrativaX);
            }
        } else if (valorSpinner < cantidadActual) {
            for (int i = cantidadActual - 1; i >= valorSpinner; i--) {
                // aqui podemos buscar el ultimo hilo creado para eliminar, se debe estructurar bien
                // la logica del .get de la lista para saber cual queremos borrar. 
                DesarrolladorNarrativa empleadoNarrativaX = desarrolladoresNarrativaX.get(i);
                // Aqui se elimina el ultimo hilo que se creo, agregar esa logica. 
            }
        }
    }
}
