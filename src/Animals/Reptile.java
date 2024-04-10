package Animals;

public class Reptile extends Animal implements Animal_Actions {

	public Reptile(String name, String type, int age, int happiness, int hunger, int health) {
		super(name, type, age, happiness, hunger, health);
	}

	public Reptile(String name, String type, int age) {
		super(name, type, age);
	}

	public void move() {
		System.out.println(name + "scoot 1 meter");

	}

	public void makeSound() {
		System.out.println(name + "making reptiles sounds");

	}

	public Boolean isMoving() {
		return this.isMoving();
	}

	public void eat() {
		System.out.println(name + "eating a reptiles food");
		this.hunger-=10;

	}

	public void rest() {
		System.out.println(name + "resting in the nest");
		this.health+=5;
	}

	public void play() {
		System.out.println(name + "playing a reptiles game");
		this.happiness+=5;

	}

}
