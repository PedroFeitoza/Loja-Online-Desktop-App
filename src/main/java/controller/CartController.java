package controller;

import java.util.List;

import controller.interfaces.ICartController;
import model.DAO.CartDAO;
import model.dtos.ProductCart;
import model.interfaces.DAO.ICartDAO;

public class CartController implements ICartController {

    private final ICartDAO cartDAO = new CartDAO();

    /**
     * Retorna todos os produtos no carrinho de um usuário específico.
     * 
     * @param userId ID do usuário
     * @return Lista de produtos no carrinho
     */
    @Override
    public List<ProductCart> getProductsInCart(int userId) {
        try {
            return cartDAO.readByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos no carrinho: " + e.getMessage(), e);
        }
    }

    /**
     * Adiciona um produto ao carrinho de um usuário.
     * 
     * @param userId    ID do usuário
     * @param productId ID do produto
     * @return true se o produto foi adicionado com sucesso, false caso contrário
     */
    @Override
    public boolean addProductToCart(int userId, int productId) {
        try {
            int result = cartDAO.create(userId, productId);
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar produto ao carrinho: " + e.getMessage(), e);
        }
    }

    /**
     * Realiza a compra dos produtos no carrinho de um usuário e limpa o carrinho.
     * 
     * @param userId ID do usuário
     * @return true se a compra foi concluída com sucesso, false caso contrário
     */
    @Override
    public boolean completePurchase(int userId) {
        try {
            int result = cartDAO.delete(userId);
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao concluir a compra: " + e.getMessage(), e);
        }
    }

    /**
     * Remove um produto específico do carrinho de um usuário.
     * 
     * @param cartId    ID do carrinho
     * @param userId    ID do usuário
     * @param productId ID do produto
     * @return true se o produto foi removido com sucesso, false caso contrário
     */
    @Override
    public boolean removeProductFromCart(int cartId, int userId, int productId) {
        try {
            int result = cartDAO.delete(cartId, userId, productId);
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover produto do carrinho: " + e.getMessage(), e);
        }
    }
}
