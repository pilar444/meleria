
package forms;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pilar
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
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

        itemButton = new javax.swing.JButton();
        clientButton = new javax.swing.JButton();
        providerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemButton.setBackground(new java.awt.Color(255, 255, 255));
        itemButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        itemButton.setForeground(new java.awt.Color(102, 102, 102));
        itemButton.setText("ARTICULOS");
        itemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemButtonActionPerformed(evt);
            }
        });
        getContentPane().add(itemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        clientButton.setBackground(new java.awt.Color(255, 255, 255));
        clientButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        clientButton.setForeground(new java.awt.Color(102, 102, 102));
        clientButton.setText("CLIENTES");
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 360, 50));

        providerButton.setBackground(new java.awt.Color(255, 255, 255));
        providerButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        providerButton.setForeground(new java.awt.Color(102, 102, 102));
        providerButton.setText("PROVEEDORES");
        providerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(providerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 270, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fondo.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemButtonActionPerformed
        articlesForm form;
        try {
            form = new articlesForm();
            form.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_itemButtonActionPerformed

    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
        clientForm form = new clientForm();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_clientButtonActionPerformed

    private void providerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerButtonActionPerformed
        providerForm form = new providerForm();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_providerButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientButton;
    private javax.swing.JButton itemButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton providerButton;
    // End of variables declaration//GEN-END:variables
}
