/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capalogica.CLCompany;
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
 * @author CLIENTE
 */
public class CDCompany {
    private final Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    public CDCompany()throws SQLException{
        cn = Conexion.conectar();
    }
    public void insertCompanyName(CLCompany clc) throws SQLException {

        String sql = "{call sp_insertCompanyName(?)}";

        try {
            ps = cn.prepareCall(sql);
            ps.setString(1, clc.getCompanyName());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para actualizar companyName en la base de datos.
    public void updateCompanyName(CLCompany clc) throws SQLException{
        
        String sql = "{call sp_updateCompanyName(?,?)}";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, clc.getCompanyName());
            ps.setInt(2, clc.getCompanyNameID());
            ps.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
     // Método para eliminar un registro de companyName de la base de datos.
    public void deleteProductCategory(CLCompany clc) throws SQLException{
        
        String sql = "{call sp_deleteCompanyName(?)}";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, clc.getCompanyNameID());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }
    
    public int autoIncrementCompanyName() throws SQLException{
        
        int companyNameID = 0;
        String sql = "{call sp_autoIncrementableCompanyName()}";

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            rs.first();

            companyNameID = rs.getInt("companyNameID");

            if (companyNameID == 0) {
                companyNameID = 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return companyNameID;
    }
    
     public List<CLCompany> getListCompanyName() throws SQLException {
        String sql;

        sql = "{call sp_showCompanyName()}";

        List<CLCompany> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLCompany clc = new CLCompany();

                clc.setCompanyNameID(rs.getInt("CompanyNameID"));
                clc.setCompanyName(rs.getString("CompanyName"));
                miLista.add(clc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
     // Método para realizar el filtro de la tabla por el ID 
     public List<CLCompany> getListCompanyNameID(int companynameID) throws SQLException {
        String sql;

        sql = "{call sp_showCompanyNameByID(?)}";

        List<CLCompany> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, companynameID);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLCompany clc = new CLCompany();

                clc.setCompanyNameID(rs.getInt("companyNameID"));
                clc.setCompanyName(rs.getString("companyName"));
                miLista.add(clc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
     
    // Método para listar las categorías de productos en la base de datos.
    public ArrayList<String> loadCompanyName() throws SQLException{
        String sql = "{call sp_showCompanyName}";
        
        ArrayList<String> miLista;
        
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        miLista = new ArrayList<>();
        miLista.add("--Select--");
        
        while(rs.next()){
            miLista.add(rs.getString("CompanyName"));
        }
        
        return miLista;
    }
    
}
