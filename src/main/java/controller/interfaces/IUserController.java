package controller.interfaces;

public interface IUserController {
    public int Login(String name, String password);
    public boolean Register(String name, String email, String password);
}
