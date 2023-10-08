package classes;

import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BethesdaStudio {

    public static int totalPay = 0;
    static int capacidadDriveNB = 25;
    static int capacidadDriveNivelB = 20;
    public static Semaphore driveNB = new Semaphore(capacidadDriveNB);
    public static Semaphore driveNivelB = new Semaphore(capacidadDriveNivelB);
    final private boolean active = true;
    private int videojuegosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);
    private final double[] utilityOverTime = new double[200];

    int totalDayCounter = 0;

    private static int desarrolladorNarrativaCount = 0;

    private static int desarrolladorNivelesCount = 0;

    public BethesdaStudio(int dayDuration, int daysUntilLaunch) {
        this.dayDuration = dayDuration;
    }
    private static DesarrolladorNarrativa[] desarrolladoresNarrativa = new DesarrolladorNarrativa[15];    //CREACION ARREGLOS
    private static DesarrolladorNiveles[] desarrolladoresNivel = new DesarrolladorNiveles[15];

    public static void crearDesarrolladorNarrativa(Semaphore driveN, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        DesarrolladorNarrativa desarrolladorNarrativa = new DesarrolladorNarrativa(driveN, totalPay, diasParaGenerar, studio, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 11; i++) {
            if (desarrolladoresNarrativa[i] == null) {
                desarrolladoresNarrativa[i] = desarrolladorNarrativa;
                desarrolladorNarrativaCount++; // Incrementar el contador
                desarrolladorNarrativa.start(); // Iniciar el hilo del desarrollador de narrativa
                break;
            }
        }
    }

    public static void stopDesarrolladorNarrativaAleatorio() {
        if (desarrolladorNarrativaCount == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (desarrolladoresNarrativa[indiceAleatorio] == null);

        DesarrolladorNarrativa hilo = desarrolladoresNarrativa[indiceAleatorio];

        if (hilo != null) {
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
        }
    }

    //NIVELES
    public static void crearDesarrolladorNivel(Semaphore driveNivelB, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        DesarrolladorNiveles desarrolladorNiveles = new DesarrolladorNiveles(driveNivelB, totalPay, diasParaGenerar, studio, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < capacidadDriveNivelB; i++) {
            if (desarrolladoresNivel[i] == null) {
                desarrolladoresNivel[i] = desarrolladorNiveles;
                desarrolladorNivelesCount++; // Incrementar el contador
                desarrolladorNiveles.start(); // Iniciar el hilo del desarrollador de nivel
                break;
            }
        }
    }

    public static void stopDesarrolladorNivelAleatorio() {
        if (desarrolladorNivelesCount == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (desarrolladoresNivel[indiceAleatorio] == null);

        DesarrolladorNiveles hilo = desarrolladoresNivel[indiceAleatorio];

        if (hilo != null) {
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
        }
    }

}
