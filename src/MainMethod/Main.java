package MainMethod;
import java.util.LinkedList;
import java.util.Scanner;

import Animals.Animal;
import Animals.Mammals;
import Animals.Bird;
import Animals.Reptile;
import Humans.ZooKeeper;
import ThePark.FoodTruck;
import ThePark.Park;
import ThePark.Product;
import ThePark.SouvenirStore;
import ThePark.ZooTrain;
import Humans.Human;
import Humans.Veterinarian;
import Humans.Ceo;
import Humans.Employee;

// visitors - useing stores, trains...
public class Main {
	public static void main(String[] args)   {

		Animal bird1 = null;
		Animal bird2 = null;
		Animal bird3 = null;
		Animal bird4 = null;
		Animal mamma1 = null;
		Animal mamma2 = null;
		Animal mamma3 = null;
		Animal mamma4 = null;
		Animal reptile1 = null;
		Animal reptile2 = null;
		Animal reptile3 = null;
		Animal reptile4 = null;
		ZooKeeper worker1 = null;
		ZooKeeper worker2 = null;
		ZooKeeper worker3 = null;
		Veterinarian worker8 = null;
		Veterinarian worker9 = null;
		Veterinarian worker10 = null;
		Ceo worker23 = null;

		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BOLD = "\u001B[1m";
		final String ANSI_RED = "\u001B[31m";

		try {
			// Bird
			bird1 = new Bird("Blue", "parrot", 5);
			bird2 = new Bird("Charlie", "eagle", 2);
			bird3 = new Bird("Rio", "parrot", 3);
			bird4 = new Bird("Sunny", "parrot", 4);

			// Mammal
			mamma1 = new Mammals("Buddy", "dog", 7);
			mamma2 = new Mammals("Mittens", "cat", 4);
			mamma3 = new Mammals("Simba", "lion", 6);
			mamma4 = new Mammals("Max", "dog", 3);

			// Reptile
			reptile1 = new Reptile("Spike", "snake", 3);
			reptile2 = new Reptile("Terry", "turtle", 10);
			reptile3 = new Reptile("Lizzy", "lizard", 2);
			reptile4 = new Reptile("Rex", "crocodile", 12);

		} catch (Exception e) {
			System.out.println("There is error in creating an animal\n");
		}

		try {
			// ZooKeeper
			worker1 = new ZooKeeper("yuval", "levy", "1234567" , 30, "yuvalp", "12345", 10);
			worker2 = new ZooKeeper("matan", "semo", "1234568" , 16, "matanos", "12345", 1);
			worker3 = new ZooKeeper("rami", "navon", "1234569" , 48, "ramilan", "12345", 6);



			// Veterinarian
			worker8 = new Veterinarian("sharon", "gidon", "1234582", 55, "sharoni", "12345", 4, "Medicine");
			worker9 = new Veterinarian("alon", "broidex", "1234583", 21, "alonbalon", "12345", 12, "Medicine");
			worker10 = new Veterinarian("meydad", "mor", "1234584", 51, "hidad", "12345", 16, "Medicine");


			// CEO
			worker23 = new Ceo("yossi", "dvir", "1234589", 44, "yossison", "123456", 11, "ALL", true);

		} catch (Exception e1) {
			System.out.println("There is error in creating a human\n");
		}

		ZooTrain train = null;
		// Park
		try {
			train = new ZooTrain("Long", 20);
		}catch(Exception e2) {
			System.out.println("There was an error in creating zoo train\n");
		}
		Product key_chain = new Product(5, 100);
		Product zoo_photo = new Product(10,100);
		Product snack = new Product(5,200);
		SouvenirStore svStore = new SouvenirStore(key_chain, zoo_photo, snack);
		Product hotdog = new Product(20,200);
		Product hamburger = new Product(40,200);
		Product chips = new Product(10,200);
		Product cola = new Product(5,200);
		Product water_bottle = new Product(3,200);
		Product orange_juice = new Product(4,200);
		FoodTruck foodTruck = new FoodTruck(hotdog, hamburger, chips, cola, orange_juice, water_bottle);
		Product Ticket = new Product(75,1000);
		Park p = null;
		try {
		p = new Park(worker23, train, svStore, foodTruck, 0, Ticket);
		}catch(Exception e3) {
			System.out.println("There was error in creating the park\n");
		}
		worker23.SetparkImManage(p);
		p.addRide(train);



		p.animalsCollection.addLast(bird1);
		p.animalsCollection.addLast(bird2);
		p.animalsCollection.addLast(bird3);
		p.animalsCollection.addLast(bird4);
		p.animalsCollection.addLast(mamma1);
		p.animalsCollection.addLast(mamma2);
		p.animalsCollection.addLast(mamma3);
		p.animalsCollection.addLast(mamma4);
		p.animalsCollection.addLast(reptile1);
		p.animalsCollection.addLast(reptile2);
		p.animalsCollection.addLast(reptile3);
		p.animalsCollection.addLast(reptile4);

		p.workersCollection.insert(worker1);
		p.workersCollection.insert(worker2);
		p.workersCollection.insert(worker3);
		p.workersCollection.insert(worker8);
		p.workersCollection.insert(worker9);
		p.workersCollection.insert(worker10);



		boolean isExit = false;
		boolean isLoggedIn = true;

		while(!isExit && isLoggedIn) {
			Scanner scanner = new Scanner(System.in);
			String username;
			String password;
			// user enter login details
			System.out.println(ANSI_BOLD+ANSI_RED+"Welcome to MyZoo App:"+ANSI_RESET);
			System.out.println("User name: ");
			username = scanner.nextLine();
			System.out.print("Password: ");
			password = scanner.nextLine();


			// User name and password check
			Employee tempo = authenticateUser(username, password, p);
			if (tempo != null) {
				System.out.println("Login successfully!");
				isLoggedIn = true;
				if (tempo instanceof Ceo) {
					isExit = displayCeoMenu((Ceo) tempo, p);
				} else if (tempo instanceof Veterinarian) {
					isExit = displayVeterinarianMenu((Veterinarian) tempo, p);
				} else if (tempo instanceof ZooKeeper) {
					isExit = displayZookeeperMenu((ZooKeeper) tempo, p);
				}

			} else {
				System.out.println("User name or Password are incorrect.");
			}
		}
		isLoggedIn = false;



	}

	// Function to authenticate user based on username and password
	public static Employee authenticateUser(String username, String password, Park p) {
		for (Employee tempemployee : p.workersInPark ) {
			if (tempemployee.getUser().equals(username) && tempemployee.getPassword().equals(password)) {
				return tempemployee;
			}
		}
		return null;
	}

	// Ceo menu
	public static boolean displayCeoMenu(Ceo temp, Park p) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean logout = false;

		do {
			System.out.println("\nHey CEO, What do you want to do today?\n");
			System.out.println("1. Show your details");
			System.out.println("2. Show the park animals list");
			System.out.println("3. Show the park employeers list");
			System.out.println("4. Show the Animals collection list");
			System.out.println("5. Show the Workers collection list");
			System.out.println("6. Calculate daily profit");
			System.out.println("7. Add animal to the park");
			System.out.println("8. Delete animal from the park");
			System.out.println("9. Hire a new employee");
			System.out.println("10. Fire an employee");
			System.out.println("11. Calculate daily salary for an employee");
			System.out.println("12. Increase salary for an employee");
			System.out.println("13. Show Zoo details");
			System.out.println("14. Log out");
			System.out.println("15. Exit");
			System.out.print("Enter the number of the option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println(temp.toString());
				break;
			case 2:
				System.out.println("Park animals list: \n ");
				System.out.println(p.getanimalsInPark());
				break;
			case 3:
				System.out.println("Park employeers list: \n ");
				System.out.println(p.getWorkersInPark());
				break;
			case 4:
				System.out.println("Animal collection list: ");
				System.out.println(p.getanimalsInCollection());
				break;
			case 5:
				System.out.println("Employeers collection list: ");
				System.out.println(p.workersCollection.inOrder());
				break;
			case 6:
				System.out.println("Total profit for this day: ");
				System.out.println(temp.calcDailyProfit());
				break;
			case 7:
				System.out.println("Enter animal ID to add to the Zoo: ");
				int animalID5 = scanner.nextInt();
				temp.addAnimaltoPark(animalID5);
				break;
			case 8:
				System.out.println("Enter animal ID to delete from the Zoo: ");
				int animalID6 = scanner.nextInt();
				temp.DeleteAnimalFromPark(animalID6);
				break;
			case 9:
				System.out.println("Enter worker ID to add to the Zoo: ");
				scanner.nextLine();
				String worker = scanner.nextLine();
				temp.addWorkertoPark(worker);
				break;
			case 10:
				System.out.println("Enter worker ID to remove from the Zoo: ");
				scanner.nextLine();
				String worker1 = scanner.nextLine();
				temp.DeleteWorkerIDFromPark(worker1);
				break;
			case 11:
				System.out.println("Enter worker ID to calculate daily salary: ");
				scanner.nextLine();
				String worker2 = scanner.nextLine();
				temp.calcDailySalary(p.WorkerIdExists(worker2),p);
				break;
			case 12:
				System.out.println("Enter worker ID to raise salary: ");
				scanner.nextLine();
				String worker3 = scanner.nextLine();
				System.out.println("Enter amount of raise: ");
				int raise = scanner.nextInt();
				temp.raiseDailySalary(p.WorkerIdExists(worker3), raise);
				break;
			case 13:
				System.out.println(p);
				break;
			case 14:
				System.out.println("\nYou've logged out!");
				logout = true;
				return false;
			case 15:
				System.out.println("\nExiting the program...");
				return true;
			default:
				System.out.println("\nInvalid choice.. please try again");
			}
		} while (!logout);
		return false;
	}




	// Veterinarian menu
	public static boolean displayVeterinarianMenu(Veterinarian temp, Park p) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean logout = false;

		do {
			System.out.println("\nHey Veterinarian, What do you want to do today?\n");
			System.out.println("1. Show your details");
			System.out.println("2. Show the park animals list");
			System.out.println("3. Operate animal");
			System.out.println("4. Medical check for animal");
			System.out.println("5. Teach ZooKeeper");
			System.out.println("6. Log out");
			System.out.println("7. Exit");
			System.out.print("Enter the number of the option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println(temp.toString());
				break;
			case 2:
				System.out.println("Park animals list: \n ");
				System.out.println(p.getanimalsInPark());
				break;
			case 3:
				System.out.println("Enter animal_ID to operate animal: ");
				int animalID = scanner.nextInt();
				temp.Operate(p.animalIdExists(animalID), p);
				break;
			case 4:
				System.out.println("Enter id of the responsible zooKeeper: ");
				scanner.nextLine();
				String zooKeeperID = scanner.nextLine();
				System.out.println("Enter animal_ID to check animal: ");
				int animalID1 = scanner.nextInt();
				temp.MedicalCheck((ZooKeeper) p.WorkerIdExists(zooKeeperID),p.animalIdExists(animalID1), p);
				break;
			case 5:
				System.out.println("Enter ZooKeeper ID to teach: ");
				scanner.nextLine();
				String ZooKeeperId = scanner.nextLine();
				System.out.println("Enter Animal ID: ");
				int animalID2= scanner.nextInt();
				temp.TeachZooKeeper((ZooKeeper) p.WorkerIdExists(ZooKeeperId), p.animalIdExists(animalID2), p);
				break;
			case 6:
				System.out.println("Park employeers list: \n ");
				System.out.println(p.getWorkersInPark());
				break;
				
			case 7:
				System.out.println("\nYou've logged out!");
				logout = true;
				return false;				
			case 8:
				System.out.println("\nExiting the program...");
				return true;
			default:
				System.out.println("\nInvalid choice.. please try again");
			}
		} while (!logout);
		return false;
	}

	// Zookeeper menu
	public static boolean displayZookeeperMenu(ZooKeeper temp, Park p) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean logout = false;

		do {
			System.out.println("\nHey Zookeeper, What do you want to do today?\n");
			System.out.println("1. Show your details");
			System.out.println("2. Show your animals");
			System.out.println("3. Clean cage");
			System.out.println("4. Preforme a show with animal");
			System.out.println("5. Pet animal");
			System.out.println("6. Show me the park animals list");
			System.out.println("7. Add animal to my responsibillity");
			System.out.println("8. Show my tasks");
			System.out.println("9. Mark task as done");
			System.out.println("10. Log out");
			System.out.println("11. Exit");
			System.out.print("Enter the number of the option: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println(temp.toString());
				break;
			case 2:
				temp.printAnimals();
				break;
			case 3:
				temp.Clean();
				break;
			case 4:
				temp.Show();
				break;
			case 5:
				temp.Pet();
				break;
			case 6:
				System.out.println(p.getanimalsInPark());
				break;

			case 7:
				System.out.print("Enter the ID of the animal you want to add: ");
				int animalID = scanner.nextInt();
				temp.addAnimalByID(animalID, p);
				break;
			case 8:
				System.out.println("This is your task :\n");
				System.out.println(temp.getTasks());
				break;
			case 9:
				System.out.println("Choose task that have been done");
				int tid = scanner.nextInt();
				temp.markTaskAsDone(tid);
				break;
			case 10:
				System.out.println("\nYou've logged out!");
				logout = true;
				break;
			case 11:
				System.out.println("\nExiting the program...");
				return true;
			default:
				System.out.println("\nInvalid choice.. please try again");
			}

		} while (!logout);
		return false; }}

