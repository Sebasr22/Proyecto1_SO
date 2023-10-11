package classes;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class BethesdaStudio {

    public static int totalPayB = 0;
    public static int ingreso = 0;
    public static int utilidad = ingreso - totalPayB;
    public static int juegosGenerados = 0;
    public static int juegosDLCGenerados = 0;
    
    // Capacidad de los drive de los desarrolladores
    static int capacidadDriveNB = 25;
    static int capacidadDriveNivelB = 20;
    static int capacidadDriveDLCB = 10;
    static int capacidadDriveLogicaB = 35;
    static int capacidadDriveSprites = 55;

    // Semaforos de los drive de los desarrolladores
    public static Semaphore driveNB = new Semaphore(capacidadDriveNB);
    public static Semaphore driveNivelB = new Semaphore(capacidadDriveNivelB);
    public static Semaphore driveDLCB = new Semaphore(capacidadDriveDLCB);
    public static Semaphore driveLogicB = new Semaphore(capacidadDriveLogicaB);
    public static Semaphore driveSpritesB = new Semaphore(capacidadDriveSprites);
    public static Semaphore driveJuegosB = new Semaphore(Integer.MAX_VALUE);

    final private boolean active = true;
    private int videojuegosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);

    int totalDayCounter = 0;

    //CONTADORES DESARROLLADORES
    private static int desarrolladorNarrativaCount = 0;
    private static int desarrolladorNivelesCount = 0;
    private static int desarrolladorDLCCount = 0;
    private static int desarrolladorLogicCount = 0;
    private static int desarrolladorSpritesCount = 0;
    private static int integradoresCount = 0;

    public BethesdaStudio(int dayDuration, int daysUntilLaunch) {
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

    // LOGICA 
    public static void crearDesarrolladorLogic(Semaphore driveLogicB, int diasParaGenerar, int totalPay, String studio, boolean activo) {
        DesarrolladorLogica desarrolladorLogica = new DesarrolladorLogica(driveLogicB, totalPay, diasParaGenerar, studio, activo);
        // Encuentra la primera posicion libre en el arreglo
        for (int i = 0; i < 11; i++) {
            if (desarrolladoresLogica[i] == null) {
                desarrolladoresLogica[i] = desarrolladorLogica;
                desarrolladorLogicCount++;
                desarrolladorLogica.start();
                break;
            }
        }
    }

    public static void stopDesarrolladorLogicaAleatorio() {
        if (desarrolladorLogicCount == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11);
        } while (desarrolladoresLogica[indiceAleatorio] == null);

        DesarrolladorLogica hilo = desarrolladoresLogica[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de DLC antes de eliminar: " + desarrolladorLogicCount);
            hilo.setActivo(false);
            desarrolladoresLogica[indiceAleatorio] = null;
            desarrolladorLogicCount--;
        }
    }

    // Sprites
    public static void crearDesarrolladorSprites(Semaphore driveSpritesB, int diasParaGenerar, int totalPay, String studio, boolean activo) {
        DesarrolladorSprites desarrolladorSprite = new DesarrolladorSprites(driveSpritesB, totalPay, diasParaGenerar, studio, activo);

        for (int i = 0; i < 11; i++) {
            if (desarrolladoresSprites[i] == null) {
                desarrolladoresSprites[i] = desarrolladorSprite;
                desarrolladorSpritesCount++;
                desarrolladorSprite.start();
                break;
            }
        }
    }

    public static void stopDesarrolladorSpriteAleatorio() {

        if (desarrolladorSpritesCount == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11);
        } while (desarrolladoresSprites[indiceAleatorio] == null);

        DesarrolladorSprites hilo = desarrolladoresSprites[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de DLC antes de eliminar: " + desarrolladorSpritesCount);
            hilo.setActivo(false);
            desarrolladoresSprites[indiceAleatorio] = null;
            desarrolladorSpritesCount--;
        }
    }

    // Integradores
    public static void crearIntegrador(Semaphore driveJuegosB, Semaphore driveNB, Semaphore driveNivelB, Semaphore driveDLCB, Semaphore driveLogicB, Semaphore driveSpritesB, int juegosGenerados, int juegosDLCGenerados, int diasParaGenerar, int guionesNecesarios, int nivelesNecesarios, int spritesNecesarios, int sistemasNecesarios, int DLCNecesarios, String studio, boolean activo) {
        Integrador integrador = new Integrador(driveJuegosB, driveNB, driveNivelB, driveDLCB, driveLogicB, driveSpritesB, juegosGenerados, juegosDLCGenerados, diasParaGenerar, guionesNecesarios, nivelesNecesarios, spritesNecesarios, sistemasNecesarios, DLCNecesarios, studio, activo);

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
