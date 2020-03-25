/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capalogica.CLLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oscarpineda
 */
public class CDLogin {
    
    private final Connection cn;
    
    public CDLogin() throws SQLException, ClassNotFoundException{
        this.cn = Conexion.conectar();
    }
    
    public String iniciarSesion(CLLogin ll) throws SQLException{
        
        String sql = "{Call sp_login(?,?)}";
        
        int userID = 0;
        String userName = null;
        
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, ll.getUserName());
            ps.setString(2, ll.getPassword());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                userID = rs.getInt("userID");
                userName = rs.getString("userName");
                
            }
        }
        return (String.valueOf(userID) + "-" + userName);
    }           
}
