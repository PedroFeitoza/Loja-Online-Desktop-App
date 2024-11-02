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
import model.interfaces.DAO.ICartDAO;
import model.interfaces.connection.IDatabaseConnection;

public class CartDAO implements ICartDAO {

    private final IDatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<Product> ReadByUserId(int userId) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Product> products = new ArrayList<>();

        try {
            String query = ("SELECT product.id, product.imagePath, product.name, product.description, product.price\n"
                    + "FROM product\n"
                    + "INNER JOIN cart on product.id = cart.id_product\n"
                    + "WHERE cart.id_user = ?;");

            stmt = con.prepareStatement(query);
            stmt.setInt(1, userId);
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
    public int Create(int userId, int productId) {
        Connection con = databaseConnection.GetConnection();

        PreparedStatement stmt = null;
        int rs = 0;

        try {
            String query = ("INSERT INTO cart(id, id_product, id_user) VALUES(0,?,?)");

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
}
