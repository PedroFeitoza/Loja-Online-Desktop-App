package controller;

import model.DAO.UserDAO;

public class UserController {

    public boolean login(String name, String password) {
        var dao = new UserDAO();
        return dao.loginUser(name, password);
    }
    
    public boolean register(String name, String email, String password) {
        var dao = new UserDAO();
        return dao.registerUser(name, email, password);
    }
}
