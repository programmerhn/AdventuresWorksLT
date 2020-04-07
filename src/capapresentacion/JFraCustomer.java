/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capapresentacion;

import capadatos.CDCustomer;
import capalogica.CLCustomer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscarpineda
 */
public class JFraCustomer extends javax.swing.JFrame {

    /**
     * Creates new form JFraProducto
     */
    private PreparedStatement ps;
    private ResultSet rs;

    public JFraCustomer() throws SQLException {
        initComponents();
        fillTableCustomer();
        findCorrelative();
        loadComboCompanyName();
        enabledButtons(true, false, false, true);
        this.setLocationRelativeTo(null);
    }
    // metodo para limpiar tabla
    private void clearTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.jTblCustomer.getModel();

        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }

    // Metodo para limpiar TextFields.
    private void clearTextField() {
        this.jTFFirstName.setText("");
        this.jTFMiddleName.setText("");
        this.jTFLastName.setText("");
        this.jTFEmail.setText("");
        this.jTFTitle.setText("");
        this.jTFPhone.setText("");
        this.jCBCompanyName.setSelectedIndex(0);
    }

    // Metodo para cargar la comboBox de companyName
    private void loadComboCompanyName() throws SQLException {

        CDCustomer cp = new CDCustomer();

        String[] color = new String[cp.loadCompanyName().size()];
        color = cp.loadCompanyName().toArray(color);

        DefaultComboBoxModel modeloColor = new DefaultComboBoxModel(color);
        this.jCBCompanyName.setModel(modeloColor);
    }

    // Metodo que llenar la tabla customerr
    private void fillTableCustomer() throws SQLException {
        clearTable();

        CDCustomer cdc = new CDCustomer();
        List<CLCustomer> miLista = cdc.getListCustomer();
        DefaultTableModel temp = (DefaultTableModel) this.jTblCustomer.getModel();

        for (CLCustomer cl : miLista) {
            Object[] fila = new Object[8];
            fila[0] = cl.getCustomerID();
            fila[1] = cl.getTitle();
            fila[2] = cl.getFirstName();
            fila[3] = cl.getMiddleName();
            fila[4] = cl.getLastName();
            fila[5] = cl.getEmailAddress();
            fila[6] = cl.getPhone();
            fila[7] = cl.getCompanyName();

            temp.addRow(fila);
        }
    }

    // Medoto para buscar en la tabla customer por ID
    private void fillTableCustomerID(String customerFirstName) throws SQLException {
        clearTable();

        CDCustomer cdc = new CDCustomer();
        List<CLCustomer> miLista = cdc.getListaCustomerFirstName(customerFirstName);
        DefaultTableModel temp = (DefaultTableModel) this.jTblCustomer.getModel();

        miLista.stream().map((cl) -> {
            Object[] fila = new Object[8];
            fila[0] = cl.getCustomerID();
            fila[1] = cl.getTitle();
            fila[2] = cl.getFirstName();
            fila[3] = cl.getMiddleName();
            fila[4] = cl.getLastName();
            fila[5] = cl.getEmailAddress();
            fila[6] = cl.getPhone();
            fila[7] = cl.getCompanyName();
            return fila;
        }).forEachOrdered((fila) -> {
            temp.addRow(fila);
        });
    }

    // Method to fill the TextField with the selected a row of the JTable.
    private void selectedRow() {
        if (this.jTblCustomer.getSelectedRow() != -1) {
            this.jTFIdCustomer.setText(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 0)));
            this.jTFTitle.setText(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 1)));
            this.jTFFirstName.setText(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 2)));
            this.jTFMiddleName.setText(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 3)));
            this.jTFLastName.setText(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 4)));
            this.jTFEmail.setText(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 5)));
            this.jTFPhone.setText(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 6)));
            this.jCBCompanyName.setSelectedItem(String.valueOf(this.jTblCustomer.getValueAt(this.jTblCustomer.getSelectedRow(), 7)));
        }
    }

    // Metodo para optener el ultimo id
    private void findCorrelative() throws SQLException {

        CDCustomer cdc = new CDCustomer();
        CLCustomer cl = new CLCustomer();

        cl.setCustomerID(cdc.autoIncrementColorID());
        this.jTFIdCustomer.setText(String.valueOf(cl.getCustomerID()));

    }

    // metodo para habilitar los botoner
    private void enabledButtons(boolean add, boolean modify, boolean delete, boolean clear) {
        this.jBtnSave.setEnabled(add);
        this.jBtnEdit.setEnabled(modify);
        this.jBtnDelete.setEnabled(delete);
        this.jBtnCancel.setEnabled(clear);
    }

    private boolean validarTextField() {
        boolean estado;

        if (this.jTFTitle.getText().isEmpty() || this.jTFFirstName.getText().isEmpty()
                || this.jTFMiddleName.getText().isEmpty() || this.jTFLastName.getText().isEmpty()
                || this.jTFEmail.getText().isEmpty() || this.jTFPhone.getText().isEmpty()) {
            estado = false;
        } else {
            estado = true;
        }
        return estado;
    }

    // Method to insert the color in the DB.
    private void insertCustomer() {
        try {
            CDCustomer cdc = new CDCustomer();
            CLCustomer clc = new CLCustomer();

            clc.setTitle(this.jTFTitle.getText().trim());
            clc.setFirstName(this.jTFFirstName.getText().trim());
            clc.setMiddleName(this.jTFMiddleName.getText().trim());
            clc.setLastName(this.jTFLastName.getText().trim());
            clc.setEmailAddress(this.jTFEmail.getText().trim());
            clc.setPhone(this.jTFPhone.getText().trim());
            clc.setCompanyName(this.jCBCompanyName.getSelectedItem().toString());
            cdc.insertCustomer(clc);

            JOptionPane.showMessageDialog(null, "Record saved successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to save customer: " + ex);
        }
    }

    // Method to update the color in the DB.
    private void updateCustomer() {
        try {
            CDCustomer cdc = new CDCustomer();
            CLCustomer cl = new CLCustomer();
            cl.setCustomerID(Integer.parseInt(this.jTFIdCustomer.getText().trim()));
            cl.setTitle(this.jTFTitle.getText().trim());
            cl.setFirstName(this.jTFFirstName.getText().trim());
            cl.setMiddleName(this.jTFMiddleName.getText().trim());
            cl.setLastName(this.jTFLastName.getText().trim());
            cl.setEmailAddress(this.jTFEmail.getText().trim());
            cl.setPhone(this.jTFPhone.getText().trim());
            cl.setCompanyName(this.jCBCompanyName.getSelectedItem().toString().trim());
            cdc.updateCustomer(cl);

            JOptionPane.showMessageDialog(null, "Record modified successfully...", "AdventureWorksLT System",
                    JOptionPane.INFORMATION_MESSAGE);

            clearTextField();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to modify color: " + ex);
        }
    }

    // Metodo para eliminar customer.
    private void deleteCustomer() {
        try {
            CDCustomer cdc = new CDCustomer();
            CLCustomer clc = new CLCustomer();
            clc.setCustomerID(Integer.parseInt(this.jTFIdCustomer.getText().trim()));
            cdc.deleteCustomer(clc);

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
        jTFIdCustomer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFMiddleName = new javax.swing.JTextField();
        jCBCompanyName = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jBtnSave = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();
        jTFPhone = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblCustomer = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTfByCode = new javax.swing.JTextField();
        jRBByFirstName = new javax.swing.JRadioButton();
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
        jLabel2.setText("Manage Customer");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 90));

        jPanel5.setBackground(new java.awt.Color(121, 134, 203));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(228, 241, 254));

        jLabel1.setText("Customer ID");

        jTFIdCustomer.setEditable(false);

        jLabel3.setText("Title");

        jLabel4.setText("First Name");

        jLabel5.setText("Middle Name");

        jLabel6.setText("Last Name");

        jLabel8.setText("Company Name");

        jLabel9.setText("Email");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 151, Short.MAX_VALUE)
                .addComponent(jBtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancel)
                .addGap(165, 165, 165))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTFIdCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTFLastName)
                                    .addComponent(jTFFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFMiddleName)
                                    .addComponent(jTFPhone))))
                        .addGap(55, 55, 55))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFEmail)
                            .addComponent(jCBCompanyName, 0, 236, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTFMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        jTPRegistro.addTab("Data of customer", jPanel2);

        jPanel3.setBackground(new java.awt.Color(228, 241, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "FirstName", "MiddleName", "LastName", "Email", "Phone", "CompanyName"
            }
        ));
        jTblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblCustomer);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 687, 267));

        jLabel12.setText("Buscar");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jPanel3.add(jTfByCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 302, 30));

        jRBByFirstName.setBackground(new java.awt.Color(228, 241, 254));
        buttonGroup1.add(jRBByFirstName);
        jRBByFirstName.setText("By first name");
        jRBByFirstName.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRBByFirstNameStateChanged(evt);
            }
        });
        jRBByFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBByFirstNameActionPerformed(evt);
            }
        });
        jPanel3.add(jRBByFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

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

        jTPRegistro.addTab("List of customers", jPanel3);

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
            insertCustomer();
            fillTableCustomer();
            findCorrelative();

        } catch (SQLException ex) {
            Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void jTblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblCustomerMouseClicked
        selectedRow();
        enabledButtons(false, true, true, true);
    }//GEN-LAST:event_jTblCustomerMouseClicked

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        try {
            updateCustomer();
            fillTableCustomer();
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
            Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnCancelActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        try {
            deleteCustomer();
            fillTableCustomer();
            findCorrelative();
        } catch (SQLException ex) {
            Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jRBByFirstNameStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRBByFirstNameStateChanged

    }//GEN-LAST:event_jRBByFirstNameStateChanged

    private void jRBByFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBByFirstNameActionPerformed
        if (this.jRBByFirstName.isSelected() == true) {
            this.jTfByCode.setEditable(true);
            this.jBtnFind.setEnabled(true);
        }
    }//GEN-LAST:event_jRBByFirstNameActionPerformed

    private void jRBAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAllActionPerformed
        if (this.jRBAll.isSelected() == true) {
            try {
                this.jTfByCode.setEditable(false);
                this.jTfByCode.setText("");
                this.jBtnFind.setEnabled(false);
                fillTableCustomer();
            } catch (SQLException ex) {
                Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jRBAllActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed

        String customerFirstName;

        customerFirstName = this.jTfByCode.getText();

        try {
            fillTableCustomerID(customerFirstName);

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
            java.util.logging.Logger.getLogger(JFraCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFraCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFraCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFraCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                    new JFraCustomer().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFraCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> jCBCompanyName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRBAll;
    private javax.swing.JRadioButton jRBByFirstName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFFirstName;
    private javax.swing.JTextField jTFIdCustomer;
    private javax.swing.JTextField jTFLastName;
    private javax.swing.JTextField jTFMiddleName;
    private javax.swing.JTextField jTFPhone;
    private javax.swing.JTextField jTFTitle;
    private javax.swing.JTabbedPane jTPRegistro;
    private javax.swing.JTable jTblCustomer;
    private javax.swing.JTextField jTfByCode;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
