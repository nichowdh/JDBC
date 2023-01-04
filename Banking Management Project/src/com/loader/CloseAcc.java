package com.loader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.Helper;

public class CloseAcc {
	int db_pin;
	long db_acc;

	public void closeAcc(long acc_no, int pin) throws SQLException {

		Connection conn = Helper.con();
		Statement stmt = conn.createStatement(); // create statement
		ResultSet rs = stmt.executeQuery("select * from Bank where account_no= " + acc_no + " and pin= " + pin);
		while (rs.next()) {
			db_acc = rs.getLong(1);
			db_pin = rs.getInt(7);
		}
		if (db_acc != acc_no) {
			System.err.println("!! WRONG ACCOUNT NUMBER INSERTED !!");
		}
		if (db_pin != pin) {
			System.err.println("!! WRONG PIN INSERTED !!");
		} else

			stmt.executeUpdate("delete  from Bank where account_no=" + acc_no + " and pin= " + pin);
		System.out.println("___BANK A/C CLOSED___");

	}

}
