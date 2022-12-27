package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ScannerJdbc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// user input
		System.out.println("Enter ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Name: ");
		String ename = sc.next();
		System.out.println("Enter Phone: ");
		String ephone = sc.next();
		System.out.println("Enter Address:");
		String eadd = sc.next();
		System.out.println("Enter Department: ");
		String edept = sc.next();
		System.out.println("Enter Salary");
		double esalary = sc.nextDouble();
		try {
			// register driver step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get connection step 2
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/niladri_db", "root",
					"Niladri@1993");
			// creating statement
			PreparedStatement stm;
			// inserting data in database table
			String sql = "insert into Employee values(?,?,?,?,?,?)"; // no. of column
			stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			stm.setString(2, ename);
			stm.setString(3, ephone);
			stm.setString(4, eadd);
			stm.setString(5, edept);
			stm.setDouble(6, esalary);
			stm.execute();
			System.out.println("Inserted succesfully");
			// close database connection step 5
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
