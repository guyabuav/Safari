package ThePark;

import java.util.*;
import Animals.*;
import Humans.*;
import MainMethod.BST;
import MainMethod.EmployeeComparator;


public class Park {

	private Ceo boss;
	public LinkedList<Animal> animalsInPark;
	public LinkedList<Employee> workersInPark;
	public LinkedList<Animal> animalsCollection;
	public BST workersCollection;
	public Queue<ZooTrain> rides;
	protected SouvenirStore sov_store;
	protected FoodTruck food_truck;
	protected int visitors_today;
	protected Product Ticket;

	//Constructors
	public Park(Ceo boss, ZooTrain train, SouvenirStore sov_store, FoodTruck food_truck, int visitors_today, Product ticketPrice) throws Exception {
		if (boss == null) {
			throw new Exception("Park must have a CEO!\n");
		}
		this.boss = boss;
		this.animalsInPark = new LinkedList<Animal>();
		this.workersInPark = new LinkedList<Employee>();
		this.animalsCollection = new LinkedList<Animal>();
		EmployeeComparator comp = new EmployeeComparator();
		this.workersCollection = new BST(comp);
		this.rides = new LinkedList<ZooTrain>();
		this.sov_store = sov_store;
		this.food_truck = food_truck;
		this.visitors_today = visitors_today;
		this.Ticket = ticketPrice;
	}

	//Class method
	public boolean animalExists(Animal an) {
		return(this.animalsInPark.contains(an));
	}	

	public Animal animalIdExists(int animalID) {
		Animal foundAnimal = null;
		for (Animal animal : this.animalsInPark) {
			if (animal.getID() == animalID) {
				foundAnimal = animal;
				break;
			}
		}
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

	public boolean workerIdExistsInCollection(String workerID) {
		return (this.workersCollection.findByID(workerID) != null);
	}

	public Object workerFinder(String workerID) {
		return this.workersCollection.findDataByID(workerID);
	}

	public Employee WorkerIdExists(String zooKeeperID) {
		for (Employee zoo : workersInPark) {
			if(zoo.getId().equals(zooKeeperID)) {
				return zoo;
			}
		}
		return null;
	}

	public boolean workerExists(Employee em) {
		return(this.workersInPark.contains(em));
	}

	public void addRide(ZooTrain ride) {//Add ride
		this.rides.add(ride);
	}

	public void startRide() {//Start a ride
		for(ZooTrain ride : this.rides){
			if(ride.getTripDone() == false){
				ride.setTripDone(true);
				System.out.println("Ride number "+ride.getRideNum()+" begins its journey on the"+ride.getRouteType()+" route");
			}
		}
	}

	//Getters Setters
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

	public LinkedList<Employee> getWorkersList() {
		return workersInPark;
	}

	public void setWorkersInPark(LinkedList<Employee> workersInPark) {
		this.workersInPark = workersInPark;
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

	//Print methods
	public String toString() {
		return ("\nPark Details:\n-------------\n"+
	"\nBoss:\n-----\n"+boss.getFirstName() + boss.getLastName()+
				"\n\nAnimals in Park:\n----------------\n "+animalsInPark+
				"\n\nWorkers in Park:\n----------------\n"+workersInPark+
				"\n\nZoo Train Rides: \n----------------\n"+rides+
				"\n\nSouvenir Store: \n---------------\n"+sov_store+
				"\n\nFood Truck: \n-----------\n"+food_truck+
				"\n\nVisitors Today: \n---------------\n"+visitors_today+
				"\n\nTicket Price: \n-------------\n"+Ticket+"\n");
	}
}
