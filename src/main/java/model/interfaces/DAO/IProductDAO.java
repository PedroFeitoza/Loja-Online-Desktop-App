package model.interfaces.DAO;

import java.util.List;
import model.entity.Product;

public interface IProductDAO {
    public List<Product> readAll();

    public List<Product> readByName(String name);

    public int create(String name, String imagePath, String description, double price);

    public int update(int id, String name, String imagePath, String description, double price);

    public int delete(int id);
}
