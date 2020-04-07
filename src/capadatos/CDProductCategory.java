/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capalogica.CLProductCategory;
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
public class CDProductCategory {
    
    private final Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

    public CDProductCategory() throws SQLException{
        cn = Conexion.conectar();
    }
    
      // Método para insertar la categoría del producto en la BD's
    public void insertProductCategory(CLProductCategory clpc) throws SQLException {

        String sql = "{call sp_insertProductCategory(?)}";

        try {
            ps = cn.prepareCall(sql);
            ps.setString(1, clpc.getProductCategoryName());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para actualizar la categoría del producto en la base de datos.
    public void updateProductCategory(CLProductCategory clpc) throws SQLException{
        
        String sql = "{call sp_updateProductCategory(?,?)}";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, clpc.getProductCategoryName());
            ps.setInt(2, clpc.getProductCategoryID());
            ps.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para eliminar una categoría de producto de la base de datos.
    public void deleteProductCategory(CLProductCategory clpc) throws SQLException{
        
        String sql = "{call sp_deleteProductCategory(?)}";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, clpc.getProductCategoryID());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }
    
    // Método para consultar el ID del color que se va a almacenar.
    public int autoIncrementProductCategory() throws SQLException{
        
        int productCategoryID = 0;
        String sql = "{call sp_autoIncrementProductCategoryID()}";

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            rs.first();

            productCategoryID = rs.getInt("productCategoryID");

            if (productCategoryID == 0) {
                productCategoryID = 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return productCategoryID;
    }
    
    // Método para llenar la tabla.
    public List<CLProductCategory> getListProductCategory() throws SQLException {
        String sql;

        sql = "{call sp_showProductCategory()}";

        List<CLProductCategory> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLProductCategory clpc = new CLProductCategory();

                clpc.setProductCategoryID(rs.getInt("productCategoryID"));
                clpc.setProductCategoryName(rs.getString("productCategoryName"));
                miLista.add(clpc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
   
    // Método para realizar el filtro de la tabla por el ID de la categoría del producto.
     public List<CLProductCategory> getListProductCategoryID(int productCategoryID) throws SQLException {
        String sql;

        sql = "{call sp_showXProductCategory(?)}";

        List<CLProductCategory> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, productCategoryID);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLProductCategory clpc = new CLProductCategory();

                clpc.setProductCategoryID(rs.getInt("productCategoryID"));
                clpc.setProductCategoryName(rs.getString("productCategoryName"));
                miLista.add(clpc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
   
    // Método para listar las categorías de productos en la base de datos.
    public ArrayList<String> loadProductCategory() throws SQLException{
        String sql = "{call sp_showProductCategory}";
        
        ArrayList<String> miLista;
        
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        miLista = new ArrayList<>();
        miLista.add("--Select--");
        
        while(rs.next()){
            miLista.add(rs.getString("productCategoryName"));
        }
        
        return miLista;
    }
}
