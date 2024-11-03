package controller;

import java.util.List;
import controller.interfaces.IProductController;
import model.DAO.ProductDAO;
import model.entity.Product;
import model.enums.Operation;
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
    
    @Override
    public int UpdateProduct(int id, String name, String imagePath, String description, double price) {
        return DAO.Update(id, name, imagePath, description, price);
    }
    
    @Override
    public int DeleteProduct(int id) {
        return DAO.Delete(id);
    }
    
    @Override
    public int ManageProduct(Operation op, int id, String name, String imagePath, String description, double price) {
        switch (op) {
            case Operation.Add -> this.CreateProduct(name, imagePath, description, price);
            case Operation.Edit -> this.UpdateProduct(id, name, imagePath, description, price);
            case Operation.Delete -> this.DeleteProduct(id);
            default -> throw new AssertionError();
        }
        
        return -1;
    }
}
