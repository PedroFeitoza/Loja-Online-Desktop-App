package controller;

import java.util.List;
import model.DAO.ProductDAO;
import model.Product;

public class ProductController {
    
    public List<Product> GetAll() {
        var p = new ProductDAO();
        return p.read();
    }

    public List<Product> GetByName(String name) {
        var p = new ProductDAO();
        return p.readByName(name);
    }        
}
