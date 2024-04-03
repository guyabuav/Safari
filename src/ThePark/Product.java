package ThePark;

public class Product {
	int price;
	int stock;

	public Product(int price, int stock) {
		this.price = price;
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	// Setters
	public void setPrice(int price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String toString() {
		return "Product{" +
				"price=" + price +
				", stock=" + stock +
				'}';
	}
}
