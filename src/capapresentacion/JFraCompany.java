/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capapresentacion;

import capadatos.CDCompany;
import capalogica.CLCompany;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CLIENTE
 */
public class JFraCompany extends javax.swing.JFrame {

    /**
     * Creates new form JFraCompany
     */
    public JFraCompany() throws SQLException {
        initComponents();
        fillTableCompanyName();
        findCorrelative();
        this.setLocationRelativeTo(null);
        
    }
    
    private boolean validarTextField(){
        boolean estado;
        
        estado = this.jTFModelName.getText().length() > 0;
        
        return estado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jBtnClear = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jTFModelName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTFModelID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblCompanyName = new javax.swing.JTable();
        jRBByCode = new javax.swing.JRadioButton();
        jRBAll = new javax.swing.JRadioButton();
        jTFByCode = new javax.swing.JTextField();
        jBtnFind = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLblCerrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(121, 134, 203));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(121, 134, 203));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnClear.setBackground(new java.awt.Color(255, 255, 255));
        jBtnClear.setForeground(new java.awt.Color(40, 53, 147));
        jBtnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancel1.png"))); // NOI18N
        jBtnClear.setText("Clear");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 310, 47));

        jBtnAdd.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAdd.setForeground(new java.awt.Color(40, 53, 147));
        jBtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        jBtnAdd.setText("Save");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jBtnEdit.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEdit.setForeground(new java.awt.Color(40, 53, 147));
        jBtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        jBtnEdit.setText("Edit");
        jBtnEdit.setEnabled(false);
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 90, -1));

        jBtnDelete.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setForeground(new java.awt.Color(40, 53, 147));
        jBtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        jBtnDelete.setText("Delete");
        jBtnDelete.setEnabled(false);
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        jPanel6.add(jTFModelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 165, 32));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 245, 245));
        jLabel1.setText("Company ID");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jTFModelID.setEditable(false);
        jPanel6.add(jTFModelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 140, 31));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 245, 245));
        jLabel6.setText("Company Name");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.setBackground(new java.awt.Color(121, 134, 203));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jTblCompanyName.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company Name ID", "Company Name"
            }
        ));
        jTblCompanyName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblCompanyNameMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblCompanyName);

        buttonGroup1.add(jRBByCode);
        jRBByCode.setForeground(new java.awt.Color(255, 255, 255));
        jRBByCode.setText("By Code");
        jRBByCode.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRBByCodeStateChanged(evt);
            }
        });
        jRBByCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBByCodeActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBAll);
        jRBAll.setForeground(new java.awt.Color(255, 255, 255));
        jRBAll.setText("All");
        jRBAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBAllActionPerformed(evt);
            }
        });

        jTFByCode.setEditable(false);

        jBtnFind.setBackground(new java.awt.Color(255, 255, 255));
        jBtnFind.setForeground(new java.awt.Color(255, 255, 255));
        jBtnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Find2.png"))); // NOI18N
        jBtnFind.setEnabled(false);
        jBtnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFindActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Find Company");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRBAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBByCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFByCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnFind)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRBAll)
                        .addComponent(jRBByCode)
                        .addComponent(jTFByCode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );

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
        jLabel2.setText("Company");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Maintenance1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLblCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMousePressed

    private void jLblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMouseClicked

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        try {
            // TODO add your handling code here:
            if(validarTextField())
            {
                insertCompanyName();
                fillTableCompanyName();
            }
            else{
                return;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JFraCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jRBByCodeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRBByCodeStateChanged

    }//GEN-LAST:event_jRBByCodeStateChanged

    private void jRBByCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBByCodeActionPerformed

        if(this.jRBByCode.isSelected()== true){
            this.jTFByCode.setEditable(true);
            this.jBtnFind.setEnabled(true);
        }
    }//GEN-LAST:event_jRBByCodeActionPerformed

    private void jRBAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAllActionPerformed
        if(this.jRBAll.isSelected()== true){
            this.jTFByCode.setEditable(false);
            this.jTFByCode.setText("");
            this.jBtnFind.setEnabled(false);
            try {
                fillTableCompanyName();
            } catch (SQLException ex) {
                Logger.getLogger(JFraCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jRBAllActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed

        int CompanyNameID;

        CompanyNameID = Integer.parseInt(this.jTFByCode.getText());

        try {
            fillTableCompanyNameID(CompanyNameID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }
    }//GEN-LAST:event_jBtnFindActionPerformed

    private void jTblCompanyNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblCompanyNameMouseClicked
        selectedRow();
        enabledButtons(false,true,true,true);
    }//GEN-LAST:event_jTblCompanyNameMouseClicked

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        // TODO add your handling code here:
        
        try {
            
            if(validarTextField())
            {
                updateCompanyName();
                findCorrelative();
                fillTableCompanyName();
                enabledButtons(true, false, false, true);
            }
            else{
                return;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        } 
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        clearTextField();
        enabledButtons(true, false, false, true);
        try {
            fillTableCompanyName();
            findCorrelative();
        } catch (SQLException ex) {
            Logger.getLogger(JFraCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        try {
            if(validarTextField())
            {
                deleteCompanyName();
                findCorrelative();
                fillTableCompanyName();
                enabledButtons(true, false, false, true);
            }
            else{
                return;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }  
    }//GEN-LAST:event_jBtnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(JFraCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFraCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFraCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFraCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFraCompany().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFraCompany.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void clearTextField() {
        this.jTFModelID.setText("");
        this.jTFModelName.setText("");
    }
    
        // Método para insertar una categoría de producto.
    private void insertCompanyName(){
        try{
            CDCompany cdc = new CDCompany();
            CLCompany clc = new CLCompany();
            clc.setCompanyName(this.jTFModelName.getText().trim());
            cdc.insertCompanyName(clc);
            
            JOptionPane.showMessageDialog(null, "Record saved successfully...", "AdventureWorksLT System", 
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error to save company name: " + ex);
        }
    }

    private void updateCompanyName() {
        try {
            CDCompany cdc = new CDCompany();
            CLCompany clc = new CLCompany();
            clc.setCompanyName(this.jTFModelName.getText().trim());
            clc.setCompanyNameID(Integer.parseInt(this.jTFModelID.getText().trim()));
            cdc.updateCompanyName(clc);

            JOptionPane.showMessageDialog(null, "Record edited successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to edit company name: " + ex);
        }
    }
    
    // Método para eliminar una categoría de producto de la base de datos.
    private void deleteCompanyName() {
        try {
            CDCompany cdc = new CDCompany();
            CLCompany clc = new CLCompany();           
            clc.setCompanyNameID(Integer.parseInt(this.jTFModelID.getText().trim()));
            cdc.deleteProductCategory(clc);

            JOptionPane.showMessageDialog(null, "Record deleted successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to delete company name: " + ex);
        }
    }
    
    private void clearTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.jTblCompanyName.getModel();

        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }
    
    
    private void fillTableCompanyName() throws SQLException {
        clearTable();

        CDCompany cdc = new CDCompany();
        List<CLCompany> miLista = cdc.getListCompanyName();
        DefaultTableModel temp = (DefaultTableModel) this.jTblCompanyName.getModel();

        miLista.stream().map((clc) -> {
            Object[] fila = new Object[2];
            fila[0] = clc.getCompanyNameID();
            fila[1] = clc.getCompanyName();
            return fila;
        }).forEachOrdered((fila) -> {
            temp.addRow(fila);
        });
    }
    
    private void fillTableCompanyNameID(int CompanyNameID) throws SQLException {
        clearTable();

         CDCompany cdc = new CDCompany();
        List<CLCompany> miLista = cdc.getListCompanyNameID(CompanyNameID);
        DefaultTableModel temp = (DefaultTableModel) this.jTblCompanyName.getModel();

        miLista.stream().map((clc) -> {
            Object[] fila = new Object[2];
            fila[0] = clc.getCompanyNameID();
            fila[1] = clc.getCompanyName();
            return fila;
        }).forEachOrdered((fila) -> {
            temp.addRow(fila);
        });
    }
    
        private void enabledButtons(boolean add, boolean modify, boolean delete, boolean clear ){
        this.jBtnAdd.setEnabled(add);
        this.jBtnEdit.setEnabled(modify);
        this.jBtnDelete.setEnabled(delete);
        this.jBtnClear.setEnabled(clear);
    }
    
    
    private void selectedRow(){
        if(this.jTblCompanyName.getSelectedRow() != -1){
            this.jTFModelID.setText(String.valueOf(this.jTblCompanyName.getValueAt(this.jTblCompanyName.getSelectedRow(), 0)));
            this.jTFModelName.setText(String.valueOf(this.jTblCompanyName.getValueAt(this.jTblCompanyName.getSelectedRow(), 1)));
        }
    }
    
   
    private void findCorrelative() throws SQLException{
        
        CDCompany cdc = new CDCompany();
        CLCompany clc = new CLCompany();
        
        clc.setCompanyNameID(cdc.autoIncrementCompanyName());
        this.jTFModelID.setText(String.valueOf(clc.getCompanyNameID()));
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLblCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRBAll;
    private javax.swing.JRadioButton jRBByCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFByCode;
    private javax.swing.JTextField jTFModelID;
    private javax.swing.JTextField jTFModelName;
    private javax.swing.JTable jTblCompanyName;
    // End of variables declaration//GEN-END:variables
}
