package Humans;
import java.util.*;
import Animals.*;
import ThePark.*;


public class ZooKeeper extends Employee {
	protected Stack<Task> zooKeeperTasks;
	protected LinkedList<Animal> animalsToCare;

	public void printAnimals() {
		System.out.println("Animals Cared for by " + getFirstName() + " " + getLastName() + ":");
		for (Animal animal : animalsToCare) {
			System.out.println("\n" +animal.toString());
		}
	}

	public ZooKeeper(String firstName, String lastName, String id, int age, String user, String password, int seniority) throws Exception {
		super(firstName, lastName, id, age, user, password, seniority);
		this.animalsToCare = new LinkedList<Animal>();
		this.zooKeeperTasks = new Stack<Task>();
	}

	public Stack<Task> getTasks() {
		return this.zooKeeperTasks;
	}

	public void setTasks(Stack<Task> tasks) {
		this.zooKeeperTasks = tasks;
	}

	public void markTaskAsDone(int taskID) {
		boolean found = false;
		for(Task task : this.zooKeeperTasks) {
			if(task.getTask_id()== taskID) {
				this.zooKeeperTasks.remove(task);
				System.out.println("Task number " + taskID + " done and removed successfully!\n");
				found = true;
				break; // Once task is found and removed, exit the loop
			}
		}
		if (!found) {
			System.out.println("Error: Task number " + taskID + " not found!\n");
		}
	}

	public void Clean() {
		this.printAnimals();
		System.out.println("\nChoose animal ID: ");
		Scanner scanner = new Scanner(System.in);
		int animalID = scanner.nextInt();
		if(this.animalIDexists(animalID) != null) {
			System.out.println("cage has been cleaned!");
			this.animalIDexists(animalID).raiseHealth();
		}
		else {
			System.out.println("There is no such animal in ur list");
		}

	}

	public void Show() {
		this.printAnimals();
		System.out.println("\nChoose animal ID: ");
		Scanner scanner = new Scanner(System.in);
		int animalID = scanner.nextInt();
		if(this.animalIDexists(animalID) != null) {
			System.out.println("This was a great show!");
			this.animalIDexists(animalID).raiseHappienes();
		}
		else {
			System.out.println("There is no such animal in ur list");
		}

	}

	public void Pet() {
		this.printAnimals();
		System.out.println("\nChoose animal ID: ");
		Scanner scanner = new Scanner(System.in);
		int animalID = scanner.nextInt();
		if(this.animalIDexists(animalID) != null) {
			System.out.println("You fed pet succesfully!");
			this.animalIDexists(animalID).DownHunger();
		}
		else {
			System.out.println("There is no such animal in ur list");
		}

	}

	public Animal animalIDexists(int animalID) {
		for(Animal animal : this.animalsToCare) {
			if(animal.getID() == animalID) {
				return animal;
			}
		}
		return null;
	}

	private Animal chooseAnimal(String chosen) {
		if (this.animalsToCare.isEmpty()) {
			System.out.println("You don't have animals to take care of..");
			return null;
		}
		for (Animal item : animalsToCare) {
			if (item.getID() == Integer.valueOf(chosen) ) 
			{
				return item;	
			}
		}
		return null;
	}

	public void addAnimal(Animal toAdd, Park park) { 
		if(park.animalExists(toAdd)) {
			this.animalsToCare.addFirst(toAdd);
			System.out.println("Animal has been added!");
		}
		else {
			System.out.println("This animal not exists in park");
		}
	}

	public void addAnimalByID(int animalID, Park park) {
		if (this.animalsToCare.contains(park.animalIdExists(animalID))) {
			System.out.println("This animal already in your responsibillity");
		}
		else if (park.animalsInPark.contains(park.animalIdExists(animalID)) && !this.animalsToCare.contains(this.animalIDexists(animalID))) {
			this.animalsToCare.addLast(park.animalIdExists(animalID));
			System.out.println("Animal added succesfully!");
		}
		else if (!park.animalsInPark.contains(park.animalIdExists(animalID)) && !this.animalsToCare.contains(this.animalIDexists(animalID)))  {
			System.out.println("This animal not exists in park animal list");
		}
	}


	public String toString() { 
		String toPrint = "\nZooKeeper\n"+super.toString()+
				"Animals Cared for:\n";
		for (Animal animal : animalsToCare) {
			toPrint += animal+"\n\n";
		}
		return toPrint;
	}
}

