/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import classes.BethesdaStudio;
import classes.Director;
import classes.Funciones;
import classes.ProjectManager;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Bethesda extends javax.swing.JPanel {

    private int valorSpinnerN;
    private int valorSpinnerLvl;
    private int valorSpinnerDLCB;
    private int valorSpinnerSistemasB;
    private int valorSpinnerSpritesB;
    private int valorSpinnerIntegradoresB;

    public Bethesda() {

        initComponents();
        Bethesda.diasParaEntrega.setText(Integer.toString(BethesdaStudio.diasRestantesSem.availablePermits()));

        Director director = new Director(BethesdaStudio.diasRestantesSem, "B");
        director.start();

        ProjectManager pm = new ProjectManager(BethesdaStudio.diasRestantesSem, "B");
        pm.start();

        Funciones dia = new Funciones();
        dia.start();

        //SPINNER NARRATIVA-----------------------------------------------
        // Obtén el valor inicial del JSpinner
        valorSpinnerN = (int) spinnnerNarrativaB.getValue();
        if (valorSpinnerN == 1) {
            // Llama a la función para crear un desarrollador de narrativa
            BethesdaStudio.crearDesarrolladorNarrativa(BethesdaStudio.driveNB, 0, 4, "B", true);
        }

        // Agrega un ChangeListener al JSpinner
        spinnnerNarrativaB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtén el nuevo valor del JSpinner
                int nuevoValorSpinner = (int) spinnnerNarrativaB.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());

                // Compara el nuevo valor del JSpinner con valorSpinner
                if (nuevoValorSpinner > valorSpinnerN) {
                    if (desarrolladoresRestantes > 0) {
                        //FUNCION CREAR DESARROLLADOR NARRATIVA
                        // Llama a la función para crear un desarrollador de narrativa
                        BethesdaStudio.crearDesarrolladorNarrativa(BethesdaStudio.driveNB, 0, 4, "B", true);
                        // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                        int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                        valorActual--;
                        desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                        valorSpinnerN = nuevoValorSpinner;
                    } else {
                        spinnnerNarrativaB.setValue(valorSpinnerN);
                    }
                } else if (nuevoValorSpinner < valorSpinnerN) {
                    //FUNCION STOP DESARROLLADOR NARRATIVA
                    BethesdaStudio.stopDesarrolladorNarrativaAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                    valorSpinnerN = nuevoValorSpinner;
                }

            }
        });
        //SPINNER NIVELES-----------------------------------------------
        // Obtén el valor inicial del JSpinner
        valorSpinnerLvl = (int) spinnnerNivelB.getValue();
        if (valorSpinnerLvl == 1) {
            // Llama a la función para crear un desarrollador de narrativa
            BethesdaStudio.crearDesarrolladorNivel(BethesdaStudio.driveNivelB, 0, 3, "B", true);
        }

        // Agrega un ChangeListener al JSpinner
        spinnnerNivelB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtén el nuevo valor del JSpinner
                int nuevoValorSpinnerLvl = (int) spinnnerNivelB.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                // Compara el nuevo valor del JSpinner con valorSpinner
                if (nuevoValorSpinnerLvl > valorSpinnerLvl) {
                    if (desarrolladoresRestantes > 0) {
                    //FUNCION CREAR DESARROLLADOR NARRATIVA
                    // Llama a la función para crear un desarrollador de nivel
                    BethesdaStudio.crearDesarrolladorNivel(BethesdaStudio.driveNivelB, 0, 3, "B", true);
                    // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual--;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                    valorSpinnerN = nuevoValorSpinnerLvl;}
                    else {
                        spinnnerNivelB.setValue(valorSpinnerLvl);
                    }
                } 
                
                else if (nuevoValorSpinnerLvl < valorSpinnerLvl) {

                    //FUNCION STOP DESARROLLADOR NIVEL
                    BethesdaStudio.stopDesarrolladorNivelAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                }

                // Actualiza valorSpinner con el nuevo valor del JSpinner
                
            }
        });

        //SPINNER DLC-----------------------------------------------
        // Obtén el valor inicial del JSpinner
        valorSpinnerDLCB = (int) spinnerDLCB.getValue();
        if (valorSpinnerDLCB == 1) {
            // Llama a la función para crear un desarrollador de DLC
            BethesdaStudio.crearDesarrolladorDLC(BethesdaStudio.driveDLCB, 0, 2, "B", true);
        }

        // Agrega un ChangeListener al JSpinner
        spinnerDLCB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtén el nuevo valor del JSpinner
                int nuevoValorSpinnerDLCB = (int) spinnerDLCB.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                // Compara el nuevo valor del JSpinner con valorSpinnerDLCB
                if (nuevoValorSpinnerDLCB > valorSpinnerDLCB) {
                    //FUNCION CREAR DESARROLLADOR DLC
                    // Llama a la función para crear un desarrollador de DLC
                    BethesdaStudio.crearDesarrolladorDLC(BethesdaStudio.driveDLCB, 0, 2, "B", true);
                    // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual--;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                } else if (nuevoValorSpinnerDLCB < valorSpinnerDLCB) {
                    //FUNCION STOP DESARROLLADOR DLC
                    BethesdaStudio.stopDesarrolladorDLCAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                }

                // Actualiza valorSpinnerDLCB con el nuevo valor del JSpinner
                valorSpinnerDLCB = nuevoValorSpinnerDLCB;
            }
        });

        // SPINNER SISTEMAS
        valorSpinnerSistemasB = (int) spinnerSistemasB.getValue();
        if (valorSpinnerSistemasB == 1) {
            // Llama a la funcion para crear un desarrollador de logica
            BethesdaStudio.crearDesarrolladorLogic(BethesdaStudio.driveLogicB, 1, 0, "B", true);
        }

        spinnerSistemasB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorSpinnerSistemasB = (int) spinnerSistemasB.getValue();
int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                if (nuevoValorSpinnerSistemasB > valorSpinnerSistemasB) {

                    BethesdaStudio.crearDesarrolladorLogic(BethesdaStudio.driveLogicB, 1, 0, "B", true);

                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual--;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));

                } else if (nuevoValorSpinnerSistemasB < valorSpinnerSistemasB) {

                    BethesdaStudio.stopDesarrolladorLogicaAleatorio();

                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                }

                valorSpinnerSistemasB = nuevoValorSpinnerSistemasB;
            }
        });

        // SPINNER SPRITES
        valorSpinnerSpritesB = (int) spinnerSpritesB.getValue();
        if (valorSpinnerSpritesB == 1) {
            // Llama a la funcion para crear un desarrollador de logica
            BethesdaStudio.crearDesarrolladorSprites(BethesdaStudio.driveSpritesB, 1, 0, "B", true);
        }

        spinnerSpritesB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorSpinnerSpritesB = (int) spinnerSpritesB.getValue();

                if (nuevoValorSpinnerSpritesB > valorSpinnerSpritesB) {

                    BethesdaStudio.crearDesarrolladorSprites(BethesdaStudio.driveSpritesB, 1, 0, "B", true);

                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual--;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));

                } else if (nuevoValorSpinnerSpritesB < valorSpinnerSpritesB) {

                    BethesdaStudio.stopDesarrolladorSpriteAleatorio();

                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                }

                valorSpinnerSpritesB = nuevoValorSpinnerSpritesB;
            }
        });

        // SPINNER INTEGRADORES
        valorSpinnerIntegradoresB = (int) spinnerIntegradoresB.getValue();
        if (valorSpinnerIntegradoresB == 1) {
            BethesdaStudio.crearIntegrador(BethesdaStudio.driveJuegosB, BethesdaStudio.driveNB, BethesdaStudio.driveNivelB, BethesdaStudio.driveDLCB, BethesdaStudio.driveLogicB, BethesdaStudio.driveSpritesB, BethesdaStudio.juegosGeneradosB, BethesdaStudio.juegosDLCGeneradosB, 2, 2, 3, 4, 6, 5, "B", true);
        }

        spinnerIntegradoresB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorSpinnerIntegradoresB = (int) spinnerIntegradoresB.getValue();

                if (nuevoValorSpinnerIntegradoresB > valorSpinnerIntegradoresB) {

                    BethesdaStudio.crearIntegrador(BethesdaStudio.driveJuegosB, BethesdaStudio.driveNB, BethesdaStudio.driveNivelB, BethesdaStudio.driveDLCB, BethesdaStudio.driveLogicB, BethesdaStudio.driveSpritesB, BethesdaStudio.juegosGeneradosB, BethesdaStudio.juegosDLCGeneradosB, 2, 2, 3, 4, 6, 5, "B", true);

                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual--;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));

                } else if (nuevoValorSpinnerIntegradoresB < valorSpinnerIntegradoresB) {

                    BethesdaStudio.stopIntegradorAleatorio();

                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                }

                valorSpinnerIntegradoresB = nuevoValorSpinnerIntegradoresB;
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        costosOperativosB = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        desarrolladoresRestantesB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spinnnerNarrativaB = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        guionesEnDriveB = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spinnnerNivelB = new javax.swing.JSpinner();
        nivelesEnDriveB = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spinnerDLCB = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        DLCEnDriveB = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spinnerSistemasB = new javax.swing.JSpinner();
        SistemasEnDriveB = new javax.swing.JLabel();
        ingresosBrutos = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spinnerSpritesB = new javax.swing.JSpinner();
        estadoDirector = new javax.swing.JLabel();
        LogoBethesda = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        diasParaEntrega = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ganancia = new javax.swing.JLabel();
        juegosGenerados = new javax.swing.JLabel();
        juegosDLCGenerados = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        spinnerIntegradoresB = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        faltasPM = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        estadoPMB = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        descontadoPM = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        SpritesEnDriveB = new javax.swing.JLabel();
        FondoBethesda = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 603));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        costosOperativosB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        costosOperativosB.setForeground(new java.awt.Color(255, 255, 255));
        costosOperativosB.setText("0");
        add(costosOperativosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 250, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Costos Operativos = $ ");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 210, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Desarrolladores restantes = ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));

        desarrolladoresRestantesB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        desarrolladoresRestantesB.setForeground(new java.awt.Color(255, 255, 255));
        desarrolladoresRestantesB.setText("9");
        add(desarrolladoresRestantesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 20, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Narrativa = ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, -1));

        spinnnerNarrativaB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNarrativaB.setValue(1);
        add(spinnnerNarrativaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Capacidad Drive");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        guionesEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        guionesEnDriveB.setForeground(new java.awt.Color(255, 255, 255));
        guionesEnDriveB.setText("0");
        add(guionesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 30, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("de 25");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Niveles =");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 70, 20));

        spinnnerNivelB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNivelB.setValue(1);
        add(spinnnerNivelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        nivelesEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nivelesEnDriveB.setForeground(new java.awt.Color(255, 255, 255));
        nivelesEnDriveB.setText("0");
        add(nivelesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 30, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("de 10");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DLC's =");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 60, -1));

        spinnerDLCB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerDLCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("de 20");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        DLCEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DLCEnDriveB.setForeground(new java.awt.Color(255, 255, 255));
        DLCEnDriveB.setText("0");
        add(DLCEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 30, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sistemas =");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        spinnerSistemasB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerSistemasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        SistemasEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SistemasEnDriveB.setForeground(new java.awt.Color(255, 255, 255));
        SistemasEnDriveB.setText("0");
        add(SistemasEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 30, -1));

        ingresosBrutos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ingresosBrutos.setForeground(new java.awt.Color(255, 255, 255));
        ingresosBrutos.setText("0");
        add(ingresosBrutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 370, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("de 35");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Sprites =");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        spinnerSpritesB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerSpritesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        estadoDirector.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        estadoDirector.setForeground(new java.awt.Color(255, 255, 255));
        estadoDirector.setText("Labores Administrativas");
        add(estadoDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 270, 20));

        LogoBethesda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BethesdaLogo.png"))); // NOI18N
        add(LogoBethesda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 510, 120));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Ingresos brutos = $ ");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Video Juegos (Con DLC) Generados = ");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, 20));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Días para la entrega = ");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Estado Director = ");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("de 55");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        diasParaEntrega.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        diasParaEntrega.setForeground(new java.awt.Color(0, 0, 0));
        diasParaEntrega.setText("0");
        add(diasParaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Ganancia = $");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 130, -1));

        ganancia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ganancia.setForeground(new java.awt.Color(255, 255, 255));
        ganancia.setText("0");
        add(ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 470, -1));

        juegosGenerados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        juegosGenerados.setForeground(new java.awt.Color(255, 255, 255));
        juegosGenerados.setText("0");
        add(juegosGenerados, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 210, -1));

        juegosDLCGenerados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        juegosDLCGenerados.setForeground(new java.awt.Color(255, 255, 255));
        juegosDLCGenerados.setText("0");
        add(juegosDLCGenerados, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 120, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Video Juegos Generados = ");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 250, 20));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Integradores =");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        spinnerIntegradoresB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerIntegradoresB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        faltasPM.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        faltasPM.setForeground(new java.awt.Color(255, 255, 255));
        faltasPM.setText("0");
        jPanel2.add(faltasPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 40, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Project Manager");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Estado = ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Descontado = $");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        estadoPMB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        estadoPMB.setForeground(new java.awt.Color(255, 255, 255));
        estadoPMB.setText("Trabajando");
        jPanel2.add(estadoPMB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Faltas =");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        descontadoPM.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        descontadoPM.setForeground(new java.awt.Color(255, 255, 255));
        descontadoPM.setText("0");
        jPanel2.add(descontadoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 120, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 300, 80));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SpritesEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SpritesEnDriveB.setForeground(new java.awt.Color(255, 255, 255));
        SpritesEnDriveB.setText("0");
        jPanel1.add(SpritesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 30, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 130, 180));

        FondoBethesda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BethesdaBackgroundDoom.jpg"))); // NOI18N
        add(FondoBethesda, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -130, 820, 830));
    }// </editor-fold>//GEN-END:initComponents

    public static JLabel getJuegosDLCGenerados() {
        return juegosDLCGenerados;
    }

    public static void setJuegosDLCGenerados(JLabel juegosDLCGenerados) {
        Bethesda.juegosDLCGenerados = juegosDLCGenerados;
    }

    public static JLabel getJuegosGenerados() {
        return juegosGenerados;
    }

    public static void setJuegosGenerados(JLabel juegosGenerados) {
        Bethesda.juegosGenerados = juegosGenerados;
    }

    public static void actualizarJuegosGenerados(int nuevoValor) {
        juegosGenerados.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarJuegosDLCGenerados(int nuevoValor) {
        juegosDLCGenerados.setText(Integer.toString(nuevoValor));
    }

    public JLabel getDesarrolladoresRestantesB() {
        return desarrolladoresRestantesB;
    }

    public void setDesarrolladoresRestantesB(JLabel desarrolladoresRestantesB) {
        this.desarrolladoresRestantesB = desarrolladoresRestantesB;
    }

    public static JLabel getGuionesEnDriveB() {
        return guionesEnDriveB;
    }

    public void setGuionesEnDriveB(JLabel guionesEnDriveB) {
        this.guionesEnDriveB = guionesEnDriveB;
    }

    public static void actualizarGuionesEnDrive(int nuevoValor) {
        guionesEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarNivelesEnDrive(int nuevoValor) {
        nivelesEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarDLCsEnDrive(int nuevoValor) {
        DLCEnDriveB.setText(Integer.toString(nuevoValor));
    }

    // Desarrollador Logica
    public static void actualizarSistemasEnDrive(int nuevoValor) {
        SistemasEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static JLabel getSistemasEnDriveB() {
        return SistemasEnDriveB;
    }

    public static void setSistemasEnDriveB(JLabel SistemasEnDriveB) {
        Bethesda.SistemasEnDriveB = SistemasEnDriveB;
    }

    //Desarrollador Sprites
    public static void actualizarSpritesEnDrive(int nuevoValor) {
        SpritesEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static JLabel getSpritesEnDriveB() {
        return SpritesEnDriveB;
    }

    public static void setSpritesEnDriveB(JLabel SpritesEnDriveB) {
        Bethesda.SpritesEnDriveB = SpritesEnDriveB;
    }

    public static JLabel getNivelesEnDriveB() {
        return nivelesEnDriveB;
    }

    public static void setNivelesEnDriveB(JLabel nivelesEnDriveB) {
        Bethesda.nivelesEnDriveB = nivelesEnDriveB;
    }

    public static JLabel getDLCEnDriveB() {
        return DLCEnDriveB;
    }

    public static void setDLCEnDriveB(JLabel DLCEnDriveB) {
        Bethesda.DLCEnDriveB = DLCEnDriveB;
    }

    public static JLabel getEstadoPM() {
        return estadoPMB;
    }

    public static void setEstadoPM(JLabel estadoPM) {
        Bethesda.estadoPMB = estadoPM;
    }

    public static void actualizarEstadoPMB(String estado) {
        estadoPMB.setText(estado);
    }

    public static JLabel getDescontadoPM() {
        return descontadoPM;
    }

    public static void setDescontadoPM(JLabel descontadoPM) {
        Bethesda.descontadoPM = descontadoPM;
    }

    public static JLabel getDiasParaEntrega() {
        return diasParaEntrega;
    }

    public static void setDiasParaEntrega(JLabel diasParaEntrega) {
        Bethesda.diasParaEntrega = diasParaEntrega;
    }

    public static void actualizarDiasParaEntregaB(int nuevoValor) {
        diasParaEntrega.setText(Integer.toString(nuevoValor));
    }

    public static JLabel getEstadoDirector() {
        return estadoDirector;
    }

    public static void setEstadoDirector(JLabel estadoDirector) {
        Bethesda.estadoDirector = estadoDirector;
    }

    public static JLabel getFaltasPM() {
        return faltasPM;
    }

    public static void setFaltasPM(JLabel faltasPM) {
        Bethesda.faltasPM = faltasPM;
    }

    public static JLabel getGanancia() {
        return ganancia;
    }

    public static void setGanancia(JLabel ganancia) {
        Bethesda.ganancia = ganancia;
    }

    public static void actualizarEstadoDirector(String estado) {
        estadoDirector.setText(estado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel DLCEnDriveB;
    private javax.swing.JLabel FondoBethesda;
    private javax.swing.JLabel LogoBethesda;
    public static javax.swing.JLabel SistemasEnDriveB;
    public static javax.swing.JLabel SpritesEnDriveB;
    public static javax.swing.JLabel costosOperativosB;
    private javax.swing.JLabel desarrolladoresRestantesB;
    public static javax.swing.JLabel descontadoPM;
    public static javax.swing.JLabel diasParaEntrega;
    public static javax.swing.JLabel estadoDirector;
    public static javax.swing.JLabel estadoPMB;
    public static javax.swing.JLabel faltasPM;
    public static javax.swing.JLabel ganancia;
    public static javax.swing.JLabel guionesEnDriveB;
    public static javax.swing.JLabel ingresosBrutos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel juegosDLCGenerados;
    public static javax.swing.JLabel juegosGenerados;
    public static javax.swing.JLabel nivelesEnDriveB;
    private javax.swing.JSpinner spinnerDLCB;
    private javax.swing.JSpinner spinnerIntegradoresB;
    private javax.swing.JSpinner spinnerSistemasB;
    private javax.swing.JSpinner spinnerSpritesB;
    private javax.swing.JSpinner spinnnerNarrativaB;
    private javax.swing.JSpinner spinnnerNivelB;
    // End of variables declaration//GEN-END:variables
}
