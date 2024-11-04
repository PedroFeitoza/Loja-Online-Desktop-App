package model.DAO;

import model.DAO.connection.DatabaseConnection;
import model.dtos.ProductCart;
import model.interfaces.DAO.ICartDAO;
import model.interfaces.connection.IDatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartDAO implements ICartDAO {

    private static final Logger LOGGER = Logger.getLogger(CartDAO.class.getName());
    private final IDatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<ProductCart> readByUserId(int userId) {
        String query = """
                SELECT cart.id_cart, product.id, product.image_path, product.name, product.description, product.price
                FROM product
                INNER JOIN cart ON product.id = cart.id_product
                WHERE cart.id_user = ?;
                """;
        List<ProductCart> products = new ArrayList<>();

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ProductCart product = mapResultSetToProductCart(rs);
                    products.add(product);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error reading products in cart for user with ID: " + userId, ex);
        }

        return products;
    }

    @Override
    public int create(int userId, int productId) {
        String query = "INSERT INTO cart (id_product, id_user) VALUES (?, ?)";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, productId);
            stmt.setInt(2, userId);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error adding product with ID: " + productId + " to user cart with ID: " + userId,
                    ex);
        }

        return 0;
    }

    @Override
    public int delete(int userId) {
        String query = "DELETE FROM cart WHERE id_user = ?";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, userId);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error clearing cart for user with ID: " + userId, ex);
        }

        return 0;
    }

    @Override
    public int delete(int idCart, int userId, int productId) {
        String query = "DELETE FROM cart WHERE id_cart = ? AND id_user = ? AND id_product = ?";

        try (Connection con = databaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, idCart);
            stmt.setInt(2, userId);
            stmt.setInt(3, productId);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error removing product with ID: " + productId + " from cart with ID: " + idCart
                    + " for user with ID: " + userId, ex);
        }

        return 0;
    }

    private ProductCart mapResultSetToProductCart(ResultSet rs) throws SQLException {
        ProductCart product = new ProductCart();
        product.setIdCart(rs.getInt("id_cart"));
        product.setId(rs.getInt("id"));
        product.setImagePath(rs.getString("image_path"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}
