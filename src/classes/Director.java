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
import interfaces.Bethesda;
import interfaces.Nintendo;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Director extends Thread {

    private int daysRemaining;
    private float totalIncome;
    int rand1;
    int rand2;
    String studio;
    int sueldoPorHora;
    static int ingresoB;
    static int ingresoN;
    String estado;
    int faltasCounter;
    int descontadoPm;

    public Director(int daysRemaining, String studio) {
        this.daysRemaining = daysRemaining;
        this.totalIncome = 0;
        this.sueldoPorHora = 30;
        this.estado = "Labores administrativas";
        this.ingresoB = 0;
        this.ingresoN = 0;
        this.faltasCounter = 0;
        this.descontadoPm = 0;
    }

    public void payDayDirector() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("B".equals(studio)) {
            BethesdaStudio.totalPayB += salario;
        } else {
            // Pago de nintendo
            NintendoStudio.totalPayN += salario;
        }

    }

    public void entregarJuegos() {

        if ("B".equals(studio)) {
            ingresoB += Integrador.countJuegosGeneradosB * 450000;
            ingresoB += Integrador.countJuegosDLCGeneradosB * 900000;
            Integrador.countJuegosGeneradosB = 0;
            Integrador.countJuegosDLCGeneradosB = 0;
            BethesdaStudio.diasRestantesB = 6;  //Resetea Dias Restantes
            Bethesda.estadoDirector.setText("Labores administrativas");
        } else {
            ingresoN += Integrador.countJuegosGeneradosN * 550000;
            ingresoN += Integrador.countJuegosDLCGeneradosN * 600000;
            Integrador.countJuegosGeneradosN = 0;
            Integrador.countJuegosDLCGeneradosN = 0;
            NintendoStudio.diasRestantesN = 6;  //Resetea Dias Restantes
            Nintendo.estadoDirector.setText("Labores administrativas");
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                if (daysRemaining == 0) {
                    if ("B".equals(studio)) {
                        Bethesda.estadoDirector.setText("Entregando Juegos");
                    } else {
                        Nintendo.estadoDirector.setText("Entregando Juegos");
                    }
                    Thread.sleep(1000);  //PASA UN DIA
                    payDayDirector();
                    entregarJuegos();
                } else {
                    trabajoAdministrativo();
                }

            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }

    }

    public void trabajoAdministrativo() {
        try {
            int randomN = new Random().nextInt(1000);
            Thread.sleep(randomN);
            checkPM();
            Thread.sleep(1000 - randomN);
            payDayDirector();

        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkPM() {
        if ("B".equals(studio)) {
            Bethesda.estadoDirector.setText("Vigilando P.M.");
        } else {
            Nintendo.estadoDirector.setText("Vigilando P.M.");
        }
        estado = "Vigilando P.M.";
        if (ProjectManager.isWatchingStreams == true) {
            faltasCounter++;
            descontadoPm -= 50;
            if ("B".equals(studio)) {
                Bethesda.faltasPM.setText(Integer.toString(faltasCounter));
                Bethesda.descontadoPM.setText(Integer.toString(descontadoPm));
                Bethesda.estadoDirector.setText("Labores administrativas");
            } else {

                Nintendo.faltasPM.setText(Integer.toString(faltasCounter));
                Nintendo.descontadoPM.setText(Integer.toString(descontadoPm));
                Nintendo.estadoDirector.setText("Labores administrativas");

            }

        }
    }

}
