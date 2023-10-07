package classes;

import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BethesdaStudio {
    
    static int capacidadDriveN = 25;
    public static Semaphore driveN = new Semaphore(capacidadDriveN);
    final private boolean active = true;
    private int videojuegosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);
    private final double[] utilityOverTime = new double[200];

    int totalDayCounter = 0;

    private static  List<DesarrolladorNarrativa> desarrolladoresNarrativaList = new ArrayList<>();
    private static int desarrolladorNarrativaCount = 0;

    public BethesdaStudio(int dayDuration, int daysUntilLaunch) {
        this.dayDuration = dayDuration;
    }

    public static void crearDesarrolladorNarrativa(Semaphore driveN, int totalPay, int diasParaGenerar) {
        DesarrolladorNarrativa desarrolladorNarrativa = new DesarrolladorNarrativa(driveN, totalPay, true, diasParaGenerar);
        desarrolladoresNarrativaList.add(desarrolladorNarrativa); // Agregar el desarrollador a la lista
        desarrolladorNarrativaCount++; // Incrementar el contador
        desarrolladorNarrativa.start(); // Iniciar el hilo del desarrollador de narrativa
    }

    public static void stopDesarrolladorNarrativaAleatorio() {
        if (desarrolladorNarrativaCount > 0) {
            // Genera un índice aleatorio para detener un desarrollador de narrativa
            Random rand = new Random();
            int randomIndex = rand.nextInt(desarrolladorNarrativaCount);

            // Obtiene el desarrollador de narrativa en el índice aleatorio
            DesarrolladorNarrativa desarrolladorNarrativa = desarrolladoresNarrativaList.get(randomIndex);

            // Detiene el hilo del desarrollador de narrativa
            desarrolladorNarrativa.activo = false;

            // Elimina el desarrollador de la lista
            desarrolladoresNarrativaList.remove(randomIndex);
            desarrolladorNarrativaCount--;
        }
    }
}
