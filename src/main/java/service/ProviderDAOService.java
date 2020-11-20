package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AccountLogged;
<<<<<<< HEAD
import model.AdminAcceptProvider;
import model.Provider;

public class ProviderDAOService {

	public void selectAllProviders(int location) throws SQLException {

=======
import model.Provider;

public class ProviderDAOService {
	
	public void selectAllProviders(int location) throws SQLException {
		
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;

<<<<<<< HEAD
		AccountLogged.providers.clear();

		try {
			connection = DatabaseService.getDBConnection();
			String query = "SELECT Account.id, Provider.star, Account.name  FROM Provider INNER JOIN Account ON Provider.idProvider = Account.id where Provider.location = "
					+ location;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Provider provider = new Provider();

=======
		try {
			connection = DatabaseService.getDBConnection();
			String query = "SELECT Account.id, Provider.star, Account.name  FROM Provider INNER JOIN Account ON Provider.idProvider = Account.id where Provider.location = " + location;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) 
			{
				Provider provider = new Provider();
				
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
				provider.setIdProvider(resultSet.getInt(1));
				provider.setLocation(location);
				provider.setStar(resultSet.getInt(2));
				provider.setName(resultSet.getString(3));
				AccountLogged.providers.add(provider);
			}
<<<<<<< HEAD

		} catch (SQLException exception) {
			exception.printStackTrace();

		} finally {
			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}
	}

	public void selectAllProviders() throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;

		AccountLogged.adminAcceptProviders.clear();

		try {
			connection = DatabaseService.getDBConnection();
			String query = "SELECT AccountWaiting.id, Account.name, AccountWaiting.location FROM AccountWaiting INNER JOIN Account ON AccountWaiting.id = Account.id where AccountWaiting.accepted = 0";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				AdminAcceptProvider provider = new AdminAcceptProvider();
				provider.setId(resultSet.getInt(1));
				provider.setName(resultSet.getString(2));
				provider.setLocation(resultSet.getInt(3));
				AccountLogged.adminAcceptProviders.add(provider);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();

=======
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
		} finally {
			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}
	}

<<<<<<< HEAD
	public boolean updateProvider(int id, int location) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
			String query = "UPDATE AccountWaiting SET accepted = 1 WHERE id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			connection.commit();
			resultSet = statement.getResultSet();

			return true;

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

		return false;
	}
	
	public boolean removeProvider(int id) throws SQLException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
			String query = "DELETE FROM AccountWaiting WHERE id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			connection.commit();
			resultSet = statement.getResultSet();

			return true;

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

		return false;
	}

=======
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
}
