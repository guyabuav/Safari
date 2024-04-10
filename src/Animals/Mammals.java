package Animals;

public class Mammals extends Animal implements Animal_Actions {

	public Mammals(String name, String type, int age, int happiness, int hunger, int health) {
		super(name, type, age, happiness, hunger, health);
	}

	public Mammals(String name, String type, int age) {
		super(name, type, age);
	}

	public void move() {
		System.out.println(name + "walk 1 meter");

	}

	public void makeSound() {
		System.out.println(name + "making mammals sounds");

	}

	public Boolean isMoving() {
		return this.isMoving();
	}

	public void eat() {
		System.out.println(name + "eating a mammals food");
		this.hunger-=10;

	}

	public void rest() {
		System.out.println(name + "resting in the hole");
		this.health+=5;
	}

	public void play() {
		System.out.println(name + "playing a mammals game");
		this.happiness+=5;

	}

}
