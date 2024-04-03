package Humans;

public class Human {

	protected String firstName;
	protected String lastName;
	protected String id;
	protected int age;

	public Human(String first_name, String last_name, String id, int age) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.id = id;
		this.age = age;
	}

	public Human(Human other) {
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.id = other.id;
		this.age = other.age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("First Name: ").append(firstName).append("\n");
		sb.append("Last Name: ").append(lastName).append("\n");
		sb.append("ID: ").append(id).append("\n");
		sb.append("Age: ").append(age).append("\n");
		return sb.toString();	}
}
