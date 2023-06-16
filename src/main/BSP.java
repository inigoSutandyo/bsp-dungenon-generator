package main;

import java.util.Random;
import model.Container;
import model.Node;

public class BSP {
	private int iteration;
	private Node[] nodes;
	private int len;
	public BSP(int iteration) {
		super();
		this.iteration = iteration;
		this.len = (int) (Math.pow(2, iteration));
		this.nodes = new Node[len];
	}
	
	public Node split(Container container, int iter, Node parent, int idx) {
		Node newNode = new Node(container, iter, parent, idx);
		nodes[idx] = newNode;
		if (iter < iteration) {
			Container[] res = splitContainer(container);
			if (res[0] == null || res[1] == null) return newNode;
			
			newNode.setLeft(split(res[0], iter+1, newNode, (idx*2)+1));
			newNode.setRight(split(res[1], iter+1, newNode, (idx*2)+2));
		}
		return newNode;
	}
	
	public Container[] splitContainer(Container c) {
		Container c1 = null, c2 = null;
		Container[] res = {c1, c2};
		int r = splitDirection(random(1, 3), c.getWidth(), c.getHeight());
		
		if (r == -1) {
			System.out.println("Cannot be split");
			return res;
		} 
		if (r == 1) {
			// split vertical
			int w1 = random(1, c.getWidth());
			
			c1 = new Container(c.getX(), c.getY(), w1, c.getHeight());
			c2 = new Container(c.getX() + w1, c.getY(), c.getWidth() - w1, c.getHeight());
		} else {
			// split horizontal
			int h1 = random(1, c.getHeight());
			c1 = new Container(c.getX(), c.getY(), c.getWidth(), h1); 
			c2 = new Container(c.getX(), c.getY() + h1, c.getWidth(), c.getHeight() - h1); 
		}
		res[0] = c1;
		res[1] = c2;
		
		return res;
	}
	

	private int splitDirection(int r, int w, int h) {
		if (w <= 1 && h <= 1) {
			// if width and height <= 3 do not split 
			return -1;
		} else if (w <= 1) {
			// split horizontal if width <= 3
			return 2;
		} else if (h <= 1) {
			// split vertical if height <= 3
			return 1;
		} else {
			// if width and height >= 3 split random
			return r;
		}
	}
	
	int random(int min, int max) {
		if (max == min) {
			return max;
		}
		Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	
	public Node[] getLeaveNodes() {
		int n = len/2 - 1;
		Node[] res = new Node[n+2];
		int j = 0;
		
		for (int i = n; i < len-1; i++) {
			if (nodes[i] == null) continue;
			res[j] = nodes[i];
			System.out.println(j);
			j++;
		}
		return res;
	}
	
	public void printInOrder(Node node) {
		if (node == null) return;
		printInOrder(node.getLeft());
		System.out.printf("%-2d: %-3d - %-3d\n", node.getIndex(), node.getContainer().getWidth(), node.getContainer().getHeight());
		printInOrder(node.getRight());
	}
	
	public void printNodes() {
		for (int i = 0; i < len-1; i++) {
			if (nodes[i] == null) {
				System.out.println("Null at : " + i);
				continue;
			}
			System.out.printf("[%3d %-3d] %2d %2d\n", nodes[i].getIndex(), 
					nodes[i].getHeight(),
					nodes[i].getContainer().getX(),
					nodes[i].getContainer().getY());
		}
	}
	
}
