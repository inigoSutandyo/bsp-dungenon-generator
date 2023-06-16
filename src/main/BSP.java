package main;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import model.Container;
import model.Node;

public class BSP {
	private int iteration;
	public BSP(int iteration) {
		super();
		this.iteration = iteration;
	}
	
	public Node split(Container container, int iter, Node parent) {
		Node newNode = new Node(container, iter, parent);
		if (iter <= iteration) {
			Container[] res = splitContainer(container);
			if (res[0] == null || res[1] == null) return newNode;
			
			newNode.setLeft(split(res[0], iter+1, newNode));
			newNode.setRight(split(res[1], iter+1, newNode));
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
			return -1;
		} else if (w <= 1) {
			return 2;
		} else if (h <= 1) {
			return 1;
		} else {
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
}
