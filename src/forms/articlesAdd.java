package forms;

import SQLconection.AdministradorDeConexiones;
import classes.Brand;
import classes.Heading;
import classes.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
public class articlesAdd extends javax.swing.JFrame {
    
    
    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    public articlesAdd() {
        try {
            initComponents();
            cargarRubroCB();
            cargarMarcaCB();
        } catch (SQLException ex) {
            Logger.getLogger(articlesAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        brandCB = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        headingCB = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        observacionField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        precioCostoField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        gananciaField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Nombre:");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        brandCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione.." }));
        brandCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandCBActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        headingCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione.." }));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Marca:");

        jLabel3.setText("Rubro:");

        jLabel6.setText("Stock:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        observacionField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        saveButton.setText("Guardar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(observacionField, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(observacionField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setText("Precio de costo");

        precioCostoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioCostoFieldActionPerformed(evt);
            }
        });

        jLabel17.setText("Precio de venta");

        stockField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(headingCB, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8)
                                    .addComponent(jButton5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(brandCB, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton4))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nameField))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(15, 15, 15)
                            .addComponent(stockField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioCostoField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gananciaField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(headingCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(brandCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(precioCostoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(gananciaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        jLabel1.setText("AÑADIR ARTICULO");

        jButton8.setText("Volver");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton8)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
                                     
        try {
            Item art = new Item();
            art.setName(nameField.getText());
            art.setHeadingCode(Heading.searchHeadingByName(headingCB.getSelectedItem().toString()).getHeadingCode());
            art.setBrandCode(Brand.searchBrandByName(brandCB.getSelectedItem().toString()).getBrandCode());
            art.setStock(Integer.parseInt(stockField.getText()));
            art.setCostPrice(Float.parseFloat(precioCostoField.getText()));
            art.setSalePrice(Float.parseFloat(gananciaField.getText()));
            art.setObservation(observacionField.getText());
            art.setLow(false); //si esta en falso, significa que esta habilitado    
            JOptionPane.showMessageDialog(null, "El articulo ha sido guardado");
            nameField.setText("");
            stockField.setText("");
            gananciaField.setText("");
            precioCostoField.setText("");
            observacionField.setText("");
            
            art.insertarArticulo();
        } catch (Exception ex) {
            Logger.getLogger(articlesAdd.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        main m = new main();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        main m = new main();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void precioCostoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioCostoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioCostoFieldActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        itemAdd form = new itemAdd();
        form.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void brandCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandCBActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        itemAdd form = new itemAdd();
        form.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void stockFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockFieldActionPerformed
    
    public void cargarRubroCB() throws SQLException{

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realizaciÃ³n de la consulta
           String laConsulta = "select * from rubros";
            PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
            stmtlaConsulta.executeQuery();
            ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();

            while (rs.next()) {
                
                headingCB.addItem(rs.getObject(2).toString());
            }
            stmtlaConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
            }
        }
    public void cargarMarcaCB() throws SQLException{

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realizaciÃ³n de la consulta
           String laConsulta = "select * from marcas";
            PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
            stmtlaConsulta.executeQuery();
            ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();

            while (rs.next()) {
                
                brandCB.addItem(rs.getObject(2).toString());
            }
            stmtlaConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }
        }
    public void cargarMarcas() throws SQLException{

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realizacion de la consulta
           String laConsulta = "select * from marcas ";
            PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
            stmtlaConsulta.executeQuery();
            ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();

            brandCB.addItem("Seleccione..");
            while (rs.next()) {
                brandCB.addItem(rs.getObject(2).toString()+" "+rs.getObject(3).toString());
            }
            stmtlaConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }
        }
   public void cargarRubros() throws SQLException{

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realizacion de la consulta
           String laConsulta = "select * from rubros ";
            PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
            stmtlaConsulta.executeQuery();
            ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();

            headingCB.addItem("Seleccione..");
            while (rs.next()) {
                headingCB.addItem(rs.getObject(2).toString()+" "+rs.getObject(3).toString());
            }
            stmtlaConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }
        }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> brandCB;
    private javax.swing.JTextField gananciaField;
    private javax.swing.JComboBox<String> headingCB;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField observacionField;
    private javax.swing.JTextField precioCostoField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField stockField;
    // End of variables declaration//GEN-END:variables
}
