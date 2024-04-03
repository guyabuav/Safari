package Humans;

public abstract class Employee extends Human {

	protected String user;
	protected String password;
	protected String seniority; // by years
	protected int salary; // per hour
	protected int todayWorkingHours;

	public Employee(String firstName, String lastName, String id, int age, String user, String password,
			String seniority) {
		super(firstName, lastName, id, age);
		this.user = user;
		this.password = password;
		this.seniority = seniority;
		this.salary = Integer.valueOf(seniority) * 20;
		this.todayWorkingHours = 0;
	}

	// Copy constructor
	public Employee(Employee other) {
		super(other.getFirstName(), other.getLastName(), other.getId(), other.getAge());
		this.user = other.getUser();
		this.password = other.getPassword();
		this.seniority = other.getSeniority();
		this.salary = other.getSalary();
		this.todayWorkingHours = other.getTodayWorkingHours();
	}

	// Getters and setters
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getTodayWorkingHours() {
		return todayWorkingHours;
	}

	public void setTodayWorkingHours(int todayWorkingHours) {
		this.todayWorkingHours = todayWorkingHours;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString()); // Include Human fields
		sb.append("User: ").append(user).append("\n");
		sb.append("Password: ").append(password).append("\n");
		sb.append("Seniority: ").append(seniority).append("\n");
		sb.append("Salary: ").append(salary).append("\n");
		sb.append("Today's Working Hours: ").append(todayWorkingHours).append("\n");
		return sb.toString();
	}

}
