package Animals;

public abstract class Animal {
	protected String name;
	protected String type;
	protected int id;
	protected int age;
	protected int happiness;
	protected int hunger;
	protected int health;
	protected boolean isMoving;
	protected static int counter = 1;


	// Constructor
	public Animal(String name, String type, int age, int happiness, int hunger, int health) {
		this.name = name;
		this.type = type;
		this.id = counter++;
		this.age = age;
		this.happiness = happiness;
		this.hunger = hunger;
		this.health = health;
		this.isMoving = false;
	}

	public Animal(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.id = counter++;
		this.age = age;
		this.happiness = 50;
		this.hunger = 50;
		this.health = 50;
		this.isMoving = false;
	}

	// Copy constructor ///// DO WE NEED IT?????????????????
	public Animal(Animal other) {
		this.name = other.getName();
		this.type = other.getType();
		this.id = counter++;
		this.age = other.getAge();
		this.happiness = other.getHappiness();
		this.hunger = other.getHunger();
		this.health = other.getHealth();
		this.isMoving = other.isMoving;
	}

	public void raiseHealth() {
		this.setHealth(this.getHealth()+10);
	}

	public void raiseHappienes() {
		this.setHappiness(this.getHappiness()+10);
	}

	public void DownHunger() {
		this.setHunger(this.getHunger() -10);
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getID() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean getIsmoving() {
		return this.isMoving;
	}

	public void setIsmoving(boolean choise) {
		this.isMoving = choise;
	}

	public String toString() {
		return "ID: " + this.id + "\n" +
				"Name: " + this.name + "\n" +
				"Type: " + this.type + "\n" +
				"Age: " + this.age + "\n" +
				"Happiness: " + this.happiness + "\n" +
				"Hunger: " + this.hunger + "\n" +
				"Health: " + this.health + "\n" +
				"Moving: " + (this.isMoving ? "Yes" : "No") + "\n";
	}

}
