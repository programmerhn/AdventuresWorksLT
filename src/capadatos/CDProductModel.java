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
    
    
    public List<CLProductModel> getListaProductModel(CLProductModel clp) throws SQLException {
        String sql;

        sql = "{call sp_showProductModel(?)}";

        List<CLProductModel> miLista;

        ps = cn.prepareStatement(sql);
        ps.setString(1, clp.getProductCategoryName());
        rs = ps.executeQuery();

        miLista = new ArrayList<>();

        while (rs.next()) {
            CLProductModel cl = new CLProductModel();

            cl.setProductModelName(rs.getString("productModelName"));
            miLista.add(cl);
        }

        return miLista;
    }


}
