/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capapresentacion;

import capadatos.CDColor;
import capadatos.CDProductCategory;
import capadatos.CDProductModel;
import capalogica.CLProductModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author oscarpineda
 */
public class JFraProducto extends javax.swing.JFrame {

    /**
     * Creates new form JFraProducto
     */
    private PreparedStatement ps;
    private ResultSet rs;
    
    public JFraProducto() throws SQLException {
        initComponents();
        loadComboColor();
        loadComboProductCategory();
        this.setLocationRelativeTo(null);
    }
    
    // Method to load data in the Color Combo Box.
    private void loadComboColor() throws SQLException{
        
        CDColor cp = new CDColor();
        
        String[] color = new String[cp.loadColor().size()];
        color = cp.loadColor().toArray(color);
        
        DefaultComboBoxModel modeloColor = new DefaultComboBoxModel(color);
        this.jCBColor.setModel(modeloColor);
        
    }
    
    // Method to load data in the Product Category Combo Box.
    private void loadComboProductCategory() throws SQLException{
        
        CDProductCategory cdc = new CDProductCategory();
        
        String[] productCategory = new String[cdc.loadProductCategory().size()];
        productCategory = cdc.loadProductCategory().toArray(productCategory);
        
        DefaultComboBoxModel modeloProductCategory = new DefaultComboBoxModel(productCategory);
        this.jCBProductCategory.setModel(modeloProductCategory);
        
    }
    
     private void loadComboProductModel() throws SQLException{
        
        CDProductModel cdpm = new CDProductModel();
        CLProductModel clpm = new CLProductModel();
        
        clpm.setProductCategoryName(this.jCBProductCategory.getSelectedItem().toString());
        String[] productModel = new String[cdpm.loadProductModel(clpm).size()];
        productModel= cdpm.loadProductModel(clpm).toArray(productModel);
        
        DefaultComboBoxModel modeloProductModel = new DefaultComboBoxModel(productModel);
        this.jCBProductModel.setModel(modeloProductModel); 
        this.jCBProductModel.setEnabled(true);
    }
    
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLblCerrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTPRegistro = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFCodProduct = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFProductName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFProductNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFWeight = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFListPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSpSize = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jTFStandarCost = new javax.swing.JTextField();
        jCBColor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jCBProductCategory = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCBProductModel = new javax.swing.JComboBox<>();
        jBtnSave = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(40, 53, 147));

        jLblCerrar.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLblCerrar.setForeground(new java.awt.Color(245, 245, 245));
        jLblCerrar.setText("X");
        jLblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLblCerrarMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblCerrarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(245, 245, 245));
        jLabel2.setText("Manage Product");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Product.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                .addComponent(jLblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        jPanel5.setBackground(new java.awt.Color(121, 134, 203));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(228, 241, 254));

        jLabel1.setText("Cod. Product");

        jLabel3.setText("Product Name");

        jLabel4.setText("Product Number");

        jLabel5.setText("Standar Cost");

        jLabel6.setText("List Price");

        jLabel7.setText("Size");

        jLabel8.setText("Color");

        jCBColor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Weight");

        jCBProductCategory.setBackground(new java.awt.Color(255, 255, 255));
        jCBProductCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBProductCategoryItemStateChanged(evt);
            }
        });

        jLabel10.setText("Product Category");

        jLabel11.setText("Product Model");

        jCBProductModel.setBackground(new java.awt.Color(255, 255, 255));
        jCBProductModel.setEnabled(false);

        jBtnSave.setBackground(new java.awt.Color(40, 53, 147));
        jBtnSave.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSave.setText("Save");

        jBtnEdit.setBackground(new java.awt.Color(40, 53, 147));
        jBtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEdit.setText("Edit");

        jBtnDelete.setBackground(new java.awt.Color(40, 53, 147));
        jBtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setText("Delete");

        jBtnCancel.setBackground(new java.awt.Color(40, 53, 147));
        jBtnCancel.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCancel.setText("Cancel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCBProductModel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFProductName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTFCodProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTFProductNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFStandarCost))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTFListPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpSize, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jTFWeight))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jCBColor, 0, 167, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jCBProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBtnSave)
                .addGap(10, 10, 10)
                .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancel)
                .addGap(158, 158, 158))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCodProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFProductNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTFStandarCost, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFListPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jSpSize)
                    .addComponent(jLabel9)
                    .addComponent(jTFWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBColor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jCBProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jCBProductModel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSave)
                    .addComponent(jBtnEdit)
                    .addComponent(jBtnDelete)
                    .addComponent(jBtnCancel))
                .addGap(27, 27, 27))
        );

        jTPRegistro.addTab("Data of products", jPanel2);

        jPanel3.setBackground(new java.awt.Color(228, 241, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Product", "Product Name", "Product Number", "Standar Cost", "List Price", "Size", "Weight", "Color", "Product category", "Product model"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 687, 267));

        jLabel12.setText("Buscar");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 302, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Find.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jTPRegistro.addTab("List of products", jPanel3);

        jPanel5.add(jTPRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 390));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 740, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLblCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMousePressed

    private void jLblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMouseClicked

    private void jCBProductCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBProductCategoryItemStateChanged
        try {
            loadComboProductModel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jCBProductCategoryItemStateChanged

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
            java.util.logging.Logger.getLogger(JFraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFraProducto().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFraProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JComboBox<String> jCBColor;
    private javax.swing.JComboBox<String> jCBProductCategory;
    private javax.swing.JComboBox<String> jCBProductModel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpSize;
    private javax.swing.JTextField jTFCodProduct;
    private javax.swing.JTextField jTFListPrice;
    private javax.swing.JTextField jTFProductName;
    private javax.swing.JTextField jTFProductNumber;
    private javax.swing.JTextField jTFStandarCost;
    private javax.swing.JTextField jTFWeight;
    private javax.swing.JTabbedPane jTPRegistro;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
