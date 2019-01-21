
public class Employee implements Comparable<Employee> {

	private String name;
	private Double salary;
	@SuppressWarnings("unused")
	private String job;
	private String department;
	private String email;
	private int age;

	public Employee(final String name, final Double salary, final String job, final String department,
			final String email, final int age) {
		this.name = name;
		this.salary = salary;
		this.job = job;
		this.department = department;
		this.email = email;
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public int compareTo(final Employee employee) {
		return (Integer) employee.getSalary().compareTo(salary);
	}

	@Override
	public String toString() {
		return name + " " + String.format("%.2f", salary) + " " + email + " " + age;
	}

}
