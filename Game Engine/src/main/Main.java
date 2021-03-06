package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import figures.BasicFigure;
import base.Coordinate;
import base.Vector2D;

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
		frame.setTitle("GamePhysics");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}
	
	class DrawPanel extends JPanel
	{
		Coordinate S = new Coordinate(50, 50, 200, 400);
		Coordinate T = new Coordinate(50,50,500,400);

		Vector2D c = new Vector2D(4, 3);
		double a = 3;
		double b = 2;
		Vector2D p1 = new Vector2D(2.5, 0);
		Vector2D p2 = new Vector2D(10, 5);
		
	    Vector2D A=new Vector2D(2,2);
	    Vector2D B=new Vector2D(4,2);
	    Vector2D C=new Vector2D(4,4);
	    Vector2D D=new Vector2D(2,4);
	    Vector2D E=new Vector2D(3,4);
	    Vector2D F=new Vector2D(1,-1);
		
		BasicFigure figure = new BasicFigure(A, B, C, D);
		BasicFigure triangle = new BasicFigure(A,E,B);
		
		BasicFigure rotated = figure.Rotate(45);
		BasicFigure flippedX = figure.flipAroundXAxis();
		BasicFigure flippedY = figure.flipAroundYAxis();
		BasicFigure expressFigure = figure.express(2,2);
		BasicFigure triangleTranslated = triangle.translate(F);
		BasicFigure triangleMirror = triangle.flipAroundXAxis();
		BasicFigure shearsFigure = figure.Shears(1, 0);
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			S.drawAxis(g);
			T.drawFigure(g, triangle);
//			S.drawFigure(g,x figure);
			figure.Rotate(60);
			g.setColor(Color.blue);
			S.drawFigure(g, figure);
			
			g.setColor(Color.BLUE);
			S.drawFigure(g, rotated);
			
			g.setColor(Color.RED);
			S.drawFigure(g, flippedX);
			
			g.setColor(Color.GREEN);
			S.drawFigure(g, flippedY);

			g.setColor(Color.orange);
			S.drawFigure(g, expressFigure);

			g.setColor(Color.pink);
			T.drawFigure(g, triangleTranslated);
			
			g.setColor(Color.ORANGE);
			T.drawFigure(g, triangleMirror);

			g.setColor(Color.CYAN);
			S.drawFigure(g, expressFigure);		
			
			g.setColor(Color.MAGENTA);
			S.drawFigure(g, shearsFigure);
		}
	}
}
