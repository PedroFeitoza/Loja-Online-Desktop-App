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
import model.entity.ProductCart;
import model.interfaces.DAO.ICartDAO;
import model.interfaces.connection.IDatabaseConnection;

public class CartDAO implements ICartDAO {

    private final IDatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<ProductCart> ReadByUserId(int userId) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProductCart> products = new ArrayList<>();

        try {
            String query = ("""
                            SELECT cart.id_cart, product.id, product.imagePath, product.name, product.description, product.price
                            FROM product
                            INNER JOIN cart on product.id = cart.id_product
                            WHERE cart.id_user = ?;""");

            stmt = con.prepareStatement(query);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProductCart product = new ProductCart();
                product.setIdCart(rs.getInt("id_cart"));
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
    public int Create(int userId, int productId) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        int rs = 0;

        try {
            String query = ("INSERT INTO cart(id_cart, id_product, id_user) VALUES(0,?,?)");

            stmt = con.prepareStatement(query);
            stmt.setInt(1, productId);
            stmt.setInt(2, userId);
            rs = stmt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt);
        }

        return rs;
    }

    @Override
    public int Delete(int userId) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        int rs = 0;

        try {
            String query = ("DELETE FROM cart WHERE id_user = ?");

            stmt = con.prepareStatement(query);
            stmt.setInt(1, userId);
            rs = stmt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt);
        }

        return rs;
    }

    @Override
    public int Delete(int idCart, int userId, int productId) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        int rs = 0;

        try {
            String query = ("DELETE FROM cart WHERE id_cart = ? AND id_user = ? AND id_product = ?");

            stmt = con.prepareStatement(query);
            stmt.setInt(1, idCart);
            stmt.setInt(2, userId);
            stmt.setInt(3, productId);
            rs = stmt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.CloseConnection(con, stmt);
        }

        return rs;
    }
}
