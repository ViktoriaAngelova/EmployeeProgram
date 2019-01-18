

import java.util.List;

public class Main {

	public static void main(String[] args) {

		int numberOfLines = Application.getNumberOfLines();
		List<String> linesOfInput = Application.getLinesOfInput(numberOfLines);
		List<Employee> employees = Application.getListOfEmployees(linesOfInput);
		Application.sortEmployeesBySalaryDescending(employees);
		ICompanyStructure departmentWithHighestAverageSalary = Application.getDepartmentWithHighestAverageSalary();

		System.out.println("Highest Average Salary: " + departmentWithHighestAverageSalary);
		Application.printEmployees(employees, departmentWithHighestAverageSalary);

	}

}
