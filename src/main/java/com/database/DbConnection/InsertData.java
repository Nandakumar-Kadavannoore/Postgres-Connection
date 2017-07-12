package com.database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
	
	public void process(Connection con){
		PreparedStatement stmt;
		Scanner scan = new Scanner(System.in);
		int choice = 3;
		do{
		try {
			stmt = con.prepareStatement("insert into student_details values(?,?)");
			System.out.println("Enter Student Id:: ");
			int id = scan.nextInt();
			stmt.setInt(1,id);
			System.out.println("Enter Student Name: ");
			String string = scan.nextLine();
			stmt.setString(2,string);  			  
	      	stmt.executeUpdate();  
	      	System.out.println("To Exit Enter 3");
	      	choice = scan.nextInt();
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
		}while(choice!=3);
	    scan.close();
			
		
	}

}
