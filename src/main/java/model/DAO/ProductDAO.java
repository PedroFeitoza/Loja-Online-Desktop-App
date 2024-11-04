package model.DAO;

import model.DAO.connection.DatabaseConnection;
import model.entity.Product;
import model.interfaces.DAO.IProductDAO;
import model.interfaces.connection.IDatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO implements IProductDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private final IDatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<Product> readAll() {
        String query = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product product = mapResultSetToProduct(rs);
                products.add(product);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error reading all products", ex);
        }

        return products;
    }

    @Override
    public List<Product> readByName(String name) {
        String query = "SELECT * FROM product WHERE name LIKE ?";
        List<Product> products = new ArrayList<>();

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, "%" + name + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = mapResultSetToProduct(rs);
                    products.add(product);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error reading products by name", ex);
        }

        return products;
    }

    @Override
    public int create(String name, String imagePath, String description, double price) {
        String query = "INSERT INTO product (image_path, name, description, price) VALUES (?, ?, ?, ?)";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, imagePath);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setDouble(4, price);

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error creating product", ex);
        }

        return 0;
    }

    @Override
    public int update(int id, String name, String imagePath, String description, double price) {
        String query = "UPDATE product SET image_path = ?, name = ?, description = ?, price = ? WHERE id = ?";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, imagePath);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setDouble(4, price);
            stmt.setInt(5, id);

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error updating product", ex);
        }

        return 0;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM product WHERE id = ?";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error deleting product", ex);
        }

        return 0;
    }

    private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setImagePath(rs.getString("image_path"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}
