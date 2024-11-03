package model.entity;

public class ProductCart extends Product {

    private int idCart;
    
    public ProductCart() {
    }

    // Getter e Setter para id
    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int id) {
        this.idCart = id;
    }

}
