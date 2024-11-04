package controller;

import java.util.List;
import controller.interfaces.IProductController;
import model.DAO.ProductDAO;
import model.entity.Product;
import model.interfaces.DAO.IProductDAO;

public class ProductController implements IProductController {

    private final IProductDAO productDAO = new ProductDAO();

    /**
     * Retorna uma lista de todos os produtos.
     * 
     * @return Lista de produtos disponíveis
     */
    @Override
    public List<Product> getAll() {
        try {
            return productDAO.readAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao recuperar produtos: " + e.getMessage(), e);
        }
    }

    /**
     * Retorna uma lista de produtos cujo nome corresponde ao termo fornecido.
     * 
     * @param name Nome ou parte do nome do produto
     * @return Lista de produtos correspondentes
     * @throws IllegalArgumentException se o nome for nulo ou vazio
     */
    @Override
    public List<Product> getByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        }

        try {
            return productDAO.readByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos por nome: " + e.getMessage(), e);
        }
    }

    /**
     * Cria um novo produto com os detalhes fornecidos.
     * 
     * @param name        Nome do produto
     * @param imagePath   Caminho da imagem do produto
     * @param description Descrição do produto
     * @param price       Preço do produto
     * @return ID do produto criado
     * @throws IllegalArgumentException se algum parâmetro for inválido
     */
    @Override
    public int createProduct(String name, String imagePath, String description, double price) {
        validateProductData(name, imagePath, description, price);

        try {
            return productDAO.create(name, imagePath, description, price);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar produto: " + e.getMessage(), e);
        }
    }

    /**
     * Atualiza um produto existente com os detalhes fornecidos.
     * 
     * @param id          ID do produto
     * @param name        Novo nome do produto
     * @param imagePath   Novo caminho da imagem do produto
     * @param description Nova descrição do produto
     * @param price       Novo preço do produto
     * @return Número de registros atualizados
     * @throws IllegalArgumentException se algum parâmetro for inválido
     */
    @Override
    public int updateProduct(int id, String name, String imagePath, String description, double price) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do produto inválido.");
        }
        validateProductData(name, imagePath, description, price);

        try {
            return productDAO.update(id, name, imagePath, description, price);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }

    /**
     * Remove um produto pelo ID fornecido.
     * 
     * @param id ID do produto a ser removido
     * @return Número de registros deletados
     * @throws IllegalArgumentException se o ID for inválido
     */
    @Override
    public int deleteProduct(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do produto inválido.");
        }

        try {
            return productDAO.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage(), e);
        }
    }

    // Método auxiliar para validação dos dados do produto
    private void validateProductData(String name, String imagePath, String description, double price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        }
        if (imagePath == null || imagePath.isEmpty()) {
            throw new IllegalArgumentException("Caminho da imagem não pode ser vazio.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Descrição do produto não pode ser vazia.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Preço do produto não pode ser negativo.");
        }
    }
}
