package classes;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class BethesdaStudio {

    public static int totalPay = 0;
    static int capacidadDriveNB = 25;
    static int capacidadDriveNivelB = 20;
    static int capacidadDriveDLCB = 10;
    public static Semaphore driveNB = new Semaphore(capacidadDriveNB);
    public static Semaphore driveNivelB = new Semaphore(capacidadDriveNivelB);
    public static Semaphore driveDLCB = new Semaphore(capacidadDriveDLCB);
    final private boolean active = true;
    private int videojuegosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);


    int totalDayCounter = 0;
//CONTADORES DESARROLLADORES
    private static int desarrolladorNarrativaCount = 0;
    private static int desarrolladorNivelesCount = 0;
    private static int desarrolladorDLCCount = 0;

    public BethesdaStudio(int dayDuration, int daysUntilLaunch) {
        this.dayDuration = dayDuration;
    }
    private static DesarrolladorNarrativa[] desarrolladoresNarrativa = new DesarrolladorNarrativa[11];  
    private static DesarrolladorNiveles[] desarrolladoresNivel = new DesarrolladorNiveles[11];
    private static DesarrolladorDLC[] desarrolladoresDLC = new DesarrolladorDLC[11];
   
//NARRATIVA 
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
        System.out.println("Cantidad de hilos antes de eliminar: " + desarrolladorNarrativaCount);
        hilo.setActivo(false); // Establecer el estado del hilo como inactivo
        desarrolladoresNarrativa[indiceAleatorio] = null; // Eliminar el hilo de la lista
        desarrolladorNarrativaCount--; // Decrementar el contador
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
        System.out.println("Cantidad de hilos de nivel antes de eliminar: " + desarrolladorNivelesCount);
        hilo.setActivo(false); // Establecer el estado del hilo como inactivo
        desarrolladoresNivel[indiceAleatorio] = null; // Eliminar el hilo de la lista
        desarrolladorNivelesCount--; // Decrementar el contador
    }
}
//DLC
    
    public static void crearDesarrolladorDLC(Semaphore driveDLC, int totalPay, int diasParaGenerar, String studio, boolean activo) {
    DesarrolladorDLC desarrolladorDLC = new DesarrolladorDLC(driveDLC, totalPay, diasParaGenerar, studio, activo);
    // Encuentra la primera posición libre en el arreglo
    for (int i = 0; i < 11; i++) {
        if (desarrolladoresDLC[i] == null) {
            desarrolladoresDLC[i] = desarrolladorDLC;
            desarrolladorDLCCount++; // Incrementar el contador
            desarrolladorDLC.start(); // Iniciar el hilo del desarrollador de DLC
            break;
        }
    }
}
public static void stopDesarrolladorDLCAleatorio() {
    if (desarrolladorDLCCount == 0) {
        return; // No hay hilos para detener
    }

    Random random = new Random();
    int indiceAleatorio;

    do {
        indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
    } while (desarrolladoresDLC[indiceAleatorio] == null);

    DesarrolladorDLC hilo = desarrolladoresDLC[indiceAleatorio];

    if (hilo != null) {
        System.out.println("Cantidad de hilos de DLC antes de eliminar: " + desarrolladorDLCCount);
        hilo.setActivo(false); // Establecer el estado del hilo como inactivo
        desarrolladoresDLC[indiceAleatorio] = null; // Eliminar el hilo de la lista
        desarrolladorDLCCount--; // Decrementar el contador
    }
}


}
