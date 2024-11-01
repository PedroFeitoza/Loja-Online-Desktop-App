package model.interfaces.DAO;

public interface IUserDAO {
     public boolean Read(String nome, String senha);
     public boolean Create(String name, String email, String password);
}
