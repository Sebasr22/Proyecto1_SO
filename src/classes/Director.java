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
    int faltasCounterB;
    int faltasCounterN;
    static int descontadoPmB;
    static int descontadoPmN;

    public Director(String studio) {
        this.studio = studio;
        this.daysRemaining = daysRemaining;
        this.totalIncome = 0;
        this.sueldoPorHora = 30;
        this.estado = "Labores administrativas";
        this.ingresoB = 0;
        this.ingresoN = 0;
        this.faltasCounterB = 0;
        this.faltasCounterN = 0;
        this.descontadoPmB = 0;
        this.descontadoPmN = 0;
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
            System.out.println("SE ENTREGARON JUEGOS BETHESDA");
            ingresoB += Integrador.countJuegosGeneradosB * 450000;
            ingresoB += Integrador.countJuegosDLCGeneradosB * 900000;
            Integrador.countJuegosGeneradosB = 0;
            Bethesda.actualizarJuegosGenerados(Integrador.countJuegosGeneradosB);
            Integrador.countJuegosDLCGeneradosB = 0;
            Bethesda.actualizarJuegosDLCGenerados(Integrador.countJuegosDLCGeneradosB);
            BethesdaStudio.diasRestantesB = 6;  //Resetea Dias Restantes 
            Bethesda.estadoDirector.setText("Labores administrativas");
        } else {
            ingresoN += Integrador.countJuegosGeneradosN * 550000;
            ingresoN += Integrador.countJuegosDLCGeneradosN * 600000;
            Integrador.countJuegosGeneradosN = 0;
            Nintendo.actualizarJuegosGenerados(Integrador.countJuegosGeneradosN);
            Integrador.countJuegosDLCGeneradosN = 0;
            Nintendo.actualizarJuegosDLCGenerados(Integrador.countJuegosDLCGeneradosN);
            NintendoStudio.diasRestantesN = 6;  //Resetea Dias Restantes
            Nintendo.estadoDirector.setText("Labores administrativas");
        }

    }

    @Override
    public void run() {
        while (true) {

            try {
                if ("B".equals(studio)) {
                    if (BethesdaStudio.diasRestantesB == 0) {

                        Bethesda.actualizarEstadoDirector("Entregando Juegos");
                        Thread.sleep(1000);  //PASA UN DIA
                        payDayDirector();
                        entregarJuegos();
                    } else {

                        trabajoAdministrativo();
                    }
                } else {
                    if (NintendoStudio.diasRestantesN == 0) {

                        Nintendo.actualizarEstadoDirector("Entregando Juegos");
                        Thread.sleep(1000);  //PASA UN DIA
                        payDayDirector();
                        entregarJuegos();
                    } else {

                        trabajoAdministrativo();
                    }
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

            Bethesda.actualizarEstadoDirector("Vigilando P.M.");
        } else {
            Nintendo.estadoDirector.setText("Vigilando P.M.");
        }
        if (ProjectManager.isWatchingStreams == true) {

            if ("B".equals(studio)) {
                faltasCounterB++;
                descontadoPmB -= 50;
                Bethesda.faltasPM.setText(Integer.toString(faltasCounterB));
                Bethesda.descontadoPM.setText(Integer.toString(descontadoPmB));
                Bethesda.actualizarEstadoDirector("Labores administrativas");
            } else {
                faltasCounterN++;
                descontadoPmN -= 50;
                Nintendo.faltasPM.setText(Integer.toString(faltasCounterN));
                Nintendo.descontadoPM.setText(Integer.toString(descontadoPmN));
                Nintendo.estadoDirector.setText("Labores administrativas");

            }

        }
    }

}
