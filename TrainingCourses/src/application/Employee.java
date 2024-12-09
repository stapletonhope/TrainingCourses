package application;

import java.util.Scanner;

/*
* File name :Employee
* Author :Hope Stapleton
* Student number : C23376453
* Description of class : represents an employee in a course and stores all employee details
* and includes error checking and getters and setters
*/
public class Employee {
	private String name, courseName;
	private int yrs, empNum;

	// empty constructor
	public Employee() {
		this.name = "";
		this.courseName = "";
		this.yrs = 0;
		this.empNum = 0;
	}

	// parameterised constructor with error checking
	public Employee(String name, String courseName, int empNum, int yrs) {
		Scanner scan = new Scanner(System.in);
		this.name = name;
		this.courseName = courseName;
		this.empNum = empNum;
		this.yrs = yrs;

		while (this.yrs < 5) {
			System.out.print("Error! Only employees with over 5 years experience are allowed on training courses.\n"
					+ "Please enter the number of years again: ");
			this.yrs = scan.nextInt();
			scan.nextLine(); // Clear the newline character
		}

		// Validate course name
		if ((courseName.charAt(0) == ('F')) && (courseName.charAt(1) == ('O')) && (courseName.charAt(2) == ('O'))
				&& (courseName.charAt(3) == ('D'))) {
			this.courseName = courseName;
		} else {
			System.out.print(
					"Error! Course name is invalid. Must start with 'FOOD'.\nPlease enter a valid course name: ");
			this.courseName = scan.nextLine();
		}

	}

	// getters and setters
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return this.courseName;
	}

	public void setCourse(String courseName) {
		this.courseName = courseName;
	}

	public int getYears() {
		return this.yrs;
	}

	public void setYears(int yrs) {
		this.yrs = yrs;
	}

	public int getEmpNum() {
		return this.empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	// boolean to find duplicates by checking employee numbers
	public boolean contains(Employee emp) {
		boolean equals;

		if (this.empNum == (emp.getEmpNum())) {
			equals = true;
		} else {
			equals = false;
		}
		return equals;

	}

	// display all details in a user friendly way
	public String toString() {
		return "\nEmployee name: " + this.name + "\nEmployee number: " + this.empNum
				+ "\nNumber of years working in the organisation: " + this.yrs
				+ "\nName of the training course in which they are enrolled: " + this.courseName + "\n";
	}
}
