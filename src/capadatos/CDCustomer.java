/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capalogica.CLCustomer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class CDCustomer {
    private final Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    public CDCustomer() throws SQLException{
        this.cn = Conexion.conectar();
    }
    
    // Método para insertar los clientes en la BD's
    public void insertCustomer(CLCustomer clc) throws SQLException {

        String sql = "{call sp_InsertCustomer(?,?,?,?,?,?,?)}";

        try {
            ps = cn.prepareCall(sql);
            ps.setString(1, clc.getTitle());
            ps.setString(2, clc.getFirstName());
            ps.setString(3, clc.getMiddleName());
            ps.setString(4, clc.getLastName());
            ps.setString(5, clc.getEmailAddress());
            ps.setString(6, clc.getPhone());
            ps.setString(7, clc.getCompanyName());
            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para actualizar el color en la base de datos.
    public void updateCustomer(CLCustomer clc) throws SQLException{
        
        String sql = "{call sp_actualizarCustomer(?,?,?,?,?,?,?,?)}";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, clc.getCustomerID());
            ps.setString(2, clc.getTitle());
            ps.setString(3, clc.getFirstName());
            ps.setString(4, clc.getMiddleName());
            ps.setString(5, clc.getLastName());
            ps.setString(6, clc.getEmailAddress());
            ps.setString(7, clc.getPhone()); 
            ps.setString(8, clc.getCompanyName());
            ps.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void deleteCustomer(CLCustomer clc) throws SQLException{
        
        String sql = "{call sp_eliminarCustomer(?)}";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, clc.getCustomerID());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }
      
    public int autoIncrementColorID() throws SQLException{
        
        int customerID = 0;
        String sql = "{call sp_autoIncrementCustomerID()}";

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            rs.first();

            customerID = rs.getInt("customerID");

            if (customerID == 0) {
                customerID = 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return customerID;
    }
    
    // Método para llenar la tabla.
    public List<CLCustomer> getListCustomer() throws SQLException {
        String sql;

        sql = "{call sp_MostrarCustomer()}";

        List<CLCustomer> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLCustomer clc = new CLCustomer();

                clc.setCustomerID(rs.getInt("customerID"));
                clc.setTitle(rs.getString("title"));
                clc.setFirstName(rs.getString("firstName"));
                clc.setMiddleName(rs.getString("middleName"));
                clc.setLastName(rs.getString("lastName"));
                clc.setEmailAddress(rs.getString("emailAddress"));
                clc.setPhone(rs.getString("phone"));
                clc.setCompanyName(rs.getString("companyName"));
                miLista.add(clc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
    
    // Método para cargar de datos el ComboBox Color.
    public ArrayList<String> loadCompanyName() throws SQLException{
        String sql = "{call sp_showCompanyName()}";

        ArrayList<String> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();
            miLista.add("--Select--");

            while (rs.next()) {
                miLista.add(rs.getString("companyName"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return miLista;
    }
    
    // Método que permite realizar el filtro en la tabla por el ID del color.
    public List<CLCustomer> getListaCustomerFirstName(String firstName) throws SQLException {
        String sql;

        sql = "{call sp_mostrarXCustomer(?)}";

        List<CLCustomer> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, firstName);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLCustomer clc = new CLCustomer();

                clc.setCustomerID(rs.getInt("customerID"));
                clc.setTitle(rs.getString("title"));
                clc.setFirstName(rs.getString("firstName"));
                clc.setMiddleName(rs.getString("middleName"));
                clc.setLastName(rs.getString("lastName"));
                clc.setEmailAddress(rs.getString("emailAddress"));
                clc.setPhone(rs.getString("phone"));
                clc.setCompanyName(rs.getString("companyName"));
                miLista.add(clc);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
}