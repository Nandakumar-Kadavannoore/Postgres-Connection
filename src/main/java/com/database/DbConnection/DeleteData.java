package com.database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {

	public void process(Connection con){
		PreparedStatement stmt;
		Scanner scan = new Scanner(System.in);
		try {
			stmt = con.prepareStatement("delete from student_details where id=?");
			System.out.println("Enter Student Id:: ");
			int id = scan.nextInt();
			stmt.setInt(1,id);  
			  
			stmt.executeUpdate();  
		} catch (SQLException e) {
		
			e.printStackTrace();
		}  
	
	 scan.close();	 
	}
}
