package model.interfaces.DAO;

import java.util.List;

import model.dtos.ProductCart;

public interface ICartDAO {

    public List<ProductCart> readByUserId(int userId);

    public int create(int userId, int productId);

    public int delete(int idUser);

    public int delete(int idCart, int idUser, int idProduct);
}
