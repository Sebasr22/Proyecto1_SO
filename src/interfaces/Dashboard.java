/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.UtilidadChart;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Dashboard extends javax.swing.JPanel {
    public static int duracionDiasSegundos;
    public static int diasParaEntrega;
    public static int narrativaBethesda;
    public static int nivelesBethesda;
    public static int dlcsBethesda;
    public static int sistemasBethesda;
    public static int spritesBethesda;
    public static int integradoresBethesda;
    public static int narrativaNintendo;
    public static int nivelesNintendo;
    public static int dlcsNintendo;
    public static int sistemasNintendo;
    public static int spritesNintendo;
    public static int integradoresNintendo;

    /**
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        cargarValoresDesdeArchivo();
        cargarValoresEnSpinners(); 
        
    }
public static void cargarValoresDesdeArchivo() {
        try ( FileReader fileReader = new FileReader("src/assets/valoresIniciales.txt");  Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    switch (key) {
                        case "duracionDiasSegundos":
                            duracionDiasSegundos = Integer.parseInt(value);
                            break;
                        case "diasParaEntrega":
                            diasParaEntrega = Integer.parseInt(value);
                            break;
                        case "narrativaBethesda":
                            narrativaBethesda = Integer.parseInt(value);
                            break;
                        case "nivelesBethesda":
                            nivelesBethesda = Integer.parseInt(value);
                            break;
                        case "dlcsBethesda":
                            dlcsBethesda = Integer.parseInt(value);
                            break;
                        case "sistemasBethesda":
                            sistemasBethesda = Integer.parseInt(value);
                            break;
                        case "spritesBethesda":
                            spritesBethesda = Integer.parseInt(value);
                            break;
                        case "integradoresBethesda":
                            integradoresBethesda = Integer.parseInt(value);
                            break;
                        case "narrativaNintendo":
                            narrativaNintendo = Integer.parseInt(value);
                            break;
                        case "nivelesNintendo":
                            nivelesNintendo = Integer.parseInt(value);
                            break;
                        case "dlcsNintendo":
                            dlcsNintendo = Integer.parseInt(value);
                            break;
                        case "sistemasNintendo":
                            sistemasNintendo = Integer.parseInt(value);
                            break;
                        case "spritesNintendo":
                            spritesNintendo = Integer.parseInt(value);
                            break;
                        case "integradoresNintendo":
                            integradoresNintendo = Integer.parseInt(value);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarValoresEnTxt() {
        try ( FileWriter fileWriter = new FileWriter("src/assets/valoresIniciales.txt")) {
            fileWriter.write("duracionDiasSegundos=" + spinnerDuracionDias.getValue() + "\n");
            fileWriter.write("diasParaEntrega=" + spinnerDiasParaEntrega.getValue() + "\n");
            fileWriter.write("narrativaBethesda=" + spinnnerNarrativaB.getValue() + "\n");
            fileWriter.write("nivelesBethesda=" + spinnnerNivelB.getValue() + "\n");
            fileWriter.write("dlcsBethesda=" + spinnerDLCB.getValue() + "\n");
            fileWriter.write("sistemasBethesda=" + spinnerSistemasB.getValue() + "\n");
            fileWriter.write("spritesBethesda=" + spinnerSpritesB.getValue() + "\n");
            fileWriter.write("integradoresBethesda=" + spinnerIntegradoresB.getValue() + "\n");
            fileWriter.write("narrativaNintendo=" + spinnnerNarrativaN.getValue() + "\n");
            fileWriter.write("nivelesNintendo=" + spinnnerNivelN.getValue() + "\n");
            fileWriter.write("dlcsNintendo=" + spinnerDLCN.getValue() + "\n");
            fileWriter.write("sistemasNintendo=" + spinnerSistemasN.getValue() + "\n");
            fileWriter.write("spritesNintendo=" + spinnerSpritesN.getValue() + "\n");
            fileWriter.write("integradoresNintendo=" + spinnerIntegradoresN.getValue() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarValoresEnSpinners() {
        spinnerDuracionDias.setValue(duracionDiasSegundos);
        spinnerDiasParaEntrega.setValue(diasParaEntrega);
        spinnnerNarrativaB.setValue(narrativaBethesda);
        spinnnerNivelB.setValue(nivelesBethesda);
        spinnerDLCB.setValue(dlcsBethesda);
        spinnerSistemasB.setValue(sistemasBethesda);
        spinnerSpritesB.setValue(spritesBethesda);
        spinnerIntegradoresB.setValue(integradoresBethesda);
        spinnnerNarrativaN.setValue(narrativaNintendo);
        spinnnerNivelN.setValue(nivelesNintendo);
        spinnerDLCN.setValue(dlcsNintendo);
        spinnerSistemasN.setValue(sistemasNintendo);
        spinnerSpritesN.setValue(spritesNintendo);
        spinnerIntegradoresN.setValue(integradoresNintendo);
    }
    public static void generarGrafico(){
        UtilidadChart chart = new UtilidadChart(); // Crea una instancia de UtilidadChart
        chartPanel.add(chart); // Agrega el gráfico a chartPanel
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spinnerDuracionDias = new javax.swing.JSpinner();
        spinnerDiasParaEntrega = new javax.swing.JSpinner();
        chartPanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        desarrolladoresRestantesB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        spinnnerNarrativaB = new javax.swing.JSpinner();
        spinnnerNivelB = new javax.swing.JSpinner();
        spinnerDLCB = new javax.swing.JSpinner();
        spinnerSistemasB = new javax.swing.JSpinner();
        spinnerSpritesB = new javax.swing.JSpinner();
        spinnerIntegradoresB = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        spinnnerNarrativaN = new javax.swing.JSpinner();
        spinnnerNivelN = new javax.swing.JSpinner();
        spinnerDLCN = new javax.swing.JSpinner();
        spinnerSistemasN = new javax.swing.JSpinner();
        spinnerSpritesN = new javax.swing.JSpinner();
        spinnerIntegradoresN = new javax.swing.JSpinner();
        desarrolladoresRestantesN = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 603));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spinnerDuracionDias.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        add(spinnerDuracionDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 30, -1));

        spinnerDiasParaEntrega.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        add(spinnerDiasParaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 40, -1));
        add(chartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 430, 410));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("DashBoard Principal");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valores Iniciales");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Días para entrega = ");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, 20));

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("GUARDAR");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 80, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Duración del días (segundos) = ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NintendoStudio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Desarrolladores restantes = ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 200, -1));

        desarrolladoresRestantesB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        desarrolladoresRestantesB.setForeground(new java.awt.Color(255, 255, 255));
        desarrolladoresRestantesB.setText("9");
        jPanel1.add(desarrolladoresRestantesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 20, 20));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("BethesdaStudio");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Narrativa = ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Niveles =");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DLC's =");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 60, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sistemas =");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Sprites =");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Integradores =");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        spinnnerNarrativaB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNarrativaB.setValue(1);
        jPanel1.add(spinnnerNarrativaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        spinnnerNivelB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNivelB.setValue(1);
        jPanel1.add(spinnnerNivelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        spinnerDLCB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerDLCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        spinnerSistemasB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerSistemasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        spinnerSpritesB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerSpritesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        spinnerIntegradoresB.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerIntegradoresB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Desarrolladores restantes = ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Narrativa = ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 80, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Niveles =");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 70, 20));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DLC's =");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 60, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sistemas =");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sprites =");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Integradores =");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        spinnnerNarrativaN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNarrativaN.setValue(1);
        jPanel1.add(spinnnerNarrativaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        spinnnerNivelN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnnerNivelN.setValue(1);
        jPanel1.add(spinnnerNivelN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        spinnerDLCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerDLCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        spinnerSistemasN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerSistemasN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        spinnerSpritesN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerSpritesN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        spinnerIntegradoresN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        jPanel1.add(spinnerIntegradoresN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        desarrolladoresRestantesN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        desarrolladoresRestantesN.setForeground(new java.awt.Color(255, 255, 255));
        desarrolladoresRestantesN.setText("12");
        jPanel1.add(desarrolladoresRestantesN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 20, 20));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 280, 410));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dashboard_background.png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardarValoresEnTxt();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    public static javax.swing.JPanel chartPanel;
    private javax.swing.JLabel desarrolladoresRestantesB;
    private javax.swing.JLabel desarrolladoresRestantesN;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spinnerDLCB;
    private javax.swing.JSpinner spinnerDLCN;
    private javax.swing.JSpinner spinnerDiasParaEntrega;
    private javax.swing.JSpinner spinnerDuracionDias;
    private javax.swing.JSpinner spinnerIntegradoresB;
    private javax.swing.JSpinner spinnerIntegradoresN;
    private javax.swing.JSpinner spinnerSistemasB;
    private javax.swing.JSpinner spinnerSistemasN;
    private javax.swing.JSpinner spinnerSpritesB;
    private javax.swing.JSpinner spinnerSpritesN;
    private javax.swing.JSpinner spinnnerNarrativaB;
    private javax.swing.JSpinner spinnnerNarrativaN;
    private javax.swing.JSpinner spinnnerNivelB;
    private javax.swing.JSpinner spinnnerNivelN;
    // End of variables declaration//GEN-END:variables
}
