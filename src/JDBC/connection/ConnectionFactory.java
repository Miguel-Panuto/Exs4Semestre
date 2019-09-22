package JDBC.connection;

import java.sql.*;

public class ConnectionFactory
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/testebd?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1234";

    public static Connection getConnection()
    {
        try
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException("Erro na conexão", e);
        }
    }

    public static void closeConnection(Connection con)
    {
        if (con != null)
        {
            try
            {
                con.close();
            } catch (SQLException e)
            {
                throw new RuntimeException("Erro no fechamento da conexão", e);
            }

        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt)
    {
        if (stmt != null)
        {
            try
            {
                stmt.close();
            } catch (SQLException e)
            {
                throw new RuntimeException("Erro no fechamento da conexão", e);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            } catch (SQLException e)
            {
                throw new RuntimeException("Erro no fechamento da conexão", e);
            }
        }
        closeConnection(con, stmt);
    }
}
