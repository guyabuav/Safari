package Animals;

public class Bird extends Animal implements Animal_Actions {

	public Bird(String name, String type, int age, int happiness, int hunger, int health) {
		super(name, type, age, happiness, hunger, health);
	}

	public Bird(String name, String type, int age) {
		super(name, type, age);
	}

	public void move() {
		System.out.println(name + "flown 1 meter");

	}

	public void makeSound() {
		System.out.println(name + "making tweet sounds");

	}

	public Boolean isMoving() {
		return this.isMoving();
	}

	public void eat() {
		System.out.println(name + "eating a birds food");
		this.hunger-=10;

	}

	public void rest() {
		System.out.println(name + "resting in the nest");
		this.health+=5;
	}

	public void play() {
		System.out.println(name + "playing a birds game");
		this.happiness+=5;

	}

}
