package model.interfaces.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IDatabaseConnection {
    public Connection getConnection();

    public void closeConnection(Connection con);

    public void closeConnection(Connection con, PreparedStatement stmt);

    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs);
}
