package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Main;

public class Container {

	private int x, y, width, height;
	private Point center;
	public Container(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.center = new Point (this.x + (this.width/2), this.y + (this.height/2));
	}
	
	public void paintContainer(GraphicsContext gc) {
		
		Color color = Color.GREEN;
		gc.setStroke(color);
		gc.setLineWidth(2);
		gc.strokeRect(this.x * Main.GRID_SIZE, 
				this.y * Main.GRID_SIZE, 
				this.width * Main.GRID_SIZE, 
				this.height * Main.GRID_SIZE);
		gc.setFill(Color.BLACK);
		gc.fillRect(this.x * Main.GRID_SIZE, 
				this.y * Main.GRID_SIZE, 
				this.width * Main.GRID_SIZE, 
				this.height * Main.GRID_SIZE);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	
	
	

}
