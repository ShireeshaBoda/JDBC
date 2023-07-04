package com.taashee.jdbc.dao;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	private static  ConnectionFactory connectionFactory=new ConnectionFactory();
	private final String URL="jdbc:mysql://localhost:3306/training";
	private final String USERNAME="root";
	private final String PASSWORD="Siri123#";
	        public ConnectionFactory()
	        {
	        	try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	}
	        	catch(ClassNotFoundException e){
	        		e.printStackTrace();
	        		
	        	}
	        }
             private Connection fetchConnection() {
            	 Connection con=null;
            	 try {
            		 con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            		 
            	 }
            	 catch(SQLException throwables)
            	 {
            		 throwables.printStackTrace();
            	 }
            	 return con;
             }
             public  static Connection getConnection() {
            	 return connectionFactory.fetchConnection();
             }
}
