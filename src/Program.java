
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class Program {

	private static Scanner input;

	static {
		input = new Scanner(System.in);
	}

	private Program() {
		throw new UnsupportedOperationException();
	}

	public static int getNumberOfLines() {
		int numberOfLines = input.nextInt();
		input.nextLine();
		return numberOfLines;
	}

	public static List<String> getLinesOfInput(int numberOfLines) {
		List<String> linesOfInput = new ArrayList<>();
		while (numberOfLines-- > 0) {
			linesOfInput.add(input.nextLine());
		}
		input.close();
		return linesOfInput;
	}

	public static List<Employee> getListOfEmployees(final List<String> linesOfInput) {
		List<Employee> employees = new ArrayList<>();
		Employee employee;

		for (String inputData : linesOfInput) {
			employee = createEmployee(inputData.trim().split(" "));
			employees.add(employee);
		}
		return employees;
	}

	public static List<Department> getListOfDepartments(final List<Employee> employees) {
		List<Department> departments = new ArrayList<>();
		Department department;
		
		for (Employee employee : employees) {
			department = getDepartment(employee.getDepartment(), departments);
			if (department == null) {
				department = new DefaultDepartment(employee.getDepartment());
				departments.add(department);
			}
			department.addEmployee(employee);
		}
		return departments;
	}

	public static void sortEmployeesBySalaryDescending(final List<Employee> employees) {
		Collections.sort(employees);
	}

	public static Department getDepartmentWithHighestAverageSalary(final List<Department> departments) {
		Department departmentWithHighestAverageSalary = departments.get(0);
		for (Department department : departments) {
			if (department.getAverageSalary() > departmentWithHighestAverageSalary.getAverageSalary()) {
				departmentWithHighestAverageSalary = department;
			}
		}
		return departmentWithHighestAverageSalary;
	}

	public static void printEmployees(final List<Employee> employees, final Department department) {
		for (Employee employee : employees) {
			if (department.toString().equals(employee.getDepartment())) {
				System.out.println(employee);
			}
		}
	}

	private static Employee createEmployee(final String[] inputArray) {
		String name = inputArray[0];
		double salary = Double.parseDouble(inputArray[1]);
		String job = inputArray[2];
		String department = inputArray[3];
		String email = "n/a";
		int age = -1;

		if (inputArray.length == 5) {
			if (inputArray[4].contains("@")) {
				email = inputArray[4];
			} else {
				age = Integer.parseInt(inputArray[4]);
			}
		}

		if (inputArray.length == 6) {
			email = inputArray[4];
			age = Integer.parseInt(inputArray[5]);
		}

		return new Employee(name, salary, job, department, email, age);
	}

	private static Department getDepartment(final String departmentName, final List<Department> departments) {
		for (Department department : departments) {
			if (department.toString().equalsIgnoreCase(departmentName)) {
				return department;
			}
		}
		return null;
	}

}
