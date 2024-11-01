package controller;

import controller.interfaces.IUserController;
import model.DAO.UserDAO;
import model.interfaces.DAO.IUserDAO;

public class UserController implements IUserController {
    private final IUserDAO DAO = new UserDAO();   

    public boolean Login(String name, String password) {
        return DAO.Read(name, password);
    }
    
    public boolean Register(String name, String email, String password) {
        return DAO.Create(name, email, password);
    }
}
