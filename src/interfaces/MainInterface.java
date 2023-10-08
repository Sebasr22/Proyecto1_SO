/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author Sebastian Rodriguez
 */
public class MainInterface extends javax.swing.JFrame {

    /**
     * Creates new form MainInterface
     */
    public MainInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        nintendo1 = new interfaces.Nintendo();
        bethesda1 = new interfaces.Bethesda();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane.setName("tabbedPane"); // NOI18N

        javax.swing.GroupLayout nintendo1Layout = new javax.swing.GroupLayout(nintendo1);
        nintendo1.setLayout(nintendo1Layout);
        nintendo1Layout.setHorizontalGroup(
            nintendo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        nintendo1Layout.setVerticalGroup(
            nintendo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Nintendo", nintendo1);
        tabbedPane.addTab("Bethesda", bethesda1);

        getContentPane().add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents


// Agrega los paneles como pestañas al JTabbedPane

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
                
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaces.Bethesda bethesda1;
    private interfaces.Nintendo nintendo1;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
