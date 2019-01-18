

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class Application {

	private static Scanner input;
	private static List<ICompanyStructure> departments;

	static {
		input = new Scanner(System.in);
		departments = new ArrayList<ICompanyStructure>();
	}

	private Application() {

	}

	public static int getNumberOfLines() {
		int numberOfLines = input.nextInt();
		input.nextLine();
		return numberOfLines;
	}

	public static List<String> getLinesOfInput(int numberOfLines) {
		List<String> linesOfInput = new ArrayList<String>();
		while (numberOfLines-- > 0) {
			linesOfInput.add(input.nextLine());
		}
		return linesOfInput;
	}

	public static List<Employee> getListOfEmployees(final List<String> linesOfInput) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee;

		for (String inputData : linesOfInput) {
			employee = createEmployee(inputData.trim().split(" "));
			employees.add(employee);
			if (!departments.contains(employee.getDepartment())) {
				departments.add(employee.getDepartment());
			}
		}
		return employees;
	}

	public static void sortEmployeesBySalaryDescending(final List<Employee> employees) {
		Collections.sort(employees);
	}

	public static ICompanyStructure getDepartmentWithHighestAverageSalary() {
		ICompanyStructure departmentWithHighestAverageSalary = departments.get(0);
		for (ICompanyStructure department : departments) {
			if (department.getAverageSalary() > departmentWithHighestAverageSalary.getAverageSalary()) {
				departmentWithHighestAverageSalary = department;
			}
		}
		return departmentWithHighestAverageSalary;
	}

	public static void printEmployees(final List<Employee> employees, final ICompanyStructure department) {
		for (Employee employee : employees) {
			if (department.equals(employee.getDepartment())) {
				System.out.println(employee);
			}
		}
		endProgram();
	}

	private static Employee createEmployee(final String[] inputArray) {
		Employee employee = new Employee();
		employee.setName(inputArray[0]);
		employee.setSalary(Double.parseDouble(inputArray[1]));
		employee.setJob(inputArray[2]);

		if (!departments.isEmpty()) {
			for (ICompanyStructure department : departments) {
				if (department.toString().equalsIgnoreCase(inputArray[3])) {
					employee.setDepartment(department);
					break;
				}
			}
		}
		if (employee.getDepartment() == null) {
			employee.setDepartment(new Department(inputArray[3]));
		}

		if (inputArray.length == 5) {
			if (inputArray[4].contains("@")) {
				employee.setEmail(inputArray[4]);
			} else {
				employee.setAge(Integer.parseInt(inputArray[4]));
			}
		}

		if (inputArray.length == 6) {
			employee.setEmail(inputArray[4]);
			employee.setAge(Integer.parseInt(inputArray[5]));
		}

		return employee;
	}

	private static void endProgram() {
		input.close();
	}

}
