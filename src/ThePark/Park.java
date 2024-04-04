package ThePark;

import java.util.LinkedList;

import Animals.Animal;
import Humans.Ceo;
import Humans.Employee;
import Humans.ZooKeeper;


public class Park {

	private Ceo boss;
	public LinkedList<Animal> animalsInPark;
	public LinkedList<Employee> workersInPark;
	public LinkedList<Animal> animalsCollection;
	public LinkedList<Employee> workersCollection;
	protected ZooTrain train;
	protected SouvenirStore sov_store;
	protected FoodTruck food_truck;
	protected int visitors_today;
	protected Product Ticket;


	public Park(Ceo boss, ZooTrain train, SouvenirStore sov_store, FoodTruck food_truck, int visitors_today, Product ticketPrice) {
		this.boss = boss;
		this.animalsInPark = new LinkedList<Animal>();
		this.workersInPark = new LinkedList<Employee>();
		this.animalsCollection = new LinkedList<Animal>();
		this.workersCollection = new LinkedList<Employee>();
		this.train = train;
		this.sov_store = sov_store;
		this.food_truck = food_truck;
		this.visitors_today = visitors_today;
		this.Ticket = ticketPrice;
	}


	public boolean animalExists(Animal an) {
		return(this.animalsInPark.contains(an));
	}	

	public Animal animalIdExists(int animalID) {
		Animal foundAnimal = null;
		for (Animal animal : this.animalsInPark) {
			if (animal.getID() == animalID) {
				foundAnimal = animal;
				break; // Found the animal, no need to continue searching
			}
		}
		//	    if (foundAnimal == null) {
		//	        System.out.println("There is no such Animal in the park");
		//	    }
		return foundAnimal;
	}

	public Animal animalIdExistsInCollection(int animalID) {
		for(Animal animal : this.animalsCollection) {
			if(animal.getID() == animalID) {
				return animal;
			}
		}
		return null;
	}

	public Employee workerIdExistsInCollection(String workerID) {
		for(Employee employee : this.workersCollection) {
			if(employee.getId().equals(workerID))
				return employee;
		}
		//		System.out.println("There is no such Worker in the Collection");
		return null;
	}

	public Employee WorkerIdExists(String zooKeeperID) {
		for (Employee zoo : this.getWorkersInPark()) {
			if(zoo.getId().equals(zooKeeperID)) {
				return zoo;
			}
		}
		return null;
	}

	public boolean workerExists(Employee em) {
		return(this.workersInPark.contains(em));
	}

	// Getters and Setters
	public Ceo getBoss() {
		return boss;
	}

	public void setBoss(Ceo boss) {
		this.boss = boss;
	}

	public LinkedList<Animal> getanimalsInPark() {
		return animalsInPark;
	}

	public void setanimalsInPark(LinkedList<Animal> animalsToCare) {
		this.animalsInPark = animalsToCare;
	}

	public LinkedList<Animal> getanimalsInCollection() {
		return this.animalsCollection;
	}

	public void setanimalsInCollection(LinkedList<Animal> animalsCollection) {
		this.animalsCollection = animalsCollection;
	}


	public LinkedList<Employee> getWorkersCollection() {
		return this.workersCollection;
	}

	public void setWorkersCollection(LinkedList<Employee> WorkersCollection) {
		this.workersCollection = WorkersCollection;
	}

	public LinkedList<Employee> getWorkersInPark() {
		return workersInPark;
	}

	public void setWorkersInPark(LinkedList<Employee> workersInPark) {
		this.workersInPark = workersInPark;
	}

	public ZooTrain getTrain() {
		return train;
	}

	public void setTrain(ZooTrain train) {
		this.train = train;
	}

	public SouvenirStore getSov_store() {
		return sov_store;
	}

	public void setSov_store(SouvenirStore sov_store) {
		this.sov_store = sov_store;
	}

	public FoodTruck getFood_truck() {
		return food_truck;
	}

	public void setFood_truck(FoodTruck food_truck) {
		this.food_truck = food_truck;
	}

	public int getVisitors_today() {
		return visitors_today;
	}

	public void setVisitors_today(int visitors_today) {
		this.visitors_today = visitors_today;
	}

	public int getTicketPrice() {
		return this.Ticket.getPrice();
	}

	public void setTicketPrice(Product ticketPrice) {
		this.Ticket = ticketPrice;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nPark Details:\n");
		sb.append("Boss: ").append(boss.getFirstName() + boss.getLastName()).append("\n");
		sb.append("Animals in Park:\n ").append(animalsInPark).append("\n");
		sb.append("Workers in Park:\n").append(workersInPark).append("\n");
		sb.append("Zoo Train: ").append(train).append("\n");
		sb.append("Souvenir Store: ").append(sov_store).append("\n");
		sb.append("Food Truck: ").append(food_truck).append("\n");
		sb.append("Visitors Today: ").append(visitors_today).append("\n");
		sb.append("Ticket Price: ").append(Ticket).append("\n");
		return sb.toString();
	}



}
