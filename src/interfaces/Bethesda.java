/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import classes.BethesdaStudio;
import classes.Funciones;
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

    public Bethesda() {
        initComponents();

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

                // Compara el nuevo valor del JSpinner con valorSpinner
                if (nuevoValorSpinner > valorSpinnerN) {
                    //FUNCION CREAR DESARROLLADOR NARRATIVA
                    // Llama a la función para crear un desarrollador de narrativa
                    BethesdaStudio.crearDesarrolladorNarrativa(BethesdaStudio.driveNB, 0, 4, "B", true);
                    // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual--;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                } else if (nuevoValorSpinner < valorSpinnerN) {
                    //FUNCION STOP DESARROLLADOR NARRATIVA
                    BethesdaStudio.stopDesarrolladorNarrativaAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                }

                // Actualiza valorSpinner con el nuevo valor del JSpinner
                valorSpinnerN = nuevoValorSpinner;
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

                // Compara el nuevo valor del JSpinner con valorSpinner
                if (nuevoValorSpinnerLvl > valorSpinnerLvl) {
                    //FUNCION CREAR DESARROLLADOR NARRATIVA
                    // Llama a la función para crear un desarrollador de nivel
                    BethesdaStudio.crearDesarrolladorNivel(BethesdaStudio.driveNivelB, 0, 3, "B", true);
                    // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual--;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                } else if (nuevoValorSpinnerLvl < valorSpinnerLvl) {

                    //FUNCION STOP DESARROLLADOR NIVEL
                    BethesdaStudio.stopDesarrolladorNivelAleatorio();
                    // Suma 1 a desarrolladoresRestantesB si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                }

                // Actualiza valorSpinner con el nuevo valor del JSpinner
                valorSpinnerLvl = nuevoValorSpinnerLvl;
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
        logoBethesda = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spinnerSistemasB = new javax.swing.JSpinner();
        SistemasEnDriveB = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spinnerSpritesB = new javax.swing.JSpinner();
        SpritesEnDriveB = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        FondoBethesda = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 603));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        costosOperativosB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        costosOperativosB.setForeground(new java.awt.Color(0, 0, 0));
        costosOperativosB.setText("0");
        add(costosOperativosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 80, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Costos Operativos = ");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Desarrolladores restantes = ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));

        desarrolladoresRestantesB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        desarrolladoresRestantesB.setForeground(new java.awt.Color(0, 0, 0));
        desarrolladoresRestantesB.setText("14");
        add(desarrolladoresRestantesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 20, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Narrativa = ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, -1));

        spinnnerNarrativaB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNarrativaB.setValue(1);
        add(spinnnerNarrativaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Capacidad Drive");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        guionesEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        guionesEnDriveB.setForeground(new java.awt.Color(0, 0, 0));
        guionesEnDriveB.setText("0");
        add(guionesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 30, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("de 25");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" Niveles =");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, 20));

        spinnnerNivelB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNivelB.setValue(1);
        add(spinnnerNivelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        nivelesEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nivelesEnDriveB.setForeground(new java.awt.Color(0, 0, 0));
        nivelesEnDriveB.setText("0");
        add(nivelesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 30, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("de 10");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DLC's =");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 60, -1));

        spinnerDLCB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerDLCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("de 20");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        DLCEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DLCEnDriveB.setForeground(new java.awt.Color(0, 0, 0));
        DLCEnDriveB.setText("0");
        add(DLCEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 30, -1));

        logoBethesda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bethedaLogo.png"))); // NOI18N
        add(logoBethesda, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, -10, 380, 190));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Sistemas =");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        spinnerSistemasB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerSistemasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        SistemasEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SistemasEnDriveB.setForeground(new java.awt.Color(0, 0, 0));
        SistemasEnDriveB.setText("0");
        add(SistemasEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 30, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("de 35");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Sprites =");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        spinnerSpritesB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        add(spinnerSpritesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        SpritesEnDriveB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SpritesEnDriveB.setForeground(new java.awt.Color(0, 0, 0));
        SpritesEnDriveB.setText("0");
        add(SpritesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 30, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("de 55");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        FondoBethesda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Fallout.png"))); // NOI18N
        add(FondoBethesda, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, -180, 970, 830));
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel DLCEnDriveB;
    private javax.swing.JLabel FondoBethesda;
    public static javax.swing.JLabel SistemasEnDriveB;
    public static javax.swing.JLabel SpritesEnDriveB;
    public static javax.swing.JLabel costosOperativosB;
    private javax.swing.JLabel desarrolladoresRestantesB;
    public static javax.swing.JLabel guionesEnDriveB;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel logoBethesda;
    public static javax.swing.JLabel nivelesEnDriveB;
    private javax.swing.JSpinner spinnerDLCB;
    private javax.swing.JSpinner spinnerSistemasB;
    private javax.swing.JSpinner spinnerSpritesB;
    private javax.swing.JSpinner spinnnerNarrativaB;
    private javax.swing.JSpinner spinnnerNivelB;
    // End of variables declaration//GEN-END:variables
}
