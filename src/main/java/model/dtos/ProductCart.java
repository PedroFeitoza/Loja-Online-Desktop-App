package model.dtos;

import model.entity.Product;

public class ProductCart extends Product {

    private int idCart;

    public ProductCart() {
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int id) {
        this.idCart = id;
    }
}
