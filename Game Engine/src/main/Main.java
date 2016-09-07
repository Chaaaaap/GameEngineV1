package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twodimensions.Coordinate;
import twodimensions.Vector;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	public Main() {
		add(new DrawPanel());
	}

	public static void main(String[] args) {
		
	}

	private class DrawPanel extends JPanel {
		Coordinate c = new Coordinate(50, 50, 200, 400);
		Vector v = new Vector(4, 3);
		double a = 3;
		double b = 2;
		Vector p1 = new Vector(2.5, 0);
		Vector p2 = new Vector(10, 5);
		
	}
}


