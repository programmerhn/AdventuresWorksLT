/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capapresentacion;

import capadatos.CDColor;
import capalogica.CLColor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscarpineda
 * comentario prueba
 */
public class JFraColor extends javax.swing.JFrame {

    /**
     * Creates new form JFraColor
     * @throws java.sql.SQLException
     */
    public JFraColor() throws SQLException {
        initComponents();
        fillTableColor();
        enabledButtons(true, false, false, true);
        findCorrelative();
        this.jTFColorName.requestFocus();
        this.setLocationRelativeTo(null);
        
    }
    
    // Method to clear the jTable.
    private void clearTable(){
        DefaultTableModel dtm = (DefaultTableModel) this.jTblColores.getModel();
        
        while(dtm.getRowCount() > 0){
            dtm.removeRow(0);
        }
    }
    
    // Method to fill of data the jTable.
    private void fillTableColor() throws SQLException{
        clearTable();
        
        CDColor cdc = new CDColor();
        List<CLColor> miLista = cdc.getListColor();
        DefaultTableModel temp = (DefaultTableModel) this.jTblColores.getModel();
        
       for(CLColor cl: miLista) {
            Object[] fila = new Object[2];
            fila[0] = cl.getColorID();
            fila[1] = cl.getColorName();
            temp.addRow(fila);
        }
    }
    
    // Method to fill of data the jTable filtered by color ID.
    private void fillTableColorID(int colorID) throws SQLException{
        clearTable();
        
        CDColor cdc = new CDColor();
        List<CLColor> miLista = cdc.getListaColorID(colorID);
        DefaultTableModel temp = (DefaultTableModel) this.jTblColores.getModel();
        
        miLista.stream().map((cl) -> {
            Object[] fila = new Object[2];
            fila[0] = cl.getColorID();
            fila[1] = cl.getColorName();
            return fila;
        }).forEachOrdered((fila) -> {
            temp.addRow(fila);
        });
    }
    
    // Method to enabled the buttons.
    private void enabledButtons(boolean add, boolean modify, boolean delete, boolean clear ){
        this.jBtnAdd.setEnabled(add);
        this.jBtnModify.setEnabled(modify);
        this.jBtnDelete.setEnabled(delete);
        this.jBtnClear.setEnabled(clear);
    }
    
    // Method to fill the TextField with the selected a row of the JTable.
    private void selectedRow(){
        if(this.jTblColores.getSelectedRow() != -1){
            this.jTFColorID.setText(String.valueOf(this.jTblColores.getValueAt(this.jTblColores.getSelectedRow(), 0)));
            this.jTFColorName.setText(String.valueOf(this.jTblColores.getValueAt(this.jTblColores.getSelectedRow(), 1)));
        }
    }
    
    // Method to consult the correlative ID of the color.
    private void findCorrelative() throws SQLException{
        
        CDColor cdc = new CDColor();
        CLColor cl = new CLColor();
        
        cl.setColorID(cdc.autoIncrementColorID());
        this.jTFColorID.setText(String.valueOf(cl.getColorID()));
        
    }
    
    // Method to clear the TextFields.
    private void clearTextField(){
        this.jTFColorID.setText("");
        this.jTFColorName.setText("");
    }
    
    // Method to insert the color in the DB.
    private void insertColor(){
        try{
            CDColor cdc = new CDColor();
            CLColor cl = new CLColor();
            cl.setColorName(this.jTFColorName.getText().trim());
            cdc.insertColor(cl);
            
            JOptionPane.showMessageDialog(null, "Record saved successfully...", "AdventureWorksLT System", 
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error to save color: " + ex);
        }
    }
    
    // Method to update the color in the DB.
    private void updateColor(){
        try{
            CDColor cdc = new CDColor();
            CLColor cl = new CLColor();
            cl.setColorID(Integer.parseInt(this.jTFColorID.getText().trim()));
            cl.setColorName(this.jTFColorName.getText().trim());
            cdc.updateColor(cl);
            
            JOptionPane.showMessageDialog(null, "Record modified successfully...", "AdventureWorksLT System", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            clearTextField();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error to modify color: " + ex);
        }
    }
    
    // Method to delete the color in the DB.
    private void deleteColor(){
        try{
            CDColor cdc = new CDColor();
            CLColor cl = new CLColor();
            cl.setColorID(Integer.parseInt(this.jTFColorID.getText().trim()));
            cdc.deleteColor(cl);
            
            JOptionPane.showMessageDialog(null, "Record deleted successfully...", "AdventureWorksLT System", 
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error to delete color: " + ex);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblColores = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jRBByCode = new javax.swing.JRadioButton();
        jRBAll = new javax.swing.JRadioButton();
        jTFByCode = new javax.swing.JTextField();
        jBtnFind = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jBtnClear = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        jBtnModify = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jTFColorName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFColorID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(680, 340));
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
        jLabel2.setText("Manage Color");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 70));

        jPanel2.setBackground(new java.awt.Color(121, 134, 203));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(121, 134, 203));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jTblColores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Color ID", "Color Name"
            }
        ));
        jTblColores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblColoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblColores);

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
                        .addGap(0, 11, Short.MAX_VALUE))))
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

        jBtnClear.setBackground(new java.awt.Color(255, 255, 255));
        jBtnClear.setForeground(new java.awt.Color(40, 53, 147));
        jBtnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancel1.png"))); // NOI18N
        jBtnClear.setText("Clear");

        jBtnAdd.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAdd.setForeground(new java.awt.Color(40, 53, 147));
        jBtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        jBtnAdd.setText("Save");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnModify.setBackground(new java.awt.Color(255, 255, 255));
        jBtnModify.setForeground(new java.awt.Color(40, 53, 147));
        jBtnModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        jBtnModify.setText("Edit");
        jBtnModify.setEnabled(false);
        jBtnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModifyActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(245, 245, 245));
        jLabel3.setText("Color Name");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 245, 245));
        jLabel1.setText("Color ID");

        jTFColorID.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFColorID, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFColorName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jBtnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jBtnAdd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnDelete))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFColorID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFColorName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnModify)
                    .addComponent(jBtnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 680, 250));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setPreferredSize(new java.awt.Dimension(475, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 680, 10));

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
            insertColor();
            findCorrelative();
            fillTableColor();
            enabledButtons(true, false, false, true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }
        
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModifyActionPerformed
        try {
            updateColor();
            findCorrelative();
            fillTableColor();
            enabledButtons(true, false, false, true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }  
    }//GEN-LAST:event_jBtnModifyActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
          try {
            deleteColor();
            findCorrelative();
            fillTableColor();
            enabledButtons(true, false, false, true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }  
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed

        int colorID;

        colorID = Integer.parseInt(this.jTFByCode.getText());

        try {
            fillTableColorID(colorID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }
    }//GEN-LAST:event_jBtnFindActionPerformed

    private void jRBAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAllActionPerformed
        if(this.jRBAll.isSelected()== true){
            this.jTFByCode.setEditable(false);
            this.jTFByCode.setText("");
            this.jBtnFind.setEnabled(false);
        }
    }//GEN-LAST:event_jRBAllActionPerformed

    private void jRBByCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBByCodeActionPerformed

        if(this.jRBByCode.isSelected()== true){
            this.jTFByCode.setEditable(true);
            this.jBtnFind.setEnabled(true);
        }
    }//GEN-LAST:event_jRBByCodeActionPerformed

    private void jRBByCodeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRBByCodeStateChanged

    }//GEN-LAST:event_jRBByCodeStateChanged

    private void jTblColoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblColoresMouseClicked

        selectedRow();
        enabledButtons(false, true, true, true);
    }//GEN-LAST:event_jTblColoresMouseClicked

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
            java.util.logging.Logger.getLogger(JFraColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFraColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFraColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFraColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFraColor().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFraColor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnFind;
    private javax.swing.JButton jBtnModify;
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
    private javax.swing.JTextField jTFColorID;
    private javax.swing.JTextField jTFColorName;
    private javax.swing.JTable jTblColores;
    // End of variables declaration//GEN-END:variables
}
