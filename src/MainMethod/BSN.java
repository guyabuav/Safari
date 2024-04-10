package MainMethod;

import Humans.*;

public class BSN extends BinaryNode{
	private EmployeeComparator comp;
	private static BSN staticVariable = null;



	public BSN(Object data, EmployeeComparator comp) {
		super(data);
		this.comp = comp;
	}

	public BSN(BSN other) {
		super(other);
		this.comp = other.comp;
	}

	public void insert(Object toAdd){
		if (comp.compare(toAdd, this.data) < 0) {
			if (left == null)
				left = new BSN(toAdd,this.comp);
			else
				left.insert(toAdd);
		}
		if (comp.compare(toAdd, this.data) > 0) {
			if (right == null)
				right = new BSN(toAdd,this.comp);
			else
				right.insert(toAdd);
		}
	} 

	public BinaryNode findMin() {
		BinaryNode t=this;
		while( t.left != null )
			t = t.left;
		return t;
	} // findMin

	public BSN findByID(BSN root, String key) {
		if (root == null) {
			return null;
		}
		if (key.equalsIgnoreCase(root.extractId((Employee) root.data))) {
			return root;
		}
		BSN leftResult = findByID((BSN) root.left, key);
		if (leftResult != null) {
			return leftResult;
		}
		return findByID((BSN) root.right, key);
	}

	public Object findDataByID(BSN root, String key) {
		if (root == null) {
			return null;
		}
		if (key.equalsIgnoreCase(root.extractId((Employee) root.data))) {
			return root.data;
		}
		BSN leftResult = findByID((BSN) root.left, key);
		if (leftResult != null) {
			return leftResult.data;
		}
		return findByID((BSN) root.right, key).data;

	}

	public BSN removeByID(BSN root, String ToRemove) {
		if (root == null) {
			return null;
		}

		// Traverse left subtree if valueToRemove is smaller than current node's integer data
		if (root.comp.compare(root.data, (Employee)this.findDataByID(root, ToRemove)) < 0) {
			root.left = removeByID((BSN) root.left, ToRemove);
		}
		// Traverse right subtree if valueToRemove is greater than current node's integer data
		else if (root.comp.compare(root.data, (Employee)this.findDataByID(root, ToRemove)) > 0) {
			root.right = removeByID((BSN) root.right, ToRemove);
		}
		// Found the node to remove
		else {
			// Node with only one child or no child
			if (root.left == null) {
				return (BSN) root.right;
			} else if (root.right == null) {
				return (BSN) root.left;
			}

			// Node with two children: Get the inorder successor (smallest in the right subtree)
			root.data = findMin();

			// Delete the inorder successor
			root.right = removeByID((BSN) root.right, this.extractId((Employee)root.data));
		}

		return root;
	}

}