package Humans;

public class Human {

	protected String firstName;
	protected String lastName;
	protected String id;
	protected int age;

	public Human(String first_name, String last_name, String id, int age) throws Exception {
		if (id == null){
			throw new Exception("You must enter ID of human!");
		}
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
		return "First Name: "+firstName+"\n"+
				"Last Name: "+lastName+"\n"+
				"ID: "+id+"\n"+
				"Age: "+age+"\n";
	}
}
