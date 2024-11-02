package controller.interfaces;

import java.util.List;

import model.entity.Product;

public interface ICartController {
    public List<Product> GetAll(int idUser);
}
