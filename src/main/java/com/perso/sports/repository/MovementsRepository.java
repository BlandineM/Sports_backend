package com.perso.sports.repository;

import com.perso.sports.entity.Movements;
import com.perso.sports.utils.JdbcUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MovementsRepository implements CrudDao<Movements> {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/sports?serverTimezone=GMT";
    private final static String DB_USER = "toto";
    private final static String DB_PASSWORD = "Titi123!";

    @Override
    public Movements save(Movements movements) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement= connection.prepareStatement(
                    "INSERT INTO movemments (name, shortName, description) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, movements.getName());
            statement.setString(2, movements.getShortName());
            statement.setString(3, movements.getDescription());

            if (statement.executeUpdate() !=1){
                throw new SQLException("Failed to insert data");
            }
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                Long idMovements = generatedKeys.getLong(1);
                movements.setIdMovements(idMovements);
                return movements;
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
    }

    @Override
    public Movements findById(Long idMovements) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM movements WHERE idMovements = ?;"
            );
            statement.setLong(1, idMovements);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String shortName = resultSet.getString("shortName");
                String description = resultSet.getString("description");
                return new Movements(idMovements, name, shortName, description);
            }

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
    public List<Movements> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM movements;"
            );
            resultSet = statement.executeQuery();

            List<Movements> movements = new ArrayList<>();

            while (resultSet.next()){
                Long idMovements = resultSet.getLong("idMovements");
                String name = resultSet.getString("name");
                String shortName = resultSet.getString("shortName");
                String description = resultSet.getString("description");
                movements.add(new Movements(idMovements, name, shortName, description));
            }
            return movements;

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
    public Movements update(Movements movements) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "UPDATE users SET name=?, shortName=?, description=? WHERE idUsers=?"
            );
            statement.setString(1, movements.getName());
            statement.setString(2, movements.getShortName());
            statement.setString(3, movements.getDescription());
            statement.setLong(4, movements.getIdMovements());
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return movements;
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
    public boolean deleteById(Long idMovements) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "DELETE FROM movements WHERE idMovements=?"
            );
            statement.setLong(1, idMovements);

            return statement.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
            return false;

        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
        } }


}
