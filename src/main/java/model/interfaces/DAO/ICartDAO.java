package model.interfaces.DAO;

import java.util.List;
import model.entity.ProductCart;

public interface ICartDAO {

    public List<ProductCart> ReadByUserId(int userId);

    public int Create(int userId, int productId);

    public int Delete(int idUser);

    public int Delete(int idCart, int idUser, int idProduct);
}
