

public class Employee implements Comparable<Employee> {

	private String name;
	private Double salary;
	private String job;
	private ICompanyStructure department;
	private String email;
	private int age;

	public Employee() {
		email = "n/a";
		age = -1;
	}

	public Employee(final String name, final Double salary, final String job, final ICompanyStructure department) {
		this.name = name;
		this.salary = salary;
		this.job = job;
		this.department = department;
		email = "n/a";
		age = -1;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(final Double salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(final String job) {
		this.job = job;
	}

	public ICompanyStructure getDepartment() {
		return department;
	}

	public void setDepartment(final ICompanyStructure department) {
		this.department = department;
		this.department.addEmployee(this);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
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
