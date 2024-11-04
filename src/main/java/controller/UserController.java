package controller;

import controller.interfaces.IUserController;
import model.DAO.UserDAO;
import model.interfaces.DAO.IUserDAO;

public class UserController implements IUserController {
    
    private final IUserDAO userDAO = new UserDAO();

    /**
     * Realiza o login de um usuário com as credenciais fornecidas.
     * 
     * @param name     Nome do usuário
     * @param password Senha do usuário
     * @return ID do usuário se as credenciais estiverem corretas, ou 0 se falharem
     * @throws IllegalArgumentException se os parâmetros forem inválidos
     */
    @Override
    public int login(String name, String password) {
        if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Nome e senha não podem ser vazios.");
        }
        
        try {
            return userDAO.read(name, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer login: " + e.getMessage(), e);
        }
    }
    
    /**
     * Registra um novo usuário com o nome, email e senha fornecidos.
     * 
     * @param name     Nome do usuário
     * @param email    Email do usuário
     * @param password Senha do usuário
     * @return true se o registro foi bem-sucedido, false caso contrário
     * @throws IllegalArgumentException se os parâmetros forem inválidos
     */
    @Override
    public boolean register(String name, String email, String password) {
        if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Nome, email e senha não podem ser vazios.");
        }

        try {
            return userDAO.create(name, email, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao registrar usuário: " + e.getMessage(), e);
        }
    }

    /**
     * Obtém o nome de usuário com base no ID fornecido.
     * 
     * @param userId ID do usuário
     * @return Nome do usuário ou null se não for encontrado
     */
    @Override
    public String getUserName(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("ID de usuário inválido.");
        }

        try {
            return userDAO.readById(userId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter o nome do usuário: " + e.getMessage(), e);
        }
    }
}
