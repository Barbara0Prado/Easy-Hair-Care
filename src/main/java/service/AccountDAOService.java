package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Account;

public class AccountDAOService {
	
	public int saveAccount(Account account) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
			String query = "INSERT INTO Account(name, email, number, password) VALUES(?, ?, ?, ?)";
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, account.getName());
			statement.setString(2, account.getEmail());
			statement.setInt(3, account.getNumber());
			statement.setString(4, account.getPassword());
			statement.executeUpdate();
			connection.commit();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException exception) {
			exception.getMessage();
			if (null != connection) {
				connection.rollback();
			}
		} finally {
			if (null != resultSet) {
				resultSet.close();
			}

			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}

		return 0;
	}
	
	public int saveAccountRole(Account account, int role) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
			String query = "INSERT INTO `Barbara_2019143`.`AccountRole`(`idAccount`,`IdRole`) VALUES(?, ?);";
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, account.getId());
			statement.setInt(2, role);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException exception) {
			exception.getMessage();
			if (null != connection) {
				connection.rollback();
			}
		} finally {
			if (null != resultSet) {
				resultSet.close();
			}

			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}

		return 0;
	}


}
