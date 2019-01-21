

import java.util.ArrayList;
import java.util.List;

public class DefaultDepartment implements Department {

	private String name;
	private List<Employee> employees;
	
	public DefaultDepartment(final String name) {
		this.name = name;
		employees = new ArrayList<Employee>();
	}
	
	@Override
	public void addEmployee(final Employee employee) {
		employees.add(employee);
	}
	
	@Override
	public Double getAverageSalary() {
		double averageSalary = 0;
		for(Employee employee : employees) {
			averageSalary += employee.getSalary();
		}
		return averageSalary / employees.size();
	}
	
	@Override
	public String toString() {
		return name;
	}

}
