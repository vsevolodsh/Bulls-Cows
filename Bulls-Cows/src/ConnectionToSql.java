
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionToSql {

    static Connection createConnection() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String url = "jdbc:sqlserver://ИВАНМИХАЙЛОВИЧ\\MSSQLSERVER;databaseName=Bulls-Cows";
        String username = "sa";
        String password = "123456";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
        return  DriverManager.getConnection(url, username, password);



    }
}


