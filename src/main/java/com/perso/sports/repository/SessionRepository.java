package com.perso.sports.repository;

import com.perso.sports.entity.Sessions;
import com.perso.sports.utils.JdbcUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SessionRepository implements CrudDao<Sessions> {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/sports?serverTimezone=GMT";
    private final static String DB_USER = "toto";
    private final static String DB_PASSWORD = "Titi123!";

    @Override
    public Sessions save(Sessions sessions){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement= connection.prepareStatement(
                    "INSERT INTO sessions (idMovements, idUsers, date, repetitions, weight, name  ) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setLong(1, sessions.getIdMovements());
            statement.setLong(2, sessions.getIdUsers());
            statement.setTimestamp(3, Timestamp.from(sessions.getDate()));
            statement.setInt(4, sessions.getRepetitions());
            statement.setInt(5, sessions.getWeight());
            statement.setString(6, sessions.getName());

            if (statement.executeUpdate() !=1){
                throw new SQLException("Failed to insert data");
            }
            generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()){
                Long idSessions = generatedKeys.getLong(1);
                sessions.setIdSessions(idSessions);
                return sessions;
            } else {
                throw new SQLException("Failed to get inserted id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeResultSet(generatedKeys);
        }
        return null;
    }

    @Override
    public Sessions findById(Long idSessions) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM sessions WHERE idSessions=?;"
            );
            statement.setLong(1, idSessions);
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                Long idMovements = resultSet.getLong("idMovements");
                Long idUsers = resultSet.getLong("idUsers");
                Instant date = resultSet.getTimestamp("date").toInstant();
                int repetitions = resultSet.getInt("repetitions");
                int weight = resultSet.getInt("weight");
                String name = resultSet.getString("name");
                return new Sessions(idMovements, idSessions, idUsers, date, repetitions, weight, name);
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
    public List<Sessions> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM sessions;"
            );
            resultSet = statement.executeQuery();
            List<Sessions> sessions = new ArrayList<>();

            while (resultSet.next()){
                Long idMovements = resultSet.getLong("idMovements");
                Long idSessions = resultSet.getLong("idSessions");
                Long idUsers = resultSet.getLong("idUsers");
                Instant date = resultSet.getTimestamp("date").toInstant();
                int repetitions = resultSet.getInt("repetitions");
                int weight = resultSet.getInt("weight");
                String name = resultSet.getString("name");
                sessions.add(new Sessions(idMovements,idSessions,idUsers, date,repetitions, weight, name));
            }
            return sessions;

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
    public Sessions update(Sessions sessions) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "UPDATE sessions SET idMovements=?, idUsers=?, date=?, repetitions=?, weight=?,name=?  WHERE idSessions=?"
            );
            statement.setLong(1, sessions.getIdMovements() );
            statement.setLong(2, sessions.getIdUsers() );
            statement.setTimestamp(3,  Timestamp.from(sessions.getDate()) );
            statement.setInt(4, sessions.getRepetitions() );
            statement.setInt(5, sessions.getWeight() );
            statement.setString(6, sessions.getName() );
            statement.setLong(7, sessions.getIdSessions());

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return sessions;

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
    public boolean deleteById(Long idSessions) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "DELETE FROM sessions WHERE idSessions=?"
            );
            statement.setLong(1, idSessions);

            return statement.executeUpdate() == 1;

        } catch (SQLException e){
            e.printStackTrace();
            return false;

        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
        }

    }
}
