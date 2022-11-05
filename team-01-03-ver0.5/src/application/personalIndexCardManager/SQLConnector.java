package application.personalIndexCardManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLConnector {
	
	/**
     * Connect to the desired database
     * in resources/database
     *
     * @return the Connection object
     */
    private Connection connect(String database) {
    	
        // SQLite connection string for this project
        String url = "jdbc:sqlite:resources/database/" + database;
        Connection conn = null;
        
        try {
        	// Establishes a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*
     * Inserts a new user into the database
     * 
     * Available tables: Users
     * 
     */
    public void addUser(String database, String table, User user) {
    	String sql = "INSERT INTO " + table + "(email, password, securityQuest, securityAns) VALUES(?,?,?,?)";

    	// Establishes a connection to the database
    	// Prepares a statement
    	try (Connection conn = this.connect(database);
    			PreparedStatement statement = conn.prepareStatement(sql)) {
    		
    		// Extracts data from user object and put into database
    		statement.setString(1, user.getEmail());
    		statement.setString(2, user.getPass());
    		statement.setString(3, user.getSecurityQuest());
    		statement.setString(4, user.getSecurityAns());
           
    		// Updates database
    		statement.executeUpdate();
    		
    		System.out.println("Added new user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Tests using dummy database
    public static void main(String[] args) {
    	 SQLConnector app = new SQLConnector();
    	 
    	 User user = new User("example12324@email.com","password1","What is your favorite video game","Shulk");
    	 
         app.addUser("usersTest.db","Users",user);
    }
}
