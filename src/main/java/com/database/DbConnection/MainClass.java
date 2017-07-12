package com.database.DbConnection;

import java.sql.*;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception ex) {
			System.out.println(ex);
		}	
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tracking_table", "postgres",
					"attinad@123");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		if (con != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		  
	    System.out.println("--------------Main_Menu------------");
	    int choice=0;
	    Scanner scan = new Scanner(System.in);
	    do{
	    	System.out.println("1] Insert Data");
	    	System.out.println("2] Display Data");
	    	System.out.println("3] Delete Data");
	    	System.out.println("4] Exit");
	    	choice = scan.nextInt();
	    	switch(choice){
	    	case 1 : InsertData insertData = new InsertData();
	    	         insertData.process(con);
	    	         insertData = null;
	    	       break;
	    	case 2 : DisplayDb displayDb = new DisplayDb();
	    	         displayDb.process(con);
	    	         displayDb = null;
	    	       break;
	    	case 3 : DeleteData deleteData = new DeleteData();
	    	         deleteData.process(con);
	    	         deleteData = null;
	    	        break; 
	    	case 4 : choice = 4;
	    	       break;
	    	default : System.out.println("Wrong Entry");       
	    	}
	    }while(choice!=4);
	    scan.close();
		con.close();  
	}
}
