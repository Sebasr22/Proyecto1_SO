/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import classes.BethesdaStudio;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Sebastian Rodriguez
 */
public class Bethesda extends javax.swing.JPanel {

    private int valorSpinnerN; // Declarar como miembro de la clase
    private int valorSpinnerLvl;

    public Bethesda() {
        initComponents();
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

                    //FUNCION STOP DESARROLLADOR NARRATIVA
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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

        setPreferredSize(new java.awt.Dimension(720, 603));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Bethesda");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 170, 68));

        jLabel2.setText("Desarrolladores restantes = ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        desarrolladoresRestantesB.setText("14");
        add(desarrolladoresRestantesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        jLabel3.setText("Narrativa = ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 70, -1));

        spinnnerNarrativaB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNarrativaB.setValue(1);
        add(spinnnerNarrativaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel4.setText("Capacidad Drive");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        guionesEnDriveB.setText("0");
        add(guionesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 30, -1));

        jLabel6.setText("de 25");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jLabel5.setText(" Niveles =");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 50, 20));

        spinnnerNivelB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNivelB.setValue(1);
        add(spinnnerNivelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        nivelesEnDriveB.setText("0");
        add(nivelesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 30, -1));

        jLabel7.setText("de 20");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));
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

    public static JLabel getNivelesEnDriveB() {
        return nivelesEnDriveB;
    }

    public static void setNivelesEnDriveB(JLabel nivelesEnDriveB) {
        Bethesda.nivelesEnDriveB = nivelesEnDriveB;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel desarrolladoresRestantesB;
    public static javax.swing.JLabel guionesEnDriveB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel nivelesEnDriveB;
    private javax.swing.JSpinner spinnnerNarrativaB;
    private javax.swing.JSpinner spinnnerNivelB;
    // End of variables declaration//GEN-END:variables
}
