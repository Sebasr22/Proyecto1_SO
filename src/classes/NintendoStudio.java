package classes;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class NintendoStudio {
    public static int diasRestantesN = 6;
    public static int totalPayN = 0;
    public static int ingresoN = 0;
    public static int utilidadN = ingresoN - totalPayN;
    public static int juegosGeneradosN = 0;
    public static int juegosDLCGeneradosN = 0;
    // Capacidad de los drive de los desarrolladores
    static int capacidadDriveN = 25;
    static int capacidadDriveNivelN = 20;
    static int capacidadDriveDLCN = 10;
    static int capacidadDriveLogicaN = 35;
    static int capacidadDriveSpritesN = 55;

    // Semaforos de los drive de los desarrolladores
    public static Semaphore driveN = new Semaphore(capacidadDriveN);
    public static Semaphore driveNivelN = new Semaphore(capacidadDriveNivelN);
    public static Semaphore driveDLCN = new Semaphore(capacidadDriveDLCN);
    public static Semaphore driveLogicN = new Semaphore(capacidadDriveLogicaN);
    public static Semaphore driveSpritesN = new Semaphore(capacidadDriveSpritesN);
    public static Semaphore driveJuegosN = new Semaphore(Integer.MAX_VALUE);

    final private boolean active = true;
    private int videojuegosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);

    int totalDayCounter = 0;

    //CONTADORES DESARROLLADORES
    private static int desarrolladorNarrativaCountN = 0;
    private static int desarrolladorNivelesCountN = 0;
    private static int desarrolladorDLCCountN = 0;
    private static int desarrolladorLogicCountN = 0;
    private static int desarrolladorSpritesCountN = 0;
    private static int integradoresCount = 0;

    public NintendoStudio(int dayDuration, int daysUntilLaunch) {
        this.dayDuration = dayDuration;
    }

    // Lista de desarrolladores
    private static DesarrolladorNarrativa[] desarrolladoresNarrativa = new DesarrolladorNarrativa[11];
    private static DesarrolladorNiveles[] desarrolladoresNivel = new DesarrolladorNiveles[11];
    private static DesarrolladorDLC[] desarrolladoresDLC = new DesarrolladorDLC[11];
    private static DesarrolladorLogica[] desarrolladoresLogica = new DesarrolladorLogica[11];
    private static DesarrolladorSprites[] desarrolladoresSprites = new DesarrolladorSprites[11];
    private static Integrador[] integradores = new Integrador[11];

    //NARRATIVA 
    public static void crearDesarrolladorNarrativa(Semaphore driveN, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        DesarrolladorNarrativa desarrolladorNarrativa = new DesarrolladorNarrativa(driveN, totalPay, diasParaGenerar, studio, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 11; i++) {
            if (desarrolladoresNarrativa[i] == null) {
                desarrolladoresNarrativa[i] = desarrolladorNarrativa;
                desarrolladorNarrativaCountN++; // Incrementar el contador
                desarrolladorNarrativa.start(); // Iniciar el hilo del desarrollador de narrativa
                break;
            }
        }
    }

    public static void stopDesarrolladorNarrativaAleatorio() {
        if (desarrolladorNarrativaCountN == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (desarrolladoresNarrativa[indiceAleatorio] == null);

        DesarrolladorNarrativa hilo = desarrolladoresNarrativa[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + desarrolladorNarrativaCountN);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            desarrolladoresNarrativa[indiceAleatorio] = null; // Eliminar el hilo de la lista
            desarrolladorNarrativaCountN--; // Decrementar el contador
        }
    }

    //NIVELES
    public static void crearDesarrolladorNivel(Semaphore driveNivelB, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        DesarrolladorNiveles desarrolladorNiveles = new DesarrolladorNiveles(driveNivelB, totalPay, diasParaGenerar, studio, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < capacidadDriveNivelN; i++) {
            if (desarrolladoresNivel[i] == null) {
                desarrolladoresNivel[i] = desarrolladorNiveles;
                desarrolladorNivelesCountN++; // Incrementar el contador
                desarrolladorNiveles.start(); // Iniciar el hilo del desarrollador de nivel
                break;
            }
        }
    }

    public static void stopDesarrolladorNivelAleatorio() {
        if (desarrolladorNivelesCountN == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (desarrolladoresNivel[indiceAleatorio] == null);

        DesarrolladorNiveles hilo = desarrolladoresNivel[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de nivel antes de eliminar: " + desarrolladorNivelesCountN);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            desarrolladoresNivel[indiceAleatorio] = null; // Eliminar el hilo de la lista
            desarrolladorNivelesCountN--; // Decrementar el contador
        }
    }

    //DLC
    public static void crearDesarrolladorDLC(Semaphore driveDLC, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        DesarrolladorDLC desarrolladorDLC = new DesarrolladorDLC(driveDLC, totalPay, diasParaGenerar, studio, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 11; i++) {
            if (desarrolladoresDLC[i] == null) {
                desarrolladoresDLC[i] = desarrolladorDLC;
                desarrolladorDLCCountN++; // Incrementar el contador
                desarrolladorDLC.start(); // Iniciar el hilo del desarrollador de DLC
                break;
            }
        }
    }

    public static void stopDesarrolladorDLCAleatorio() {
        if (desarrolladorDLCCountN == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (desarrolladoresDLC[indiceAleatorio] == null);

        DesarrolladorDLC hilo = desarrolladoresDLC[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de DLC antes de eliminar: " + desarrolladorDLCCountN);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            desarrolladoresDLC[indiceAleatorio] = null; // Eliminar el hilo de la lista
            desarrolladorDLCCountN--; // Decrementar el contador
        }
    }

    // LOGICA 
    public static void crearDesarrolladorLogic(Semaphore driveLogicB, int diasParaGenerar, int totalPay, String studio, boolean activo) {
        DesarrolladorLogica desarrolladorLogica = new DesarrolladorLogica(driveLogicB, totalPay, diasParaGenerar, studio, activo);
        // Encuentra la primera posicion libre en el arreglo
        for (int i = 0; i < 11; i++) {
            if (desarrolladoresLogica[i] == null) {
                desarrolladoresLogica[i] = desarrolladorLogica;
                desarrolladorLogicCountN++;
                desarrolladorLogica.start();
                break;
            }
        }
    }

    public static void stopDesarrolladorLogicaAleatorio() {
        if (desarrolladorLogicCountN == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11);
        } while (desarrolladoresLogica[indiceAleatorio] == null);

        DesarrolladorLogica hilo = desarrolladoresLogica[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de DLC antes de eliminar: " + desarrolladorLogicCountN);
            hilo.setActivo(false);
            desarrolladoresLogica[indiceAleatorio] = null;
            desarrolladorLogicCountN--;
        }
    }

    // Sprites
    public static void crearDesarrolladorSprites(Semaphore driveSpritesB, int diasParaGenerar, int totalPay, String studio, boolean activo) {
        DesarrolladorSprites desarrolladorSprite = new DesarrolladorSprites(driveSpritesB, totalPay, diasParaGenerar, studio, activo);

        for (int i = 0; i < 11; i++) {
            if (desarrolladoresSprites[i] == null) {
                desarrolladoresSprites[i] = desarrolladorSprite;
                desarrolladorSpritesCountN++;
                desarrolladorSprite.start();
                break;
            }
        }
    }

    public static void stopDesarrolladorSpriteAleatorio() {

        if (desarrolladorSpritesCountN == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11);
        } while (desarrolladoresSprites[indiceAleatorio] == null);

        DesarrolladorSprites hilo = desarrolladoresSprites[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de DLC antes de eliminar: " + desarrolladorSpritesCountN);
            hilo.setActivo(false);
            desarrolladoresSprites[indiceAleatorio] = null;
            desarrolladorSpritesCountN--;
        }
    }
    
    // Integradores
    public static void crearIntegrador(Semaphore driveJuegosN, Semaphore driveN, Semaphore driveNivelN, Semaphore driveDLCN, Semaphore driveLogicN, Semaphore driveSpritesN, int juegosGeneradosN, int juegosDLCGeneradosN, int diasParaGenerar, int guionesNecesarios, int nivelesNecesarios, int spritesNecesarios, int sistemasNecesarios, int DLCNecesarios, String studio, boolean activo) {
        Integrador integrador = new Integrador(driveJuegosN, driveN, driveNivelN, driveDLCN, driveLogicN, driveSpritesN, juegosGeneradosN, juegosDLCGeneradosN, diasParaGenerar, guionesNecesarios, nivelesNecesarios, spritesNecesarios, sistemasNecesarios, DLCNecesarios, studio, activo);

        for (int i = 0; i < 11; i++) {
            if (integradores[i] == null) {
                integradores[i] = integrador;
                integradoresCount++;
                integrador.start();
                break;
            }
        }
    }

    public static void stopIntegradorAleatorio() {

        if (integradoresCount == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11);
        } while (integradores[indiceAleatorio] == null);

        Integrador hilo = integradores[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de Integrador antes de eliminar: " + integradoresCount);
            hilo.setActivo(false);
            integradores[indiceAleatorio] = null;
            integradoresCount--;
        }
    }

}
