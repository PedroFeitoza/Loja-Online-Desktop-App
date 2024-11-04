package model.DAO;

import model.DAO.connection.DatabaseConnection;
import model.interfaces.DAO.IUserDAO;
import model.interfaces.connection.IDatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO implements IUserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());
    private final IDatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public int read(String name, String password) {
        String query = "SELECT id FROM user WHERE name = ? AND password = ?";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error reading user by name and password", ex);
        }

        return 0;
    }

    @Override
    public String readById(int userId) {
        String query = "SELECT name FROM user WHERE id = ?";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error reading user by ID", ex);
        }

        return null; // Retorno nulo indica que o usuário não foi encontrado
    }

    @Override
    public boolean create(String name, String email, String password) {
        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error creating user", ex);
        }

        return false;
    }
}
