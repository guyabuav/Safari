package Humans;

import ThePark.*;

public class Ceo extends Veterinarian {
	private boolean have_background;
	private Park parkImManage;

	public Ceo(String firstName, String lastName, String id, int age, String user, String password, int seniority, String expertise,  boolean background) throws Exception {
		super(firstName, lastName, id, age, user, password, seniority, expertise);
		this.have_background = background;
		this.parkImManage = null;
	}

	public boolean Getbackground() {
		return this.have_background;
	}

	public void Setbackground(boolean background) {
		this.have_background = background;
	}

	public Park GetparkImManage() {
		return this.parkImManage;
	}

	public void SetparkImManage(Park parkImManage) {
		this.parkImManage = parkImManage;
		parkImManage.workersInPark.add(this);
	}

	public int calcDailyProfit() {
		return this.parkImManage.getVisitors_today() * this.parkImManage.getTicketPrice();
	}


	// Add animal from the collection to the park & delete animal from the collection
	public void addAnimaltoPark(int animal_Id) {
		if(this.parkImManage.animalIdExists(animal_Id) != null) {
			System.out.println("This animal already exists in the park");
		}
		else if(this.parkImManage.animalIdExistsInCollection(animal_Id) == null){
			System.out.println("This animal is not exists in collection");
		}
		else{
			this.parkImManage.animalsInPark.addFirst(this.parkImManage.animalIdExistsInCollection(animal_Id));
			System.out.println("Animal added succesfully from collection to your Zoo!");
			this.parkImManage.animalsCollection.remove(this.parkImManage.animalIdExistsInCollection(animal_Id));
		}
	} 

	public void DeleteAnimalFromPark(int animal_Id) {
		if(this.parkImManage.animalIdExists(animal_Id) == null) {
			System.out.println("This animal not exists in the park");
		}
		else {
			this.parkImManage.animalsCollection.addLast(this.parkImManage.animalIdExists(animal_Id));
			this.parkImManage.animalsInPark.remove(this.parkImManage.animalIdExistsInCollection(animal_Id));
			System.out.println("Animal removed succesfully from your Zoo!");
		}
	} 


	// Add worker from the collection to the park
	public void addWorkertoPark(String worker_Id) {
		if(this.parkImManage.WorkerIdExists(worker_Id) != null) {
			System.out.println("\nThis worker already exists in the park");
		}
		else if((this.parkImManage.workerIdExistsInCollection(worker_Id))== false) {
			System.out.println("\nThis worker is not exists in collection");
		}
		else {
			this.parkImManage.workersInPark.addLast(((Employee) this.parkImManage.workerFinder(worker_Id)));
			System.out.println("\nWorker added succesfully from collection to your Zoo!");		}
	} 

	public void DeleteWorkerIDFromPark(String worker_Id) {
		if(this.parkImManage.WorkerIdExists(worker_Id) == null) {
			System.out.println("This worker not exists in the park");
		}
		else {
			this.parkImManage.workersInPark.remove(this.parkImManage.WorkerIdExists(worker_Id));
			System.out.println("Worker removed succesfully from your Zoo!");
		}
	} 

	public void addWorker(Employee worker) {
		if(this.parkImManage.workerExists(worker)) {
			System.out.println("This worker already exists in the park");
		}
		else {
			this.parkImManage.workersInPark.addFirst(worker);
			System.out.println("Worker added succesfully");
		}
	}

	public void deleteWorkerFromPark(Employee worker) {
		if (parkImManage.getWorkersList().remove(worker)) {
			System.out.println("Worker removed from the park successfully");
		} else {
			System.out.println("Worker not found in the park");
		}


	}
	public void calcDailySalary(Employee em, Park p) {
		if(p.workersInPark.contains(em)) {
			System.out.println("Daily salary of " + em.getFirstName() + " is: " + (em.getTodayWorkingHours() * em.getSalary())); 
		}
		else {
			System.out.println("Worker not exists");
		}
	}

	public void raiseDailySalary(Employee em, int raise) {
		em.setSalary(em.getSalary() + raise);
		System.out.println("Salary raised by " + raise);
	}

	public String toString() {
		String toPrint = "\nCeo and also a"+super.toString()+
				"Have background: "+have_background+"\n";
		return toPrint;
	}
}


