package ThePark;

public class ZooTrain {

	private String route_type;
	private int passengers;
	private int ride_num;
	private static int passengers_max = 15;
	private boolean trip_done;


	// Constructors
	public ZooTrain(String route_type, int passengers) throws Exception   {
		if (route_type == null) {
			throw new Exception("You must enter route type!\n!!");

		}
		this.route_type = route_type;
		if (passengers > passengers_max)
			this.passengers = passengers;
		else this.passengers = passengers;
		this.ride_num = (int)Math.random();
		this.trip_done = false;
	}

	public ZooTrain(ZooTrain tocpy) {
		this.route_type = tocpy.route_type;
		this.passengers = tocpy.passengers;
		this.ride_num = tocpy.ride_num;
		this.trip_done = tocpy.trip_done;
	}

	//Getters Setters
	public String getRouteType() {
		return this.route_type;
	}

	public void setRouteType(String route) {
		route_type = route; 
	}

	public int getPassengers() {
		return this.passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
		if (passengers > 15) {
			System.out.println("The train can contain 15 people maximum, only the first 15 people gets a ticket..");
			this.passengers = 15;
		}
	}

	public int getRideNum() {
		return this.ride_num;
	}

	public void setRideNum(int ridenum) {
		ride_num = ridenum;
	}

	public boolean getTripDone() {
		return trip_done;
	}

	public void setTripDone(boolean state) {
		trip_done = state;
	}



	//Print method
	public String toString() {
		return "Route type = "+route_type+"\nNumber of passengers = "+passengers+"\nRide number = "
				+ride_num+"\nTrip has been done = " + trip_done+'}';
	}

}
