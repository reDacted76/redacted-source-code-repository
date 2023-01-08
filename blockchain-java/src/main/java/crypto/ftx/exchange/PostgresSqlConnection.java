import java.sql.*;

public class PostgresSqlConnection {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5434/test_database";
        String user = "postgres";
        String password = "batman";

        Connection connection = DriverManager.getConnection(url, user, password );
        //SQL STATEMENT
        String sql = "";
        //
        Statement statement = connection.createStatement();
        //
        statement.executeUpdate(sql);
        //Close sql statement
        statement.close();
        //Close connection
        connection.close();

    }
}
