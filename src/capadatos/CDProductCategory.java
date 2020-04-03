/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
