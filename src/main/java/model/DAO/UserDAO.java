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
    public int Read(String nome, String senha) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT id FROM user WHERE name = ? AND password = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, senha);

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
    public boolean Create(String name, String email, String password) {
        Connection con = databaseConnection.GetConnection();
        PreparedStatement stmt = null;
        int rs;

        try {
            String query = "INSERT INTO user VALUES(0, ?,?,?);";
            stmt = con.prepareStatement(query);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, password);

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
