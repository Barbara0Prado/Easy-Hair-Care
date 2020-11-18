package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AccountLogged;
import model.Provider;

public class ProviderDAOService {
	
	public void selectAllProviders(int location) throws SQLException {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;

		try {
			connection = DatabaseService.getDBConnection();
			String query = "SELECT Account.id, Provider.star, Account.name  FROM Provider INNER JOIN Account ON Provider.idProvider = Account.id where Provider.location = " + location;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) 
			{
				Provider provider = new Provider();
				
				provider.setIdProvider(resultSet.getInt(1));
				provider.setLocation(location);
				provider.setStar(resultSet.getInt(2));
				provider.setName(resultSet.getString(3));
				AccountLogged.providers.add(provider);
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

}
