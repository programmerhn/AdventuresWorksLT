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
import javax.swing.JOptionPane;

/**
 *
 * @author oscarpineda
 */
public class CDColor {
    
    private final Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    public CDColor() throws SQLException{
        this.cn = Conexion.conectar();
    }
    
    // Método para insertar el color en la BD's
    public void insertColor(CLColor cl) throws SQLException {

        String sql = "{call sp_insertColor(?)}";

        try {
            ps = cn.prepareCall(sql);
            ps.setString(1, cl.getColorName());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para actualizar el color en la base de datos.
    public void updateColor(CLColor cl) throws SQLException{
        
        String sql = "{call sp_updateColor(?,?)}";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getColorName());
            ps.setInt(2, cl.getColorID());
            ps.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // Método para eliminar un color de la base de datos.
    public void deleteColor(CLColor cl) throws SQLException{
        
        String sql = "{call sp_deleteColor(?)}";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cl.getColorID());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    // Método para consultar el ID del color que se va a almacenar.
    public int autoIncrementColorID() throws SQLException{
        
        int colorID = 0;
        String sql = "{call sp_autoIncrementeColor()}";

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            rs.first();

            colorID = rs.getInt("colorID");

            if (colorID == 0) {
                colorID = 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return colorID;
    }
    
    // Método para llenar la tabla.
    public List<CLColor> getListColor() throws SQLException {
        String sql;

        sql = "{call sp_showColor()}";

        List<CLColor> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLColor cl = new CLColor();

                cl.setColorID(rs.getInt("colorID"));
                cl.setColorName(rs.getString("colorName"));
                miLista.add(cl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
   
    // Método para cargar de datos el ComboBox Color.
    public ArrayList<String> loadColor() throws SQLException{
        String sql = "{call sp_showColor}";

        ArrayList<String> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();
            miLista.add("--Select--");

            while (rs.next()) {
                miLista.add(rs.getString("colorName"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return miLista;
    }
    
    // Método que permite realizar el filtro en la tabla por el ID del color.
    public List<CLColor> getListaColorID(int colorID) throws SQLException {
        String sql;

        sql = "{call sp_showColorByID(?)}";

        List<CLColor> miLista = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, colorID);
            rs = ps.executeQuery();

            miLista = new ArrayList<>();

            while (rs.next()) {
                CLColor cl = new CLColor();

                cl.setColorID(rs.getInt("colorID"));
                cl.setColorName(rs.getString("colorName"));
                miLista.add(cl);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return miLista;
    }
}
