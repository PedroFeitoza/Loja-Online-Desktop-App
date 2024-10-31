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

public class UserDAO {

    public List<Product> read(String nome, String senha) {
        Connection con = DatabaseConnection.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Product> products = new ArrayList<>();

        try {
            String query = "SELECT * FROM user WHERE nome = ? AND senha = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1,"%" + nome + "%"); 
            stmt.setString(2, "%" + senha + "%");
            rs = stmt.executeQuery();
        }
    }
}
