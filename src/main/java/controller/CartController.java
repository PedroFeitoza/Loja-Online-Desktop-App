package controller;

import java.util.List;

import controller.interfaces.ICartController;
import model.DAO.CartDAO;
import model.entity.Product;
import model.interfaces.DAO.ICartDAO;

public class CartController implements ICartController {
    private final ICartDAO DAO = new CartDAO();

    @Override
    public List<Product> GetAll(int idUser) {
        return DAO.ReadByUserId(idUser);
    }   
}
