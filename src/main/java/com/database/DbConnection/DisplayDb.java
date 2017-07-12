package com.database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayDb {

	public void process(Connection con) {

		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = con.prepareStatement("select * from student_details");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);

				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
