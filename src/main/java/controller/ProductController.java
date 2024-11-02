package controller;

import java.util.List;
import controller.interfaces.IProductController;
import model.DAO.ProductDAO;
import model.entity.Product;
import model.interfaces.DAO.IProductDAO;

public class ProductController implements IProductController {
    private final IProductDAO DAO = new ProductDAO();   
    
    @Override
    public List<Product> GetAll() {
        return DAO.ReadAll();
    }

    @Override
    public List<Product> GetByName(String name) {
        return DAO.ReadByName(name);
    }
    
    @Override
    public int CreateProduct(String name, String imagePath, String description, double price) {
        return DAO.Create(name, imagePath, description, price);
    }
}
