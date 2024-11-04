package controller.interfaces;

import java.util.List;
import model.entity.Product;

public interface IProductController {

    public List<Product> getAll();

    public List<Product> getByName(String name);

    public int createProduct(String name, String imagePath, String description, double price);

    public int updateProduct(int id, String name, String imagePath, String description, double price);

    public int deleteProduct(int id);
}
