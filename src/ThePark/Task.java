package ThePark;

import Animals.Animal;
import Humans.Veterinarian;

public class Task {
protected int task_id;
protected String task_name;
protected String task_description;
protected Animal an;
protected Veterinarian responsible_vet;
protected int counter = 1;

// Constructor
public Task(String task_name, String task_description, Animal an, Veterinarian responsible_vet) {
    this.task_id = counter++;
    this.task_name = task_name;
    this.task_description = task_description;
    this.an = an;
    this.responsible_vet = responsible_vet;
}

// Getters
public int getTask_id() {
    return task_id;
}

public String getTask_name() {
    return task_name;
}

public String getTask_description() {
    return task_description;
}

public Animal getAn() {
    return an;
}

public Veterinarian getResponsible_vet() {
    return responsible_vet;
}

// Setters
public void setTask_id(int task_id) {
    this.task_id = task_id;
}

public void setTask_name(String task_name) {
    this.task_name = task_name;
}

public void setTask_description(String task_description) {
    this.task_description = task_description;
}

public void setAn(Animal an) {
    this.an = an;
}

public void setResponsible_vet(Veterinarian responsible_vet) {
    this.responsible_vet = responsible_vet;
}

public String toString() {
    return  "task_id: " + task_id + "\n" +
            "task_name: " + task_name + "\n" +
            "task_description: " + task_description + "\n" +
            ", an=" + an +
            ", responsible_vet=" + responsible_vet;
}

}
