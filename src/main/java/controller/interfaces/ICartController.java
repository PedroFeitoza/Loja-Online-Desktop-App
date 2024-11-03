package controller.interfaces;

import java.util.List;

import model.entity.ProductCart;

public interface ICartController {

    public List<ProductCart> GetAll(int idUser);

    public int Add(int idUser, int idProduct);

    public int Buy(int idUser);

    public int RemoveProduct(int idCart, int idUser, int idProduct);
}
