package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final int MAP_SIZE = 20;
	private static final int GRID_SIZE = 30; // pixels
	private static final int PIXEL_SIZE = MAP_SIZE * GRID_SIZE;
	private Canvas canvas;
	private Group group;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		initialize();
		Scene scene = new Scene(group);
		stage.setScene(scene);
		stage.setTitle("Pacmon");
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
		Color color = Color.rgb(255, 255, 255);
		gc.setFill(color);
		gc.fillRect(0, 0, PIXEL_SIZE, PIXEL_SIZE);
		drawGrid(gc);
	}
	
	private void drawGrid(GraphicsContext gc) {
		gc.setStroke(null);
		for (int i = 1; i < MAP_SIZE; i++) {
			gc.strokeLine(i * GRID_SIZE, 0, i * GRID_SIZE, GRID_SIZE * MAP_SIZE);
			gc.strokeLine(0, i * GRID_SIZE, GRID_SIZE * MAP_SIZE, i * GRID_SIZE);
		}
		
	}

	
}
