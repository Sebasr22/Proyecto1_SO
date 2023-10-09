/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import classes.Funciones;
import classes.NintendoStudio;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Nintendo extends javax.swing.JPanel {

    private int valorSpinnerN;
    private int valorSpinnerLvl;
    private int valorSpinnerDLCN;
    private int valorSpinnerSistemasN;
    private int valorSpinnerSpritesN;

    public Nintendo() {
        initComponents();
        Funciones dia = new Funciones();
        dia.start();
        // SPINNER NARRATIVA
        valorSpinnerN = (int) spinnnerNarrativaN.getValue();
        if (valorSpinnerN == 1) {
            // Llama a la función para crear un desarrollador de narrativa
            NintendoStudio.crearDesarrolladorNarrativa(NintendoStudio.driveN, 0, 4, "N", true);  //MODIFICAR VALORES
        }

        spinnnerNarrativaN.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnnerNarrativaN.getValue();

                if (nuevoValorSpinner > valorSpinnerN) {

                    //FUNCION CREAR DESARROLLADOR NARRATIVA
                    // Llama a la función para crear un desarrollador de narrativa
                    NintendoStudio.crearDesarrolladorNarrativa(NintendoStudio.driveN, 0, 4, "N", true);   //MODIFICAR VALORES 
                    // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual--;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                } else if (nuevoValorSpinner < valorSpinnerN) {
                    //FUNCION STOP DESARROLLADOR NARRATIVA
                    NintendoStudio.stopDesarrolladorNarrativaAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual++;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                }

                // Actualiza valorSpinner con el nuevo valor del JSpinner
                valorSpinnerN = nuevoValorSpinner;
            }
        });
//SPINNER NIVELES-----------------------------------------------
        // Obtén el valor inicial del JSpinner
        valorSpinnerLvl = (int) spinnnerNivelN.getValue();
        if (valorSpinnerLvl == 1) {
            // Llama a la función para crear un desarrollador de narrativa
            NintendoStudio.crearDesarrolladorNivel(NintendoStudio.driveNivelN, 0, 3, "N", true);
        }

        // Agrega un ChangeListener al JSpinner
        spinnnerNivelN.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtén el nuevo valor del JSpinner
                int nuevoValorSpinnerLvl = (int) spinnnerNivelN.getValue();

                // Compara el nuevo valor del JSpinner con valorSpinner
                if (nuevoValorSpinnerLvl > valorSpinnerLvl) {
                    //FUNCION CREAR DESARROLLADOR NARRATIVA
                    // Llama a la función para crear un desarrollador de nivel
                    NintendoStudio.crearDesarrolladorNivel(NintendoStudio.driveNivelN, 0, 3, "N", true);
                    // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual--;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                } else if (nuevoValorSpinnerLvl < valorSpinnerLvl) {

                    //FUNCION STOP DESARROLLADOR NIVEL
                    NintendoStudio.stopDesarrolladorNivelAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual++;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                }

                // Actualiza valorSpinner con el nuevo valor del JSpinner
                valorSpinnerLvl = nuevoValorSpinnerLvl;
            }
        });

        //SPINNER DLC-----------------------------------------------
// Obtén el valor inicial del JSpinner
        valorSpinnerDLCN = (int) spinnerDLCN.getValue();
        if (valorSpinnerDLCN == 1) {
            // Llama a la función para crear un desarrollador de DLC
            NintendoStudio.crearDesarrolladorDLC(NintendoStudio.driveDLCN, 0, 2, "N", true);
        }

// Agrega un ChangeListener al JSpinner
        spinnerDLCN.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtén el nuevo valor del JSpinner
                int nuevoValorSpinnerDLCB = (int) spinnerDLCN.getValue();

                // Compara el nuevo valor del JSpinner con valorSpinnerDLCB
                if (nuevoValorSpinnerDLCB > valorSpinnerDLCN) {
                    //FUNCION CREAR DESARROLLADOR DLC
                    // Llama a la función para crear un desarrollador de DLC
                    NintendoStudio.crearDesarrolladorDLC(NintendoStudio.driveDLCN, 0, 2, "N", true);
                    // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual--;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                } else if (nuevoValorSpinnerDLCB < valorSpinnerDLCN) {
                    //FUNCION STOP DESARROLLADOR DLC
                    NintendoStudio.stopDesarrolladorDLCAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual++;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                }

                // Actualiza valorSpinnerDLCB con el nuevo valor del JSpinner
                valorSpinnerDLCN = nuevoValorSpinnerDLCB;
            }
        });

        // SPINNER SISTEMAS
        valorSpinnerSistemasN = (int) spinnerSistemasN.getValue();
        if (valorSpinnerSistemasN == 1) {
            // Llama a la funcion para crear un desarrollador de logica
            NintendoStudio.crearDesarrolladorLogic(NintendoStudio.driveLogicN, 1, 0, "N", true);
        }

        spinnerSistemasN.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorSpinnerSistemasB = (int) spinnerSistemasN.getValue();

                if (nuevoValorSpinnerSistemasB > valorSpinnerSistemasN) {

                    NintendoStudio.crearDesarrolladorLogic(NintendoStudio.driveLogicN, 1, 0, "N", true);

                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual--;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));

                } else if (nuevoValorSpinnerSistemasB < valorSpinnerSistemasN) {

                    NintendoStudio.stopDesarrolladorLogicaAleatorio();

                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual++;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                }

                valorSpinnerSistemasN = nuevoValorSpinnerSistemasB;
            }
        });

        // SPINNER SPRITES
        valorSpinnerSpritesN = (int) spinnerSpritesN.getValue();
        if (valorSpinnerSpritesN == 1) {
            // Llama a la funcion para crear un desarrollador de logica
            NintendoStudio.crearDesarrolladorSprites(NintendoStudio.driveSpritesN, 1, 0, "N", true);
        }

        spinnerSpritesN.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorSpinnerSpritesB = (int) spinnerSpritesN.getValue();

                if (nuevoValorSpinnerSpritesB > valorSpinnerSpritesN) {

                    NintendoStudio.crearDesarrolladorSprites(NintendoStudio.driveSpritesN, 1, 0, "N", true);

                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual--;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));

                } else if (nuevoValorSpinnerSpritesB < valorSpinnerSpritesN) {

                    NintendoStudio.stopDesarrolladorSpriteAleatorio();

                    int valorActual = Integer.parseInt(desarrolladoresRestantesN.getText());
                    valorActual++;
                    desarrolladoresRestantesN.setText(Integer.toString(valorActual));
                }

                valorSpinnerSpritesN = nuevoValorSpinnerSpritesB;
            }
        });
    }

    public static void actualizarGuionesEnDrive(int nuevoValor) {
        guionesEnDriveN.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarNivelesEnDrive(int nuevoValor) {
        nivelesEnDriveN.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarDLCsEnDrive(int nuevoValor) {
        DLCEnDriveN.setText(Integer.toString(nuevoValor));
    }

    // Desarrollador Logica
    public static void actualizarSistemasEnDrive(int nuevoValor) {
        SistemasEnDriveN.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarSpritesEnDrive(int nuevoValor) {
        SpritesEnDriveN.setText(Integer.toString(nuevoValor));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinnnerNarrativaN = new javax.swing.JSpinner();
        spinnnerNivelN = new javax.swing.JSpinner();
        spinnerDLCN = new javax.swing.JSpinner();
        spinnerSistemasN = new javax.swing.JSpinner();
        spinnerSpritesN = new javax.swing.JSpinner();
        guionesEnDriveN = new javax.swing.JLabel();
        nivelesEnDriveN = new javax.swing.JLabel();
        DLCEnDriveN = new javax.swing.JLabel();
        SistemasEnDriveN = new javax.swing.JLabel();
        SpritesEnDriveN = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        desarrolladoresRestantesN = new javax.swing.JLabel();
        costosOperativosN = new javax.swing.JLabel();
        mario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logoNintendo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nintendoBackground = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(765, 575));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Costos Operativos = ");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Narrativa = ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" Niveles =");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DLC's =");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 60, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Sistemas =");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Sprites =");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("de 25");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("de 20");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("de 10");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("de 35");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("de 55");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        spinnnerNarrativaN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNarrativaN.setValue(1);
        add(spinnnerNarrativaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        spinnnerNivelN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNivelN.setValue(1);
        add(spinnnerNivelN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        spinnerDLCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerDLCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        spinnerSistemasN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerSistemasN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        spinnerSpritesN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerSpritesN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        guionesEnDriveN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        guionesEnDriveN.setForeground(new java.awt.Color(0, 0, 0));
        guionesEnDriveN.setText("0");
        add(guionesEnDriveN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 30, -1));

        nivelesEnDriveN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nivelesEnDriveN.setForeground(new java.awt.Color(0, 0, 0));
        nivelesEnDriveN.setText("0");
        add(nivelesEnDriveN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 30, -1));

        DLCEnDriveN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DLCEnDriveN.setForeground(new java.awt.Color(0, 0, 0));
        DLCEnDriveN.setText("0");
        add(DLCEnDriveN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 30, -1));

        SistemasEnDriveN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SistemasEnDriveN.setForeground(new java.awt.Color(0, 0, 0));
        SistemasEnDriveN.setText("0");
        add(SistemasEnDriveN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 30, -1));

        SpritesEnDriveN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SpritesEnDriveN.setForeground(new java.awt.Color(0, 0, 0));
        SpritesEnDriveN.setText("0");
        add(SpritesEnDriveN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 30, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Desarrolladores restantes = ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));

        desarrolladoresRestantesN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        desarrolladoresRestantesN.setForeground(new java.awt.Color(0, 0, 0));
        desarrolladoresRestantesN.setText("14");
        add(desarrolladoresRestantesN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 20, 20));

        costosOperativosN.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        costosOperativosN.setForeground(new java.awt.Color(0, 0, 0));
        costosOperativosN.setText("0");
        add(costosOperativosN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 200, -1));

        mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/mario.png"))); // NOI18N
        mario.setText("jLabel3");
        add(mario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/marioMushroom.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 200, 200));

        logoNintendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/nintendoLogo.png"))); // NOI18N
        add(logoNintendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 480, 120));

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Capacidad Drive");
        jPanel1.add(jLabel4);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 130, 180));

        nintendoBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/nintendoBackground.jpg"))); // NOI18N
        nintendoBackground.setText("jLabel2");
        add(nintendoBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));
    }// </editor-fold>//GEN-END:initComponents

    public static JLabel getDLCEnDriveN() {
        return DLCEnDriveN;
    }

    public static void setDLCEnDriveN(JLabel DLCEnDriveN) {
        Nintendo.DLCEnDriveN = DLCEnDriveN;
    }

    public static JLabel getSistemasEnDriveN() {
        return SistemasEnDriveN;
    }

    public static void setSistemasEnDriveN(JLabel SistemasEnDriveN) {
        Nintendo.SistemasEnDriveN = SistemasEnDriveN;
    }

    public static JLabel getSpritesEnDriveN() {
        return SpritesEnDriveN;
    }

    public static void setSpritesEnDriveN(JLabel SpritesEnDriveN) {
        Nintendo.SpritesEnDriveN = SpritesEnDriveN;
    }

    public static JLabel getGuionesEnDriveN() {
        return guionesEnDriveN;
    }

    public static void setGuionesEnDriveN(JLabel guionesEnDriveN) {
        Nintendo.guionesEnDriveN = guionesEnDriveN;
    }

    public static JLabel getNivelesEnDriveN() {
        return nivelesEnDriveN;
    }

    public static void setNivelesEnDriveN(JLabel nivelesEnDriveN) {
        Nintendo.nivelesEnDriveN = nivelesEnDriveN;
    }

    public static JLabel getCostosOperativosN() {
        return costosOperativosN;
    }

    public static void setCostosOperativosN(JLabel costosOperativosN) {
        Nintendo.costosOperativosN = costosOperativosN;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel DLCEnDriveN;
    public static javax.swing.JLabel SistemasEnDriveN;
    public static javax.swing.JLabel SpritesEnDriveN;
    public static javax.swing.JLabel costosOperativosN;
    private javax.swing.JLabel desarrolladoresRestantesN;
    public static javax.swing.JLabel guionesEnDriveN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoNintendo;
    private javax.swing.JLabel mario;
    private javax.swing.JLabel nintendoBackground;
    public static javax.swing.JLabel nivelesEnDriveN;
    private javax.swing.JSpinner spinnerDLCN;
    private javax.swing.JSpinner spinnerSistemasN;
    private javax.swing.JSpinner spinnerSpritesN;
    private javax.swing.JSpinner spinnnerNarrativaN;
    private javax.swing.JSpinner spinnnerNivelN;
    // End of variables declaration//GEN-END:variables
}
