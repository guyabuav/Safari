package ThePark;

public class ZooTrain {

	private String location;
	private int capacity;
	private int rides_num;
	private int rides_remain_today;
	public boolean is_moving;


	// Constructor
	public ZooTrain(String location, int capacity, int ridesNum, int ridesRemainToday) {
		this.location = location;
		this.capacity = capacity;
		this.rides_num = ridesNum;
		this.rides_remain_today = ridesRemainToday;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getRides_num() {
		return rides_num;
	}
	public void setRides_num(int rides_num) {
		this.rides_num = rides_num;
	}
	public int getRides_remain_today() {
		return rides_remain_today;
	}
	public void setRides_remain_today(int rides_remain_today) {
		this.rides_remain_today = rides_remain_today;
	}

	public String toString() {
		return "ZooTrain{" +
				"location='" + location + '\'' +
				", capacity=" + capacity +
				", rides_num=" + rides_num +
				", rides_remain_today=" + rides_remain_today +
				'}';
	}

}
