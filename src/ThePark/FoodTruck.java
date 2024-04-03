package ThePark;


public class FoodTruck {
	Product hotdog;
	Product hamburger;
	Product chips;
	Product cola;
	Product orange_juice;
	Product water_bottle;

	public FoodTruck(Product hotdog, Product hamburger, Product chips, Product cola, Product orange_juice, Product water_bottle) {
		this.hotdog = hotdog;
		this.hamburger = hamburger;
		this.chips = chips;
		this.cola = cola;
		this.orange_juice = orange_juice;
		this.water_bottle = water_bottle;
	}

	// Getters and Setters
	public Product getHotdog() {
		return hotdog;
	}

	public void setHotdog(Product hotdog) {
		this.hotdog = hotdog;
	}

	public Product getHamburger() {
		return hamburger;
	}

	public void setHamburger(Product hamburger) {
		this.hamburger = hamburger;
	}

	public Product getChips() {
		return chips;
	}

	public void setChips(Product chips) {
		this.chips = chips;
	}

	public Product getCola() {
		return cola;
	}

	public void setCola(Product cola) {
		this.cola = cola;
	}

	public Product getOrange_juice() {
		return orange_juice;
	}

	public void setOrange_juice(Product orange_juice) {
		this.orange_juice = orange_juice;
	}

	public Product getWater_bottle() {
		return water_bottle;
	}

	public void setWater_bottle(Product water_bottle) {
		this.water_bottle = water_bottle;
	}

	public String toString() {
		return "FoodTruck{" +
				"hotdog=" + hotdog +
				", hamburger=" + hamburger +
				", chips=" + chips +
				", cola=" + cola +
				", orange_juice=" + orange_juice +
				", water_bottle=" + water_bottle +
				'}';
	}
}
