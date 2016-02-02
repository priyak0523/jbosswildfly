/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbosswildfly;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author c0664573
 */
public class jbosswildfly {
     private static Connection getConnection() throws SQLException {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jbosswildfly.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        String name = "jbosswildfly";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
        return DriverManager.getConnection(url, username, password);
    }
    
    public static String getTable(){
        String output = "";
        try{
            Connection conn = getConnection();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM people");
            while(rs.next()){
                output+= "<h2>" + rs.getString("name") + "<h2/>";
                output+= "<p>" + rs.getString("bio") + "</p>";
            }
            conn.close();
        }
        catch (SQLException ex){
            output = "SQL EXCEPTION: " + ex.getMessage();
        } 
        return output;
        
    }
}
