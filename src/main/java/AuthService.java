//package info.tatarintsev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class AuthService {

    AuthService() {
    }

    synchronized Client auth(String login, String password) {
        try {
            Class.forName("org.sqlite.JDBC");
            final Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson.db");
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT ID, NAME from STUDENT WHERE LOGIN = ? AND PASSWORD = ?");

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Client(resultSet.getString("name"), login, password);
            }

            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден дравер SQLite");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
        }

        return null;
    }
}
