package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Container;
import model.Node;

public class Main extends Application {
	
	public static final int MAP_SIZE = 50;
	public static final int GRID_SIZE = 10; // pixels
	public static final int PIXEL_SIZE = MAP_SIZE * GRID_SIZE;
	private Canvas canvas;
	private Group group;
	private BSP bsp;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		initialize();
		Scene scene = new Scene(group);
		stage.setScene(scene);
		stage.setTitle("Maze");
		stage.show();
	}	
	
	private void initialize() {
		canvas = new Canvas(PIXEL_SIZE, PIXEL_SIZE);
		group = new Group();
		group.getChildren().add(canvas);
		
		draw();
	}
	
	
	private void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Container container = new Container(0, 0, MAP_SIZE, MAP_SIZE);
		
		/**
		 * 5 == iteration
		 * e.g = 5 iteration will produce 16 containers, but in the tree it will produce 32 nodes
		 */
		bsp = new BSP(5);
		Node node = bsp.split(container, 1, null, 0);
		node.paint(gc);
		Node[] leaves = bsp.getLeaveNodes();
		
		for (int i = 0; i < leaves.length; i++) {
			Node n = leaves[i];
			if (n == null) {
				return;
			}
			// show center 
			gc.setFill(Color.GRAY);
			gc.fillOval(n.getContainer().getCenter().getX() * GRID_SIZE, n.getContainer().getCenter().getY() * GRID_SIZE, 5, 5);
		}
	}

	
}
