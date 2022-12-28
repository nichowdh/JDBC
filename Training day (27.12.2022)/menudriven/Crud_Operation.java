package com.menudriven;

import java.sql.SQLException;
import java.util.Scanner;

import com.student.Employee;

public class Crud_Operation {

	public static void main(String[] args) throws SQLException {
		Employee e = new Employee();
		Scanner s = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1. Insert \n 2. Display \n 3. Update \n 4. Delete \n 5. Exit");
			System.out.println("Enter your Choice from 1-5");
			ch = s.nextInt();
			System.out.println("---------------------------");
			switch (ch) {
			case 1:
				e.saveMenudriven();
				break;
			case 2:
				e.fetchMenudriven();
				break;
			case 3:
				e.updateMenudriven();
				break;
			case 4:
				e.deleteMenudriven();
				break;
			case 5:
				System.exit(0);
				break;
			}

		} while (ch != 5);

	}

}
