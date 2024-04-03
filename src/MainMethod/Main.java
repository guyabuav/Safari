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

	public static void main(String[] args) {

		// Bird
		Animal bird1 = new Bird("Blue", "parrot", 5);
		Animal bird2 = new Bird("Charlie", "eagle", 2);
		Animal bird3 = new Bird("Rio", "parrot", 3);
		Animal bird4 = new Bird("Sunny", "parrot", 4);

		// Mammal
		Animal mamma1 = new Mammals("Buddy", "dog", 7);
		Animal mamma2 = new Mammals("Mittens", "cat", 4);
		Animal mamma3 = new Mammals("Simba", "lion", 6);
		Animal mamma4 = new Mammals("Max", "dog", 3);

		// Reptile
		Animal reptile1 = new Reptile("Spike", "snake", 3);
		Animal reptile2 = new Reptile("Terry", "turtle", 10);
		Animal reptile3 = new Reptile("Lizzy", "lizard", 2);
		Animal reptile4 = new Reptile("Rex", "crocodile", 12);

		// ZooKeeper
		ZooKeeper worker1 = new ZooKeeper("yuval", "levy", "1234567" , 30, "yuvalp", "12345", "0");
		ZooKeeper worker2 = new ZooKeeper("matan", "semo", "1234568" , 16, "matanos", "12345", "1");
		ZooKeeper worker3 = new ZooKeeper("rami", "navon", "1234569" , 48, "ramilan", "12345", "6");
		ZooKeeper worker4 = new ZooKeeper("dan", "gil", "1234570" , 24, "danidin", "1234567", "5");
		ZooKeeper worker5 = new ZooKeeper("alon", "shir", "1234571" , 70, "alonir", "12345", "2");
		ZooKeeper worker6 = new ZooKeeper("yoni", "nir", "1234572" , 22, "yonion", "12345", "1");
		ZooKeeper worker7 = new ZooKeeper("happy", "eiion", "1234573" , 43, "happo", "12345", "5");

		
		// Veterinarian
		Veterinarian worker8 = new Veterinarian("sharon", "gidon", "1234582", 55, "sharoni", "12345", "0", "Medicine");
		Veterinarian worker9 = new Veterinarian("alon", "broidex", "1234583", 21, "alonbalon", "12345", "2", "Medicine");
		Veterinarian worker10 = new Veterinarian("meydad", "mor", "1234584", 51, "hidad", "12345", "1", "Medicine");
		Veterinarian worker11 = new Veterinarian("mori", "sason", "1234585", 23, "moron", "12345", "1", "Medicine");
		Veterinarian worker12 = new Veterinarian("eitan", "gita", "1234586", 52, "eitanos", "12345", "1", "Medicine");
		Veterinarian worker13 = new Veterinarian("tamir", "po", "1234587", 66, "shamir", "12345", "0", "Medicine");
		Veterinarian worker14 = new Veterinarian("son", "sin", "1234588", 33, "sinson", "12345", "4", "Medicine");


		// CEO
		Ceo worker23 = new Ceo("yossi", "dvir", "1234589", 44, "yossison", "123456", "11", "ALL", true);

		// Park

		ZooTrain train = new ZooTrain("Entry", 30, 0, 50);
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
		Park p = new Park(worker23, train, svStore, foodTruck, 0, Ticket);
		worker23.SetparkImManage(p);

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

		p.workersCollection.addLast(worker1);
		p.workersCollection.addLast(worker2);
		p.workersCollection.addLast(worker3);
		p.workersCollection.addLast(worker4);
		p.workersCollection.addLast(worker5);
		p.workersCollection.addLast(worker6);
		p.workersCollection.addLast(worker7);
		p.workersCollection.addLast(worker8);
		p.workersCollection.addLast(worker9);
		p.workersCollection.addLast(worker10);
		p.workersCollection.addLast(worker11);
		p.workersCollection.addLast(worker12);
		p.workersCollection.addLast(worker13);
		p.workersCollection.addLast(worker14);

		boolean isExit = false;
		boolean isLoggedIn = true;

		while(!isExit && isLoggedIn) {
			Scanner scanner = new Scanner(System.in);
			String username;
			String password;
			// user enter login details
			System.out.println("Welcome to MyZoo App:");
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
				System.out.println(p.getWorkersCollection());
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
				System.out.println(p.toString());
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
				temp.Operate(p.animalIdExists(animalID));
				break;
			case 4:
				System.out.println("Enter animal_ID to check animal: ");
				int animalID1 = scanner.nextInt();
				temp.MedicalCheck(p.animalIdExists(animalID1));
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
				System.out.println("\nYou've logged out!");
				break;
			case 7:
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
			System.out.println("8. Log out");
			System.out.println("9. Exit");
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
				System.out.println("\nYou've logged out!");
				logout = true;
				break;
			case 9:
				System.out.println("\nExiting the program...");
				return true;
			default:
				System.out.println("\nInvalid choice.. please try again");
			}

		} while (!logout);
		return false; }}

