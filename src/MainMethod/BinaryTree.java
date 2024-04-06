package MainMethod;

public class BinaryTree {
	 protected BinaryNode root;
	 
	 public BinaryTree() {
		 root = null;
	 } // BinaryTree
	 
	 public boolean isEmpty() {
		 return root == null;
	 } // isEmpty
	 
	 public void insert(Object toAdd) {
		if (isEmpty())
		 root = new BinaryNode(toAdd);
		else
		 root.insert(toAdd);
	 } // insert
	 
	public String inOrder() {
	if (isEmpty())
	 return "";
	else
	 return root.inOrder();
	 } // inOrder
	
	 public String preOrder() {
	if (isEmpty())
	 return "";
	else return root.preOrder();
	 } // preOrder
	 
	 public String postOrder() {
	if (isEmpty())
	 return "";
	else
	 return root.postOrder();
	 } // postOrder
	 
	}
