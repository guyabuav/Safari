package ThePark;


public class SouvenirStore {
	Product key_chain;
	Product zoo_photo;
	Product snack;

	// Constructor
	public SouvenirStore(Product keyChain, Product zooPhoto, Product snack) {
		this.key_chain = keyChain;
		this.zoo_photo = zooPhoto;
		this.snack = snack;
	}

	// Getters
	public Product getKeyChain() {
		return key_chain;
	}

	public Product getZooPhoto() {
		return zoo_photo;
	}

	public Product getSnack() {
		return snack;
	}

	// Setters
	public void setKeyChain(Product keyChain) {
		this.key_chain = keyChain;
	}

	public void setZooPhoto(Product zooPhoto) {
		this.zoo_photo = zooPhoto;
	}

	public void setSnack(Product snack) {
		this.snack = snack;
	}

	public String toString() {
		return "SouvenirStore{" +
				"key_chain=" + key_chain +
				", zoo_photo=" + zoo_photo +
				", snack=" + snack +
				'}';
	}
}
