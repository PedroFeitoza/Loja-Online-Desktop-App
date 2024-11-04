package controller.interfaces;

public interface IUserController {

    public String getUserName(int userId);

    public int login(String name, String password);

    public boolean register(String name, String email, String password);
}
