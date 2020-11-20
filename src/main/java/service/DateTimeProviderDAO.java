package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AccountLogged;
import model.DateTimeProvider;
<<<<<<< HEAD
import model.Provider;
=======
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5

public class DateTimeProviderDAO {

	public void selectAllProviders(int available, int idProvider) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;
<<<<<<< HEAD

		AccountLogged.datetimeproviders.clear();

=======
		
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
		try {
			connection = DatabaseService.getDBConnection();
			String query = "SELECT id, idCustumer, idProvider, Year, Month, Day, Hour, Minute, Available FROM DateTimeProvider WHERE Available = "
					+ available + " and idProvider = " + idProvider;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				DateTimeProvider provider = new DateTimeProvider();
				provider.setId(resultSet.getInt(1));
				provider.setIdCustumer(resultSet.getInt(2));
				provider.setIdProvider(resultSet.getInt(3));
				provider.setYear(resultSet.getInt(4));
				provider.setMonth(resultSet.getInt(5));
				provider.setDay(resultSet.getInt(6));
				provider.setHour(resultSet.getInt(7));
				provider.setMinute(resultSet.getInt(8));
				provider.setAvailable(resultSet.getInt(9));
				AccountLogged.datetimeproviders.add(provider);
			}

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
<<<<<<< HEAD

	public boolean saveProvider(int idCustumer, int id) throws SQLException {
=======
	
	public boolean saveProvider(int idCustumer, int id) throws SQLException 
	{
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
<<<<<<< HEAD
			String query = "UPDATE DateTimeProvider SET idCustumer = ?, Available = 0, Accept = 0 WHERE id = ?;";
=======
			String query = "UPDATE DateTimeProvider SET idCustumer = ?, Available = 0 WHERE id = ?;";
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
			statement = connection.prepareStatement(query);
			statement.setInt(1, idCustumer);
			statement.setInt(2, id);
			statement.executeUpdate();
			connection.commit();
			resultSet = statement.getResultSet();
<<<<<<< HEAD

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

	public void selectAllBookings(int id) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;

		AccountLogged.datetimeproviders.clear();

		try {
			connection = DatabaseService.getDBConnection();
			String query = "SELECT Account.name, DateTimeProvider.id, DateTimeProvider.idProvider, DateTimeProvider.Year, DateTimeProvider.Month, DateTimeProvider.Day, DateTimeProvider.Hour, DateTimeProvider.Minute FROM DateTimeProvider INNER JOIN Account ON DateTimeProvider.idProvider = Account.id WHERE Available = 0 and idCustumer = "
					+ id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				DateTimeProvider provider = new DateTimeProvider();
				provider.setProviderName(resultSet.getString(1));
				provider.setId(resultSet.getInt(2));
				provider.setIdCustumer(id);
				provider.setIdProvider(resultSet.getInt(3));
				provider.setYear(resultSet.getInt(4));
				provider.setMonth(resultSet.getInt(5));
				provider.setDay(resultSet.getInt(6));
				provider.setHour(resultSet.getInt(7));
				provider.setMinute(resultSet.getInt(8));
				provider.setAvailable(0);
				AccountLogged.datetimeproviders.add(provider);
			}

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

	public boolean updateBooking(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
			String query = "UPDATE DateTimeProvider SET Available = 1, Accept = 0, idCustumer = null WHERE id = ?;";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			connection.commit();
			resultSet = statement.getResultSet();

			return true;

=======
			
			return true;
			
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
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

<<<<<<< HEAD
	public boolean updateAcceptProvider(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
			String query = "UPDATE DateTimeProvider SET Available = 0, Accept = 1 WHERE id = ?;";
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

	public boolean updateDenyProvider(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseService.getDBConnection();
			connection.setAutoCommit(false);
			String query = "UPDATE DateTimeProvider SET Available = 1, Accept = 0, idCustumer = null WHERE id = ?;";
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

	public void selectAllProviderBookings(int id) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;

		AccountLogged.datetimeproviders.clear();

		try {
			connection = DatabaseService.getDBConnection();
			String query = "SELECT DateTimeProvider.id, DateTimeProvider.Year, DateTimeProvider.Month, DateTimeProvider.Day, DateTimeProvider.Hour, DateTimeProvider.Minute, Account.name  FROM DateTimeProvider INNER JOIN Account ON DateTimeProvider.idCustumer = Account.id WHERE Available = 0 AND Accept = 0 AND DateTimeProvider.idProvider = "
					+ id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				DateTimeProvider provider = new DateTimeProvider();
				provider.setId(resultSet.getInt(1));
				provider.setYear(resultSet.getInt(2));
				provider.setMonth(resultSet.getInt(3));
				provider.setDay(resultSet.getInt(4));
				provider.setHour(resultSet.getInt(5));
				provider.setMinute(resultSet.getInt(6));
				provider.setProviderName(resultSet.getString(7));
				AccountLogged.datetimeproviders.add(provider);
			}

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

=======
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
}
