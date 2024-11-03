package model.DAO;

import model.DAO.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.interfaces.DAO.IUserDAO;
import model.interfaces.connection.IDatabaseConnection;

public class UserDAO implements IUserDAO {

    private final IDatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public int Read(String name, String password) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT id FROM user WHERE name = ? AND password = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt, rs);
        }

        return 0;
    }

    @Override
    public String ReadById(int userId) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT name FROM user WHERE id = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, userId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt, rs);
        }

        return null;
    }

    @Override
    public boolean Create(String name, String email, String password) {
        Connection con = databaseConnection.GetConnection();
        PreparedStatement stmt = null;
        int rs;

        try {
            String query = "INSERT INTO user VALUES(0,?,?,?);";
            stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            rs = stmt.executeUpdate();

            return rs != 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt);
        }

        return false;
    }

}
