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
        int capacidadDrive = 25;
        Semaphore drive = new Semaphore(capacidadDrive);

        // Pasamos los parametros necesarios para el desarrollador de narrativa.
        DesarrolladorNarrativa empleado = new DesarrolladorNarrativa(0, 0, capacidadDrive, 0, 10, drive, 0, true);
        empleado.start();
        // FUNCIONAAA SUUU
//        }
    }
}
