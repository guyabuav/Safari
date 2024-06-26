package Humans;

import Animals.*;
import ThePark.*;


public class Veterinarian extends Employee {
	protected String expertise;

	public Veterinarian(String firstName, String lastName, String id, int age, String user, String password, int seniority, String expertise) throws Exception {
		super(firstName, lastName, id, age, user, password, seniority);
		this.expertise = expertise;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public void Operate(Animal an, Park park) {
		if (park.animalExists(an)) {
			an.setHealth(an.getHealth()+10);
			System.out.println(an.getName() + " Operated succesfully!");
		}
		else System.out.println("There is no such animal");
	}

	public void MedicalCheck(ZooKeeper k, Animal an, Park park) {
		if(park.animalExists(an) && park.workerExists(k)) {
			if (an.getHealth() < 50) {
				//insert task to queue
				System.out.println("Animal health need to improve! inserting task to " +k.firstName + "\n");
				Task t = new Task("Raise Health", "The animal needs a cage clean!", an,this);
				k.zooKeeperTasks.add(t);
			}
			else System.out.println("Animal health is good");
			if (an.getHunger() < 50) {
				System.out.println("This animal is hungry! inserting task to " +k.firstName + "\n");
				Task t = new Task("Pet Animal", "The animal needs a meal!", an,this);
				k.zooKeeperTasks.add(t);
			}
			else System.out.println("Animal Hunger is good");
			if (an.getHappiness() < 50) {
				System.out.println("This animal is sad! inserting task to " +k.firstName + "\n");
				Task t = new Task("Cheer animal", "The animal needs a show!", an,this);
				k.zooKeeperTasks.add(t);			}
		}
		else System.out.println("There is no such animal or ZooKeeper");
	}

	public void TeachZooKeeper(ZooKeeper k, Animal an, Park p) {
		if(p.workerExists(k) && p.animalExists(an)) {
			if(!k.animalsToCare.contains(an)) {
				System.out.println(k.getFirstName() + " is able now to take care of " + an.getName());
				k.addAnimalByID(an.getID(),p);
			}
			else System.out.println("This animal already in " + k.firstName + " list!");
		}
		if(!p.workerExists(k)) {
			System.out.println("There is no such worker in the park");
		}
		if(!p.animalExists(an)) {
			System.out.println("There is no such animal in the park");
		}
	}

	public String toString() {

		return "\nVeterinarian\n"+super.toString()+
				"Expertise: "+expertise+"\n";
	}
}



