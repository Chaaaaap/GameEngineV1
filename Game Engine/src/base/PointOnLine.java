package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import figures.Ellipse;

public class PointOnLine extends JFrame {
	PaintPanel panel = new PaintPanel();

	PointOnLine() {
		add(panel);
	} // Constructor

	class PaintPanel extends JPanel {
		Coordinate S2 = new Coordinate(40, 40, 100, 500);

		// Simulating time
		double t0; 													// Timestamp of simulationstart in sec
		double t = 0; 											// Time in sec since simulation start

		// Animation
		int frameRate = 25; 								// No of frames/second
		int frameDelay = 1000 / frameRate; 	// time between frames in milli sec
		Timer myTimer = new Timer(frameDelay, new TimerListener());

		Vector A = new Vector(4, 2); 								// Point on the line
		Vector B = new Vector(16, 5); 							// Point on the line
		Vector r = B.sub(A).unit(); 						// Unit length vector in direction of the line
		Vector P; 															// Blue point moving along the line
		Vector moon = A;
		double s = 2; 											// speed - units pr. sec

		PaintPanel() {
			// Start simulation
			t0 = System.currentTimeMillis() / 1000.0;
			myTimer.start();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Update time
			t = System.currentTimeMillis() / 1000.0 - t0;

			// Simulation
			P = A.add(r.multiply(s * t));
			moon = new Matrix(Math.cos(1), -Math.sin(1), Math.sin(1), Math.cos(1)).multiply(moon);
			

			// Display
			S2.drawAxis(g);
			S2.drawLine(g, A, B);
			S2.drawPoint(g, A);
			S2.drawPoint(g, B);
			S2.drawPoint(g, P, Color.BLUE, 10);
			
			S2.drawCircle(g, new Ellipse(400), A);
			S2.drawPoint(g, moon, Color.RED, 10);

			// Stop simulation
			// if (P.x>=B.x) myTimer.stop();
		}

		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		}
	} // class PaintPanel

	public static void main(String[] args) {
		PointOnLine frame = new PointOnLine();
		frame.setTitle("Game Physics - PointOnLine");
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // main()

} // class MainFrame