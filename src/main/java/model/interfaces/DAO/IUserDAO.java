package model.interfaces.DAO;

public interface IUserDAO {

    public int read(String name, String password);

    public String readById(int userId);

    public boolean create(String name, String email, String password);
}
