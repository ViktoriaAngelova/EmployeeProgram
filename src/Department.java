

import java.util.ArrayList;
import java.util.List;

public class Department implements ICompanyStructure {

	private String name;
	private List<Employee> employees;

	public Department() {
		employees = new ArrayList<Employee>();
	}
	
	public Department(final String name) {
		this.name = name;
		employees = new ArrayList<Employee>();
	}

	public Department(final String name, final List<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;

	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(final List<Employee> employees) {
		this.employees = employees;

	}

	@Override
	public void addEmployee(final Employee employee) {
		employees.add(employee);
	}
	
	@Override
	public Double getAverageSalary() {
		double averageSalary = 0;
		int numberOfEmployees = employees.size();
		for(Employee employee : employees) {
			averageSalary += employee.getSalary();
		}
		return averageSalary / numberOfEmployees;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
