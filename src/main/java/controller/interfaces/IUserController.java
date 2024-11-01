package controller.interfaces;

public interface IUserController {
    public boolean Login(String name, String password);
    public boolean Register(String name, String email, String password);
}
