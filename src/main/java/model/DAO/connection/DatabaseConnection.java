package model.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.connection.IDatabaseConnection;

public class DatabaseConnection implements IDatabaseConnection {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/loja_online";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    /**
     * Estabelece a conexão com o banco de dados.
     * 
     * @return Objeto Connection ou lança uma RuntimeException em caso de falha.
     */
    @Override
    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados: ", ex);
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     * 
     * @param con Objeto Connection a ser fechado.
     */
    @Override
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Erro ao fechar a conexão com o banco de dados", ex);
            }
        }
    }

    /**
     * Fecha a conexão e o PreparedStatement.
     * 
     * @param con  Objeto Connection a ser fechado.
     * @param stmt Objeto PreparedStatement a ser fechado.
     */
    @Override
    public void closeConnection(Connection con, PreparedStatement stmt) {
        closeStatement(stmt);
        closeConnection(con);
    }

    /**
     * Fecha a conexão, o PreparedStatement e o ResultSet.
     * 
     * @param con  Objeto Connection a ser fechado.
     * @param stmt Objeto PreparedStatement a ser fechado.
     * @param rs   Objeto ResultSet a ser fechado.
     */
    @Override
    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeResultSet(rs);
        closeConnection(con, stmt);
    }

    /**
     * Método auxiliar para fechar o PreparedStatement.
     * 
     * @param stmt Objeto PreparedStatement a ser fechado.
     */
    private void closeStatement(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Erro ao fechar o PreparedStatement", ex);
            }
        }
    }

    /**
     * Método auxiliar para fechar o ResultSet.
     * 
     * @param rs Objeto ResultSet a ser fechado.
     */
    private void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Erro ao fechar o ResultSet", ex);
            }
        }
    }
}
