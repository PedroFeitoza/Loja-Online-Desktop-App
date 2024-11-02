package model.interfaces.DAO;

import java.util.List;
import model.entity.Product;

public interface ICartDAO {
    public List<Product> ReadByUserId(int userId);
}
