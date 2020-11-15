package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {

    /*
	 * Database connection
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String NAME = "Barbara_2019143";
    private static final String CONNECTION = "jdbc:mysql://52.50.23.197:3306/";
    private static final String USER = "Barbara_2019143";
    private static final String PASSWORD = "2019143";
    
   

    private DatabaseService() {

    }

    /*
	 * Create table if it does not exist (can create database as well in case of not exist.
     */
    public static void CreateTable() {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
            Statement statement = connection.createStatement();
            //CREATE DATABASE IF NOT EXISTS
            String s = "CREATE TABLE IF NOT EXISTS `Barbara_2019143`.`Account` (`id` INT auto_increment  PRIMARY KEY,`name` VARCHAR(45) NOT NULL,`email` VARCHAR(45) NOT NULL,`number` INT NOT NULL,`password` VARCHAR(45) NOT NULL,UNIQUE INDEX `id_UNIQUE` (`id` ASC),UNIQUE INDEX `email_UNIQUE` (`email` ASC));";
            statement.executeUpdate(s);
            s = "CREATE TABLE IF NOT EXISTS `Barbara_2019143`.`Role` (`id` INT NOT NULL,`Name` VARCHAR(45) NOT NULL,UNIQUE INDEX `id_UNIQUE` (`id` ASC), PRIMARY KEY (`id`));";
            statement.executeUpdate(s);
            s = "CREATE TABLE IF NOT EXISTS `Barbara_2019143`.`AccountRole` (`idAccount` INT NULL,`idRole` INT NULL,INDEX `idAccountKey_idx` (`idAccount` ASC),INDEX `idRoleKey_idx` (`idRole` ASC, `idAccount` ASC),CONSTRAINT `idAccount` FOREIGN KEY (`idAccount`) REFERENCES `Barbara_2019143`.`Account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION, CONSTRAINT `idRole` FOREIGN KEY (`idRole`) REFERENCES `Barbara_2019143`.`Role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            statement.executeUpdate(s);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
    }

    /*
	 * Get connection
     */
    public static Connection getDBConnection() {
        Connection connection = null;
        
        /*
         * Search for a driver first
         */
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
            return connection;
        }

        /*
         * Create database if it does not exist
         */
        CreateTable();


        try {
            connection = DriverManager.getConnection(CONNECTION + NAME, USER, PASSWORD);
            return connection;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return connection;
    }
}
