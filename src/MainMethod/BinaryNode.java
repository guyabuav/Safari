package MainMethod;

import Humans.Employee;

public class BinaryNode {
	 protected Object data;
	 protected BinaryNode left;
	 protected BinaryNode right;
	
	 public BinaryNode(Object data) {// BinaryNode
		 this.data = data;
		 left = null;
		 right = null;
	 } 
	 
	 public BinaryNode(BinaryNode other) {
		 this.data = other.data;
		 left = other.left;
		 right = other.right;
	 }
	 
	public void insert(Object toAdd) {// insert
	 double select = Math.random();
	 if (select > 0.5) {
	if (left == null)
	 left = new BinaryNode(toAdd);
	else
	 left.insert(toAdd);
	 }
	 else {
	if (right == null)
	 right = new BinaryNode(toAdd);
	else
	 right.insert(toAdd);
	 }
	} 
	
	public String inOrder() {// inOrder
	 String res = "";
	 if (left != null)
	res = res + left.inOrder();
	 res = res + " " + data + " ";
	 if (right != null)
	res = res + right.inOrder();
	 return res;
	} 
	
	public String preOrder() {// preOrder
	 String res = "";
	 res = res + " " + data + " ";
	 if (left != null)
	res = res + left.preOrder();
	 if (right != null)
	res = res + right.preOrder();
	 return res;
	} 

	public String postOrder() {// postOrder
	 String res = "";
	 if (left != null)
	res = res + left.postOrder();
	 if (right != null)
	res = res + right.postOrder();
	 res = res + " " + data + " ";
	 return res;
	} 

	 public String extractId(Employee temp) {
		 if (temp == null)
			 return null;
		 return temp.getId();
	 }
}
