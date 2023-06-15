package model;

import javafx.scene.canvas.GraphicsContext;

public class Node {
	// Binary Tree Node
	private int height;
	private Container container;
	private Node left, right, parent;
	
	public Node(Container container, int height, Node parent) {
		super();
		this.container = container;
		this.height = height;
		this.left = null;
		this.right = null;
		this.parent = parent;
	}
	
	public boolean isLeaf() {
		if (left == null && right == null) return true;
		return false;
	}
	
	public boolean isRoot() {
		if (parent == null) return true;
		return false;
	}
	
	public void paint(GraphicsContext gc) {
		System.out.printf("%-2d: %-3d - %-3d\n", height, getContainer().getWidth(), getContainer().getHeight());
		this.container.paintContainer(gc);
		if (left != null) {
			left.paint(gc);
		} 
		if (right != null) {
			right.paint(gc);
		}
	}
	
	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
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
