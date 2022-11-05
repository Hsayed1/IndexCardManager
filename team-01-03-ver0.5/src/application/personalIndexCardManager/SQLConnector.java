package application.personalIndexCardManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    /*
     * Check database for the specified user
     * 
     */
    public void getAllUsers(String database, String table) {
    	
    	// PreparedStatement where it pulls data from the database
    	String sql = "SELECT email, password, securityQuest, securityAns FROM " + table;
    	try (Connection conn = this.connect(database);
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
                
               // loop through the result set
               while (rs.next()) {
                   System.out.println(rs.getString("email") +  "\t" + 
                                       rs.getString("password") + "\t" +
                                       rs.getString("securityQuest") + "\t" +
                                       rs.getString("securityAns"));
               }
               
           } catch (SQLException e) {
               e.getStackTrace();
           }
    }
    
    /*
     * Find the specified user in the database by email
     * 
     */
    public boolean findEmail(String database, String table, String email) {
    	
    	// PreparedStatement where it pulls a piece of data that matches
    	// with the desired username from teh database
    	String sql = "SELECT email FROM " + table + " WHERE email = ?";
    	
    	// Establishes a connection to the database and creates a statement
    	//
    	try (Connection con = this.connect(database);
                PreparedStatement statement  = con.prepareStatement(sql)) {
    		
    		// Gets the user with the desired email
    		statement.setString(1, email);
    		
    		
    		// Check if user is found in the database
    		ResultSet rs  = statement.executeQuery();
    		if (rs.next()) {
                System.out.println(rs.getString("email"));
                return true;
            }
    		return false;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		
    	}
    	return false;
    }
    
    /*
     * Find the specified user in the database by email
     * 
     * Tables: Users
     * 
     */
    public boolean findPass(String database, String table, String email, String password) {
    	
    	// PreparedStatement where it pulls a piece of data that matches
    	// with the desired username from teh database
    	String sql = "SELECT email, password FROM " + table + " WHERE email = ? and password = ?";
    	
    	// Establishes a connection to the database and creates a statement
    	//
    	try (Connection con = this.connect(database);
                PreparedStatement statement  = con.prepareStatement(sql)) {
    		
    		// Gets the user with the desired password
    		statement.setString(1, email);
    		statement.setString(2, password);
    		
    		
    		// Check if user is found in the database
    		ResultSet rs  = statement.executeQuery();
    		if (rs.next()) {
                System.out.println(rs.getString("email") + "\t" +
                		rs.getString("password"));
                return true;
            }
    		return false;
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    		
    	}
    	return false;
    }
    
    /*
     * Find the specified user in the database by email
     * 
     */
    public String getSecQuest(String database, String table, String email) {
    	
    	// PreparedStatement where it pulls a piece of data that matches
    	String sql = "SELECT email, securityQuest FROM " + table + " WHERE email = ?";
    	
    	// Establishes a connection to the database and creates a statement
    	//
    	try (Connection con = this.connect(database);
                PreparedStatement statement  = con.prepareStatement(sql)) {
    		
    		// Gets the user with the desired password
    		statement.setString(1, email);
    		
    		
    		// Check if user is found in the database
    		ResultSet rs  = statement.executeQuery();
    		if (rs.next()) {
                System.out.println(rs.getString("email") + "\t" +
                		rs.getString("securityQuest"));
                return rs.getString("SecurityQuest");
            }
    		return null;
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    		
    	}
    	return null;
    }
    
    // Tests using dummy database
    public static void main(String[] args) {
    	 SQLConnector app = new SQLConnector();
    	 
    	 User user = new User("example12324@email.com","password1","What is your favorite video game","Shulk");
    	 
         //app.addUser("usersTest.db","Users",user);
         app.getAllUsers("usersTest.db", "Users");
         System.out.println();
         System.out.println(app.findEmail("usersTest.db", "Users", "example12324@email.com"));
         System.out.println(app.findPass("usersTest.db", "Users", "example12324@email.com","password1"));
         System.out.println(app.getSecQuest("usersTest.db", "Users", "example12324@email.com"));
    }
}
