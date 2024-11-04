package controller.interfaces;

import java.util.List;
import model.dtos.ProductCart;

public interface ICartController {

    public List<ProductCart> getProductsInCart(int idUser);

    public boolean addProductToCart(int idUser, int idProduct);

    public boolean completePurchase(int idUser);

    public boolean removeProductFromCart(int idCart, int idUser, int idProduct);
}
