///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package classes;
//
///**
// *
// * @author juand
// */
//public class Main {
//    public static void main(String[] args){
//        //se inicializan los estudios
//    }
//            
//}

import classes.DesarrolladorNarrativa;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore driveGuiones = new Semaphore(11);

        // Pasamos los parametros necesarios para el desarrollador de narrativa.
        DesarrolladorNarrativa empleado = new DesarrolladorNarrativa(0, 0, /**capacidadDrive,*/ 0, 10, driveGuiones, 0, true);
        empleado.start();
        
        DesarrolladorNarrativa empleado2 = new DesarrolladorNarrativa(0, 0, /**capacidadDrive,*/ 0, 10, driveGuiones, 0, true);
        empleado2.start();
        // FUNCIONAAA SUUU
//        }
    }
}
