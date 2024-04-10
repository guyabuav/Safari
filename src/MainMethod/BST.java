package MainMethod;

public class BST extends BinaryTree{
	private EmployeeComparator comp;

	public BST(EmployeeComparator comp) {
		super();
		this.comp = comp;
	}

	public void insert(Object toAdd) {	
		if (isEmpty()) {
			root = new BSN(toAdd, this.comp);
		}
		else {
			root.insert(toAdd);
		}
	}

	public Object findMin(BSN root) {
		if (isEmpty()) {
			return null; // Exceptions are needed...
		}
		return ((BSN)root).findMin();
	} // findMin

	public BSN findByID(String key) {
		if (isEmpty()) {
			return null;
		}
		return (((BSN)root).findByID((BSN)root, key));
	}

	public Object findDataByID(String key) {
		if (isEmpty()) {
			return null;
		}
		return ((BSN)root).findDataByID(((BSN)root), key);
	}

	public void removeByID(String key) {
		if (isEmpty()) {
			return;
		}
		((BSN)root).removeByID((BSN)root, key);
	}
}
