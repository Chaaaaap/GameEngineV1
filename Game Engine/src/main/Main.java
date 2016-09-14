package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import base.Coordinate;
import base.Vector;
import figures.BasicFigure;

@SuppressWarnings("serial")
public class Main extends JFrame
{
	
	public Main()
	{
		add(new DrawPanel());
	}
	
	public static void main(String[] args)
	{
		Main frame = new Main();
		frame.setTitle("TestPanelDrawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}
	
	class DrawPanel extends JPanel
	{
		Coordinate S = new Coordinate(50, 50, 200, 400);
		Vector c = new Vector(4, 3);
		double a = 3;
		double b = 2;
		Vector p1 = new Vector(2.5, 0);
		Vector p2 = new Vector(10, 5);
		
		Vector A = new Vector(2, 2);
		Vector B = new Vector(4, 2);
		Vector C = new Vector(4, 4);
		Vector D = new Vector(2, 4);
		
		BasicFigure figure = new BasicFigure(A, B, C, D);
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			S.drawAxis(g);
			S.drawFigure(g, figure);
			figure.Rotate(60);
			g.setColor(Color.blue);
			S.drawFigure(g, figure);
			// S.drawLine(g, p1, p2);
			//
			// for (double i = 0; i < 2 * Math.PI; i = i + 0.01)
			// {
			// Vector p = c.add(new Vector(a * Math.cos(i), b * Math.sin(i)));
			// S.drawPoint(g, p);
			// }
			
		}
	}
}
