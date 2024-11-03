package model.interfaces.DAO;

public interface IUserDAO {

    public int Read(String name, String password);

    public String ReadById(int userId);

    public boolean Create(String name, String email, String password);
}
