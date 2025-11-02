package ElektroNet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {

    Connection connection;
    Statement statement;

    public database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elektro_net", "root", "YOUR_PASSWORD");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
