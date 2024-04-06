package Humans;

import java.util.LinkedList;

import Animals.Animal;
import ThePark.Park;


public class Veterinarian extends Employee {
	protected String expertise;

	public Veterinarian(String firstName, String lastName, String id, int age, String user, String password, int seniority, String expertise) {
		super(firstName, lastName, id, age, user, password, seniority);
		this.expertise = expertise;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder("Veterinarian\n"); 
		sb.append("First Name: ").append(firstName).append("\n");
		sb.append("Last Name: ").append(lastName).append("\n");
		sb.append("ID: ").append(id).append("\n");
		sb.append("Age: ").append(age).append("\n");
		sb.append("User: ").append(user).append("\n");
		sb.append("Password: ").append(password).append("\n");
		sb.append("Seniority: ").append(seniority).append("\n");
		sb.append("Salary: ").append(salary).append("\n");
		sb.append("Today's Working Hours: ").append(todayWorkingHours).append("\n");
		sb.append("Expertise: ").append(expertise).append("\n\n");
		return sb.toString();

	}

	public void Operate(Animal an) {
		an.setHealth(an.getHealth()+10);
	}

	public void MedicalCheck(Animal an) {
		if (an.getHealth() < 50) {
			System.out.println("The animal needs a medical treatment!");
		}
		if (an.getHunger() < 50) {
			System.out.println("The animals needs food!");
		}
		if (an.getHappiness() < 50) {
			System.out.println("The animals needs a show");
		}
	}

	public void TeachZooKeeper(ZooKeeper k, Animal an, Park p) {
		System.out.println(k.getFirstName() + " is able now to take care of " + an.getName());
		k.addAnimalByID(an.getID(),p);
	}
}
