package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
		try {
			// register driver step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get connection step 2
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/niladri_db", "root",
					"Niladri@1993");
			// create statement step 3
			Statement stmt = conn.createStatement();
			// execute querry fetch data from datebase step 4
			ResultSet rs = stmt.executeQuery("select * from CUSTOMER");
			// iteration
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

			}
			// close database connection step 5
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
