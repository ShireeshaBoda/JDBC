package com.taashee.jdbc.dao;
import java.sql.*;
public class PhoneDAO {
	 public void getAllPhones() {
	    	try {
	    	Connection con=ConnectionFactory.getConnection();
	    	Statement statement=con.createStatement();

	    	ResultSet rs=statement.executeQuery("SELECT * FROM phone");
	    	while(rs.next())
	    	{
	    		System.out.printf("\n%s manufactured by %s",rs.getString("name"),rs.getString("manufacturer"));
	    	}
	    	con.close();
	        statement.close();
	    	}
	    	catch(SQLException throwables){
	    		throwables.printStackTrace();
	    		
	    	}
	    }
	 public void addPhone(String name,String manufacturer)
	    {
	    	String insertQuery="INSERT INTO phone(name,manufacturer) VALUES(?,?)";
	    	try(
	    		Connection con=ConnectionFactory.getConnection();
	    		PreparedStatement statement = con.prepareStatement(insertQuery))
	    	{
	    			statement.setString(1,name);
	    			statement.setString(2,manufacturer);
	    			int rowsInserted=statement.executeUpdate();
	    			if(rowsInserted>0)
	    				System.out.printf("Successfully inserted %s", name);
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	 public void getPhoneByName(String name) {

	    	String getUserNameQuery="SELECT * FROM phone WHERE name=?";
	    	try(
	    		Connection con=ConnectionFactory.getConnection();
	    		PreparedStatement statement = con.prepareStatement(getUserNameQuery))
	    	{
	    		statement.setString(1,name);
	    		ResultSet rs=statement.executeQuery();
	    		
	        	while(rs.next())
	        	{
	        		System.out.printf("\n%s manufactured by %s",rs.getString("name"),rs.getString("manufacturer"));
	        	}
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	 public void updatePhone(int id,String name,String manufacturer)
	    {
	    	
	    		String updateQuery = "UPDATE phone SET name=? ,manufacturer=? where id=?";
	    	try (
	    			Connection con=ConnectionFactory.getConnection();
	    			
	    			PreparedStatement stmt = con.prepareStatement(updateQuery))
	    	{
	    		    stmt.setString(1,name);
	    		    stmt.setString(2,manufacturer);
	    		    stmt.setInt(3,id);
	    	         int r=stmt.executeUpdate();
	    	         if(r>0)
	    	        	 System.out.printf("Updated Successfully phone %s",name);
	                  
	    			}
	    	
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	}
	 public void deletePhone(int id)
	    {
	    	String deleteQuery = "DELETE FROM phone WHERE id=?";
	    	try (
	    			Connection con=ConnectionFactory.getConnection();
	    			
	    			PreparedStatement stmt = con.prepareStatement(deleteQuery))
	    	{
	    		    stmt.setInt(1,id);
	    		    
	    	         int r=stmt.executeUpdate();
	    	         if(r>0)
	    	        	 System.out.printf("deleted Successfully phone %d",id);
	                  
	    			}
	    	
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}

	    }
	 public void searchPhone(String name,String manufacturer)
	    {
	    	String searchquery="SELECT *FROM phone WHERE name LIKE ? AND manufacturer LIKE ?";
	    	try(Connection con=ConnectionFactory.getConnection();
	    			PreparedStatement stmt=con.prepareStatement(searchquery))
	    	{
	    		stmt.setString(1, "%"+name+"%");
	    		stmt.setString(2, "%"+manufacturer+"%");
	          ResultSet rs=stmt.executeQuery();
	    		
	        	while(rs.next())
	        	{
	        		System.out.printf("\n%s manufactured by %s",rs.getString("name"),rs.getString("manufacturer"));
	        	}
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	}
	    }
