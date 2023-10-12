/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Bethesda;
import interfaces.Nintendo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class Funciones extends Thread {

    boolean activo;

    public Funciones() {
        this.activo = true;

    }

    @Override
    public void run() {
        while (activo) 
        try {
            Thread.sleep(1005);
            Bethesda.costosOperativosB.setText(Integer.toString(BethesdaStudio.totalPayB));
            Nintendo.costosOperativosN.setText(Integer.toString(NintendoStudio.totalPayN));
            Bethesda.ganancia.setText(Integer.toString(Director.ingresoB-BethesdaStudio.totalPayB+Math.abs(Director.descontadoPmB)));
            Nintendo.ganancia.setText(Integer.toString(Director.ingresoN-NintendoStudio.totalPayN+Math.abs(Director.descontadoPmN)));
            Bethesda.ingresosBrutos.setText(Integer.toString(Director.ingresoB));
            Nintendo.ingresosBrutos.setText(Integer.toString(Director.ingresoN));
        } catch (InterruptedException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
