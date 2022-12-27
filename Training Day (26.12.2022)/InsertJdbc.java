package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJdbc {

	public static void main(String[] args) {
		try {
			// register driver step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get connection step 2
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/niladri_db", "root",
					"Niladri@1993");
			// create statement step 3
			Statement stmt = conn.createStatement();
			// inserting the data to datebase serp 4
			stmt.executeUpdate("insert into Employee values (5,'Misbha',9875413698,'Kolaghat','MSC',4000.20)");
			System.out.println("Inserted succesfully");
			// close database connection step 5
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
