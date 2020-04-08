/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capapresentacion;

import capadatos.CDUser;
import capalogica.CLUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class JFraUser extends javax.swing.JFrame {

    /**
     * Creates new form JFraProducto
     */
    private PreparedStatement ps;
    private ResultSet rs;

    public JFraUser() throws SQLException {
        initComponents();
        fillTableUser();
        findCorrelative();
        enabledButtons(true, false, false, true);
        this.setLocationRelativeTo(null);
    }
    // metodo para limpiar tabla
    private void clearTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.jTblUser.getModel();

        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }

    // Metodo para limpiar TextFields.
    private void clearTextField() {
        this.jTFFirstName.setText("");
        this.jTFUserName.setText("");
        this.jTFLastName.setText("");
        this.jTFAddress.setText("");
        this.jTFPassword.setText("");
        this.jTFPhone.setText("");
    }

    // Metodo que llenar la tabla customerr
    private void fillTableUser() throws SQLException {
        clearTable();

        CDUser cdc = new CDUser();
        List<CLUser> miLista = cdc.getListUser();
        DefaultTableModel temp = (DefaultTableModel) this.jTblUser.getModel();

        for (CLUser clu : miLista) {
            Object[] fila = new Object[7];
            fila[0] = clu.getUserID();
            fila[1] = clu.getFirstName();
            fila[2] = clu.getLastName();
            fila[3] = clu.getPhone();
            fila[4] = clu.getAdress();
            fila[5] = clu.getUserName();
            fila[6] = clu.getPassword();

            temp.addRow(fila);
        }
    }

    // Medoto para buscar en la tabla customer por ID
    private void fillTableCustomerID(String userFirstName) throws SQLException {
        clearTable();

        CDUser cdu = new CDUser();
        List<CLUser> miLista = cdu.getListaUserFirstName(userFirstName);
        DefaultTableModel temp = (DefaultTableModel) this.jTblUser.getModel();

        miLista.stream().map((clu) -> {
            Object[] fila = new Object[7];
            fila[0] = clu.getUserID();
            fila[1] = clu.getFirstName();
            fila[2] = clu.getLastName();
            fila[3] = clu.getPhone();
            fila[4] = clu.getAdress();
            fila[5] = clu.getUserName();
            fila[6] = clu.getPassword();
            return fila;
        }).forEachOrdered((fila) -> {
            temp.addRow(fila);
        });
    }

    // Method to fill the TextField with the selected a row of the JTable.
    private void selectedRow() {
        if (this.jTblUser.getSelectedRow() != -1) {
            this.jTFUserID.setText(String.valueOf(this.jTblUser.getValueAt(this.jTblUser.getSelectedRow(), 0)));
            this.jTFFirstName.setText(String.valueOf(this.jTblUser.getValueAt(this.jTblUser.getSelectedRow(), 1)));
            this.jTFLastName.setText(String.valueOf(this.jTblUser.getValueAt(this.jTblUser.getSelectedRow(), 2)));
            this.jTFPhone.setText(String.valueOf(this.jTblUser.getValueAt(this.jTblUser.getSelectedRow(), 3)));
            this.jTFAddress.setText(String.valueOf(this.jTblUser.getValueAt(this.jTblUser.getSelectedRow(), 4)));
            this.jTFUserName.setText(String.valueOf(this.jTblUser.getValueAt(this.jTblUser.getSelectedRow(), 5)));
            this.jTFPassword.setText(String.valueOf(this.jTblUser.getValueAt(this.jTblUser.getSelectedRow(), 6)));
        }
    }

    // Metodo para optener el ultimo id
    private void findCorrelative() throws SQLException {

        CDUser cdu = new CDUser();
        CLUser clu = new CLUser();

        clu.setUserID(cdu.autoIncrementUserID());
        this.jTFUserID.setText(String.valueOf(clu.getUserID()));

    }

    // metodo para habilitar los botoner
    private void enabledButtons(boolean add, boolean modify, boolean delete, boolean clear) {
        this.jBtnSave.setEnabled(add);
        this.jBtnEdit.setEnabled(modify);
        this.jBtnDelete.setEnabled(delete);
        this.jBtnCancel.setEnabled(clear);
    }
    
    // Method to insert the color in the DB.
    private void insertUser() {
        try {
            CDUser cdu = new CDUser();
            CLUser clu = new CLUser();

            clu.setFirstName(this.jTFFirstName.getText().trim());
            clu.setLastName(this.jTFLastName.getText().trim());
            clu.setPhone(this.jTFPhone.getText().trim());
            clu.setAdress(this.jTFAddress.getText().trim());
            clu.setUserName(this.jTFUserName.getText().trim());
            clu.setPassword(this.jTFPassword.getText().trim());
            cdu.insertUser(clu);

            JOptionPane.showMessageDialog(null, "Record saved successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to save customer: " + ex);
        }
    }
    
    // Method to update the color in the DB.
    private void updateUser() {
        try {
            CDUser cdc = new CDUser();
            CLUser clu = new CLUser();
            clu.setUserID(Integer.parseInt(this.jTFUserID.getText().trim()));
            clu.setFirstName(this.jTFFirstName.getText().trim());
            clu.setLastName(this.jTFLastName.getText().trim());
            clu.setPhone(this.jTFPhone.getText().trim());
            clu.setAdress(this.jTFAddress.getText().trim());
            clu.setUserName(this.jTFUserName.getText().trim());
            clu.setPassword(this.jTFPassword.getText().trim());
            cdc.updateCustomer(clu);

            JOptionPane.showMessageDialog(null, "Record modified successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);

            clearTextField();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to modify color: " + ex);
        }
    }
    
    // Metodo para eliminar customer.
    private void deleteUser() {
        try {
            CDUser cdu = new CDUser();
            CLUser clu = new CLUser();
            clu.setUserID(Integer.parseInt(this.jTFUserID.getText().trim()));
            cdu.deleteUser(clu);

            JOptionPane.showMessageDialog(null, "Record deleted successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to delete color: " + ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLblCerrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTPRegistro = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFUserID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFLastName = new javax.swing.JTextField();
        jTFUserName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jBtnSave = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();
        jTFPhone = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblUser = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTfByUserName = new javax.swing.JTextField();
        jRBByUserName = new javax.swing.JRadioButton();
        jRBAll = new javax.swing.JRadioButton();
        jBtnFind = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

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
        jLabel2.setText("Manage User");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Maintenance1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 90));

        jPanel5.setBackground(new java.awt.Color(121, 134, 203));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(228, 241, 254));

        jLabel1.setText("User ID");

        jTFUserID.setEditable(false);

        jLabel3.setText("Password");

        jLabel4.setText("First Name");

        jLabel5.setText("User Name");

        jLabel6.setText("Last Name");

        jLabel9.setText("Address");

        jLabel10.setText("Phone");

        jBtnSave.setBackground(new java.awt.Color(40, 53, 147));
        jBtnSave.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        jBtnSave.setText("Save");
        jBtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        jBtnEdit.setBackground(new java.awt.Color(40, 53, 147));
        jBtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        jBtnEdit.setText("Edit");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnDelete.setBackground(new java.awt.Color(40, 53, 147));
        jBtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        jBtnDelete.setText("Delete");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnCancel.setBackground(new java.awt.Color(40, 53, 147));
        jBtnCancel.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancel1.png"))); // NOI18N
        jBtnCancel.setText("Cancel");
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTFFirstName)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTFLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jTFPhone))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTFUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3))
                            .addComponent(jTFUserID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jBtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTFFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTFLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );

        jTPRegistro.addTab("Data of user", jPanel2);

        jPanel3.setBackground(new java.awt.Color(228, 241, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FirstName", "LastName", "Phone", "Address", "UserName", "Password"
            }
        ));
        jTblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblUser);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 687, 267));

        jLabel12.setText("Buscar");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jPanel3.add(jTfByUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 302, 30));

        jRBByUserName.setBackground(new java.awt.Color(228, 241, 254));
        buttonGroup1.add(jRBByUserName);
        jRBByUserName.setText("By first name");
        jRBByUserName.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRBByUserNameStateChanged(evt);
            }
        });
        jRBByUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBByUserNameActionPerformed(evt);
            }
        });
        jPanel3.add(jRBByUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jRBAll.setBackground(new java.awt.Color(228, 241, 254));
        buttonGroup1.add(jRBAll);
        jRBAll.setText("All");
        jRBAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBAllActionPerformed(evt);
            }
        });
        jPanel3.add(jRBAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jBtnFind.setBackground(new java.awt.Color(255, 255, 255));
        jBtnFind.setForeground(new java.awt.Color(255, 255, 255));
        jBtnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Find2.png"))); // NOI18N
        jBtnFind.setEnabled(false);
        jBtnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFindActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 40, -1));

        jTPRegistro.addTab("List of user", jPanel3);

        jPanel5.add(jTPRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 720, 390));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 740, 420));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 740, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLblCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMousePressed

    private void jLblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblCerrarMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLblCerrarMouseClicked

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        try {
            insertUser();
            fillTableUser();
            findCorrelative();

        } catch (SQLException ex) {
            Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void jTblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblUserMouseClicked
        selectedRow();
        enabledButtons(false, true, true, true);
    }//GEN-LAST:event_jTblUserMouseClicked

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        try {
            updateUser();
            fillTableUser();
            findCorrelative();
        } catch (SQLException ex) {
            Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        try {
            findCorrelative();
            enabledButtons(true, false, false, true);
            clearTextField();
        } catch (SQLException ex) {
            Logger.getLogger(JFraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnCancelActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        try {
            deleteUser();
            fillTableUser();
            findCorrelative();
        } catch (SQLException ex) {
            Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jRBByUserNameStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRBByUserNameStateChanged

    }//GEN-LAST:event_jRBByUserNameStateChanged

    private void jRBByUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBByUserNameActionPerformed
        if (this.jRBByUserName.isSelected() == true) {
            this.jTfByUserName.setEditable(true);
            this.jBtnFind.setEnabled(true);
        }
    }//GEN-LAST:event_jRBByUserNameActionPerformed

    private void jRBAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAllActionPerformed
        if (this.jRBAll.isSelected() == true) {
            try {
                this.jTfByUserName.setEditable(false);
                this.jTfByUserName.setText("");
                this.jBtnFind.setEnabled(false);
                fillTableUser();
            } catch (SQLException ex) {
                Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jRBAllActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed

        String userFirstName;

        userFirstName = this.jTfByUserName.getText();

        try {
            fillTableCustomerID(userFirstName);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fill table: " + ex);
        }
    }//GEN-LAST:event_jBtnFindActionPerformed

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
            java.util.logging.Logger.getLogger(JFraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFraUser().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFraUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnFind;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRBAll;
    private javax.swing.JRadioButton jRBByUserName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFAddress;
    private javax.swing.JTextField jTFFirstName;
    private javax.swing.JTextField jTFLastName;
    private javax.swing.JTextField jTFPassword;
    private javax.swing.JTextField jTFPhone;
    private javax.swing.JTextField jTFUserID;
    private javax.swing.JTextField jTFUserName;
    private javax.swing.JTabbedPane jTPRegistro;
    private javax.swing.JTable jTblUser;
    private javax.swing.JTextField jTfByUserName;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
