package classes;

import interfaces.Bethesda;
import interfaces.Nintendo;

public class ProjectManager extends Thread {

    int diasRestantesEntregaJuegos;
    int totalPay;
    boolean isWatchingStreams;
    int sueldoPorHora;
    String studio;

    // Tiempos basados en que 1 dia de trabajo (24 horas) son 1000 milisegundos.
    int currentTime = 0;
    int streamInterval = 21; // 30 minutos en milisegundos
    int workInterval = 21;   // 30 minutos en milisegundos
    int totalWorkTime = 666; // 16 horas en milisegundos 
    int totalDayTime = 1000;  // 24 horas en milisegundos

    // Estados PM
    String estadoWork = "Trabajando";
    String estadoStreams = "Viendo streams";

    public ProjectManager(int diasRestantes, String studio) {
        this.diasRestantesEntregaJuegos = diasRestantes;
        this.totalPay = 0;
        this.isWatchingStreams = false;
        this.sueldoPorHora = 20;
        this.studio = studio;
    }

    @Override
    public void run() {

        while (true) {
            try {
                while (currentTime < totalWorkTime) {
                    trabaja();
                    Thread.sleep(100);
                    veStreams();
                    currentTime += (workInterval + streamInterval);
                }

                changeDaysRemaining();
                payDayPM();

                // Simula el paso del tiempo restante 
                int tiempoRestanteDia = totalDayTime - totalWorkTime;
                Thread.sleep(tiempoRestanteDia); // 1 segundo

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void trabaja() {
        if ("B".equals(studio)) {
            try {
                isWatchingStreams = false;
                Bethesda.actualizarEstadoPMB(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingStreams = false;
                Nintendo.actualizarEstadoPM(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void veStreams() {
        if ("B".equals(studio)) {
            try {
                isWatchingStreams = true;
                Bethesda.actualizarEstadoPMB(estadoStreams);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingStreams = true;
                Nintendo.actualizarEstadoPM(estadoStreams);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeDaysRemaining() {
        try {

            // Cambia el contador de días restantes
            diasRestantesEntregaJuegos--;

            // Simula el tiempo que lleva cambiar el contador
            Thread.sleep(100); // Tiempo despreciable
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void payDayPM() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("B".equals(studio)) {
            BethesdaStudio.totalPayB += salario;
        } else {
            // Pago de nintendo
            NintendoStudio.totalPayN += salario;
        }
    }
}
