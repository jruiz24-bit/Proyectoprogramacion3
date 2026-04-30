package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthModel {

    public AuthModel() {}
    
    
    public boolean access(String username, String password) {
        

        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
           
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/basededatos", 
                    "root", 
                    "544712986750"
            );
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()) {
                rs.close();
                ps.close();
                conn.close();
                return true;
            }  
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (Exception e) { 
            e.printStackTrace();
        }
        
        return false;
    }
}