package com.perso.sports.repository;

import com.perso.sports.entity.User;
import com.perso.sports.utils.JdbcUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements CrudDao<User> {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/sports?serverTimezone=GMT";
    private final static String DB_USER = "toto";
    private final static String DB_PASSWORD = "Titi123!";

    @Override
    public User save(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            if (connection != null){
                System.out.println("Successfully connected to MySQL database test");
            }
            statement= connection.prepareStatement(
                    "INSERT INTO users (name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, user.getName());
            if (statement.executeUpdate() !=1){
                throw new SQLException("Failed to insert data");
            }
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                Long idUsers = generatedKeys.getLong(1);
                user.setIdUsers(idUsers);
                return user;
            } else {
                throw new SQLException("Failed to get inserted id");
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeResultSet(generatedKeys);
        }
        return null;
    };

    @Override
    public User findById(Long idUsers){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE idUsers = ?;"
            );
            statement.setLong(1, idUsers);
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                String name = resultSet.getString("name");
                return new User(idUsers, name);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeResultSet(resultSet);
        }
        return null;
    };

    @Override
    public List<User> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM users;"
            );
            resultSet = statement.executeQuery();

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                Long idUsers = resultSet.getLong("idUsers");
                String name = resultSet.getString("name");
                users.add(new User(idUsers, name));
            }
            return users;

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeResultSet(resultSet);
        }
        return null;
    }

    @Override
    public User update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "UPDATE users SET name=? WHERE idUsers=?"
            );
            statement.setString(1, user.getName());
            statement.setLong(2, user.getIdUsers());
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return user;


        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long idUsers) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "DELETE FROM users WHERE idUsers=?"
            );
            statement.setLong(1, idUsers);

            if (statement.executeUpdate() != 1) {
                return false;
            }
            return true;
        } catch (SQLException e) {
             e.printStackTrace();
            return false;
        } finally {
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }    }
}
