

import java.util.List;

public class Run {

	public static void main(String[] args) {

		int numberOfLines = Program.getNumberOfLines();
		List<String> linesOfInput = Program.getLinesOfInput(numberOfLines);
		List<Employee> employees = Program.getListOfEmployees(linesOfInput);
		Program.sortEmployeesBySalaryDescending(employees);
		List<Department> departments = Program.getListOfDepartments(employees);
		Department departmentWithHighestAverageSalary = Program.getDepartmentWithHighestAverageSalary(departments);

		System.out.println("Highest Average Salary: " + departmentWithHighestAverageSalary);
		Program.printEmployees(employees, departmentWithHighestAverageSalary);

	}

}
