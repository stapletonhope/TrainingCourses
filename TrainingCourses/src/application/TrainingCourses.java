package application;

import java.util.Scanner;
import util.LinkedList;

/*
* File name :TrainingCourses
* Author :Hope Stapleton
* Student number : C23376453
* Description of class : Driver class implements all methods
*/
public class TrainingCourses {
	LinkedList<Employee> list; // linked list to hold the employees details

	public TrainingCourses() {
		list = new LinkedList<Employee>();

		inputEmployees(); // input employees into the linked list
		displayEmployees(); // display all employee details
		findEmployeeWorkingLongest(); // display the employee details of the employee who has worked for FoodCo the
										// longest
		removeEmployee(); // remove an employee from a training course based on their employee number
		displayEmployeesOnCourse(); // display all employees enrolled in a specific course
		deleteEmployeesFromCourse(); // remove all employees from a specific course
		displayRemainingEmployees(); // display remaining employees after changes

	}

//1. allow user to input up to 10 employees (user should first be asked the number of employees, should contain error checking)
	public void inputEmployees() {
		Employee e; // employee object
		String name, courseName;
		int yrs, num, empNum;
		Scanner scan = new Scanner(System.in);

		// ask user to input number of employees - between 1 and 10
		System.out.print("Enter the number of employees you wish to input: ");
		num = scan.nextInt();
		scan.nextLine();

		// error check to ensure its a valid number
		while (num < 1 || num > 10) {
			System.out.print("\nError! Number of employees must be between 1-10. ");
			System.out.print("\nEnter the number of employees you wish to input: ");
			num = scan.nextInt();
			scan.nextLine();
		}

		// loop for user to input the employees details and store them in the list
		for (int count = 1; count <= num; count++) {
			System.out.print("\n\nEnter the employee's name: ");
			name = scan.nextLine();
			System.out.print("Enter course name: ");
			courseName = scan.nextLine();
			System.out.print("Enter number of years the employee has worked for the company: ");
			yrs = scan.nextInt();
			scan.nextLine();
			System.out.print("Enter the employee number: ");
			empNum = scan.nextInt();
			scan.nextLine();

			// create an employee object with necessary parameters
			e = new Employee(name, courseName, empNum, yrs);

			// add employee object to the list
			list.add(e);
		}
	}

//2. displays all employee details
	public void displayEmployees() {
		System.out.println("\nDisplaying all employee details....\n");
		if (list.isEmpty()) {
			System.out.println("\nNo employees to display.");
		} else {
			System.out.println(list.toString());// call toString method to display the info
		}
	}

//3. remove an employee from a training course (as specified by their employee number)
	public void removeEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Please input the employee number of the employee you would like to remove from a training course: ");
		int empNum = scan.nextInt();
		scan.nextLine();

		boolean found = false;// track if the employee is found

		// Iterate through the list to find the employee by their employee number
		for (int i = 0; i < list.size(); i++) {
			Employee emp = (Employee) list.get(i);
			if (emp.getEmpNum() == empNum) {
				// remove the employee from the list
				list.remove(emp);
				System.out.println("Employee with employee Number " + empNum + " has been removed.");
				found = true;
				break; // exit the loop after removing the employee
			}
		}

		if (!found) {
			System.out.println("No employee with Employee Number " + empNum + " was found.");
		}
	}

//4. display all details of employees on training courses
	public void displayEmployeesOnCourse() {

		Scanner scan = new Scanner(System.in);
		String courseName;
		System.out.print("Enter the course name to display employees: ");
		courseName = scan.nextLine(); // get course name from user

		System.out.println("\nDisplaying employees enrolled in " + courseName + ": ");
		boolean found = false;

		// iterate through the list to check if the courseName matches
		for (int i = 0; i < list.size(); i++) {
			Employee emp = (Employee) list.get(i); // cast to Employee
			if (emp != null && emp.getCourse().equalsIgnoreCase(courseName)) {
				System.out.println(emp); // display employee if course matches
				found = true;
			}
		}

		if (!found) {
			System.out.println("No employees found in the course " + courseName);
		}
	}

//5. delete all employees from a specified course

	public void deleteEmployeesFromCourse() {

		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter the name of the course in which you want to remove employees from: ");
		String courseName = scan.nextLine(); // get the course name from the user

		System.out.println("\nRemoving employees enrolled in " + courseName + ": ");
		boolean found = false; // track if employees are found

		// Iterate through the list and remove matching employees
		for (int i = list.size() - 1; i >= 0; i--) {// search through loop backwards so that it doesn't skip any object
			Employee emp = (Employee) list.get(i);
			if (emp.getCourse().equals(courseName)) {
				list.remove(emp); // remove employee at index i
				System.out.println(emp + "\n" + emp.getName() +" has been removed.");
				found = true;
			}
		}

		if (!found) {
			System.out.println("No employees found in the course " + courseName);
		}
	}

//6. display the remaining employees
	public void displayRemainingEmployees() {
		System.out.println("\nDisplaying remaining employees...\n");
		if (list.isEmpty()) {
			System.out.println("No employees remain in the list.");
		} else {
			System.out.println(list.toString()); // call toString method to display remaining employees after deletion
		}
	}

//7. run your own personalised function
//– this does not have to be run last – it can be executed at any appropriate point in your project.
	public void findEmployeeWorkingLongest() {
		    if (list.isEmpty()) {
		        System.out.println("No employees to check.");
		        return;
		    }

		    Employee longestEmployee = null;
		    int longestYears = -1;//set this to -1 so that first employee checked is automatically the highest years worked at start

		    // loop through all employees and compare their years
		    for (int i = 0; i < list.size(); i++) {
		        Employee emp = (Employee) list.get(i);
		        int yearsWorked = emp.getYears();

		        if (yearsWorked > longestYears) {
		            longestYears = yearsWorked;
		            longestEmployee = emp;
		        }
		    }

		    if (longestEmployee != null) {
		        System.out.println("The employee with the longest years of service is:");
		        System.out.println(longestEmployee);
		    }
		}


	public static void main(String[] args) {
		new TrainingCourses();// creates instance of class
	}
}
