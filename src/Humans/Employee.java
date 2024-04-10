package Humans;

public abstract class Employee extends Human {

	private String user;
	private String password;
	protected int seniority; // by years
	protected int salary; // per hour
	protected int todayWorkingHours;

	public Employee(String firstName, String lastName, String id, int age, String user, String password,
			int seniority) throws Exception {
		super(firstName, lastName, id, age);
		this.user = user;
		this.password = password;
		this.seniority = seniority;
		this.salary = Integer.valueOf(seniority) * 20;
		this.todayWorkingHours = 0;
	}

	// Copy constructor
	public Employee(Employee other) throws Exception {
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

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
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
		return super.toString()+("Username: ")+user+"\n"+
				"Seniority: "+seniority+"\n"+
				"Salary: "+salary+"\n"+
				"Today's Working Hours: "+todayWorkingHours+"\n";
	}

}
