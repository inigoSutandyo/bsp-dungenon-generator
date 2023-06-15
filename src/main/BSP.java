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
			newNode.setLeft(split(res[0], iter+1, newNode));
			newNode.setRight(split(res[1], iter+1, newNode));
		}
		return newNode;
	}
	
	public Container[] splitContainer(Container c) {
		Container c1, c2;
		int r = random(1, 3);
//		System.out.println(r);
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
		Container[] res = {c1, c2};
		return res;
	}
	


	int random(int min, int max) {
		if (max == min) {
			return max;
		}
		Random random = new Random();
	    return random.nextInt(max - min) + min;

	}
}
