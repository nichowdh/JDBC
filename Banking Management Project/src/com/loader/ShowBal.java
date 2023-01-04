package com.loader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.Helper;

public class ShowBal {
	long db_acc;
	int db_pin;

	public void showAccountDetails(long acc_no, int pin) throws SQLException {
		Connection conn2 = Helper.con();
		Statement stmt = conn2.createStatement(); // create statement
		// execute query fetch data from database
		ResultSet rs = stmt.executeQuery("select * from Bank where account_no =" + acc_no + " and pin =" + pin);
		// iteration
		while (rs.next()) { // getting the column of each record of table
			db_acc = rs.getLong(1);
			db_pin = rs.getInt(7);

		}
		if (db_acc != acc_no) {
			System.err.println("!! WRONG ACCOUNT NUMBER INSERTED !!");
		}
		if (db_pin != pin) {
			System.err.println("!! WRONG PIN INSERTED !!");
		}

		else {
			System.err.println("____________________________");
			System.out.println("__Details of your Account__");
			ResultSet rs1 = stmt.executeQuery("select * from Bank where pin =" + pin);
			while (rs1.next()) {
				System.err.println("Account Number: " + rs1.getLong(1) + "\nAccount Holder: " + rs1.getString(2)
						+ "\nBranch IFSC: " + rs1.getString(3) + "\nBranch: " + rs1.getString(4) + "\nAccount Type: "
						+ rs1.getString(5) + "\nAccount Balance: " + rs1.getDouble(6) + "\nAccount Pin: "
						+ rs1.getInt(7));
				System.err.println("Data inserted & saved successfully------------------");
			}
		}

	}

}
