package info.tatarintsev;

import java.sql.*;

import static info.tatarintsev.Server.userLogger;

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
            userLogger.error("Не найден дравер SQLite");
        } catch (SQLException e) {
            userLogger.error("Can't get connection. Incorrect URL");
            e.printStackTrace();
        }

        return null;
    }
}
