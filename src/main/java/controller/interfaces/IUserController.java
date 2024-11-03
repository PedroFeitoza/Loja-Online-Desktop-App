package controller.interfaces;

public interface IUserController {

    public String GetUserName(int userId);

    public int Login(String name, String password);

    public boolean Register(String name, String email, String password);
}
