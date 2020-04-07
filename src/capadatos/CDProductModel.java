/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capalogica.CLProductModel;
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
 * @author oscarpineda
 */
public class CDProductModel {
    
    private final Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    public CDProductModel() throws SQLException{
        cn = Conexion.conectar();
    }
    
    // Método para insertar el modelo del producto en la BD's
    public void insertProductModel(CLProductModel clpm) throws SQLException {

        String sql = "{call sp_insertProductModel(?,?)}";

        try {
            ps = cn.prepareCall(sql);
            ps.setString(1, clpm.getProductModelName());
            ps.setString(2, clpm.getProductCategoryName());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
     // Método para actualizar el modelo del producto en la base de datos.
    public void updateProductModel(CLProductModel clpm) throws SQLException{
        
        String sql = "{call sp_updateProductModel(?,?,?)}";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, clpm.getProductModelName());
            ps.setString(2, clpm.getProductCategoryName());
            ps.setInt(3, clpm.getProductModelID());
            ps.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para eliminar un modelo de producto de la base de datos.
    public void deleteProductModel(CLProductModel clpm) throws SQLException{
        
        String sql = "{call sp_deleteProductModel(?)}";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, clpm.getProductModelID());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    } 
    
    // Método para consultar el ID del modelo que se va a almacenar.
    public int autoIncrementProductModel() throws SQLException{
        
        int productCategoryID = 0;
        String sql = "{call sp_autoIncrementProductModelID()}";

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            rs.first();

            productCategoryID = rs.getInt("productModelID");

            if (productCategoryID == 0) {
                productCategoryID = 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return productCategoryID;
    }
    
     // Método para llenar la tabla.
    public List<CLProductModel> getListProductModel() throws SQLException {
        String sql;

        sql = "{call sp_showProductModel()}";

        List<CLProductModel> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLProductModel clpm = new CLProductModel();

                clpm.setProductModelID(rs.getInt("productModelID"));
                clpm.setProductModelName(rs.getString("productModelName"));
                clpm.setProductCategoryName(rs.getString("productCategoryName"));
                miLista.add(clpm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
    
      // Método para realizar el filtro de la tabla por el ID del modelo del producto.
     public List<CLProductModel> getListProductCategoryID(int productModelID) throws SQLException {
        String sql;

        sql = "{call sp_showProductModelByID(?)}";

        List<CLProductModel> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, productModelID);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLProductModel clpm = new CLProductModel();

                clpm.setProductModelID(rs.getInt("productModelID"));
                clpm.setProductModelName(rs.getString("productModelName"));
                clpm.setProductCategoryName(rs.getString("productCategoryName"));
                miLista.add(clpm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
     
    // Método para cargar el combo box del modelo de productos.
    public ArrayList<String> loadProductModel(CLProductModel clp) throws SQLException {
        String sql = "{call sp_showProductModel(?)}";

        ArrayList<String> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, clp.getProductCategoryName());
            rs = ps.executeQuery();

            miLista = new ArrayList<>();
            miLista.add("--Select--");

            while (rs.next()) {
                miLista.add(rs.getString("productModelName"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
    
  
}
