package model;

public class Node {
	// Binary Tree Node
	private int height;
	private Node left, right;
	
	public Node(int height, Node left, Node right) {
		super();
		this.height = height;
		this.left = left;
		this.right = right;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	

}
