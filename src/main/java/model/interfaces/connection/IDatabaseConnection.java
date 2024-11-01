package model.interfaces.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IDatabaseConnection {
    public Connection GetConnection();
    public void CloseConnection(Connection con);
    public void CloseConnection(Connection con, PreparedStatement stmt);
    public void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs);
}
