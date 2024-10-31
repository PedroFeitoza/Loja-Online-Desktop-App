package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDAO {


    public List<Product> read() {
        Connection con = DatabaseConnection.getConnection();
        
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
            DatabaseConnection.closeConnection(con, stmt, rs);
        }

        return products;
    }
    
    public List<Product> readByName(String name) {
        Connection con = DatabaseConnection.getConnection();
        
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
            DatabaseConnection.closeConnection(con, stmt, rs);
        }

        return products;
    }
}
