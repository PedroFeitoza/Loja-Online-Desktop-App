package model.interfaces.DAO;

import java.util.List;
import model.entity.Product;

public interface IProductDAO {
    public List<Product> ReadAll();
    public List<Product> ReadByName(String name);
    public int Create(String name, String imagePath, String description, double price);
}
