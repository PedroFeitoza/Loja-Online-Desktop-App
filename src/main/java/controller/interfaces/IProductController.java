package controller.interfaces;

import java.util.List;

import model.entity.Product;

public interface IProductController {
    public List<Product> GetAll();
    public List<Product> GetByName(String name);
}
