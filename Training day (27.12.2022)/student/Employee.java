package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.menudriven.Helper;

public class Employee {
	Scanner sc = new Scanner(System.in);
	int e_id;
	double e_sal;
	String e_name, e_add, e_dept;
	long e_phone;

	// saving student details in databse
	public void saveMenudriven() throws SQLException {
		System.out.println("Enter Employee id: ");
		e_id = sc.nextInt();
		System.out.println("Enter Employee Name: ");
		e_name = sc.next();
		System.out.println("Enter Employee Phone: ");
		e_phone = sc.nextLong();
		System.out.println("Enter Employee Address: ");
		e_add = sc.next();
		System.out.println("Enter Employee Department: ");
		e_dept = sc.next();
		System.out.println("Enter Employee Fees: ");
		e_sal = sc.nextDouble();

		Connection conn = Helper.con();

		PreparedStatement stmt = conn.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
		stmt.setInt(1, e_id);
		stmt.setString(2, e_name);
		stmt.setLong(3, e_phone);
		stmt.setString(4, e_add);
		stmt.setString(5, e_dept);
		stmt.setDouble(6, e_sal);
		stmt.executeUpdate();

	}

	// fetching Student details in the database (display)
	public void fetchMenudriven() throws SQLException {
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement(); // create statement
		// execute query fetch data from database
		ResultSet rs = stmt.executeQuery("select * from Employee");
		// iteration
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getLong(3) + " " + rs.getString(4) + " "
					+ rs.getString(5) + " " + rs.getDouble(6));
			System.out.println("Data inserted & saved successfully------------------");
		}
	}

	// updating student details in database
	public void updateMenudriven() throws SQLException {
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement(); // create statement
		System.out.println("Enter Employee address: ");
		e_add = sc.nextLine();
		System.out.println("Enter Employee ID: ");
		e_id = sc.nextInt();
		stmt.executeUpdate("update Employee set Eaddr='" + e_add + "' where id =" + e_id);

	}

	// deleting student detail in the database
	public void deleteMenudriven() throws SQLException {
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement(); // create statement
		System.out.println("Enter Employee id: ");
		e_id = sc.nextInt();
		stmt.executeUpdate("delete from Employee where id =" + e_id);
	}

}
