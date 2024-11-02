package model.entity;

public class Cart {

    private int _id;
    private int _idProduct;
    private int _idUser;

    public Cart(int id, int idProduct, int idUser) {
        _id = id;
        _idProduct = idProduct;
        _idUser = idUser;
    }

    public Cart() {
    }

    public int GetId() {
        return _id;
    }

    public void SetId(int id) {
        _id = id;
    }

    public int GetIdUser() {
        return _idUser;
    }

    public void SetIdUser(int id) {
        _idUser = id;
    }

    public int GetIdProduct() {
        return _idProduct;
    }

    public void SetIdProduct(int id) {
        _idProduct = id;
    }

}
