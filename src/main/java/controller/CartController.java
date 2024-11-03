package controller;

import java.util.List;

import controller.interfaces.ICartController;
import model.DAO.CartDAO;
import model.entity.ProductCart;
import model.interfaces.DAO.ICartDAO;

public class CartController implements ICartController {

    private final ICartDAO DAO = new CartDAO();

    @Override
    public List<ProductCart> GetAll(int idUser) {
        return DAO.ReadByUserId(idUser);
    }

    @Override
    public int Add(int idUser, int idProduct) {
        return DAO.Create(idUser, idProduct);
    }

    @Override
    public int Buy(int idUser) {
        return DAO.Delete(idUser);
    }

    @Override
    public int RemoveProduct(int idCart, int idUser, int idProduct) {
        return DAO.Delete(idCart, idUser, idProduct);
    }
}
