package model.DAO;

import model.DAO.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entity.Product;
import model.interfaces.DAO.IProductDAO;
import model.interfaces.connection.IDatabaseConnection;

public class ProductDAO implements IProductDAO {

    private final IDatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<Product> ReadAll() {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Product> products = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM product");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setImagePath(rs.getString("imagePath"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt, rs);
        }

        return products;
    }

    @Override
    public List<Product> ReadByName(String name) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Product> products = new ArrayList<>();

        try {
            String query = "SELECT * FROM product WHERE name LIKE ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setImagePath(rs.getString("imagePath"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt, rs);
        }

        return products;
    }

    @Override
    public int Create(String name, String imagePath, String description, double price) {
        Connection con = databaseConnection.GetConnection();
        PreparedStatement stmt = null;
        int rs = 0;

        try {
            String sql = "INSERT INTO product(id, imagePath, name, description, price) VALUES(0,?,?,?,?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, imagePath);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setDouble(4, price);

            rs = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt);
        }

        return rs;
    }

    @Override
    public int Update(int id, String name, String imagePath, String description, double price) {
        Connection con = databaseConnection.GetConnection();
        PreparedStatement stmt = null;
        int rs = 0;

        try {
            String sql = "UPDATE product SET imagePath = ?, name = ?, description = ?, price = ? WHERE id = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, imagePath);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setDouble(4, price);
            stmt.setInt(5, id);

            rs = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt);
        }

        return rs;
    }

    @Override
    public int Delete(int id) {
        Connection con = databaseConnection.GetConnection();
        PreparedStatement stmt = null;
        int rs = 0;

        try {
            String sql = "DELETE FROM product WHERE id = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt);
        }

        return rs;
    }
}
