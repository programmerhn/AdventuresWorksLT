/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capalogica.CLColor;
import java.util.List;
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
public class CDColor {
    
    private final Connection cn;
    
    public CDColor() throws SQLException{
        this.cn = Conexion.conectar();
    }
    
    public void insertColor(CLColor cl) throws SQLException{
        
        String sql = "{call sp_insertColor(?)}";
        
        try(PreparedStatement ps = cn.prepareCall(sql)){
            ps.setString(1, cl.getColorName());
            ps.execute();
        }
    }
    
    public void updateColor(CLColor cl) throws SQLException{
        
        String sql = "{call sp_updateColor(?,?)}";
        
        try(PreparedStatement ps = cn.prepareCall(sql)){
            ps.setString(1, cl.getColorName());
            ps.setInt(2, cl.getColorID());
            ps.execute();
        }
    }
    
    public void deleteColor(CLColor cl) throws SQLException{
        
        String sql = "{call sp_deleteColor(?)}";
        
        try(PreparedStatement ps = cn.prepareCall(sql)){
            ps.setInt(1, cl.getColorID());
            ps.execute();
        }
    }
    
    public int autoIncrementColorID() throws SQLException{
        
        int colorID = 0;
        String sql = "{call sp_autoIncrementeColor()}";
        
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.first();
        
        colorID = rs.getInt("colorID");
        
        if(colorID == 0){
            colorID = 1;
        }
        
        return colorID;
    }
    
   public List<CLColor> getListaColor() throws SQLException{
        String sql;
        
        sql = "{call sp_showColor()}";
       
        
        List<CLColor> miLista;
        
        try(PreparedStatement ps = cn.prepareStatement(sql)){
     
            ResultSet rs = ps.executeQuery();
            
            miLista = new ArrayList<>();
            
            while(rs.next()){
                CLColor cl = new CLColor();
                
                cl.setColorID(rs.getInt("colorID"));
                cl.setColorName(rs.getString("colorName"));
                miLista.add(cl);
            }
        }
        
        return miLista;
    }
    
     public List<CLColor> getListaColorID(int colorID) throws SQLException{
        String sql;
        
        sql = "{call sp_showColorByID(?)}";

        List<CLColor> miLista;
        
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, colorID);
            ResultSet rs = ps.executeQuery();
            
            miLista = new ArrayList<>();
            
            while(rs.next()){
                CLColor cl = new CLColor();
                
                cl.setColorID(rs.getInt("colorID"));
                cl.setColorName(rs.getString("colorName"));
                miLista.add(cl);
            }
        }
        
        return miLista;
    }
}
