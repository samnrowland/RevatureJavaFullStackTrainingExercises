package week2.day4.fileHandling;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = -2792974244155812595L;
	int empId;
	String empName;
	String department;
	double salary;
	
	public Employee(int empId, String empName, String department, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "ID: " + empId + " | Name: " + empName + " | Department: " + department + " | Salary: $" + salary;
	}
}
