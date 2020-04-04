/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capapresentacion;

import capadatos.CDProductCategory;
import capalogica.CLProductCategory;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscarpineda
 */
public class JFraProductCategory extends javax.swing.JFrame {

    /**
     * Creates new form JFraProductCategory
     * @throws java.sql.SQLException
     */
    public JFraProductCategory() throws SQLException {
        initComponents();
        fillTableProductCategory();
        findCorrelative();
        this.jTFCategoryName.requestFocus();
        this.setLocationRelativeTo(null);
    }
    
    // Método para limpiar la tabla.
    private void clearTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.jTblProductCategory.getModel();

        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }
  
    // Método para filtrar la tabla con el filtro del id de la categoría.
    private void fillTableProductCategory() throws SQLException {
        clearTable();

        CDProductCategory cdpc = new CDProductCategory();
        List<CLProductCategory> miLista = cdpc.getListProductCategory();
        DefaultTableModel temp = (DefaultTableModel) this.jTblProductCategory.getModel();

        miLista.stream().map((clpc) -> {
            Object[] fila = new Object[2];
            fila[0] = clpc.getProductCategoryID();
            fila[1] = clpc.getProductCategoryName();
            return fila;
        }).forEachOrdered((fila) -> {
            temp.addRow(fila);
        });
    }
    
    private void fillTableProductCategoryID(int productCategoryID) throws SQLException {
        clearTable();

        CDProductCategory cdpc = new CDProductCategory();
        List<CLProductCategory> miLista = cdpc.getListProductCategoryID(productCategoryID);
        DefaultTableModel temp = (DefaultTableModel) this.jTblProductCategory.getModel();

        miLista.stream().map((clpc) -> {
            Object[] fila = new Object[2];
            fila[0] = clpc.getProductCategoryID();
            fila[1] = clpc.getProductCategoryName();
            return fila;
        }).forEachOrdered((fila) -> {
            temp.addRow(fila);
        });
    }
    
    // Método para habilitar y deshabilitar los botones.
    private void enabledButtons(boolean add, boolean modify, boolean delete, boolean clear ){
        this.jBtnAdd.setEnabled(add);
        this.jBtnEdit.setEnabled(modify);
        this.jBtnDelete.setEnabled(delete);
        this.jBtnClear.setEnabled(clear);
    }
    
    // Método para pasar a los campos de texto los datos de la fila seleccionada en la tabla.
   private void selectedRow(){
        if(this.jTblProductCategory.getSelectedRow() != -1){
            this.jTFCategoryID.setText(String.valueOf(this.jTblProductCategory.getValueAt(this.jTblProductCategory.getSelectedRow(), 0)));
            this.jTFCategoryName.setText(String.valueOf(this.jTblProductCategory.getValueAt(this.jTblProductCategory.getSelectedRow(), 1)));
        }
    }
   
   // Consultar el correlativo de Product Category.
      private void findCorrelative() throws SQLException{
        
        CDProductCategory cdpc = new CDProductCategory();
            CLProductCategory clpc = new CLProductCategory();
        
        clpc.setProductCategoryID(cdpc.autoIncrementProductCategory());
        this.jTFCategoryID.setText(String.valueOf(clpc.getProductCategoryID()));
        
    }
    
    // Método para limpiar las TextField.
    private void clearTextField() {
        this.jTFCategoryID.setText("");
        this.jTFCategoryName.setText("");
    }
    
    // Método para validar que el campo de texto del nombre de la categoría del producto.
    private boolean validarTextField(){
        boolean estado;
        
        estado = this.jTFCategoryName.getText().length() > 0;
        
        return estado;
    }
    
    // Método para insertar una categoría de producto.
      private void insertProductCategory(){
        try{
            CDProductCategory cdpc = new CDProductCategory();
            CLProductCategory clpc = new CLProductCategory();
            clpc.setProductCategoryName(this.jTFCategoryName.getText().trim());
            cdpc.insertProductCategory(clpc);
            
            JOptionPane.showMessageDialog(null, "Record saved successfully...", "AdventureWorksLT System", 
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error to save product category: " + ex);
        }
    }

    private void updateProductCategory() {
        try {
            CDProductCategory cdpc = new CDProductCategory();
            CLProductCategory clpc = new CLProductCategory();
            clpc.setProductCategoryName(this.jTFCategoryName.getText().trim());
            clpc.setProductCategoryID(Integer.parseInt(this.jTFCategoryID.getText().trim()));
            cdpc.updateProductCategory(clpc);

            JOptionPane.showMessageDialog(null, "Record edited successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to edit product category: " + ex);
        }
    }
    
    // Método para eliminar una categoría de producto de la base de datos.
    private void deleteProductCategory() {
        try {
            CDProductCategory cdpc = new CDProductCategory();
            CLProductCategory clpc = new CLProductCategory();            
            clpc.setProductCategoryID(Integer.parseInt(this.jTFCategoryID.getText().trim()));
            cdpc.deleteProductCategory(clpc);

            JOptionPane.showMessageDialog(null, "Record deleted successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to delete product category: " + ex);
        }
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
        jPanel1 = new javax.swing.JPanel();
        jLblCerrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblProductCategory = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jRBByCode = new javax.swing.JRadioButton();
        jRBAll = new javax.swing.JRadioButton();
        jTFByCode = new javax.swing.JTextField();
        jBtnFind = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jBtnClear = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jTFCategoryName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFCategoryID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(710, 340));
        setSize(new java.awt.Dimension(710, 340));
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
        jLabel2.setText("Manage Product Category");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Maintenance1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
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
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 70));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setPreferredSize(new java.awt.Dimension(475, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 640, 10));

        jPanel2.setBackground(new java.awt.Color(121, 134, 203));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(121, 134, 203));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jTblProductCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category ID", "Category Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblProductCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTblProductCategoryMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTblProductCategory);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Find type");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRBAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBByCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFByCode, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnFind)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRBAll)
                        .addComponent(jRBByCode)
                        .addComponent(jTFByCode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        jPanel6.add(jBtnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 263, 47));

        jBtnAdd.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAdd.setForeground(new java.awt.Color(40, 53, 147));
        jBtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        jBtnAdd.setText("Save");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, -1));

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
        jPanel6.add(jBtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 90, -1));

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
        jPanel6.add(jBtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));
        jPanel6.add(jTFCategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 165, 32));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(245, 245, 245));
        jLabel3.setText("Category Name");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 245, 245));
        jLabel1.setText("Category ID");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 28, -1, -1));

        jTFCategoryID.setEditable(false);
        jPanel6.add(jTFCategoryID, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 21, 124, 31));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 650, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLblCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMousePressed

    private void jLblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMouseClicked

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
                fillTableProductCategory();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
            }
        }
    }//GEN-LAST:event_jRBAllActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed
        
         int productCategoryID;

        productCategoryID = Integer.parseInt(this.jTFByCode.getText());

        try {
            fillTableProductCategoryID(productCategoryID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }
    }//GEN-LAST:event_jBtnFindActionPerformed

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        
        if(validarTextField() == true){   
            try {
                insertProductCategory();
                fillTableProductCategory();  
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error fill table: " + ex);;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Write the product category name.", "AdventuresWorsLT", 
                    JOptionPane.INFORMATION_MESSAGE);
            this.jTFCategoryName.requestFocus();
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jTblProductCategoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblProductCategoryMousePressed
        selectedRow();
        enabledButtons(false, true, true, true);
      
    }//GEN-LAST:event_jTblProductCategoryMousePressed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        
        if (validarTextField() == true) {

            try {
                updateProductCategory();
                fillTableProductCategory();
                findCorrelative();
                this.jTFCategoryName.requestFocus();
                enabledButtons(true, false, false, true);  
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error fill table: " + ex);;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Write the product category name.", "AdventuresWorsLT", 
                    JOptionPane.INFORMATION_MESSAGE);
            this.jTFCategoryName.requestFocus();
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
   
        try {
            deleteProductCategory();
            fillTableProductCategory();
            findCorrelative();
            this.jTFCategoryName.requestFocus();
            enabledButtons(true, false, false, true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        } 
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        clearTextField();
        try {
            findCorrelative();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }
    }//GEN-LAST:event_jBtnClearActionPerformed

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
            java.util.logging.Logger.getLogger(JFraProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFraProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFraProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFraProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFraProductCategory().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFraProductCategory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLblCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRBAll;
    private javax.swing.JRadioButton jRBByCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFByCode;
    private javax.swing.JTextField jTFCategoryID;
    private javax.swing.JTextField jTFCategoryName;
    private javax.swing.JTable jTblProductCategory;
    // End of variables declaration//GEN-END:variables
}
