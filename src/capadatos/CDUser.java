/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capalogica.CLUser;
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
public class CDUser {
    private final Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    public CDUser() throws SQLException{
        this.cn = Conexion.conectar();
    }
    
    // Método para insertar los usuarios en la BD's
    public void insertUser(CLUser clu) throws SQLException {

        String sql = "{call sp_insertUser(?,?,?,?,?,?)}";

        try {
            ps = cn.prepareCall(sql);
            ps.setString(1, clu.getFirstName());
            ps.setString(2, clu.getLastName());
            ps.setString(3, clu.getPhone());
            ps.setString(4, clu.getAdress());
            ps.setString(5, clu.getUserName());
            ps.setString(6, clu.getPassword());
            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para actualizar el usuario en la base de datos.
    public void updateCustomer(CLUser clu) throws SQLException{
        
        String sql = "{call sp_UpdateUser(?,?,?,?,?,?,?)}";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, clu.getUserID());
            ps.setString(2, clu.getFirstName());
            ps.setString(3, clu.getLastName());
            ps.setString(4, clu.getPhone());
            ps.setString(5, clu.getAdress());
            ps.setString(6, clu.getUserName());
            ps.setString(7, clu.getPassword()); 
            ps.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void deleteUser(CLUser clu) throws SQLException{
        
        String sql = "{call sp_deleteUser(?)}";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, clu.getUserID());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }
    
    public int autoIncrementUserID() throws SQLException{
        
        int userID = 0;
        String sql = "{call sp_autoIncrementeUser()}";

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            rs.first();

            userID = rs.getInt("userID");

            if (userID == 0) {
                userID = 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return userID;
    }
    
    public List<CLUser> getListUser() throws SQLException {
        String sql;

        sql = "{call sp_mostrarTodoUser()}";

        List<CLUser> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLUser clu = new CLUser();

                clu.setUserID(rs.getInt("userID"));
                clu.setFirstName(rs.getString("firstName"));
                clu.setLastName(rs.getString("lastName"));
                clu.setPhone(rs.getString("phone"));
                clu.setAdress(rs.getString("adress"));
                clu.setUserName(rs.getString("userName"));
                clu.setPassword(rs.getString("password"));
                miLista.add(clu);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
    
    // Método que permite realizar el filtro en la tabla por el ID del color.
    public List<CLUser> getListaUserFirstName(String firstName) throws SQLException {
        String sql;

        sql = "{call sp_mostrarUserX(?)}";

        List<CLUser> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, firstName);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLUser clu = new CLUser();

                clu.setUserID(rs.getInt("userID"));
                clu.setFirstName(rs.getString("firstName"));
                clu.setLastName(rs.getString("lastName"));
                clu.setPhone(rs.getString("phone"));
                clu.setAdress(rs.getString("adress"));
                clu.setUserName(rs.getString("userName"));
                clu.setPassword(rs.getString("password"));
                miLista.add(clu);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
}
