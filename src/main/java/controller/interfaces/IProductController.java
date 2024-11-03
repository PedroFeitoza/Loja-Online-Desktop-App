package controller.interfaces;

import java.util.List;

import model.entity.Product;
import model.enums.Operation;

public interface IProductController {

    public List<Product> GetAll();

    public List<Product> GetByName(String name);

    public int ManageProduct(Operation op, int id, String name, String imagePath, String description, double price);

    public int CreateProduct(String name, String imagePath, String description, double price);

    public int UpdateProduct(int id, String name, String imagePath, String description, double price);

    public int DeleteProduct(int id);
}
