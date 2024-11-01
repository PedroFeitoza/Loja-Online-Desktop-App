package model.DAO;

import model.DAO.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.interfaces.DAO.IUserDAO;

public class UserDAO implements IUserDAO {

    @Override
    public boolean Read(String nome, String senha) {
        Connection con = DatabaseConnection.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM user WHERE nome = ? AND senha = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1,nome); 
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();

            return rs != null;
        }
        catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
             DatabaseConnection.closeConnection(con, stmt, rs);
        }
        
        return false;
    }
    
    @Override
     public boolean Create(String name, String email, String password) {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        int rs;

        try {
            String query = "INSERT INTO user VALUES(0, ?,?,?);";
            stmt = con.prepareStatement(query);
            stmt.setString(2,name); 
            stmt.setString(3,email);
            stmt.setString(4,password);
            
            rs = stmt.executeUpdate();

            return rs != 0;
        }
        catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
             DatabaseConnection.closeConnection(con, stmt);
        }
        
        return false;
    }

}
